package project_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project_DTO.PerformanceVO;
import project_model.PerformanceService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/views/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자 입력 파라미터 가져오기
		
		 
		String searchType = request.getParameter("searchType");
		String searchQuery  = request.getParameter("searchQuery");
		
		 
		//System.out.println(searchType + ":" + searchQuery);
		 
		 

		List<PerformanceVO> pnameList = null;

		// 서비스를 통해 검색 결과 얻기
		PerformanceService pservice = new PerformanceService();
		if ("performance".equals(searchType)) {
			pnameList = pservice.searchPerformancesByName(searchQuery);
		} else if ("director".equals(searchType)) {
			pnameList = pservice.searchPerformancesByDirector(searchQuery);
		}
		request.setAttribute("pname", pnameList);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
 
	}

	 

}
