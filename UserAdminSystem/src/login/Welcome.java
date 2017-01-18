package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(true);
		String pass=(String) session.getAttribute("pass");
		if (pass==null||!pass.equals("ok")) {
			System.out.println("·Ç·¨µÇÂ¼");
			resp.sendRedirect("login");
		}
		PrintWriter printWriter=resp.getWriter();
		String sessionID=session.getId();
		printWriter.println(sessionID);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		printWriter.println("Weclome");
		printWriter.println("username="+username);
		printWriter.println("password="+password);
	}

}
