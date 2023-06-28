package quality;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utility.database;

/**
 * Servlet implementation class QA_upload
 */
@WebServlet("/QA_upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class QA_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("file");
		PrintWriter out=response.getWriter();		
		Part part=request.getPart("file");
		
		String csvFilePath="D:/Project/secondproject/projectdata/datasetcheckstatus.csv" + part.getSubmittedFileName();
	    part.write(csvFilePath);
		
		try {
			
			String qur= "LOAD DATA INFILE '"+csvFilePath+"'" + 
	   	 		      "INTO TABLE qa_maxmin FIELDS TERMINATED BY ','" + 
	   	 		      "OPTIONALLY ENCLOSED by '\"' LINES TERMINATED BY '\r\n' ignore 1 LINES";			
		   int i = utility.database.getconnection().prepareStatement(qur).executeUpdate();
		   System.out.println("test");
			if(i>0) {
				//System.out.println("test");
				out.print("<html><body><script>alert('Update Range Value Successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
				rd.include(request,response);
			}
			
			else {
				//System.out.println("test");
				out.print("<html><body><script>alert('you not Upload')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("QA_homepg.html");
				rd.include(request, response);
			}
			    
			    
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
