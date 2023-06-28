package quality;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.SystemOutLogger;

import utility.database;

/**
 * Servlet implementation class QA_loadstress
 */
@WebServlet("/QA_loadstress")
public class QA_loadstress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a = request.getParameter("hd");
		String sts="Checked" ;
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String itemno = request.getParameter("itemno");
		String cmp=request.getParameter("cmp");
		String pname=request.getParameter("pname");
		String material=request.getParameter("material");
		String length=request.getParameter("length");
		String width=request.getParameter("width");
		String height=request.getParameter("height");
		String thick=request.getParameter("thick");
		String inndia=request.getParameter("inndia");
		String outdia=request.getParameter("outdia");
		String opr=request.getParameter("opr");
		String status="Complete";
		String sts1="Remodel";
		try {					
				
			String query="update pd_production set status='"+sts+"' where itemno='"+a+"'";			
			 int r=database.getconnection().prepareStatement(query).executeUpdate();
			 if(sts.equals("rejected")) {
					
					out.print("<html><body><script>('Not Send Properly')</script></body></html>");
					RequestDispatcher rd= request.getRequestDispatcher("QA_viewproduct.jsp");
					rd.include(request, response);
					
				    
				
				}else {
					
					 out.print("<html><body><script>('Accept the Product')</script></body></html>");
				     RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
				     rd.include(request, response);
				}
			
			
			
			String qur1="select * from qa_maxmin where itemno='" + itemno + "'";						
			Statement ps2 = database.getconnection().createStatement();
			ResultSet j=ps2.executeQuery(qur1);
            if(j.next()) {
												 
				double maxLength =j.getDouble(3); 
				double minLength =j.getDouble(4); 
				double maxwidth =j.getDouble(5);
				double minwidth =j.getDouble(6);
				double maxheight =j.getDouble(7);
				double minheight =j.getDouble(8);
				double maxthick =j.getDouble(9);
				double minthick =j.getDouble(10);
				double maxinndia =j.getDouble(11);
				double mininndia =j.getDouble(12);
				double maxoutdia =j.getDouble(13);
				double minoutdia =j.getDouble(14);
				
				boolean isValid = true;
							           			
				if(!withInRange(maxLength, minLength, Double.parseDouble(length))) {
					out.print("<html><body><script>alert('Invalid Length')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request, response);
					isValid = false;
				}
				if(!withInRange(maxwidth, minwidth, Double.parseDouble(width))) {
					out.print("<html><body><script>alert('Invalid Width')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request, response);
					isValid = false;
				}
				if(!withInRange(maxheight, minheight, Double.parseDouble(height))) {
					out.print("<html><body><script>alert('Invalid Height')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request, response);
					isValid = false;
				}
				if(!withInRange(maxthick, minthick, Double.parseDouble(thick))) {
					out.print("<html><body><script>alert('Invalid Thick')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request, response);
					isValid = false;
				}
				if(!withInRange(maxinndia, mininndia, Double.parseDouble(inndia))) {
					out.print("<html><body><script>alert('Invalid Inner Diameter')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request, response);
					isValid = false;
				}
				if(!withInRange(maxoutdia, minoutdia, Double.parseDouble(outdia))) {
					out.print("<html><body><script>alert('Invalid Outer Diameter')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request, response);
					isValid = false;
				}
				
				if(!isValid)
				{
					
					String qur="insert into qa_remodel values(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps1 = database.getconnection().prepareStatement(qur);	
				    		   
					ps1.setString(1,itemno);
					ps1.setString(2,cmp);
					ps1.setString(3,pname);
					ps1.setString(4,material);
					ps1.setString(5,length);
					ps1.setString(6,width);
					ps1.setString(7,height);
					ps1.setString(8,thick);
					ps1.setString(9,inndia);
					ps1.setString(10,outdia);
					ps1.setString(11,opr);
					ps1.setString(12, sts1);
					int i=ps1.executeUpdate();
				
	            if(i>0) {
					out.print("<html><body><script>(' Remodel the Product')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
					rd.include(request,response);
				}
				else {
					out.print("<html><body><script>('Remodeling Product')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("QA_applystress.jsp");
					rd.include(request, response);
				}
					return;
				}
				
				String qur="insert into qa_stress values(?,?,?,?,?,?,?,?,?,?,?,?)";				
				PreparedStatement ps1 = database.getconnection().prepareStatement(qur);	
			    		   
				ps1.setString(1,itemno);
				ps1.setString(2,cmp);
				ps1.setString(3,pname);
				ps1.setString(4,material);
				ps1.setString(5,length);
				ps1.setString(6,width);
				ps1.setString(7,height);
				ps1.setString(8,thick);
				ps1.setString(9,inndia);
				ps1.setString(10,outdia);
				ps1.setString(11,opr);
				ps1.setString(12,status);
				
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
