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
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/views/userinsert.do")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		UserTableVO user = makeUser(request);
		UserTableService uservice = new UserTableService();

		HttpSession session = request.getSession();
		String joinResultMessage = "";

		if (user == null) {
			joinResultMessage = "회원가입에 실패했습니다.";
		} else {
			int result = uservice.insertUser(user);
			if (result > 0) {
				joinResultMessage = "회원가입에 성공했습니다";
				session.setAttribute("userInfo", user);
			} else {
				joinResultMessage = "회원가입에 실패했습니다.";
			}
		}

		session.setAttribute("joinResult", joinResultMessage);

		// userinsert.jsp로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("joinResult.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("userinsert.jsp");
		rd.forward(request, response);
	}

	private UserTableVO makeUser(HttpServletRequest request) {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		UserTableVO user = new UserTableVO();
		user.setUser_id(userid);
		user.setUser_name(username);
		user.setUser_password(password);
		user.setUser_phone(phone);
		user.setUser_email(email);

		return user;
	}

}
