package hotel.service;

import dao.HotelDAO;
import hotel.dto.HotelDTO;

//호텔정보작업
public class InsertHotelService {

	public int insertIntoHotel(HotelDTO h){
		
		
		HotelDAO dao = new HotelDAO();
		int result = dao.insertHotel(h);
		
		return 0;
		
	}
		
}
