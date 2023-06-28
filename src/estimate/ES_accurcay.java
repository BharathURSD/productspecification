package estimate;

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
 * Servlet implementation class ES_accurcay
 */
@WebServlet("/ES_accurcay")
public class ES_accurcay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String itemno=request.getParameter("itemno");
		String cname=request.getParameter("cname");
		String num=request.getParameter("num");
		String cmp=request.getParameter("cmp");
		String pname=request.getParameter("pname");
		String material=request.getParameter("material");
		String length=request.getParameter("length");
		String width= request.getParameter("width");
		String height= request.getParameter("height");
		String amount = request.getParameter("amount");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String opr= request.getParameter("opr");
		String status= request.getParameter("status");
        
		try {
			String qur="insert into es_productdata values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setString(1, itemno);
			ps1.setString(2, cname);
			ps1.setString(3, num);
			ps1.setString(4, cmp);
			ps1.setString(5, pname);
			ps1.setString(6, material);
			ps1.setString(7, length);
			ps1.setString(8, width);
			ps1.setString(9, height);
			ps1.setString(10, amount);
			ps1.setString(11, start);
			ps1.setString(12, end);
			ps1.setString(13, opr);
			ps1.setString(14, status);
			int i = ps1.executeUpdate();
         
			
			if(i>0) {
				out.print("<html><body><script>alert('Possible Product Updated Successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("ES_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not fill')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("ES_accurcay.jsp");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
