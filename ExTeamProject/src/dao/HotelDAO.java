package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;


import db.ConnectionPool;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;

public class HotelDAO {
	
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	ConnectionPool pool = new ConnectionPool();
	
	public HotelDAO(){
		con = pool.getConnection();
	}

	
	public int insertHotel(HotelDTO hotel, FacilitiesDTO facilities){
		
		int result = 0; //입력 성공 여부를 저장할 변수

		try {
			String sql1 = "INSERT INTO hotel"
					+ "(h_name, h_content, h_addr, h_caution, h_rule, h_detail, regdate, imgpath, imgname, bestcount) + "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql1);

			pstmt.setString(1, hotel.getH_name());
			pstmt.setString(2, hotel.getH_content());
			pstmt.setString(3, hotel.getH_addr());
			pstmt.setString(4, hotel.getH_caution());
			pstmt.setString(5, hotel.getH_rule());
			pstmt.setString(6, hotel.getH_detail());
			pstmt.setTimestamp(7, hotel.getH_regdate());
			pstmt.setString(8, hotel.getH_imgpath());
			pstmt.setString(9, hotel.getH_imgname());
			pstmt.setInt(10, hotel.getH_bestcount());
			
			result = pstmt.executeUpdate(); //입력 성공시 1, 실패시 0 리턴
			
			String sql2 = "SELECT * FROM hotel order by h_no desc";
			pstmt = con.prepareStatement(sql2);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			int h_no = rs.getInt("h_no");
			
			
			String sql3 = "INSERT INTO facilities"
					+ "(h_no, wifi, shampoo, closet, tv, aircon, hairdry, swim, wash_dry, parking, elevator, health, etc)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
			pstmt=con.prepareStatement(sql3);
			
			pstmt.setInt(1, h_no);
			pstmt.setInt(2, facilities.getWifi());
			pstmt.setInt(3, facilities.getShampoo());
			pstmt.setInt(4, facilities.getCloset());
			pstmt.setInt(5, facilities.getTv());
			pstmt.setInt(6, facilities.getAircon());
			pstmt.setInt(7, facilities.getHairdry());
			pstmt.setInt(8, facilities.getSwim());
			pstmt.setInt(9, facilities.getWash_dry());
			pstmt.setInt(10, facilities.getParking());
			pstmt.setInt(11, facilities.getElevator());
			pstmt.setInt(12, facilities.getHealth());
			pstmt.setInt(13, facilities.getEtc());
			
			if(result != 0) return 1; //회원가입 성공하면 true리턴
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		return 0;
		
	}

		
		public int deleteHotel(HotelDTO hotel, FacilitiesDTO facilities){
			
			
			
			return 0;
			
		}
	}
	
	
	


