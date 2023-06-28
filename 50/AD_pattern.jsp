<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>	
<!DOCTYPE html>
<html lang="zxx">

<!-- Head -->

<head>

    <title>Production team check see pattern</title>

    <!-- Meta-Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- style CSS -->
    <link rel="stylesheet" href="css1/style.css" type="text/css" media="all">

    <!-- fontawesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all">

    <!-- google fonts -->
    <link href="//fonts.googleapis.com/css?family=Mukta:300,400,500" rel="stylesheet">

</head>
<!-- //Head -->

<!-- Body -->

<body>

    <section class="main">
        <div class="bottom-grid">
            <div class="logo">
                <h1 style='background-color:white;color:black;width:400px;'> PATTERN GENERATE FORM</h1>
            </div>
        </div>
        <!-- register -->
        <div class="w3lhny-register">
            <div class="iconhny">
            <!--   <span class="fa fa-user-plus"></span>  -->
             </div>
            <form action="AD_metapattern" method="post" class="register-form">
            
            <%
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
			String itemno1=null,cmp1=null,pname1=null,material1=null,length1=null,width1=null,height1=null,thick1=null,inndia1=null,outdia1=null,opr1=null;
		    Statement st = null;
	         ResultSet rs = null;
	           
	            try{
					Connection con = database.getconnection();
				    st = con.createStatement();
					String qur = "select * from es_splitdata where itemno='"+itemno+"'";
					rs = st.executeQuery(qur);
					while(rs.next()){
						itemno1=rs.getString(1);
						cmp1=rs.getString(2);
						pname1=rs.getString(3);
						material1=rs.getString(4);
						length1=rs.getString(5);
						width1=rs.getString(6);
						height1=rs.getString(7);
						thick1=rs.getString(8);
						inndia1=rs.getString(9);
						outdia1=rs.getString(10);
						opr1=rs.getString(11);
						%>
					<%
					}
				}catch(Exception e)
					    {
						e.printStackTrace();
					   }
					  %>
                <fieldset>
                    <div class="form">
                        <div class="form-row">
                            <span class="fa fa-user"></span>
                           
                            <input type="text" class="form-text" name="itemno"  value="<%=itemno %>" placeholder="itemno" autocomplete="off" readonly required="" >
                        </div>
                         <div class="form-row">
                            <span class="fa fa-user"></span>
                           
                            <input type="text" class="form-text" name="cmp"  value="<%=cmp %>" placeholder="company name" autocomplete="off" readonly required="" >
                        </div>
                          <div class="form-row">
                            <span class="fa fa-user"></span>
                           
                            <input type="text" class="form-text" name="pname"  value="<%=pname %>" placeholder="product name"  autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="material"  value="<%=material %>" placeholder="Material" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="length"  value="<%=length %>" placeholder="length" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="width"  value="<%=width %>" placeholder="width" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="height"  value="<%=height %>" placeholder="length" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="thick"  value="<%=thick %>" placeholder="length" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="inndia"  value="<%=inndia %>" placeholder="length" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="outdia"  value="<%=outdia %>" placeholder="length" autocomplete="off" readonly required="">
                        </div>
                        <div class="form-row">
                            <span class="fa fa-envelope"></span>
                            
                            <input type="text" class="form-text" name="opr"  value="<%=opr %>" placeholder="length" autocomplete="off" readonly required="">
                        </div>
                       
                       <!--  </div> -->
                       
                        <div class="form-row button-login">
                            <button class="btn btn-login" >GENERATE</button>
                        </div>
                        <div>
                      <br><a href="AD_homepg.html" class="button" style='margin-left:70%;font-family:normal;'>HOME</a>
                        
                        </div>
                    </div>
                </fieldset>
                </form>

            <!--     <span class="create-account">Or Continue With!</span> -->

               <!--  <div class="social-media">
                    <a href="#facebook" class="fb"><span class="fa fa-facebook"></span></a>
                    <a href="#twitter" class="tw"><span class="fa fa-twitter"></span></a>
                    <a href="#pinterest" class="pi"><span class="fa fa-pinterest"></span></a>
                </div> -->
               <!--  <p class="already">Already have an account <a href="#">Sign In</a></p> -->
        </div>
        <!-- //register -->
        <div class="w3l-copyright">
          <!--   <p>© 2020 Workspace Sign Up Form. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a> -->
            </p>
        </div>
    </section>

</body>
<!-- //Body -->
<style>
.button {
  background-color: DodgerBlue;
  border: none;
  color:white;
  padding: 13px 28px;
  text-align: auto;
  text-decoration: none;
  display: inline-block;
  width: 100px;
  border: 2px solid black;  
  font-size: 16px;
  margin: 3px 1px;
  cursor: pointer;
  height:50px;
  text-align: right;
}						
</style>
</html>