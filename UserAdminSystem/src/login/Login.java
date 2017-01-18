package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out=resp.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<h1>µÇÂ¼</h1>");
		out.println("<form action=loginDeal method=get>");
		out.println("ÓÃ»§Ãû£º<input type=test name= username><br>");
		out.println("ÃÜ     Âë£º<input type=password name= password><br>");
		out.println("<input type=submit value=login><br>");
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
