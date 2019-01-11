package userManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagementDAO;
import dto.UserManagementDTO;
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
			
		}
		else if(result == 0){
			
		}
		else if(result == 1){
			HttpSession session = request.getSession();
			session.setAttribute("user_email", user_email);
			forward.setRedirect(true);
			forward.setPath("./index.jsp");
		}
		
		return forward;
	}
	
}
