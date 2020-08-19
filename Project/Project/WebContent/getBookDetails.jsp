<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<h3>Book Issue Details</h3>
	<hr>
	<html:form action="booksDetailsAction" method="post">
		<table border="2">
			<tr>
				<th>Issue Serial Number</th>
				<th>Member Code</th>
				<th>Name</th>
				<th>Book Code</th>
				<th>Book Title</th>
				<th>Date of issue</th>
				<th>Due date of return</th>
			</tr>

			<logic:iterate name="books" id="allBooks">
				<tr>
					<td><bean:write name="allBooks" property="issueId" /></td>
					<td><bean:write name="allBooks" property="member.memberId" /></td>
					<td><bean:write name="allBooks" property="member.memberName" /></td>
					<td><bean:write name="allBooks" property="book.bookId" /></td>
					<td><bean:write name="allBooks" property="book.bookName" /></td>
					<td><bean:write name="allBooks" property="issueDate" /></td>
					<td><bean:write name="allBooks" property="returnDate" /></td>
				</tr>
			</logic:iterate>

			<tr>
		</table>
		<a href="newBookIssue.jsp"> New Book </a>
		<a href="updateBook.jsp"> Update Book </a>
		<a href="deleteBook.jsp"> Delete Book </a>

	</html:form>
</body>
</html>