package hotel.action;

import java.io.File;
import java.security.Provider.Service;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.HotelDAO;
import dao.UserManagementDAO;
import dto.UserManagementDTO;
import hotel.service.InsertHotelService;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import together.Action;
import together.ActionForward;

public class InsertHotelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception   {
		
		ActionForward forward = null;
		/*
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/hotel/upload");
		System.out.println(realpath);
		*/
		//가상경로 오류로 임시로 절대경로지정
		String realpath = "D:\\upload";
		String image = "";
    	int max = 50 * 1024 * 1024;
    	
    	MultipartRequest multi = new MultipartRequest(request, realpath,max, "utf-8",new DefaultFileRenamePolicy());
    	
    	HotelDTO Hdto = new HotelDTO();
    	FacilitiesDTO fdto = new FacilitiesDTO();
    	
    	
    	//user_no 값을 얻기 위한 session값을 가져옴
    	HttpSession session = request.getSession();
    	
    	String user_email = (String)session.getAttribute("user_email");
    	
    	System.out.println(user_email);
    	
    	
    	UserManagementDAO udao = new UserManagementDAO();
    	
    	UserManagementDTO udto = udao.getUserInfo(user_email);
    	
    	String addr = "";
    	
    	addr = multi.getParameter("addr1");
    	addr += ","+multi.getParameter("addr2");
    	addr += ","+multi.getParameter("addr3");
    	
    	Hdto.setUser_no(udto.getUser_no());
    	Hdto.setH_name(multi.getParameter("h_name"));
    	Hdto.setH_content(multi.getParameter("h_content"));
    	Hdto.setH_addr(addr);
    	Hdto.setH_caution(multi.getParameter("h_caution"));
    	Hdto.setH_rule(multi.getParameter("h_rule"));
    	Hdto.setH_detail(multi.getParameter("h_detail"));
    	Hdto.setH_regdate(null);
    	
    	
    	// 파일 업로드 관련 
    	Enumeration e = multi.getFileNames();
    	
    	if(e.hasMoreElements()){
    		image = "/"+(String)e.nextElement();
    	}
    	Hdto.setH_imgpath(realpath);
    	Hdto.setH_imgname(image);
    	
    	System.out.println(realpath);
    	System.out.println(image);
    	

    	if(multi.getParameter("wifi")!=null)
    	fdto.setWifi(Integer.parseInt(multi.getParameter("wifi")));
    	
    	if(multi.getParameter("shampoo")!=null)
    	fdto.setShampoo(Integer.parseInt(multi.getParameter("shampoo")));
    	
    	if(multi.getParameter("closet")!=null)
    	fdto.setCloset(Integer.parseInt(multi.getParameter("closet")));
    	
    	if(multi.getParameter("tv")!=null)
    	fdto.setTv(Integer.parseInt(multi.getParameter("tv")));
    	
    	if(multi.getParameter("aircon")!=null)
    	fdto.setAircon(Integer.parseInt(multi.getParameter("aircon")));
    	
    	if(multi.getParameter("hairdry")!=null)
    	fdto.setHairdry(Integer.parseInt(multi.getParameter("hairdry")));
    	
    	if(multi.getParameter("swim")!=null)
    	fdto.setSwim(Integer.parseInt(multi.getParameter("swim")));
    	
    	if(multi.getParameter("wash_dry")!=null)
    	fdto.setWash_dry(Integer.parseInt(multi.getParameter("wash_dry")));
    	
    	if(multi.getParameter("parking")!=null)
    	fdto.setParking(Integer.parseInt(multi.getParameter("parking")));
    	
    	if(multi.getParameter("elevator")!=null)
    	fdto.setElevator(Integer.parseInt(multi.getParameter("elevator")));
    	
    	if(multi.getParameter("health")!=null)
    	fdto.setHealth(Integer.parseInt(multi.getParameter("health")));
    
    	fdto.setEtc(multi.getParameter("etc"));
    	
    	InsertHotelService service = new InsertHotelService();
    	
    	boolean result = service.insertIntoHotel(Hdto,fdto);
    	
    	
    	forward = new ActionForward();
    	
    	///hotel/HotelMain.hotel
    	if(result){	
    		forward.setPath("../HotelMain.hotel");
    		forward.setRedirect(true);
    	}else{	//수정
    		forward.setRedirect(false);
    		forward.setPath("../InsertHotelForm.hotel");
    	}
	
		return forward;
	}

}
