<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book Details</title>
</head>
<body>
<h3>Issue New Book</h3>
<hr>
	<html:form action="newBookIssueAction" method="post">
	<table>
		<tr>
			<td>Issue Id</td>
			<td> <html:text property="issueId" name="bookDetailsForm" /></td>
			
		</tr>
		<tr>
			<td>MemberId</td>
			<td> <html:text property="memberId" name="bookDetailsForm" /></td>
			<td> <html:submit property="getMemberDetails" value="getMember"/></td>
		</tr>
		<tr>
		<td> Member name: </td>
		<td> <html:text property="memberName" name="bookDetailsForm" readonly="true"/></td>
		</tr>
		<tr>
			<td>Book Id:</td>
			<td> <html:text property="bookId" name="bookDetailsForm" /></td>
			<td> <html:submit  property="getBookDetails" value="getBook"/></td>
		</tr>
		<tr> 
			<td> Book Name:</td>
			<td><html:text property="bookName" name="bookDetailsForm" readonly="true"/></td>
		</tr>
		<tr>
			<td>Issue Date:</td>
			<td><html:text property="issueDate" name="bookDetailsForm"/></td>
		</tr>
		<tr>
			<td>Return Date:</td>
			<td><html:text property="returnDate" name="bookDetailsForm"/></td>
		</tr>
		<tr>
		<td> <input type="submit" name="getDetails"></td>	
			
		</tr>
		
		</table>
		</html:form>
		</body>
		</html>
		
	
		
		
		
		
	