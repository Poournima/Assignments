<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Issue Book</title>
</head>
<body>
	<h3> Update Book</h3>
	<hr>
	<html:form action="updateBookDetailsAction" method="post">
	<table>
	
		<tr>
				<td>Issue ID</td>
				<td><html:text property="issueId" name="bookDetailsForm" readonly="true" /></td>

			</tr>
			<tr>
				<td> Member ID </td>
				<td><html:text property="memberId" name="bookDetailsForm" /></td>
				

			</tr>
			<tr>
				<td>Member Name</td>
				<td><html:text property="memberName" name="bookDetailsForm" readonly="true" /></td>
			</tr>
			<tr>
				<td> Book ID </td>
				<td><html:text property="bookName" name="bookDetailsForm" /></td>
				

			</tr>
			<tr>
				<td> Book Name </td>
				<td><html:text property="bookName" name="bookDetailsForm" readonly="true" /></td>
			</tr>
			

			
			<tr>
				<td>Due Date</td>
				<td><input type="date" name="dueDate"></td>
				
			</tr>
			<tr>
				

				<td><html:submit property="updateBook">Update </html:submit></td>
			</tr>
		
		</table>
	</html:form>

</body>
</html>
			
			
	
	