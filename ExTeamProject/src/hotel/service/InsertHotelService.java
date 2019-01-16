package hotel.service;

import dao.HotelDAO;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;

//호텔정보작업
public class InsertHotelService {

	public boolean insertIntoHotel(HotelDTO hdto, FacilitiesDTO fdto){
		
		boolean isInsertHotel = false;
		
		HotelDAO dao = new HotelDAO();
		int result = dao.insertHotel(hdto, fdto);
		
		System.out.println("InsertInto 서비스 메서드 실행");
		
		if(result > 0){
			isInsertHotel = true;
			System.out.println("dao성공");
		}
		
		return isInsertHotel;
		
	}
		
}
