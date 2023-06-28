<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%-- <%@ page import = "estimate.accuracy" %> --%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>

<!doctype html>
<html lang="en">
  <head>
  	<title>Trained Data</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css5/font-awesome.min.css">
	
	<link rel="stylesheet" href="css5/style.css">

	</head>
	
	<style>
body {
background-image: url("images/cs1.jpg");
background-repeat: no-repeat, repeat;
background-size: 1500px 910px;

}

</style>
	
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<!-- <h2 class="heading-section">Table #03</h2> -->
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<h4 class="text-center mb-4" style='background-color:white;width:300px;font-family:normal;margin-left:37%;'>TRAINED DATA</h4>
					<h6 class="h5 mb-4 text-center"><a  href="ES_homepg.html" style="font-family:normal;background-color:DodgerBlue;padding: 10px 10px;">HOME</a></h6>
					<div class="table-wrap" style="height:450px;color:green;">
					
						<table class="table">
					    <thead class="thead-primary" style="font-family:normal;">
					      <tr>
					        <th>ITEM NO</th>
					        <th>CUSTOMER NAME</th>
					        <th>MOBILE NUMBER</th>
					        <th>COMPANY NAME</th>
					        <th>PRODUCT NAME</th>
					        <th>MATERIAL</th>
					        <th>LENGTH</th>
					        <th>WIDTH</th>
					        <th>HEIGHT</th>
					        <th>THICKNESS</th>
					        <th>INNER DIAMETER</th>
					        <th>OUTER DIAMETER</th>
					        <th>START DATE</th>
					        <th>END DATE</th>
					        <th>QUANTITY</th>				    					         
 					      </tr>					     
					    </thead>
					     
					    <%
					    int countrow =0 ; 
					    ResultSet rs1=null;
						  try{
							 
							  String qry2 ="select * from es_customer";
						 	/*   String qry3="select count(*) from es_customer where itemno = ?";  */  
							  
						    	 rs1 = database.getconnection().createStatement().executeQuery(qry2);
						    	   /* rs1=database.getconnection().createStatement().executeQuery(qry3);*/
						    	    
						    	while(rs1.next())
						    	{						 
						    	  countrow = countrow + 1;						    							    	  						    
					    %>				    				    					    
					    <tbody>
					      <tr>
					          <td><%=rs1.getString(1) %></td>
						      <td><%=rs1.getString(2) %></td>
						      <td><%=rs1.getString(3) %></td>
						      <td><%=rs1.getString(4) %></td>
						      <td><%=rs1.getString(5) %></td>
						      <td><%=rs1.getString(6) %></td>	
						      <td><%=rs1.getString(7) %></td>
						      <td><%=rs1.getString(8) %></td>
						      <td><%=rs1.getString(9) %></td>	
						      <td><%=rs1.getString(10) %></td>		 								      
						      <td><%=rs1.getString(11) %></td>
						      <td><%=rs1.getString(12) %></td>
						      <td><%=rs1.getString(13) %></td>
						      <td><%=rs1.getString(14) %></td>	
						      <td><%=rs1.getString(15) %></td>							      
						      <%-- <td>
						      <input type="hidden" name="itemno" value="<%=rs1.getString(1)%>"> 
						      <input type="hidden" name="cname" value="<%=rs1.getString(2)%>"> 
						      <input type="hidden" name="num" value="<%=rs1.getString(3)%>"> 
						      <input type="hidden" name="cmp" value="<%=rs1.getString(4)%>"> 
						      <input type="hidden" name="pname" value="<%=rs1.getString(5)%>"> 
						      <input type="hidden" name="material" value="<%=rs1.getString(6)%>"> 
						      <input type="hidden" name="length" value="<%=rs1.getString(7)%>"> 
						      <input type="hidden" name="width" value="<%=rs1.getString(8)%>"> 
						      <input type="hidden" name="height" value="<%=rs1.getString(9)%>"> 
						      <input type="hidden" name="thickness" value="<%=rs1.getString(10)%>"> 
						      <input type="hidden" name="india" value="<%=rs1.getString(11)%>"> 
						      <input type="hidden" name="outdia" value="<%=rs1.getString(12)%>"> 
						      <input type="hidden" name="qty" value="<%=rs1.getString(13)%>"> 
						      <input type="hidden" name="sdate" value="<%=rs1.getString(14)%>"> 
						      <input type="hidden" name="edate" value="<%=rs1.getString(15)%>"> 
						  </td> --%>		 	  						   						 					    	     						     
					      </tr>
					      
					       <%
						      
						      }
						      
						    
					   		} catch (SQLException e) {
					
					e.printStackTrace();
				}	
				%>
					      
					    </tbody>
					  </table>
					  
					
					
					</div>
				</div>
				</div>
				<br><label style='background-color:yellow;color:black;width:70px;font-family:normal;'>COUNT :</label> 
				<%=countrow %>
			</div>
			<form action="es_splitdata" method="post">	
				                   							      				                 						 
	        <button style='background-color:yellow;width:130px;height:60px;font-family:normal;margin-left:45%;'>UPDATE</button>
	                          
			</form>
	
		
	</section>
	<script src="js5/jquery.min.js"></script>
  <script src="js5/popper.js"></script>
  <script src="js5/bootstrap.min.js"></script>
  <script src="js5/main.js"></script>

	</body>
<style>
.button 
{
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  width: 120px;
  border: 2px solid black;  
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  
  text-align: right;
}						
</style>
</html>

