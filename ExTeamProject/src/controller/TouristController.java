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

	
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Action action = null;
		ActionForward forward = null;
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		
		if(command=="/tourismMain.tourist"){
			
			//가장 맨위 action객체로 하위 action클래스 객체를 받는다.
			action = new tourismMainAction();
			
			//액션태그의 execute 메서드를 실행하여 Actionforward객체에 담는다.
			forward = action.execute(request, response);
			
		}else if(command=="각 요청 액션페이지"){
			
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
	
	

}
