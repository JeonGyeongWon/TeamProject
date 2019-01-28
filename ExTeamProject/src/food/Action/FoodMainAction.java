package food.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDAO;
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
		
		forward.setRedirect(false);
		forward.setPath("./index.jsp?center=food/foodMain.jsp");
		return forward;
	}

}
