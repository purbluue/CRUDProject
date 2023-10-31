package project_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReceiptServlet
 */
@WebServlet("/views/receipt.do")
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String textAreaContent = request.getParameter("receipt");

		HttpSession session = request.getSession();

		if (textAreaContent == null || textAreaContent.trim().isEmpty()) {
			session.setAttribute("receiptResult", "내용을 입력하세요.");
			response.sendRedirect("receipt.do");
			return;
		}
		session.setAttribute("receiptResult", "내용을 전송하겠습니다.");
		response.sendRedirect("receipt.do");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("receipt.jsp");
		rd.forward(request, response);
	}

}
