package production;

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
 * Servlet implementation class PD_startproduction
 */
@WebServlet("/PD_startproduction")
public class PD_startproduction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String itemno=request.getParameter("itemno");
		String cmp=request.getParameter("cmp");
		String pname=request.getParameter("pname");
		String material=request.getParameter("material");
		String length=request.getParameter("length");
		String width= request.getParameter("width");
		String height= request.getParameter("height");
		String thick=request.getParameter("thick");
		String inndia=request.getParameter("inndia");
		String outdia=request.getParameter("outdia");
		String opr= request.getParameter("opr");
					
		String sts="Request";
		String sts1="Send";
		
		try {
			String qur="update ad_pattern set status='"+sts1+"' where itemno='"+itemno+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
			
			String qur1="insert into pd_production values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur1);
		
			ps1.setString(1, itemno);
			ps1.setString(2, cmp);
			ps1.setString(3, pname);
			ps1.setString(4, material);
			ps1.setString(5, length);
			ps1.setString(6, width);
			ps1.setString(7, height);
			ps1.setString(8, thick);
			ps1.setString(9, inndia);
			ps1.setString(10, outdia);
			ps1.setString(11, opr);	
			ps1.setString(12, sts);
			int i = ps1.executeUpdate();
         
			
			if(i>0) {
				out.print("<html><body><script>alert('Production Details Send to Quality Team Successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("PD_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not updated')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("PD_startproduction.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
