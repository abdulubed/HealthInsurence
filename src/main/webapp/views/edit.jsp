<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1" id="example">

		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
		</thead>
		<c:forEach items="${adminModel}" var="adminModel">
			<tr>
				<td><c:out value="${adminModel.firstName}" /></td>
				<td><c:out value="${adminModel.lastName}" /></td>
				<td><c:out value="${adminModel.gender}" /></td>
				<td><c:out value="${adminModel.email}" /></td>
				<td><c:out value="${adminModel.password}" /></td>
				
				
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>