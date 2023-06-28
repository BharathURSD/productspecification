
package estimate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import utility.database;

/**
 * Servlet implementation class ES_customer
 */
@WebServlet("/ES_customer")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class ES_customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    Part part=request.getPart("file");		
				
	    String csvFilePath="D:/Project/secondproject/projectdata/Piece_Dimension.csv" + part.getSubmittedFileName();
	    part.write(csvFilePath);
	    
	    System.out.println(new File(csvFilePath).getCanonicalPath());
	    
		/*String csvFilePath ="D:/Work Space/secondproject/projectdata/Piece_Dimension.csv";*/
		
	    try {
			String qry = "LOAD DATA INFILE '"+csvFilePath+"'" + 
	   	 		      "INTO TABLE es_customer FIELDS TERMINATED BY ','" + 
	   	 		      "OPTIONALLY ENCLOSED by '\"' LINES TERMINATED BY '\r\n' ignore 1 LINES";
			
			// "OPTIONALLY ENCLOSED by '\"' IGNORE 1 LINES (date1, feet, inflow, outflow, tmc)";
		   	 
		   	 
		   	 int i = utility.database.getconnection().prepareStatement(qry).executeUpdate();
		    
		   
			if(i>0) {
				out.print("<html><body><script>alert('Product Details Uploaded Successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not registered')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
