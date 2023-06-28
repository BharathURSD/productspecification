package estimate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dataupload
 */
@WebServlet("/dataupload")
public class dataupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String csvFilePath ="D:/Work Space/secondproject/projectdata/Piece_Dimension.csv";
		
		  try {
		    	 String qry = "LOAD DATA INFILE '"+csvFilePath+"'" + 
		    	 		      "INTO TABLE es_customer FIELDS TERMINATED BY ','" + 
		    	 		      "OPTIONALLY ENCLOSED by '\"'";
		    	 
		    	 
		    	 // "OPTIONALLY ENCLOSED by '\"' IGNORE 1 LINES (date1, feet, inflow, outflow, tmc)";
		    	  
		    	 int i = utility.database.getconnection().prepareStatement(qry).executeUpdate();
		    	  
		    	 
		    	 if(i>0) {
		    		 response.sendRedirect("#");
		    	 }else {
		    		 response.sendRedirect("#");
		    	 }
		    	 
		     }catch(Exception e) {
		    	 e.printStackTrace();
		     }
	}

}
