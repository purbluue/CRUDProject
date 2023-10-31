package project_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_model.PerformanceService;

/**
 * Servlet implementation class PList
 */
@WebServlet("/pmce/plist.do")
public class PListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PerformanceService pService = new PerformanceService();
		//요청의 영역에 저장하기, 키 이름은 plist, 값은 모든 부서 정보
		request.setAttribute("plist", pService.getAllPerformances());
		
		//JSP에 위임하기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("plist.jsp");
		rd.forward(request, response);
	}
}

