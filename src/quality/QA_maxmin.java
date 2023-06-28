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
 * Servlet implementation class QA_maxmin
 */
@WebServlet("/QA_maxmin")
public class QA_maxmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String material=request.getParameter("material");
		String maxlen=request.getParameter("maxlen");
		String minlen=request.getParameter("minlen");
		String maxwid=request.getParameter("maxwid");
		String minwid=request.getParameter("minwid");
		String maxheg=request.getParameter("maxheg");
		String minheg=request.getParameter("minheg");
		String maxthick=request.getParameter("maxthick");
		String minthick=request.getParameter("minthick");
		String maxinn=request.getParameter("maxinn");
		String mininn=request.getParameter("mininn");
		String maxout=request.getParameter("maxout");
		String minout=request.getParameter("minout");
		
		try {
			String qur="insert into qa_maxmin values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setString(1,material);
			ps1.setString(2,maxlen);
			ps1.setString(3,minlen);
			ps1.setString(4,maxwid);
			ps1.setString(5,minwid);
			ps1.setString(6,maxheg);
			ps1.setString(7,minheg);
			ps1.setString(8,maxthick);
			ps1.setString(9,minthick);
			ps1.setString(10,maxinn);
			ps1.setString(11,mininn);
			ps1.setString(12,maxout);
			ps1.setString(13,minout);
			
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Range Value Updated')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not updated')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_maxmin.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
