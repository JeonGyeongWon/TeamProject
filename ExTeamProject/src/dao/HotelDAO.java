package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;


import db.ConnectionPool;
import hotel.dto.HotelDTO;

public class HotelDAO {
	
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	ConnectionPool pool = new ConnectionPool();
	
	public HotelDAO(){
		con = pool.getConnection();
	}
	
	public int insertHotel(HotelDTO hotel){
		
		
		return 0;
	}
	
	
	
}
