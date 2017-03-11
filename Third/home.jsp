<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
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
<h1>Welcome to ABC Home Page from JSP</h1>
<%
	request.getSession();
	String user = (String)session.getAttribute("User");
	String city = (String)session.getAttribute("City");

%>
<h3>Welcome User <%= user %>,&nbsp; you are from <%= city%></h3>
<a href = "library.jsp" >Visit My library </a>
<div class="footer">
<jsp:include page = "footer.jsp"/>
</div>

</body>
</html>