package userManagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserManagementDAO;
import together.Action;
import together.ActionForward;

public class editUserInfoAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserManagementDAO umdao = new UserManagementDAO();
		int result = umdao.editUserInfo();
		System.out.println("editUserInfoAction으로 넘어왔습니다. editUserInfo()의 결과값은 " + result + "입니다.");
		return null;
	}

}
