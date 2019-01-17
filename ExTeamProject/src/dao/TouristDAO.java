package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.ConnectionPool;

public class TouristDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ConnectionPool pool = new ConnectionPool();
	
	public TouristDAO() {
		con = pool.getConnection();
		
		
	}
	
}
