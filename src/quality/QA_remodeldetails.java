package quality;

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
 * Servlet implementation class QA_remodeldetails
 */
@WebServlet("/QA_remodeldetails")
public class QA_remodeldetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String itemno = request.getParameter("itemno");
		String cmp=request.getParameter("cmp");
		String pname=request.getParameter("pname");
		String material=request.getParameter("material");
		String length=request.getParameter("length");
		String width=request.getParameter("width");
		String height=request.getParameter("height");
		String opr=request.getParameter("opr");
		
		String sts="requested";
		
		try {
			String qur="insert into qa_remodel values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,itemno);
			ps1.setString(2,cmp);
			ps1.setString(3,pname);
			ps1.setString(4,material);
			ps1.setString(5,length);
			ps1.setString(6,width);
			ps1.setString(7,height);
			ps1.setString(8,opr);
			ps1.setString(9,sts);
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert(' Product has been Damaged')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not fill')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_remodel.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
