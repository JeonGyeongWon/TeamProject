package hotel.service;

import java.util.ArrayList;

import dao.HotelDAO;
import dao.UserManagementDAO;
import dto.UserManagementDTO;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import hotel.dto.RoomDTO;
import hotel.dto.Room_imgDTO;
import hotel.dto.UsersDTO;

public class HotelDetailService {
	
	HotelDAO dao = new HotelDAO();
	
	//한 호텔정보를 가져옴
	public HotelDTO getBringoneHotelInfo(int h_no){
		HotelDTO dto = dao.oneHotelInfo(h_no);
		return dto;
	}
	
	//호텔편의시설을 가져옴
	public FacilitiesDTO getBringAllFacilities(int h_no){
		FacilitiesDTO dto = dao.oneselectedFacilities(h_no);
		return dto;
	}
	
	//호텔 룸에 대한 정보를 가져옴 -> 내부적으로 room_img도 들고와야함!!
	public ArrayList<RoomDTO> getBringAllRoomInfo(int h_no){
		ArrayList<RoomDTO> list = dao.allselectedRoom(h_no);
		
		return list;
	}

	public UserManagementDTO bringHotelManageInfo(int user_no) {
	
		UserManagementDTO dto = dao.bringHotelManageInfo(user_no);
		
		return dto;
	}

	
	
	
	


	
}
