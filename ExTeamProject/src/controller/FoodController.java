package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import together.ActionForward;
import together.Action;

@WebServlet("*.re")
public class FoodController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request,response);
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Action action = null;
		ActionForward forward = null;	// isRedirect()값이 true일 때 response.sendRedirect(), false일 때 forward().
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		System.out.println("URI는 "+uri+"입니다.");
		System.out.println("contextPath는 "+ctx+"입니다.");
		System.out.println("command는 "+command+"입니다.");
		
		//header.jsp에서 [맛집]을 클릭할 때
		if(command.equals("/RestaurantsMain.re")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./restaurants/RestaurantsMain.jsp");
		}
		//
		else if(command.equals("각 요청 액션페이지")){
			
		}
		//
		else if(command.equals("각 요청 액션페이지")){
			
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
