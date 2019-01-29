package hotel.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagementDAO;
import dto.UserManagementDTO;
import hotel.dto.FacilitiesDTO;
import hotel.dto.HotelDTO;
import hotel.dto.ReservationDTO;
import hotel.dto.RoomDTO;
import hotel.dto.Room_imgDTO;
import hotel.service.HotelDetailService;
import together.Action;
import together.ActionForward;

public class reservationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String user_email = (String)session.getAttribute("user_email");
		
		ActionForward forward = new ActionForward();
		int h_no = Integer.parseInt(request.getParameter("h_no"));	//호텔정보
		int h_rno = Integer.parseInt(request.getParameter("h_rno"));	//방정보
		
		//예약 관련 정보들을 dto에 담는과정
		ReservationDTO Re_dto = new ReservationDTO();
		
		//시작 날짜 종료날짜 받아오는부분 !! -> timestamp로 지정했기에 date에서 timestamp캐스팅이 되지않습니다... 임의로 10시 체크인 2시체크아웃 추가합니다.
		String tempdate = request.getParameter("begindate");
		
		tempdate += "-10-00-00";
		
		
		String[] tempdate2 = tempdate.split("-");
		
		int year = Integer.parseInt(tempdate2[0]);
		int month = Integer.parseInt(tempdate2[1]);
		int date = Integer.parseInt(tempdate2[2]);
		int hour = Integer.parseInt(tempdate2[3]);
		int minute = Integer.parseInt(tempdate2[4]);
		int second = Integer.parseInt(tempdate2[5]);
		
		Timestamp begindate = new Timestamp(year, month, date, hour, minute, second, 0);
		
		Re_dto.setCkin(begindate);
		
		tempdate = request.getParameter("enddate");
		
		tempdate += "-02-00-00";
		
		tempdate2 = tempdate.split("-");
		
		year = Integer.parseInt(tempdate2[0]);
		month = Integer.parseInt(tempdate2[1]);
		date = Integer.parseInt(tempdate2[2]);
		hour = Integer.parseInt(tempdate2[3]);
		minute = Integer.parseInt(tempdate2[4]);
		second = Integer.parseInt(tempdate2[5]);
		 
		Timestamp enddate = new Timestamp(year, month, date, hour, minute, second, 0);
		
		Re_dto.setCkout(enddate);
		Re_dto.setCkprice(0);	//결제여부확인 최초0
		Re_dto.setH_no(h_no);
		Re_dto.setH_rno(h_rno);
		Re_dto.setUser_no(Integer.parseInt(request.getParameter("user_no")));
		Re_dto.setPersonnel(Integer.parseInt(request.getParameter("personnel")));
		Re_dto.setTotal_price(Integer.parseInt(request.getParameter("total_price")));
		
		
		
		// 기존정보를 가져오는것이기 때문에 이미 만들어져있는 service클래스를 사용 
		HotelDetailService service = new HotelDetailService();
		
		HotelDTO hdto = service.getBringoneHotelInfo(h_no);
		FacilitiesDTO fdto = service.getBringAllFacilities(h_no);
		RoomDTO rdto = service.getBringRoom(h_rno);
		Room_imgDTO r_imgdto = service.getBringRoom_imgInfo(h_rno);
		
		UserManagementDAO udao = new UserManagementDAO();
		UserManagementDTO udto = udao.getUserInfo(user_email);
		
		request.setAttribute("hdto", hdto);
		request.setAttribute("fdto", fdto);
		request.setAttribute("rdto", rdto);
		request.setAttribute("r_imgdto", r_imgdto);
		request.setAttribute("udto", udto);
		//예약창을 한번더 보여주기위해서 DB에 바로저장하지않고 해당정보만보내줌
		request.setAttribute("Re_dto", Re_dto);
		
		forward.setRedirect(false);
		forward.setPath("./hotel/reservation.jsp");
		return forward;
	}

}
