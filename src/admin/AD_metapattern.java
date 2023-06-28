package admin;

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
 * Servlet implementation class AD_metapattern
 */
@WebServlet("/AD_metapattern")
public class AD_metapattern extends HttpServlet {
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
		String width=request.getParameter("width");
		String height=request.getParameter("height");
		String thick=request.getParameter("thick");
		String inndia=request.getParameter("inndia");
		String outdia=request.getParameter("outdia");
		String opr=request.getParameter("opr");
		String sts="Update";
		
		String s="";
		char []in1 = new char[] {'!','@','#','$','%','^','&','*','(',')'}; 
		Random r= new Random();	
		for(int j=0;j<4;j++) 
		{
		int p = r.nextInt(10);
		char randomChar = in1[p];
		s=s+randomChar; 
		}
		
		try {
			String qur1="update es_splitdata set status='"+sts+"' where itemno='"+itemno+"'";
			int r1=database.getconnection().prepareStatement(qur1).executeUpdate();
			
			String qur="insert into ad_pattern values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setString(1,itemno);
			ps1.setString(2,cmp);
			ps1.setString(3,pname);
			ps1.setString(4,material);
			ps1.setString(5,length);
			ps1.setString(6,width);
			ps1.setString(7,height);
			ps1.setString(8, thick);
			ps1.setString(9,inndia);
			ps1.setString(10,outdia);
			ps1.setString(11,opr);
			ps1.setString(12,s);
			ps1.setString(13,sts);
			
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Pattern Generated Successfully ')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("AD_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('You not Update')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("AD_metapattern.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
