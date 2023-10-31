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
import project_model.PerformanceService;
import project_model.UserTableDAO;
import project_model.UserTableService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/views/loginCheck.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pswd = request.getParameter("pswd");
		String rem = request.getParameter("remember");
	
		UserTableService uservice = new UserTableService();
		UserTableVO user = uservice.logincheck(userid, pswd); 
	
		//session에 로그인 정보를 저장하기 (있으면 얻기, 없으면 생성)
		HttpSession session = request.getSession();
		System.out.println(user);
		if(user==null) {
			session.setAttribute("loginResult", "아이디와 비밀번호를 확인하세요.");
			response.sendRedirect("loginCheck.do");
			return;
		}
		
		session.setAttribute("loginResult", "");
		session.setAttribute("userInfo", user);
		response.sendRedirect("../index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}
