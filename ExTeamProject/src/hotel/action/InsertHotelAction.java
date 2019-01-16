package hotel.action;

import java.io.File;
import java.io.PrintWriter;
import java.security.Provider.Service;
import java.util.ArrayList;
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
import hotel.dto.RoomDTO;
import hotel.dto.Room_imgDTO;
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
		String realpath = "E:\\upload";	//메인이미지 경로
		String image = "";
		String subimg = "";	//room 서브이미지
		String roomimg =""; //room 메인이미지
    	int max = 50 * 1024 * 1024;
    	
    	MultipartRequest multi = new MultipartRequest(request, realpath,max, "utf-8",new DefaultFileRenamePolicy());
    	
    	HotelDTO Hdto = new HotelDTO();
    	FacilitiesDTO fdto = new FacilitiesDTO();
    	
    	
    	//user_no 값을 얻기 위한 session값을 가져옴
    	HttpSession session = request.getSession();
    	
    	String user_email = (String)session.getAttribute("user_email");
    	
    	//System.out.println(user_email);
    	
    	/* 유저 정보를 넣기위한 udao 생성*/
    	UserManagementDAO udao = new UserManagementDAO();
    	UserManagementDTO udto = udao.getUserInfo(user_email);
    	
    	String addr = "";
    	
    	addr = multi.getParameter("addr1");
    	addr += ","+multi.getParameter("addr2");
    	addr += ","+multi.getParameter("addr3");
    	
    	
    	
    	/*호텔입력부분*/
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
    	ArrayList list = new ArrayList();
    	while(e.hasMoreElements()){
    		
    		String ckimg = (String)e.nextElement();
    		System.out.println("체크이미지 이름은~~ : "+ckimg);
    		if(ckimg.equals("h_img0")){	//호텔 메인이미지
    			image = "/"+multi.getFilesystemName(ckimg);
    		}else if(ckimg.equals("h_img1")){	//룸 메인이미지
    			roomimg = "/"+multi.getFilesystemName(ckimg);
    		}else{	//룸 서브이미지
    			subimg ="/"+multi.getFilesystemName(ckimg);
    			list.add(subimg);
    		}
    	
    	
    	}
    	
    	Hdto.setH_imgpath(realpath);
    	Hdto.setH_imgname(image);	//메인이미지
    	
    	System.out.println("호텔 메인이미지 경로"+realpath);
    	System.out.println("호텔 메인이미지 이름"+image);
    	
    	/*호텔입력 종료*/
    	
    	/*편의시설 입력정보*/
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
    	
    	/*편의시설 입력종료 */
    	
    	/*Room정보 및 Room 서브이미지 입력*/
    	RoomDTO dto = new RoomDTO();
    	
    	dto.setBathroom(Integer.parseInt(multi.getParameter("bathroom")));
    	dto.setBed(Integer.parseInt(multi.getParameter("bed")));
    	dto.setPersonne(Integer.parseInt(multi.getParameter("personnel")));
    	dto.setRoomsize(multi.getParameter("roomsize"));
    	dto.setWeekend_price(Integer.parseInt(multi.getParameter("weekend_price")));
    	dto.setWeekprice(Integer.parseInt(multi.getParameter("weekprice")));
    	
    	
    	
    	
   
    	
    	dto.setImgpath(realpath);
    	dto.setImgname((String)list.get(0));	//RoomMainImage
    	
    	System.out.println("방 메인이미지 경로"+realpath);
    	System.out.println("방 메인이미지 이름"+roomimg);	//RoomMainImage
    	
    	Room_imgDTO RoomSub = new Room_imgDTO();
    	
    	for(int i = 0; i<list.size(); i++){
    		if(i==0){
    			continue;
    		}
    		subimg += (String)list.get(i);
    	}
    	
    	RoomSub.setImgname(subimg);
    	RoomSub.setImgpath(realpath);
    	
    	System.out.println("방 서브이미지 경로"+realpath);
    	System.out.println("방 서브이미지 이름"+subimg);
    	
    	
    	
    	service.insertIntoRoom(dto,RoomSub);
    	
    	forward = new ActionForward();
    	
    	///hotel/HotelMain.hotel
    	if(result){	
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('호텔 및 방을 등록하였습니다')");
    		out.println("</script>");
    		forward.setPath("../HotelMain.hotel");
    	}else{	//수정
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('호텔을 등록에 실패했습니다. 다시시도해보세요')");
    		out.println("</script>");
    		forward.setRedirect(false);
    		forward.setPath("../InsertHotelForm.hotel");
    	}
	
		return forward;
	}

}
