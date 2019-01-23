package food.Action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
//		String path = request.getServletContext().getRealPath("/food/upload");
		String path = request.getSession().getServletContext().getRealPath("/food/upload");
		System.out.println("path는 "+path);
		MultipartRequest multi = new MultipartRequest(request, path, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		//food_InsertForm.jsp에서 넘어온 데이터를 변수에 저장한다.
		String f_name = multi.getParameter("f_name");
		String f_group = multi.getParameter("f_group");
		String f_menu = multi.getParameter("f_menu");
		String f_content = multi.getParameter("f_content");
		String f_addr =multi.getParameter("f_addr");
	
		Enumeration e = multi.getFileNames();
		String fileName = null;
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			System.out.println(name);
				System.out.println("name은 "+name);
				fileName = multi.getFilesystemName(name);
				System.out.println("fileName은 " + fileName);	
		}
		
		FoodDTO fdto = new FoodDTO();
		fdto.setUser_no(user_no);
		fdto.setF_name(f_name);
		fdto.setF_group(f_group);
		fdto.setF_menu(f_menu);
		fdto.setF_content(f_content);
		fdto.setF_addr(f_addr);
		fdto.setF_imgname(fileName);
		fdto.setF_imgpath("/food/upload");
		
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
