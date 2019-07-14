<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet"
	href=https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<style type="text/css">
.a {
	text-decoration: none;
	color: #0325AC;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	align: center
}

.a:hover {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>
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
				<th>Date of birth</th>
				<th>Ssn Number</th>
				<th>Phone Number</th>
				<th>Role</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<c:forEach items="${accountRecords}" var="accountRecords">
			<tr>
				<%-- <td><c:out value="${ssnNumberList.ssnNumberList}"></c:out> --%>
				<td><c:out value="${accountRecords.firstName}" /></td>
				<td><c:out value="${accountRecords.lastName}" /></td>
				<td><c:out value="${accountRecords.gender}" /></td>
				<td><c:out value="${accountRecords.email}" /></td>
				<td><c:out value="${accountRecords.password}" /></td>
				<td><c:out value="${accountRecords.dateOfBirth}" /></td>
				<td><c:out value="${accountRecords.ssnNumber}" /></td>
				<td><c:out value="${accountRecords.phoneNumber}" /></td>
				<td><c:out value="${accountRecords.role}" /></td>
				<td><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="/images/edit.jpg"></td>
				<td><input type="image" id="image" alt="Delete" width="20" height="20"
       src="/images/delete.jpg"></td>
				
			</tr>
		</c:forEach>
	</table>






	<a href="/displayForm">Account Registraion Page</a>


</body>
</html>