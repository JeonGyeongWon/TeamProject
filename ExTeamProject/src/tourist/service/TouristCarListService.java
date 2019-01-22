package tourist.service;

import java.util.Vector;

import dao.TouristDAO;
import tourist.dto.Tourist_carlistDTO;

public class TouristCarListService {

	public Vector<Tourist_carlistDTO>getCarList(String car_category){
		
		TouristDAO dao = new TouristDAO();
		
		Vector<Tourist_carlistDTO> list = dao.getCarList(car_category);
		
		
		
		
		return null;
		
		
		
	}
	
	

}
