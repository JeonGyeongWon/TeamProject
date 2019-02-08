package hotel.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.dto.HotelDTO;
import hotel.dto.pagingDto;
import hotel.service.HotelMainService;
import together.Action;
import together.ActionForward;

public class HotelMainAction implements Action {

	//호텔메인에서 호텔이미지들을 뿌려주는 액션클래스
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HotelMainService service = new HotelMainService();
		ArrayList<HotelDTO> list = null;
		//페이징
		
		request.setCharacterEncoding("utf-8");
		
		int totalCount = service.getTotalCount();
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		     
	    pagingDto paging = new pagingDto();
	    paging.setPageNo(page); //get방식의 parameter값으로 반은 page변수, 현재 페이지 번호
	    paging.setPageSize(10); // 한페이지에 불러낼 게시물의 개수 지정
	    paging.setTotalCount(totalCount);
		     
	    page = (page - 1) * 10; //select해오는 기준을 구한다.

		
		//검색관련 
		
		if(request.getParameter("key")!= null){	//검색시			
			int key = Integer.parseInt(request.getParameter("key"));		
			String word = request.getParameter("word");
			list = service.getBringSearch(key,word,page,paging.getPageSize());	
			System.out.println(list.size());
		}else{ //미검색시
		list = service.getBringAllHotelInfo(page,paging.getPageSize());	
		}
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		forward.setRedirect(false);
		
		forward.setPath("./index.jsp?center=hotel/hotelMain.jsp");
		return forward;
		
	}

}
