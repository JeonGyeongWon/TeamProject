package food.Action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodDAO;
import dao.UserManagementDAO;
import dto.UserManagementDTO;
import food.dto.FoodDTO;
import together.Action;
import together.ActionForward;

public class InsertFoodAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		//food 테이블에서 회원 정보를 참조하기 위해 user_email값을 이용해 user_no값을 저장한다.
		UserManagementDAO umdao = new UserManagementDAO();
		UserManagementDTO umdto = new UserManagementDTO();
		HttpSession session = request.getSession();
		String user_email = (String) session.getAttribute("user_email");
		umdto = umdao.getUserInfo(user_email);
		int user_no = umdto.getUser_no();
		
		//food_InsertForm.jsp에서 넘어온 데이터를 변수에 저장한다.
		String f_name = request.getParameter("f_name");
		String f_group = request.getParameter("f_group");
		String f_menu = request.getParameter("f_menu");
		String f_content = request.getParameter("f_content");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String addr3 = request.getParameter("addr3");
		String f_addr = null;
		if(addr3 != null){
			f_addr = addr1 + "/" + addr2 + "/" + addr3;
		}else{
			f_addr = addr1 + "/" + addr2;
		}
		
		FoodDTO fdto = new FoodDTO();
		fdto.setUser_no(user_no);
		fdto.setF_name(f_name);
		fdto.setF_group(f_group);
		fdto.setF_menu(f_menu);
		fdto.setF_content(f_content);
		fdto.setF_addr(f_addr);
		
		System.out.println("user_no: " + user_no);
		System.out.println("f_name: " + f_name);
		System.out.println("f_group: " + f_group);
		System.out.println("f_menu: " + f_menu);
		System.out.println("f_content: " + f_content);
		System.out.println("f_addr: " + f_addr);
		
		FoodDAO fdao = new FoodDAO();
		int result = fdao.insertFood(fdto);
		
		ActionForward forward = new ActionForward();
		if(result != 1){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글 등록 실패!')");
			out.println("</script>");
			return null;
		}else{
			
			forward.setRedirect(false);
			forward.setPath("./index.jsp?center=/food/foodMain.jsp");
		}
		
		
		return forward;
	}

}
