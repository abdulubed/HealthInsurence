<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registartion</title>

<!-- date picker -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- Latest compiled and minified BootStarp CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	
	
<!-- Jquery client side validations -->
<style>
.userform {
	width: 400px;
}

.userform p {
	width: 100%;
}

.userform label {
	width: 120px;
	color: #333;
	float: left;
}

input.error {
	border: 1px dotted red;
}

label.error {
	width: 100%;
	color: red;
	font-style: italic;
	margin-left: 120px;
	margin-bottom: 5px;
}

.userform input.submit {
	margin-left: 120px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#email").blur(function() {
		var enterEmail = $("#email").val();
		$.ajax({
			type: "get",
			url: "email" ,
			 data: 	({
			email : enterEmail
			}),
				
			success:function(result){
				if(result=='DuplicateMail'){
					$("#emailError").html("***Email is already available***");
					$("#email").focus();
					//$("#createAccBtn").prop("disabled",true);
				}
				else{
					$("#emailError").html("");
					$("#createAccBtn").prop("disabled",true);
				}
			}
		});
	});
	
});
</script>


<!-- Date of birth picker -->
<script>
  $(function() {
        $( "#datepicker" ).datepicker({
            dateFormat : 'mm/dd/yy',
            changeMonth : true,
            changeYear : true,
            yearRange: '-100y:c+nn',
            maxDate: '-0d'
        });
    });
 </script>

<script type="text/javascript">
	(function($, W, D) {
		var JQUERY4U = {};
		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#myForm").validate({
					rules : {
						
						firstName : "required",
						
						lastName : {
							required : true,
							},
							gender : {
								required : true,
								},
								email : {
									required : true,
								},
								password : {
									required : true,
									},
							
						dateOfBirth : {
							required : true,
							},
							ssnNumber : {
								required : true,
								},
							
						
							
						phoneNumber : {
							required : true,
							},
							
						role : {
							required : true,
							}
						},
					
					messages : {
						firstName : "Please Enter firstName",
						lastName : "Please Enter lastName",
						gender : "Please Enter gender",
						email : "Please Enter email",
						password : "Please Enter password",
						dateOfBirth : "Please Enter dateofbirth",
						ssnNumber : "Please Enter ssnNumber",
						phoneNumber : "Please Enter phno",
						role : "Please choose role"
					},
					submitHandler : function(form) {
						form.submit();
					}
				});
			}
		}
		//when the dom has loaded setup form validation rules
		$(D).ready(function($) {
			JQUERY4U.UTIL.setupFormValidation();
		});
	})(jQuery, window, document);
</script>


<style type="text/css">
.error {
	color: red
}

.a {
	color: #0325AC;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
}

.a:hover {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>


<body>
	<div id="page-wrapper">
		<div class="container">

			<h1>
				Account Registration Page
				<h2 style="color: #39BC09;">${message}${ssnNumber}</h2>
			</h1>


			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/insertUserData" modelAttribute="adminModel" method="POST">

				<div class="panel panel-info">
					<div class="panel-heading">Account Registration Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">

									<div class="form-group">
										<label for="firstName" class="col-md-4">firstname *</label>
										<div class="col-md-6">
											<form:input path="firstName" class="form-control"
												placeholder="Enter firstName" />
											<form:errors path="firstName" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="lastName" class="col-md-4">lastname *</label>
										<div class="col-md-6">
											<form:input path="lastName" class="form-control"
												placeholder="Enter lastName" />
											<form:errors path="lastName" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="gender" class="col-md-4">gender </label>
										<div class="col-md-6">
											<form:radiobuttons items="${gendersList}" path="gender" />
											<form:errors path="gender" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="email" class="col-md-4">email *</label>
										<div class="col-md-6">
											<form:input path="email" class="form-control"
												placeholder="Enter email" id="email" />
											<form:errors path="email" class="error" />
											<span id="emailError" style="color: red"></span>
										</div>
									</div>

									<div class="form-group">
										<label for="password" class="col-md-4">password *</label>
										<div class="col-md-6">
											<form:password path="password" class="form-control"
												placeholder="Enter password" />
											<form:errors path="password" class="error" />
										</div>
									</div>



									<div class="form-group  ">
										<label for="dateOfBirth" class="col-md-4">dateOfBirth
										</label>
										<div class="col-md-6">
											<form:input path="dateOfBirth" id="datepicker"
												autocomplete="off" placeholder="Enter  dateOfBirth"
												class="form-control" />
											<form:errors path="dateOfBirth" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="ssnNumber" class="col-md-4">SsnNumber *</label>
										<div class="col-md-6">
											<form:input path="ssnNumber" class="form-control"
												placeholder="Enter SsnNumber" />
											<form:errors path="ssnNumber" class="error" />
										</div>
									</div>




									<div class="form-group">
										<label for="phoneNumber" class="col-md-4">phoneNumber
										</label>
										<div class="col-md-6">
											<form:input path="phoneNumber"
												placeholder="Enter phoneNumber" class="form-control" />
											<form:errors path="phoneNumber" class="error" />
										</div>
									</div>
									<%-- // <select name="loc.locId" id="locInp">

		  <option value="-1">--select--</option>

		  <c:forEach items="${locListObj}" var="loc">

		  <option value="${loc.locId}"><c:out value="${loc.locName}"/></option>

		  </c:forEach> --%>
									<div class="form-group">
										<label for=role class="col-md-4">role </label>
										<div class="col-md-6">
											<form:select path="role" items="${rolesList}" />
											<form:errors path="role" class="error" />
											<%-- <form:input path="state" placeholder="Enter state" class="form-control"/>  --%>
										</div>
									</div>

									<!-- end divs -->
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4 col-md-offset-4" style="margin-bottom: 50px;">
					<div align="center">
						<input type="reset" class="btn btn-primary" value="reset" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-primary" id="createAccBtn"
							value="Submit" />&nbsp;&nbsp; &nbsp;&nbsp;
						<button>
							<a href="getAllAccounts" class="a">view all records</a>&nbsp;&nbsp;
						</button>
					</div>
				</div>





			</form:form>


		</div>
	</div>


</body>
</html>