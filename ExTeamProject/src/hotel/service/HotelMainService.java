package hotel.service;

import java.util.ArrayList;

import dao.HotelDAO;
import hotel.dto.HotelDTO;

public class HotelMainService {
	
	public ArrayList<HotelDTO>getBringAllHotelInfo(){
		
		HotelDAO dao = new HotelDAO();
		ArrayList<HotelDTO> list = dao.allselectedHotel();
		
		return list;
		
	}
	
}
