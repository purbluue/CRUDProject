package project_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_DTO.PerformanceVO;
import project_model.PerformanceService;

/**
 * Servlet implementation class PSListServlet
 */
@WebServlet("/pmce/pslist.do")
public class PSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // PerformanceService를 통해 데이터를 가져옴
		PerformanceService pService = new PerformanceService();
	    request.setAttribute("pslist", pService.getPerformancesByStartDate());
	    //JSP에 위임하기
	    RequestDispatcher rd;
	    rd = request.getRequestDispatcher("pslist.jsp");
	    rd.forward(request, response);
	}

}
