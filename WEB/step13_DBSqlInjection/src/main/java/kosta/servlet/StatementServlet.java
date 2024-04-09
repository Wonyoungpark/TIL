package kosta.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kosta.dao.SecurityDao;

/**
 * Servlet implementation class StatementServlet
 */
@WebServlet("/selectState")
public class StatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno = request.getParameter("empno");//
		
		SecurityDao dao= new SecurityDao();
		List<String> list = dao.statementSelect(empno);
		
		System.out.println("statement 개수 : " +  list.size());
		
		
	}

}








