package hotel.action;

import java.io.File;
import java.security.Provider.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.HotelDAO;
import hotel.service.InsertHotelService;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import together.Action;
import together.ActionForward;

public class InsertHotelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward = null;
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/hotel/upload");
		System.out.println(realpath);
		String image = "";
    	int max = 50 * 1024 * 1024;
    	
    	MultipartRequest multi = new MultipartRequest(request, realpath,max, "utf-8",new DefaultFileRenamePolicy());
    	
    	HotelDTO Hdto = new HotelDTO();
    	FacilitiesDTO fdto = new FacilitiesDTO();
    	
    	Hdto.setH_name(multi.getParameter("h_name"));
    	Hdto.setH_content(multi.getParameter("h_content"));
    	multi.getParameter("h_addr");
    	multi.getParameter("h_caution");
    	multi.getParameter("h_rule");
    	multi.getParameter("h_detail");
    	
    	fdto.setWifi(multi.getParameter("wifi"));
    	wifi
    	shampoo
    	closet
    	tv
    	aircon
    	hairdry
    	swim
    	wash_dry
    	parking
    	elevator
    	health
    	etc
    	
    	InsertHotelService service = new InsertHotelService();
    	
    	int result = service.insertIntoHotel(Hdto);
    	
    	if(result ==0){
    		forward.setPath("/hotel/insertForm.jsp");
    		forward.setRedirect(true);
    	}else{	//수정
    		forward.setRedirect(false);
    		forward.setPath("/HotelMain.hotel");
    	}
    	//imgpath와 imgname을 나누기
		
		return null;
	}

}
