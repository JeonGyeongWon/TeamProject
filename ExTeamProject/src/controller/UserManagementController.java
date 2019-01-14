package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import together.ActionForward;
import userManagement.JoinAction;
import together.ActionForward;
import userManagement.LoginAction;
import userManagement.LogoutAction;
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
				System.out.println("loginPro.um까지는 넘어왔다");
				forward = action.execute(request, response);
				if(forward==null){
					return;
				}
				System.out.println("loginPro.um의 forward가 저장되었다.");
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
		
		}else if(command.equals("/userManagement/JoinAction.um")){
				
				//회원가입 DB처리를 위한 Action객체 생성
				action = new JoinAction();
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}	
		
				//회원가입에 성공했을때.. 로그인 화면으로 이동하라라는 요청!
				
		}else if(command.equals("/loginPage.um")){ //로그인페이지로 이동 시켜줘~ 라는 요청
			
			forward = new ActionForward();
			
			forward.setRedirect(false); 
			
			forward.setPath("./index.jsp?center=member/login.jsp");
		
			
		}else if(command.equals("/Main.um")){//Main.jsp메이페이지 요청!
		
		forward = new ActionForward();
		
		forward.setRedirect(false); 
		
		forward.setPath("./Main.jsp");
	
		}
		
		//뷰페이지로 이동 하는 역할
		if(forward != null){
			if(forward.isRedirect()){ //이동방식 여부 값이 true일때.. Response.sendRedirect()방식
									
				response.sendRedirect(forward.getPath()); 				
			
			}else{//이동방식 여부값이 false일떄 .. RequestDispatcher  forward()방식 
				
				RequestDispatcher  dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			
			}		
		}
	}
}
