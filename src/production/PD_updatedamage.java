package production;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class PD_updatedamage
 */
@WebServlet("/PD_updatedamage")
public class PD_updatedamage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("hd");
		String sts1=request.getParameter("status");
		
		try {
			String qur="update qa_remodel set status='"+sts1+"' where itemno='"+a+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
	
			
			if(sts1.equals("rejected")) {
				
				out.print("<html><body><script>alert('Product is Damage ')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("PD_damageremodel.jsp");
				rd.include(request, response);
				
			    
			
			}else {
				
				 out.print("<html><body><script>alert('Remodel Product has been Accept')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("PD_homepg.html");
			     rd.include(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}	
	

}
