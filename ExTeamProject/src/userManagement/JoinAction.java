package userManagement;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import together.Action;
import together.ActionForward;
import dao.UserManagementDAO;
import dto.UserManagementDTO;

//하는일
//1.회원가입 폼(join.jsp)에서 입력한 정보들을 MemberBean객체(자바빈,DTO)에 저장 시키고....
//2.저장시킨 MemberBean객체를 DB작업을 하기위한 DAO객체에 전달하여 insert회원가입 한다
//3.회원가입 성공시.. 로그인 페이지로 이동 시키기 위해...
//  페이지 이동방식 여부값, 이동할 페이지 경로 값을 new ActionForward();객체에 저장하여..
//  MemberFrontController로 리턴 해주는 역할.
public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("MemberJoinAction클래스의 execute()메소드 호출 당했다~ ");
		
		//회원가입 폼(join.jsp)에서 입력한 정보 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		//1,2 클라이언트 요청정보  받기 
		//3 자바빈 DTO에 저장 
		UserManagementDTO mb = new UserManagementDTO(); //DTO
		System.out.println(request.getParameter("user_email"));
		System.out.println(request.getParameter("user_pass"));
		System.out.println(request.getParameter("user_nickname"));
		System.out.println(Integer.parseInt(request.getParameter("user_birth")));
		System.out.println(request.getParameter("user_gender"));
		mb.setUser_email(request.getParameter("user_email")); 
		mb.setUser_pass(request.getParameter("user_pass"));
		mb.setUser_nickname(request.getParameter("user_nickname"));
		mb.setUser_birth(request.getParameter("user_birth"));
		mb.setUser_gender(request.getParameter("user_gender"));
		
		//회원가입 성공 여부를 담을 변수 선언
		boolean result = false;
		
		UserManagementDAO umdao = new UserManagementDAO();
		
		
		result = umdao.insertMember(mb); //회원가입에 성공하면 true, 실패하면 false리턴
		
		
		if(result == false){ //회원가입에 실패 할경우
			System.out.println("회원가입 실패");
			return null;
		}
		//회원가입 성공시 ~  로그인페이지로 이동 시키기위해 
		//페이지이동방식 여부값, 이동할페이지 경로 값을 저장하여 리턴 해주는 객체 생성
		ActionForward forward = new ActionForward();
		
		//Response.sendRedirect() 방식  <-- 노출함.
		forward.setRedirect(false);
		
		//login.jsp 이동할 페이지 주소 저장
		forward.setPath("/loginPage.um");
		
		
		return forward;
	}

}













