package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import together.ActionForward;
import userManagement.LoginAction;
import together.Action;

@WebServlet("*.um")
public class UserManagementController extends HttpServlet{

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
		
		//header.jsp에서 [로그인]버튼을 클릭했을 때 
		if(command.equals("/loginPage.um")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./userManagement/login.jsp");
		}
		//login.jsp에서 [확인]버튼을 클릭했을 때
		else if(command.equals("/loginPro.um")){
			action = new LoginAction();
			try {
				System.out.println("loginPro.um까지는 넘어왔다");
				forward = action.execute(request, response);
				System.out.println("loginPro.um의 forward가 저장되었다.");
			} catch (Exception e) {
				System.out.print("로그인 처리 과정 오류: ");
				e.printStackTrace();
			}
			
		}
		//header.jsp에서 [회원가입]버튼을 클릭했을 때
		else if(command.equals("/joinPage.um")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./userManagement/join.jsp");
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());	
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}
		
	}
	
	

}
