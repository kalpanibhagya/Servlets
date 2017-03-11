<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Page</title>
<style>
.footer{
position: absolute;
right:0;
bottom:0;
left:0;
text-align:center;
background-color: #777;

}

</style>
</head>
<body>
<h1 align="center"> My Library</h1>
<%
	request.getSession();
	String user = (String)session.getAttribute("User");
	String city = (String)session.getAttribute("City");
	String prof = (String)session.getAttribute("Profession");
	//database connection
	
	 String DB_URL = "jdbc:mysql://localhost:3306/registration";
	 String DB_USER = "root";
	 String DB_PWD = "";
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
		Statement stmt =conn.createStatement();
		
		String valsql = "SELECT path FROM image_path WHERE prof ='"+prof+"'";
		ResultSet rs = stmt.executeQuery(valsql); 
		%>
		
		<table>
			
		<% 
		while(rs.next()){
			String imp= rs.getString("path");
			%>
			<tr>
			<td>Author :</td>
			<td><img alt="Book" src="<%= imp %>" width=100px height=100px/></td>
			<td><a href="#">Reserve</a></td>
			</tr>
			<% 
		}
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException sql){
		sql.printStackTrace();
	}
	
	//String imp = "Images/Medicine/Med1.png" ;

%>
</table>
<h1>Hi!,&nbsp;<font color ="grey" ><%= prof %></font></h1>
<div class="footer">
<jsp:include page = "footer.jsp"/>
</div>
</body>
</html>