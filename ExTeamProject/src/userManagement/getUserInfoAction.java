package userManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserManagementDAO;
import together.Action;
import together.ActionForward;

public class getUserInfoAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_email = (String) session.getAttribute("user_email");
		
		UserManagementDAO umdao = new UserManagementDAO();
		//전달받은 user_email값을 getUserInfo()로 전달해 해당 회원정보를 가져와 DTO객체(umdto)에 저장한다.
		dto.UserManagementDTO umdto = umdao.getUserInfo(user_email);
		
		
		ActionForward forward = new ActionForward();
		
		//request영역에 umdto를 저장한다.
		request.setAttribute("umdto", umdto);
		
		forward.setRedirect(false);
		forward.setPath("index.jsp?center=/userManagement/edit.jsp");
		
		return forward;
		
	}

}
