package userManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.userManagementDTO;
import together.Action;
import together.ActionForward;

public class loginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		userManagementDTO dto = new userManagementDTO();
		dto.setUser_email(request.getParameter("user_email"));
		dto.setUser_pass(request.getParameter("user_pass"));
		
		
		ActionForward forward = new ActionForward();
		
		return forward;
	}
	
}
