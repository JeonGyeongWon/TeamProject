package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import db.ConnectionPool;
import dto.UserManagementDTO;
import together.ActionForward;
import controller.UserManagementController;

public class UserManagementDAO {

	ConnectionPool cp;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	
	public UserManagementDAO() {
		cp = new ConnectionPool();	//각 메서드에서 반드시 con = cp.getConnection(); 해서 DB에 접속할 것.
	}

	public int userLogin(String user_email, String user_pass) {
		int result = -1;
		try {
			con = cp.getConnection();
			String sql = "select user_pass from users where user_email=?";
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if((rs.getString("user_pass")).equals(user_pass)){
					result = 1;
				}else{
					result = 0;
				}
			}else {
				result = -1;
			}
		} catch (SQLException e) {
			System.out.print("userLogin()메서드 내부 오류: ");
			e.printStackTrace();
		} finally {
			cp.close(con, pstmt, rs);
		}
		System.out.println("userLogin()의 리턴값은 " + result + "입니다.");
		return result;
	}
	//DB작업 담당
		private Connection getConnection() throws Exception{
		Connection con = null;
		Context init = new InitialContext();
		DataSource datasource = (DataSource)init.lookup("java:comp/env/jdbc/promotion");
		con = datasource.getConnection();
		return con;
	}
		//회원가입 메소드 
		public boolean insertMember(UserManagementDTO mb){
			
			Connection con = null;
			String sql = "";
			PreparedStatement pstmt = null;
			
			//회원가입 성공 여부 저장
			int result = 0;
			
			try {
				con = getConnection(); //DB접속 객체 얻기 
				sql = "insert into users(user_email,user_pass,user_nickname,user_birth,user_gender)"
					+ "values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mb.getUser_email());
				pstmt.setString(2, mb.getUser_pass());
				pstmt.setString(3, mb.getUser_nickname());
				pstmt.setInt(4,mb.getUser_birth());
				pstmt.setString(5, mb.getUser_gender());
				
				
				
				result = pstmt.executeUpdate(); //회원가입 성공 하면 1을 리턴 실패시 0을 리턴
				
				//만약에 회원가입에 성공 하면 true리턴
				if(result != 0){
					return true;
				}		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				try {
					//자원해제
					if(pstmt != null){
						pstmt.close();
					}
					if(con != null){
						con.close();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
			}
			return false;
		}
		// 아이디 중복체크
					public int JoinCheck(String user_email){ 
						Connection con = null;
						PreparedStatement pre = null;
						ResultSet rs = null;
						int check = 0;
						
						try {
							con = getConnection();
							String sql = "select * from users where user_email=?";
							pre = con.prepareStatement(sql);
							pre.setString(1, user_email);
							rs = pre.executeQuery();
							if(rs.next()){
								check = 0;
							} else { 
								check = 1; 
							}
						} catch (Exception e) { e.printStackTrace(); }
						finally {
							if (rs != null) try {rs.close(); } catch(SQLException ex) {ex.printStackTrace(); }
							if (pre != null) try { pre.close(); } catch(SQLException ex) { ex.printStackTrace(); }
							if (con != null) try { con.close(); } catch(SQLException ex) { ex.printStackTrace(); }
						}
						return check;
						
					} 
}
