<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<%!Set<String> nameSet=new HashSet<>();%>
	
	<form action="" method="post">
		Product Name <input type="text" name="txtName"><br> 
		<input type="submit" value="print">
	</form>
	<hr>

	
<% 
	if (request.getParameter("txtName") != null) {
			nameSet.add(request.getParameter("txtName"));
	}
					
	if (application.getAttribute("Name") == null ) {
		//name=application.getInitParameter("txtName");
		application.setAttribute("Name", nameSet);
	}
	
%>
	
	Suggtion : [ 
					<% for(String name:nameSet){ %>
					<%=name+"," %>
					<%} %>
				]
<%
	
	application.setAttribute("Name",nameSet );
	%>

</body>
</html>