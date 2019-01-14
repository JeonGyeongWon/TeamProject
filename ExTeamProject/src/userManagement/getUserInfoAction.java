package userManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserManagementDAO;
import together.Action;
import together.ActionForward;

public class getUserInfoAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		String user_email = request.getParameter("user_email");
		
		//전달받은 user_email값을 getUserInfo()로 전달해 해당 회원정보를 가져온다. 
		UserManagementDAO umdao = new UserManagementDAO();
		//getUserInfo()로 가져온 회원정보를 DTO객체(umdto)에 저장한다.  
		UserManagementDTO umdto = umdao.getUserInfo(user_email);
		
		//request영역에 umdto를 저장한다.
		request.setAttribute("umdto", umdto);
		
		
		forward.setRedirect(false);
		forward.setPath("index.jsp?center=/userManagement/edit.jsp");
		
		return forward;
		
	}

}
