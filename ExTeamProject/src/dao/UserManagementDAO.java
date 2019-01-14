package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


import db.ConnectionPool;
import together.ActionForward;
import userManagement.UserManagementDTO;

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
		return result;
	}

	public UserManagementDTO getUserInfo(String user_email){
		UserManagementDTO umdto = new UserManagementDTO();
		try {
			con = cp.getConnection();
			String sql = "select user_no, user_pass, user_nickname, user_birth, user_gender, user_point, user_phone, user_level from users where user_email=?";
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				umdto.setUser_no(rs.getInt("user_no"));
				umdto.setUser_pass(rs.getString("user_pass"));
				umdto.setUser_nickname(rs.getString("user_nickname"));
				umdto.setUser_birth(rs.getInt("user_birth"));
				umdto.setUser_gender(rs.getString("user_gender"));
				umdto.setUser_point(rs.getInt("user_point"));
				umdto.setUser_phone(rs.getString("user_phone"));
				umdto.setUser_level(rs.getInt("user_level"));
			}
		} catch (Exception e) {
			System.out.print("getUserInfo()메서드 내부 오류: ");
			e.printStackTrace();
		} finally {
			cp.close(con, pstmt, rs);
		}
		return umdto;
	}
}
