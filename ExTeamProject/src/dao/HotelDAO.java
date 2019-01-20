package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;


import db.ConnectionPool;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import hotel.dto.RoomDTO;
import hotel.dto.Room_imgDTO;
import dto.UserManagementDTO;

public class HotelDAO {
	
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	ConnectionPool pool = new ConnectionPool();
	
	
	
	// 모든 호텔 정보를 가져오는 메서드 
	public ArrayList<HotelDTO> allselectedHotel(){
		
		ArrayList<HotelDTO> list = new ArrayList<HotelDTO>();
		String sql = "";
		HotelDTO dto = new HotelDTO();
		
		try{
			con = pool.getConnection();
			sql = "select * from hotel order by h_no desc";
			pstmt=con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto.setH_addr(rs.getString("h_addr"));
				dto.setH_bestcount(rs.getInt("bestcount"));
				dto.setH_caution(rs.getString("h_caution"));
				dto.setH_content(rs.getString("h_content"));
				dto.setH_detail(rs.getString("h_detail"));
				dto.setH_imgname(rs.getString("imgname"));
				dto.setH_imgpath(rs.getString("imgpath"));
				dto.setH_name(rs.getString("h_name"));
				dto.setH_no(rs.getInt("h_no"));
				dto.setH_regdate(rs.getTimestamp("regdate"));
				dto.setH_rule(rs.getString("h_rule"));
				dto.setUser_no(rs.getInt("user_no"));
				list.add(dto);
			}
			
		}catch(Exception e){
			System.out.println("allselectedHotel에서"+e);
		}finally{
			pool.close(con, pstmt, rs);
		}
		return list;
	}
	
	
	//각 호텔 번호를 이용해 룸 정보를 가져오는 메서드
	public ArrayList<RoomDTO> allselectedRoom(int h_no) {
		
		String sql ="";
		ArrayList<RoomDTO> list = new ArrayList<>();
		try{
			con = pool.getConnection();
			sql = "select * from room where h_no =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, h_no);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				RoomDTO dto = new RoomDTO();
				dto.setH_rno(rs.getInt("h_rno"));
				dto.setH_no(rs.getInt("h_no"));
				dto.setBed(rs.getInt("bed"));
				dto.setPersonne(rs.getInt("personnel"));
				dto.setBathroom(rs.getInt("bathroom"));
				dto.setRoomsize(rs.getString("roomsize"));
				dto.setWeekprice(rs.getInt("weekprice"));
				dto.setWeekend_price(rs.getInt("weekend_price"));
				dto.setImgname(rs.getString("imgname"));
				dto.setImgpath(rs.getString("imgpath"));
				list.add(dto);
			}
		}catch(Exception e){
			System.out.println("allselectedRoom에서"+e);
		}finally{
			pool.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	
	// 각 호텔 번호를 이용해 편의시설을 가져오는 메서드
	public FacilitiesDTO oneselectedFacilities(int h_no){
		FacilitiesDTO dto = new FacilitiesDTO();
		String sql ="";
		
		try{
			con = pool.getConnection();
			sql = "select * from facilities where h_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, h_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto.setAircon(rs.getInt("aircon"));
				dto.setCloset(rs.getInt("closet"));
				dto.setElevator(rs.getInt("elevator"));
				dto.setEtc(rs.getString("etc"));
				dto.setH_no(rs.getInt("h_no"));
				dto.setHairdry(rs.getInt("hairdry"));
				dto.setHealth(rs.getInt("health"));
				dto.setParking(rs.getInt("parking"));
				dto.setShampoo(rs.getInt("shampoo"));
				dto.setSwim(rs.getInt("swim"));
				dto.setTv(rs.getInt("tv"));
				dto.setWash_dry(rs.getInt("wash_dry"));
				dto.setWifi(rs.getInt("wifi"));
			}
			
		}catch(Exception e){
			System.out.println("allselectedFacilities에서"+e);
		}finally{
			pool.close(con, pstmt, rs);
		}
		return dto;
	}
	
	
	// inserthotel메서드 내부에서 사용할 메서드
	private void insertFaclities(FacilitiesDTO facilities){

		int result = 0;
		
	try{
		con = pool.getConnection();
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
	
	//1개의 호텔정보를 가져오는 메서드
	
	public HotelDTO oneHotelInfo(int h_no){
		HotelDTO dto = new HotelDTO();
		String sql ="";
		
		try{
			con = pool.getConnection();
			
			sql = "select * from hotel where h_no = ?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, h_no);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dto.setH_addr(rs.getString("h_addr"));
				dto.setH_bestcount(rs.getInt("bestcount"));
				dto.setH_caution(rs.getString("h_caution"));
				dto.setH_content(rs.getString("h_content"));
				dto.setH_detail(rs.getString("h_detail"));
				dto.setH_imgname(rs.getString("imgname"));
				dto.setH_imgpath(rs.getString("imgpath"));
				dto.setH_name(rs.getString("h_name"));
				dto.setH_no(rs.getInt("h_no"));
				dto.setH_regdate(rs.getTimestamp("regdate"));
				dto.setH_rule(rs.getString("h_rule"));
				dto.setUser_no(rs.getInt("user_no"));
			}
		}catch(Exception e){
			System.out.println("oneHotelInfo에서"+e);
			
		}finally{
			pool.close(con, pstmt, rs);
		}
		
		return dto;
	}
	
	
	//호텔 삽입 메서드
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
				con = pool.getConnection();
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
		
		private int insertSubRoom_img(Room_imgDTO dto){
			
			int result=0;
			String sql="";
			
			try{
				con = pool.getConnection();
				sql = "select * from room order by h_rno desc";
				
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				rs.next();
				
				int h_rno=rs.getInt("h_rno");
				int h_no =rs.getInt("h_no");
				
				
				
				sql = "insert into room_img value(?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, h_no);
				pstmt.setInt(2, h_rno);
				pstmt.setString(3, dto.getImgpath());
				pstmt.setString(4, dto.getImgname());
				
				result = pstmt.executeUpdate();
				
			}catch(Exception e){
				System.out.println("insertSubRoom_img에서"+e);
			}finally{
				pool.close(con, pstmt, rs);
			}
			
			
			return result;
		}
		
		//방 정보를 입력하는 메서드
		public int insertRoom(RoomDTO room, Room_imgDTO roomsub){
			
			String sql = "INSERT INTO room"
					+ "(h_no, personnel, bed, bathroom, roomsize, weekprice, weekend_price, imgpath, imgname) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			int result = 0; //입력 성공 여부를 저장할 변수
			
			try {
				con = pool.getConnection();
				
				String sql2 = "SELECT * FROM hotel order by h_no desc";
				
				pstmt=con.prepareStatement(sql2);
				
				rs = pstmt.executeQuery();
				rs.next();
				
				int h_no = rs.getInt("h_no");
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, h_no);
				pstmt.setInt(2, room.getPersonne());
				pstmt.setInt(3, room.getBed());
				pstmt.setInt(4, room.getBathroom());
				pstmt.setString(5, room.getRoomsize());
				pstmt.setInt(6, room.getWeekprice());
				pstmt.setInt(7, room.getWeekend_price());
				pstmt.setString(8, room.getImgpath());
				pstmt.setString(9, room.getImgname());
				
				result = pstmt.executeUpdate();
				
				insertSubRoom_img(roomsub);
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("insertRoom()메서드 내에서 오류 : "+e);
			}
			
			return 0;
		}


		public Room_imgDTO bringRoom_imgDto(int h_rno) {
			
			String sql = "";
			Room_imgDTO dto = new Room_imgDTO();
			try{
				con = pool.getConnection();
				sql = "select * from room_img where h_rno = ?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, h_rno);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					dto.setH_no(rs.getInt("h_no"));
					dto.setH_rno(rs.getInt("h_rno"));
					dto.setImgname(rs.getString("imgname"));
					dto.setImgpath(rs.getString("imgpath"));
				}
			}catch(Exception e){
				System.out.println("bringRoom_imgDto에서"+e);
			}finally{
				pool.close(con, pstmt, rs);
			}
			
			return dto;
		}


		//방정보를 가져옴 
		public RoomDTO bringRoomDto(int h_rno) {
			
			RoomDTO dto = new RoomDTO();
			String sql = "";
			try{
				con = pool.getConnection();
				sql = "select * from room where h_rno = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, h_rno);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					dto.setBathroom(rs.getInt("bathroom"));
					dto.setBed(rs.getInt("bed"));
					dto.setH_no(rs.getInt("h_no"));
					dto.setH_rno(rs.getInt("h_rno"));
					dto.setImgname(rs.getString("imgname"));
					dto.setImgpath(rs.getString("imgpath"));
					dto.setPersonne(rs.getInt("personnel"));
					dto.setRoomsize(rs.getString("roomsize"));
					dto.setWeekend_price(rs.getInt("weekend_price"));
					dto.setWeekprice(rs.getInt("weekprice"));
				}
			}catch(Exception e){
				System.out.println("bringRoomDto에서"+e);
			}finally{
				pool.close(con, pstmt, rs);
			}
			
			return dto;
		}

		
		
		
	}

	
	
	


