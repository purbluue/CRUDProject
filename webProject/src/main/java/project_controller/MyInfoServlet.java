package project_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project_DTO.UserTableVO;
import project_model.UserTableService;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/views/myinfo.do")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 아이디를 세션에서 가져오거나 파라미터로 전달받습니다.
		//String user_id = request.getParameter("user_id"); // 또는 세션에서 가져올 수 있음
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String loginid = (String)session.getAttribute("user_id");
		// 사용자 정보를 가져오는 메서드를 호출합니다.
		UserTableService userService = new UserTableService();
		UserTableVO user = userService.getMyUserInfo(loginid);
		session.setAttribute("user", user);
		response.sendRedirect("myinfo.jsp");

		// 사용자 정보를 JSP 페이지로 전달합니다.
		//request.setAttribute("user", user);

		// JSP 페이지로 포워딩합니다.
		//RequestDispatcher dispatcher = request.getRequestDispatcher("myinfo.jsp");
		//dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
