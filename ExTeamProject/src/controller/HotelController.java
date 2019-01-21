package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import hotel.action.BringRoomSubImgAction;
import hotel.action.HotelDetailAction;
import hotel.action.HotelMainAction;
import hotel.action.InsertHotelAction;
import together.ActionForward;
import together.Action;

@WebServlet("*.hotel")
public class HotelController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req,resp);
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		Action action = null;
		ActionForward forward = null;
		
		String uri = request.getRequestURI(); //http://localhost:8181/ExTeamProject/HotelMain.hotel
		String ctx = request.getContextPath();	//http://localhost:8181/ExTeamProject
		String command = uri.substring(ctx.length());///HotelMain.hotel
		System.out.println(command);
		
		if(command.equals("/HotelMain.hotel")){	// 메인페이지로 이동하는 주소 ( 호텔들을 뿌려주는곳)
			action = new HotelMainAction();
			try{
			forward = action.execute(request, response);
			}catch(Exception e){
				System.out.println("HotelMain.hotel(서블릿)"+e);
			}
			///InsertHotel.hotel
		}else if(command.equals("/InsertHotelForm.hotel")){ //호텔 등록 폼으로 이동
			forward = new ActionForward();	//위와 같음
			forward.setRedirect(true);
			forward.setPath("hotel/hotel_InsertForm.jsp");
		}	
		else if(command.equals("/hotel/InsertHotel.hotel")){	// 호텔 및 방 정보등을 DB에 넣는곳
			action = new InsertHotelAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				System.out.println("InsertHotel.hotel 작업중"+e);
				e.printStackTrace();
			}
			
		}else if(command.equals("/HotelDetail.hotel")){
			action = new HotelDetailAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				System.out.println("HotelDetail작업중"+e);
				e.printStackTrace();
			}
		}else if(command.equals("/BringRoomSubImg.hotel")){	//ajax 호텔
			BringRoomSubImgAction ajax = new BringRoomSubImgAction();
			try {
				String roomsumimg = ajax.execute(request, response);
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().write(roomsumimg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(forward != null){
			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());	
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
	}
	
	

}
