package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import together.ActionForward;
import tourism.Action.tourismMainAction;
import together.Action;

@WebServlet("*.tourist")
public class TouristController extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Action action = null;
		ActionForward forward = null;
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		System.out.println("URI는 "+uri+"입니다.");
		System.out.println("contextPath는 "+ctx+"입니다.");
		System.out.println("command는 "+command+"입니다.");	
		
		if(command.equals("/TouristMain.tourist")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("tourist/TouristMain.jsp");
			
		}else if(command.equals("각 요청 액션페이지")){
			
		}
		
		
		// 요청페이지가 있을경우 
		if(forward != null){
			
			//Redirect방식인지 dispatcher인지 확인하여 이동시켜줌
			//*참고 : dispatcher -> request,response영역을 같이줌
			//		Redirect -> 안줘도 되는 부분 
			
			
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
