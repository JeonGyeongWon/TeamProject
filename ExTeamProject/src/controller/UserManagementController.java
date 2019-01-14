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
import userManagement.LogoutAction;
import userManagement.UserManagementDTO;
import userManagement.getUserInfoAction;
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
		
		//main화면으로 가기 위해 Controller중심처리
		if(command.equals("/main.um")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./index.jsp");
		}
		//header.jsp에서 [로그인]버튼을 클릭했을 때 
		else if(command.equals("/loginPage.um")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("index.jsp?center=/userManagement/login.jsp"); 
		}
		//login.jsp에서 [확인]버튼을 클릭했을 때
		else if(command.equals("/loginPro.um")){
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
				if(forward==null){
					return;
				}
			} catch (Exception e) {
				System.out.print("로그인 처리 과정 오류: ");
				e.printStackTrace();
			}
			
		}
		//header.jsp에서 [로그아웃]버튼을 눌렀을 때
		else if(command.equals("/logoutPro.um")){
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.print("로그아웃 처리 과정 오류: ");
				e.printStackTrace();
			}
			
		}
		//header.jsp에서 [회원가입]버튼을 클릭했을 때
		else if(command.equals("/joinPage.um")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("index.jsp?center=/userManagement/join.jsp");
		}
		
		
		
		//header.jsp에서 [회원정보수정]버튼을 클릭했을 때
		else if(command.equals("/editPage.um")){
//			UserManagementDTO umdto = new getUserInfoAction();
			action = new getUserInfoAction();
			try {
				forward = action.execute(request, response);
				request.getAttribute("umdto");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
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
