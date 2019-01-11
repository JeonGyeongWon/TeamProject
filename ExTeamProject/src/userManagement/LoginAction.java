package userManagement;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagementDAO;
import food.dto.UserManagementDTO;
import together.Action;
import together.ActionForward;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String user_email = request.getParameter("user_email");
		String user_pass = request.getParameter("user_pass");
		
		UserManagementDAO umdao = new UserManagementDAO();
		ActionForward forward = new ActionForward();
		int result = umdao.userLogin(user_email, user_pass);
		if(result == -1){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 비밀번호를 다시 확인하세요.')");
			out.println("location.back()");
			out.println("<script>");
			return null;
		}
		else if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("location.back()");
			out.println("<script>");
			return null;
		}
		else if(result == 1){
			System.out.println("LoginAction-execute()-result값은 " + result);
			HttpSession session = request.getSession();
			session.setAttribute("user_email", user_email);
			forward.setRedirect(true);
			forward.setPath("./index.jsp");
		}
		
		return forward;
	}
	
}
