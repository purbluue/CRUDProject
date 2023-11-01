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
import project_model.UserTableDAO;
import project_model.UserTableService;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/views/userdelete.do")
public class UserDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username"); // 사용자 아이디를 요청 매개변수에서 가져옵니다.

		int resultCount = UserTableService(username); // userdelete 메서드 호출

		if (resultCount > 0) {
			request.setAttribute("deleteMessage", "계정이 성공적으로 탈퇴되었습니다.");
		} else {
			request.setAttribute("deleteMessage", "계정 탈퇴에 실패했습니다.");
		}

		// 로그아웃
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("deleteResult.jsp");
		dispatcher.forward(request, response);
	}
}