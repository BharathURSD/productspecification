package estimate;

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
 * Servlet implementation class es_splitdata
 */
@WebServlet("/es_splitdata")
public class es_splitdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			String qry2 = "select * from es_customer";
			rs1 = database.getconnection().createStatement().executeQuery(qry2);
			while (rs1.next()) {
				String pname = rs1.getString(5);
				String material = rs1.getString(6);

				String qur = "select * from es_product";
				rs2 = database.getconnection().createStatement().executeQuery(qur);
				String status = "Not possible";
				
				while (rs2.next()) {
					String pname1 = rs2.getString(2);
					String material1 = rs2.getString(3);

					if (pname.equalsIgnoreCase(pname1) && material.equalsIgnoreCase(material1)) {

						status= "possible";
						break;

					}
				}
				if (status.equalsIgnoreCase("possible")) {
					String qur1 = "insert into es_productpass values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps1 = database.getconnection().prepareStatement(qur1);
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
					ps1.setString(16, status);
					ps1.executeUpdate();
				} else {
					String qur1 = "insert into es_productfail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps1 = database.getconnection().prepareStatement(qur1);
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
					ps1.setString(16, status);
					ps1.executeUpdate();
				}
				
			}
			out.print("<html><body><script>alert('Find Possible Product')</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("ES_homepg.html");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
