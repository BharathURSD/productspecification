<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>

<!doctype html>
<html lang="en">
  <head>
  	<title>Production Remodel Product</title>
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
background-size: 1500px 900px;

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
					<h4 class="text-center mb-4" style='background-color:white;width:300px;font-family:normal;margin-left:36%;'> REMODEL PRODUCT</h4>
					<h6 class="h5 mb-4 text-center"><a  href="PD_homepg.html" class="button" style='font-family:normal; padding: 10px 17px;'>HOME</a></h6>
					<div class="table-wrap" style="height:500px;overflow:auto;">
					<div class="tableFixHead">
						<table class="table">
					    <thead class="thead-primary" style='font-family:normal;'>
					      <tr>
					        <th>ITEM NO</th>
					        <th>COMPANY NAME</th>
					        <th>PRODUCT NAME</th>
					        <th>MATERIAL</th>
					        <th>LENGTH</th>
					        <th>WIDTH</th>
					        <th>HEIGHT</th>
					        <th>THICKNESS</th>
					        <TH>INNER DIAMETER</TH>
					        <TH>OUTER DIAMETER</TH>
					        <th>QUANTITY</th>					  
					        <th>STATUS</th>
					        <th>ACTION</th>
					      </tr>
					    </thead>
					    
					    <%
					    ResultSet rs1=null;
						  try{
							  String qry2 = "Select * from qa_remodel"; 
						    	 rs1 = database.getconnection().createStatement().executeQuery(qry2);
						    	while(rs1.next())
						    	{
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
						      	 
						    
					           <td>
						      <form action="PD_updatedamage"  method="post">  
						      <input type="hidden" name="hd" value="<%=rs1.getString(1)%>"> 
						      <button class="button"  value="Accepted" name="status" style='background-color:Green;font-family:normal;'>ACCEPT</button>
						      <br><button class="button"  value="rejected" name="status" Style='background-color:red;font-family:normal;'>REJECT</button> 
						 
						      </form>
						      </td> 	
						      							      
					      </tr>
					      
					       <%}
					   		} catch (SQLException e) {
					
					e.printStackTrace();
				}	%>
					      
					    </tbody>
					  </table>
					</div>
				</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js5/jquery.min.js"></script>
  <script src="js5/popper.js"></script>
  <script src="js5/bootstrap.min.js"></script>
  <script src="js5/main.js"></script>

	</body>
	<style>
.button {
  background-color: DodgerBlue;
  
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  width: 100px;
  border: 2px solid black;  
  font-size: 16px;
  margin: 2px 1px;
  cursor: pointer;
  
  text-align: right;
}						
</style>
</html>

