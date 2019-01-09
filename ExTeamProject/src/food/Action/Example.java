package food.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import together.Action;
import together.ActionForward;

public class Example implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 프론트서블릿을 통해 들어온 페이지
	 * 최고조상인 Action페이지를 구현하여 
	 * Service메서드를 호출하여 DB작업한후 ActionForward 객체로 리턴함  
	 * 
	 * 
	 */
}
