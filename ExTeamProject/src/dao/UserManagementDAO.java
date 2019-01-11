package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import db.ConnectionPool;
import together.ActionForward;

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

}
