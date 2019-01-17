package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

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
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		System.out.println(command);
		
		if(command.equals("/HotelMain.hotel")){	//메인페이지 이동은 별다른 작업이 없으므로 주소값만 지정한다.
			action = new HotelMainAction();
			try{
			forward = action.execute(request, response);
			}catch(Exception e){
				System.out.println("HotelMain.hotel(서블릿)"+e);
			}
		}else if(command.equals("/InsertHotelForm.hotel")){ //호텔 등록 폼으로 이동
			forward = new ActionForward();	//위와 같음
			forward.setRedirect(true);
			forward.setPath("hotel/hotel_InsertForm.jsp");
		}	
		else if(command.equals("/hotel/InsertHotel.hotel")){
			action = new InsertHotelAction();
			
			
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				System.out.println("InsertHotel.hotel 작업중"+e);
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
