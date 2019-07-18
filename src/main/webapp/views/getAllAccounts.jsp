<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>All Accounts</title>

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
				<th>SerialNumber</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Password</th>
				<th>Date of birth</th>
				<th>Ssn Number</th>
				<th>Phone Number</th>
				<th>Role</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${accountRecords}" var="accountRecords">
			<tr>
				<td><c:out value="${accountRecords.serialNumber}"></c:out> 
				<td><c:out value="${accountRecords.firstName}" /></td>
				<td><c:out value="${accountRecords.lastName}" /></td>
				<td><c:out value="${accountRecords.gender}" /></td>
				<td><c:out value="${accountRecords.email}" /></td>
				<td><c:out value="${accountRecords.password}" /></td>
				<td><c:out value="${accountRecords.dateOfBirth}" /></td>
				<td><c:out value="${accountRecords.ssnNumber}" /></td>
				<td><c:out value="${accountRecords.phoneNumber}" /></td>
				<td><c:out value="${accountRecords.role}" /></td>
				<td><c:out value="${accountRecords.status}" /></td>
				
				<td><a href="<c:url value='/edit/${accountRecords.serialNumber}'  />" ><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="/images/edit.jpg"></a>
				
				
				
				
				<c:if test="${accountRecords.status == 'active' }">
				<a href="<c:url value='/statusInActive/${accountRecords.serialNumber}'  />" ><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="/images/active.jpg"></a>
				</c:if>
				
					<c:if test="${accountRecords.status == 'inActive' }">
				<a href="<c:url value='/statusActive/${accountRecords.serialNumber}' />" ><input type="image" id="image" alt="Edit" width="20" height="20" 
       src="/images/inActive.jpg"></a>
				</c:if>
				
 </td>
			<!-- 	<input type="image" id="image" alt="Edit" width="20" height="20" 
       src="/images/edit.jpg"> &nbsp;
      				<!-- <input type="image" id="image" alt="Delete" width="20" height="20"
       src="/images/delete.jpg"></td> -->
 			</tr>
		</c:forEach>
	</table>
	






	<a href="/displayForm">Account Registraion Page</a>


</body>
</html>