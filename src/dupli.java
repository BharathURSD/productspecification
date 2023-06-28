

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class dupli
 */
@WebServlet("/dupli")
public class dupli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a = request.getParameter("hd");
		String sts="approved" ;
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String itemno = request.getParameter("itemno");
		String cmp=request.getParameter("cmp");
		String pname=request.getParameter("pname");
		String material=request.getParameter("material"); // material="wood";
		String length=request.getParameter("length");
		String width=request.getParameter("width");
		String height=request.getParameter("height");
		String opr=request.getParameter("opr");
		
		
		
		try {
			// select * from qa_maxmin where materail='wood'; // 
			String query="update pd_production set status='"+sts+"' where itemno='"+a+"'";
			
			String qur1="select * from qa_maxmin where material='" + material + "'";
			
			int r=database.getconnection().prepareStatement(query).executeUpdate();
			
			Statement ps2 = database.getconnection().createStatement();
			ResultSet j=ps2.executeQuery(qur1);
			
            if(sts.equals("rejected")) {
				
				out.print("<html><body><script>alert('Not Send Properly')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("QA_viewproduct.jsp");
				rd.include(request, response);
				
			    
			
			}else {
				
				 out.print("<html><body><script>alert('Accept the Product')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
			     rd.include(request, response);
			}
			
			if(j.next()) {
				
				/*j.getDouble(2);
				j.getDouble(3);
				j.getDouble(4);
				j.getDouble(5);
				j.getDouble(6);
				j.getDouble(7);*/
				
				 
				double maxLength =j.getDouble(2); 
				double minLength =j.getDouble(3); 
				double maxwidth =j.getDouble(4);
				double minwidth =j.getDouble(5);
				double maxheight =j.getDouble(6);
				double minheight =j.getDouble(7);
				
				if(!withInRange(maxLength, minLength, Double.parseDouble(length))) {
					out.print("<html><body><script>alert('Invalid Length')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_applystress.html");
					rd.include(request, response);
					return;
				}
				if(!withInRange(maxwidth, minwidth, Double.parseDouble(width))) {
					out.print("<html><body><script>alert('Invalid Width')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_applystress.html");
					rd.include(request, response);
					return;
				}
				if(!withInRange(maxheight, minheight, Double.parseDouble(height))) {
					out.print("<html><body><script>alert('Invalid Height')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_applystress.html");
					rd.include(request, response);
					return;
				}
			}
			else {
				
			
			
			
			String qur="insert into qa_stress values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,itemno);
			ps1.setString(2,cmp);
			ps1.setString(3,pname);
			ps1.setString(4,material);
			ps1.setString(5,length);
			ps1.setString(6,width);
			ps1.setString(7,height);
			ps1.setString(8,opr);
			
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert(' Product has been Completed')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('Remodeling Product')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_applystress.jsp");
				rd.include(request, response);
			}
			}
			////////////////////////////////////////////////////////////////////////////////
          
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public boolean withInRange(double max,double min, double value) {
		// It must return true only if below statement statisfied
		// 1. value should be lesser than the max
		// 2. value should be greater than the min
		return max>value && min<value;
	
	}
}

		

	