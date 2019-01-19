package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import together.ActionForward;
import together.Action;

@WebServlet("*.fo")
public class FoodController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	protected void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Action action = null;
		ActionForward forward = null; // isRedirect()값이 true일 때
										// response.sendRedirect(), false일 때
										// forward().
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());

		System.out.println("URI는 " + uri + "입니다.");
		System.out.println("contextPath는 " + ctx + "입니다.");
		System.out.println("command는 " + command + "입니다.");

		// main화면으로 이동할 때는 항상 Controller중심처리
		if (command.equals("/main.fo")) {
			// 단순 페이지 이동
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./index.jsp");
		}
		// header.jsp에서 [맛집]을 클릭할 때
		else if (command.equals("/FoodMain.fo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("index.jsp?center=/food/FoodMain.jsp");
		}
		//
		else if (command.equals("/InsertFoodForm.fo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("index.jsp?center=/food/Food_insertForm.jsp");
		}
		else if (command.equals("각 요청 액션페이지")) {

		}

		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}

	}

}
