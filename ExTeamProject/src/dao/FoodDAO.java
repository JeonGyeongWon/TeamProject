package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.ConnectionPool;

public class FoodDAO {

	ConnectionPool cp;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public FoodDAO() {
		cp.getConnection();
	}
}
