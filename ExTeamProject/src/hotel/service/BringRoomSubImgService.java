package hotel.service;

import dao.HotelDAO;
import hotel.dto.Room_imgDTO;

public class BringRoomSubImgService {
	
	
	public Room_imgDTO bringSubImg(int h_rno){
	
		
		HotelDAO dao = new HotelDAO();
	Room_imgDTO dto = dao.bringRoomDto(h_rno);
	
	return dto;
	
	}

	
}
