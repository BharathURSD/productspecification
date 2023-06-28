

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String empid=request.getParameter("empid");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String num=request.getParameter("num");
		String pre=request.getParameter("pre");
		String role=request.getParameter("role");
		String exp=request.getParameter("exp");
		
		try {
			String qur="insert into register values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setString(1,name);
			ps1.setString(2, empid);
			ps1.setString(3,email);
			ps1.setString(4,pass);
			ps1.setString(5,cpass);
			ps1.setString(6, num);
			ps1.setString(7, pre);
			ps1.setString(8,role);
			ps1.setString(9, exp);
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Register sucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not registered')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
