package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class AD_approve
 */
@WebServlet("/AD_approve")
public class AD_approve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String itemno=request.getParameter("itemno");
		String cname=request.getParameter("cname");
		String pname=request.getParameter("pname");
		String material=request.getParameter("material");
		String rel=request.getParameter("rel");
		try {
			String qur="insert into ad_approve values(?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setString(1,itemno);
			ps1.setString(2, cname);
			ps1.setString(3,pname);
			ps1.setString(4,material);			
			ps1.setString(5,rel);
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Product has been Delivered')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("AD_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('You not Update')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("AD_approveproduct.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
