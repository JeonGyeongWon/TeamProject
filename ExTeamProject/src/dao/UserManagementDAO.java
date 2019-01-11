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

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	
	public UserManagementDAO() {
		new ConnectionPool();
	}

	public int userLogin(String user_email, String user_pass) {
		int result = -1;
		
		try {
			String sql = "select user_pass from promotion where user_email=?";
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
		}
		
		return result;
	}

}
