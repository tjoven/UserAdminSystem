package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginDeal extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		connectMySql();
        
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("doGet");
		if (username.equals("admin")&&password.equals("admin")) {
			System.out.println("welcome");
			HttpSession session=req.getSession(true);
			
			session.setAttribute("pass", "ok");
			session.setMaxInactiveInterval(30);
//			session.setMaxInactiveInterval(0);清空session
			resp.sendRedirect("welcome?username="+username+"&password="+password);
		}else {
			System.out.println("账户名或密码错误");
			resp.sendRedirect("login");
		}
	}
	/**
	 * 链连接数据库
	 */
	private void connectMySql(){
		ArrayList<String> list=new ArrayList<String>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
	        java.sql.Statement sql=conn.createStatement();
	        java.sql.ResultSet rs=sql.executeQuery("select * from user order by userId asc"); 
	        
	        while(rs.next())
	        {
	            list.add(rs.getString("name"));
	        }
		    for (String string : list) {
				System.out.println(string);
			}
		    rs.close();  
		    sql.close();//关闭连接
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
