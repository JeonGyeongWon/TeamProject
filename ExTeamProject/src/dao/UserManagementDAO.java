package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import db.ConnectionPool;
import dto.UserManagementDTO;
import together.ActionForward;
import controller.UserManagementController;

public class UserManagementDAO {

	ConnectionPool cp;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public UserManagementDAO() {
		cp = new ConnectionPool(); // 각 메서드에서 반드시 con = cp.getConnection(); 해서
									// DB에 접속할 것.
	}

	// 회원가입
	public boolean insertMember(UserManagementDTO mb) {
		// 회원가입 성공 여부 저장
		int result = 0;
		try {
			con = cp.getConnection();
			String sql = "insert into users (user_email,user_pass,user_nickname,user_birth,user_gender,user_point,user_phone,user_level) values (?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getUser_email());
			pstmt.setString(2, mb.getUser_pass());
			pstmt.setString(3, mb.getUser_nickname());
			pstmt.setInt(4, mb.getUser_birth());
			pstmt.setString(5, mb.getUser_gender());
			pstmt.setInt(6, 0);
			pstmt.setString(7, "");
			pstmt.setInt(8, 1);
			result = pstmt.executeUpdate(); // 회원가입 성공 하면 1을 리턴 실패시 0을 리턴
			// 만약에 회원가입에 성공 하면 true리턴
			if (result != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cp.close(con, pstmt, rs);
		}
		return false;
	} // insertMember() 끝

	// 로그인
	public int userLogin(String user_email, String user_pass) {
		int result = -1;
		try {
			con = cp.getConnection();
			String sql = "select user_pass from users where user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if ((rs.getString("user_pass")).equals(user_pass)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
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
	} // userLogin() 끝

	// 회원정보수정을 위한 유저정보 검색
	public UserManagementDTO getUserInfo(String user_email) {
		UserManagementDTO umdto = new UserManagementDTO();
		try {
			con = cp.getConnection();
			String sql = "select user_no, user_pass, user_nickname, user_birth, user_gender, user_point, user_phone, user_level from users where user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
	} // getUserInfo() 끝

	public int editUserInfo(){
		System.out.println("editUserInfo()로 넘어왔습니다.");
		return 0;
	}
	
	// 아이디 중복체크
	public int JoinCheck(String user_email) {
		int check = 0;
		try {
			con = cp.getConnection();
			String sql = "select * from users where user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = 0;
			} else {
				check = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cp.close(con, pstmt, rs);
		}
		return check;
	} // JoinCheck() 끝
}
