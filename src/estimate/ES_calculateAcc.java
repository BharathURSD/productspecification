package estimate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class ES_calculateAcc
 */
@WebServlet("/ES_calculateAcc")
public class ES_calculateAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet rs1=null;
		
		  try{
			  String qry1 ="select * from es_productpass";
				rs1 = database.getconnection().createStatement().executeQuery(qry1);
				while(rs1.next())
				{	
			 
			 /* String qry2 ="select * from es_productdata";      
		    	 rs2 = database.getconnection().createStatement().executeQuery(qry2);
		    	while(rs1.next())
		    	{*/
		     	/*double amount1 = 250000;
		     	double amount = rs1.getDouble(10);
		      if(amount>amount1){*/
		    	  String qur = "insert into es_splitdata values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
					ps1.setString(1, rs1.getString(1));
					ps1.setString(2, rs1.getString(2));
					ps1.setString(3, rs1.getString(3));
					ps1.setString(4, rs1.getString(4));
					ps1.setString(5, rs1.getString(5));
					ps1.setString(6, rs1.getString(6));
					ps1.setString(7, rs1.getString(7));
					ps1.setString(8, rs1.getString(8));
					ps1.setString(9, rs1.getString(9));
					ps1.setString(10, rs1.getString(10));
					ps1.setString(11, rs1.getString(11));
					ps1.setString(12, rs1.getString(12));
					ps1.setString(13, rs1.getString(13));
					ps1.setString(14, rs1.getString(14));
					ps1.setString(15, rs1.getString(15));
					ps1.setString(16, rs1.getString(16));

					ps1.executeUpdate();
		      }
		    	
		    	PrintWriter out = response.getWriter();
				
				 out.print("<html><body><script>alert('Product Send Production Team Successfully ')</script></body></html>");
				 RequestDispatcher rd = request.getRequestDispatcher("ES_homepg.html");
				 rd.include(request,response);
		   
		  }
		  catch (Exception e) 
		           
		  {
					PrintWriter out = response.getWriter();
					out.print("<html><body><script>alert('you not fill')</script></body></html>");
					 RequestDispatcher rd = request.getRequestDispatcher("ES_splitproduct.jsp");
					 rd.include(request,response);
							  
					
					System.out.println(e);
				}
		
	}

}
