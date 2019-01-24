package food.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dto.FoodDTO;
import food.service.FoodMainService;
import together.Action;
import together.ActionForward;

public class FoodMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		FoodMainService service = new FoodMainService();
		
		ArrayList<FoodDTO> list = service.getBringAllFoodInfo();
		request.setAttribute("list", list);
		System.out.println("FoodMainService에서 list를 가져왔습니다. --- 현재 위치: FoodMainAction.java");
		
		/*
		//개발자 상태 확인 → 추후 삭제 예정
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		//개발자 상태 확인 → 추후 삭제 예정
		*/
		
		forward.setRedirect(false);
		forward.setPath("./index.jsp?center=food/foodMain.jsp");
		System.out.println("FoodMainAction.java를 빠져나갑니다.");
		return forward;
	}

}
