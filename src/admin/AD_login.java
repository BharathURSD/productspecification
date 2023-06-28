package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AD_login
 */
@WebServlet("/AD_login")
public class AD_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		
		String Mail = "admin@gmail.com";
		String Pass = "admin";
		
		
		if(email.equalsIgnoreCase(Mail) && pass.equalsIgnoreCase(Pass)){
		
			pw.println("<html><body><script>alert('Admin Login Successfully')</script></body></html>");
			RequestDispatcher rd2 = request.getRequestDispatcher("AD_homepg.html");
			rd2.include(request,response);
			
			
			
		}
		else
		{
			pw.println("<html><body><script>alert('Incorrect email or password..!!')</script></body></html>");
			RequestDispatcher rd2 = request.getRequestDispatcher("AD_login.html");
			rd2.include(request,response);
			
		}
		
	
	}
}
