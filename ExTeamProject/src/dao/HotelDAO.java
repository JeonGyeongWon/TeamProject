package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;


import db.ConnectionPool;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import hotel.dto.RoomDTO;
import hotel.dto.UsersDTO;

public class HotelDAO {
	
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	ConnectionPool pool = new ConnectionPool();
	
	public HotelDAO(){
		con = pool.getConnection();
	}
	
	// inserthotel메서드 내부에서 사용할 메서드
	private void insertFaclities(FacilitiesDTO facilities){

		int result = 0;
		
	try{
		
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
		pstmt.setString(13, facilities.getEtc());
		
		result = pstmt.executeUpdate();
		
		if(result > 0){
			System.out.println("Facilities테이블 삽입 성공");
		}else{
			System.out.println("Facilities테이블 삽입 실패");
		}
		
		 //회원가입 성공하면 true리턴
		
	}catch(Exception e){
		System.out.println("insertFacilities에서"+e);
	}finally{
		pool.close(con, pstmt, rs);
	}
	
	
	}
	
	public int insertHotel(HotelDTO hdto, FacilitiesDTO fdto){
		int result = 0;
		String sql = "";
		
		try{
			con = pool.getConnection();
			sql = "insert into hotel(h_name, h_content, h_addr, h_caution, h_rule, h_detail, regdate,imgpath,imgname,user_no,bestcount) "+
			"values(?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, hdto.getH_name());
			pstmt.setString(2, hdto.getH_content());
			pstmt.setString(3, hdto.getH_addr());
			pstmt.setString(4, hdto.getH_caution());
			pstmt.setString(5, hdto.getH_rule());
			pstmt.setString(6, hdto.getH_detail());
			pstmt.setTimestamp(7, null);
			pstmt.setString(8,hdto.getH_imgpath());
			pstmt.setString(9, hdto.getH_imgname());
			pstmt.setInt(10,hdto.getUser_no());
			pstmt.setInt(11, hdto.getH_bestcount());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
			System.out.println("호텔 테이블 삽입 성공");
			
			insertFaclities(fdto);
			
			
		}catch(Exception e){
			System.out.println("insertHotel에서"+e);
		}finally{
			pool.close(con, pstmt, rs);
		}
		
		return result;
	}

		//h_no로 조회된 hotel정보를 삭제하는 메서드
		public int deleteHotel(HotelDTO hotel){
			
			String sql = "DELETE * FROM hotel WHERE h_no=?";
			
			
			try {
				pstmt.setInt(1, hotel.getH_no());
				
				pstmt=con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("deleteHotel()내에서 오류 "+e);
			}finally{
				pool.close(con, pstmt, rs);
			}
			
			
			return 0;
			
		}
		
		
		//방 정보를 입력하는 메서드
		public int insertRoom(RoomDTO room){
			
			String sql = "INSERT INTO room"
					+ "(h_no, h_rno, personne, bed, bathroom, roomsize, weekprice, weekend_price, imgpath, imgname) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			
			int result = 0; //입력 성공 여부를 저장할 변수
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, room.getH_no());
				pstmt.setInt(2, room.getH_rno());
				pstmt.setInt(3, room.getPersonne());
				pstmt.setInt(4, room.getBed());
				pstmt.setInt(5, room.getBathroom());
				pstmt.setString(6, room.getRoomsize());
				pstmt.setInt(7, room.getWeekprice());
				pstmt.setInt(8, room.getWeekend_price());
				pstmt.setString(9, room.getImgpath());
				pstmt.setString(10, room.getImgname());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("insertRoom()메서드 내에서 오류 : "+e);
			}
			
			return 0;
		}
		
	}

	
	
	


