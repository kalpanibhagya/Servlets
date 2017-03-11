<%
	request.getSession();
String user = (String)session.getAttribute("User");
%>
<h4>This is the footer created by &nbsp;<%= user %> </h4>