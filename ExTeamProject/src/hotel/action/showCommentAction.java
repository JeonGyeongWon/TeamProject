package hotel.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HotelDAO;
import hotel.dto.Hotel_commentDTO;
import hotel.service.HotelCommentService;
import together.Action;
import together.ActionForward;

public class showCommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int h_c_no = Integer.parseInt("h_c_no");
		HttpSession session = request.getSession();
		
		ArrayList<Hotel_commentDTO> cdto = null;
		if(session.getAttribute("user_no") != null){
			HotelDAO hdao = new HotelDAO();
			cdto = hdao.getCommentList(h_c_no);
		}
		
		ActionForward forward = new ActionForward();
		HotelCommentService service = new HotelCommentService();
		
		ArrayList<Hotel_commentDTO> list = service.getCommentList(h_c_no);
	
		request.setAttribute("list", list);
		forward.setPath("hotel/hotelDetail.jsp?h_no");

		/*Hotel_commentDTO cdto = new Hotel_commentDTO(); 
		
		cdto.setH_no(Integer.parseInt(request.getParameter("h_no")));
		cdto.setH_c_no(Integer.parseInt(request.getParameter("h_c_no")));
		cdto.setSubject(request.getParameter("subject"));
		cdto.setContent(request.getParameter("content"));
		cdto.setRegdate(null);
		cdto.setBestcount(Integer.parseInt(request.getParameter("bestcount")));
		cdto.setUser_no(Integer.parseInt(request.getParameter("user_id")));*/
		
		
		return forward;
	}

}
