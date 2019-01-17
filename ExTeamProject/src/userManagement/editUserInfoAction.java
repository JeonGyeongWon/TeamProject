package userManagement;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserManagementDAO;
import dto.UserManagementDTO;
import together.Action;
import together.ActionForward;

public class editUserInfoAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String user_email = request.getParameter("user_email");
		String user_nickname = request.getParameter("user_nickname");
		String user_pass = request.getParameter("user_pass");
		String user_birth = request.getParameter("user_birth");
		String user_gender = request.getParameter("user_gender");
		
		UserManagementDTO umdto = new UserManagementDTO();
		umdto.setUser_email(user_email);
		umdto.setUser_nickname(user_nickname);
		umdto.setUser_pass(user_pass);
		umdto.setUser_birth(user_birth);
		umdto.setUser_gender(user_gender);
		
		
		UserManagementDAO umdao = new UserManagementDAO();
		int result = umdao.editUserInfo(umdto);
		ActionForward forward = new ActionForward();
		if(result < 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			return null;
		} else if(result==0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('해당하는 정보가 없습니다.')");
			out.println("</script>");
			return null;
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보가 정상적으로 수정되었습니다.')");
			out.println("</script>");
			forward.setRedirect(false);
			forward.setPath("/main.um");
		}
		
		return forward;
	}

}
