package project_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/views/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate(); // 세션 무효화
		}
		HttpSession newSession = request.getSession(true); // 새 세션 생성
		// 로그아웃 메시지 설정
		newSession.setAttribute("logoutMessage", "로그아웃 되었습니다."); // 수정된 부분
		// response.sendRedirect("../index.html"); // 메인 페이지로 리디렉션
		response.sendRedirect("logout.jsp");
	}
}
