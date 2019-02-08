package hotel.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.dto.HotelDTO;
import hotel.service.HotelMainService;
import together.Action;
import together.ActionForward;

public class HotelMainAction implements Action {

	//호텔메인에서 호텔이미지들을 뿌려주는 액션클래스
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//검색관련 
		ActionForward forward = new ActionForward();
		HotelMainService service = new HotelMainService();
		ArrayList<HotelDTO> list = null;
		if(request.getParameter("key")!= null){	//검색시
			
			int key = Integer.parseInt(request.getParameter("key"));
			if(key==0){	//호텔이름
				String word = request.getParameter("word");
				list = service.getBringSearch(key,word);
			}else{//지역구관련
				
			}
			
			
		}else{ //미검색시
		
		list = service.getBringAllHotelInfo();
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		
		forward.setPath("./index.jsp?center=hotel/hotelMain.jsp");
		}
		return forward;
		
	}

}
