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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/views/userupdate.do")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		// 요청에서 사용자 정보 가져오기
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String reuser_id = request.getParameter("reuser_id");
		String reuser_name = request.getParameter("reuser_name");
		String reuser_password = request.getParameter("reuser_password");
		String reuser_phone = request.getParameter("reuser_phone");
		String reuser_email = request.getParameter("reuser_email");
		System.out.println(user_id);

		// 서비스를 사용하여 사용자 정보 업데이트
		UserTableService userService = new UserTableService();
		UserTableVO updatedUser = userService.getUpdateUser(user_id, reuser_id, reuser_name, reuser_password,
				reuser_phone, reuser_email);
		session.setAttribute("user_id", reuser_id);

		// 업데이트가 성공했는지 확인하고 적절한 응답 반환
		if (updatedUser != null) {
			// 업데이트 성공
			request.setAttribute("result", "사용자 정보가 업데이트되었습니다.");
			//response.getWriter().write("사용자 정보가 업데이트되었습니다.");
		} else {
			// 업데이트 실패
			response.getWriter().write("사용자 정보 업데이트에 실패했습니다.");
		}
		
	//	response.sendRedirect("updateResult.jsp");
			response.sendRedirect("../index.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("userupdate.jsp");
		rd.forward(request, response);
	}
}
