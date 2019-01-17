package hotel.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import hotel.dto.RoomDTO;
import hotel.service.HotelDetailService;
import together.Action;
import together.ActionForward;

public class HotelDetailAction implements Action {

	//호텔정보 및 방정보를 보여주는곳
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int h_no = Integer.parseInt(request.getParameter("h_no"));
		ActionForward forward = new ActionForward();
		
		HotelDetailService service = new HotelDetailService();
		
		HotelDTO hdto = service.getBringoneHotelInfo(h_no);
		FacilitiesDTO fdto = service.getBringAllFacilities(h_no);
		ArrayList<RoomDTO> rlist = service.getBringAllRoomInfo(h_no);
		
		
		request.setAttribute("hdto", hdto);
		request.setAttribute("fdto", fdto);
		request.setAttribute("rlist", rlist);
		
		forward.setRedirect(false);
		forward.setPath("hotel/hotelDetail.jsp");
		
		return forward;
	}

}
