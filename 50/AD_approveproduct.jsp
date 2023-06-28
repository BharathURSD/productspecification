<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>
<!DOCTYPE html>
<html>
	<head>	
		<title>Deploy Product</title>
		<link href="css6/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Lobster|Pacifico:400,700,300|Roboto:400,100,100italic,300,300italic,400italic,500italic,500' ' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,300' rel='stylesheet' type='text/css'>
		<!--webfonts-->
	</head>
	<body>	
			<!--start-login-form-->
				<div class="main">
			    	<div class="login-head">
					  <h1 style='color:green;background-color:white;width:400px;font-family:normal;margin-left:37%;'>DEPLOY PRODUCT</h1>
					</div>
					<div  class="wrap">
						  <div class="Regisration">
						  	<div class="Regisration-head">
						    <!-- 	<h2><span></span>Register</h2> -->
						 	 </div>
						  	<form action="AD_approve" method="post">
						  	<%
            String itemno=request.getParameter("itemno");
            String cmp=request.getParameter("cmp");
            String pname=request.getParameter("pname");
			String material=request.getParameter("material");			
			String itemno1=null,cmp1=null,pname1=null,material1=null;
		    Statement st = null;
	         ResultSet rs = null;
	           
	            try{
					Connection con = database.getconnection();
				    st = con.createStatement();
					String qur = "select * from ad_pattern";
					rs = st.executeQuery(qur);
					while(rs.next()){
						itemno1=rs.getString(1);
						cmp1=rs.getString(2);
						pname1=rs.getString(3);
						material1=rs.getString(4);
						
						%>
					<%
					}
				}catch(Exception e)
					    {
						e.printStackTrace();
					   }
					  %>		<input type="text" value="<%=itemno %>" name="itemno" placeholder="Itemno"  autocomplete="off" required="required" readonly >
						  		<input type="text" value="<%=cmp %>" name="cname" placeholder="company name"  autocomplete="off" required="required" readonly >
						     	<input type="text" value="<%=pname %>" name="pname" placeholder="Product name"  autocomplete="off" required="required" readonly >
						   		<input type="text" value="<%=material %>" name="material" placeholder="Material"  autocomplete="off" required="required" readonly >
								<input type="text" value="" name="rel" placeholder="Product Deploy" autocomplete="off" required="required" " >
							
								
								<div class="submit">
									<br><input type="submit" onclick="myFunction()" value="UPDATE" >
								</div>
								</form>
									<div class="clear"> </div>
								</div>
											
						 
					</div>
					
					</div>
			
				<!--//End-login-form-->	
						<div class ="copy-right">
						<!-- 	<p>Template by <a href="#">W3layouts</a></p> -->
						</div>
			 
	</body>
</html>


