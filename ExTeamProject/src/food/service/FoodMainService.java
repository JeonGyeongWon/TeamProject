package food.service;

import java.util.ArrayList;

import dao.FoodDAO;
import food.dto.FoodDTO;


public class FoodMainService {
	
	public ArrayList<FoodDTO> getBringAllFoodInfo(){
		
		FoodDAO fDAO = new FoodDAO();
		ArrayList<FoodDTO> list = fDAO.allSelectedFood();
		System.out.println("FoodMainService로 넘어온 list의 size는 "+list.size()+"입니다.");
		
		for(int i=0; i<list.size(); i++){
			FoodDTO fDTO = list.get(i);
			
			if(fDTO.getF_content().length()>30){
				fDTO.setF_content(fDTO.getF_content().substring(30)+"......");
			}
		}
		
		return list;
	}
}
