package hotel.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.dto.Hotel_commentDTO;
import together.Action;
import together.ActionForward;

public class showCommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();

		Hotel_commentDTO cdto = new Hotel_commentDTO(); 
		
		cdto.setH_no(Integer.parseInt(request.getParameter("h_no")));
		cdto.setH_c_no(Integer.parseInt(request.getParameter("h_c_no")));
		cdto.setSubject(request.getParameter("subject"));
		cdto.setContent(request.getParameter("content"));
		cdto.setRegdate(null);
		cdto.setBestcount(Integer.parseInt(request.getParameter("bestcount")));
		cdto.setUser_no(Integer.parseInt(request.getParameter("user_id")));
		
		
		return forward;
	}

}
