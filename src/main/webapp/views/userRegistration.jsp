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
	width: 50%;
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

<script>
$(document).ready(function(){
	
	 $("#email").blur(function(){
	 var enterEmail=$("#email").val();
	 $.ajax({
	 url :"email",
	 data : {
	 email : enterEmail
	 },
	  success : function(result){
		 
	  if(result=='duplicate'){
		 
	   $("#email").empty;  
	  $("#emailError").html("**** Email is alrady avilable ****");
	  $("#email").focus();
	  }
	  else{
	  $("#emailError").html("");
	  }
	    }
	   })
	   })
	   });

</script>


<!-- Date of birth picker -->
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'mm/dd/yy',
			changeMonth : true,
			changeYear : true,
			yearRange : '-100y:c+nn',
			maxDate : '-0d'
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
							email : true,
						},
						password : {
							required : true,
						},

						dateOfBirth : {
							required : true,
						},
						ssnNumber : {
							required : true,
							number : true,
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


<!-- ssn number field splitting -->
<script>
function function1() {
	var len = $("#ssnNumber1").val().length;
	if(len>=2){
		$("#ssnNumber2").focus();
	}
}
function function2() {
	var len = $("#ssnNumber2").val().length;
	if(len>=1){
		$("#ssnNumber3").focus();
	}
}
function function3(){
	var len=$("#ssnNumber3").val().length;
	var ssnNumber=$("#ssnNumber1").val()+$("#ssnNumber2").val()+$("#ssnNumber3").val();
	$("#ssnNumber4").val(ssnNumber);
	if(len>=4){
	$("#phone").focus();
	}
}
</script>

</head>


<body>
	<div id="page-wrapper">
		<div class="container">
			<h2 style="color: #39BC09;">${message}</h2>




			<form:form name="myForm" class="form-horizontal" id="myForm"
				action="/insertUserData" modelAttribute="adminModel" method="POST">

				<div class="panel panel-info">
					<div class="panel-heading">Account Registration Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">

									<div class="form-group">
										<label for="firstName" class="col-md-4">First Name *</label>
										<div class="col-md-6">
											<form:input path="firstName" class="form-control"
												placeholder="Enter firstName"/>
											<form:errors path="firstName" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="lastName" class="col-md-4">Last Name *</label>
										<div class="col-md-6">
											<form:input path="lastName" class="form-control"
												placeholder="Enter lastName" />
											<form:errors path="lastName" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="gender" class="col-md-4">Gender </label>
										<div class="col-md-6">
											<form:radiobuttons items="${gendersList}" path="gender" />
											<form:errors path="gender" class="error" />
										</div>
									</div>

									<div class="form-group">
										<label for="email" class="col-md-4">Email *</label>
										<div class="col-md-6">
											<form:input path="email" class="form-control"
												placeholder="Enter email" id="email" />
											<form:errors path="email" class="error" /> &nbsp;
											<div style="color:red" id="emailError"  name="emailError">
										</div>
									</div>

									<div class="form-group">
										<label for="password" class="col-md-4">Password *</label>
										<div class="col-md-6">
											<form:password path="password" class="form-control"
												placeholder="Enter password" />
											<form:errors path="password" class="error" />
										</div>
									</div>



									<div class="form-group  ">
										<label for="dateOfBirth" class="col-md-4">Date Of
											Birth</label>
										<div class="col-md-6">
											<form:input path="dateOfBirth" id="datepicker"
												autocomplete="off" placeholder="Enter  dateOfBirth"
												class="form-control" />
											<form:errors path="dateOfBirth" class="error" />
										</div>
									</div>

									 <div class="form-group">
										<label for="ssnNumber" class="col-md-4">Ssn Number *</label>
										<div class="col-md-6">
									<input type="text"  id="ssnNumber1"  size="3" maxlength="3" onkeypress="function1()"/> 
									<input type="text"  id="ssnNumber2"  size="2" maxlength="2" onkeypress="function2()"/> 
									<input type="text"  id="ssnNumber3" size="4" maxlength="4"  onkeyup="function3()"/>
											<form:hidden path="ssnNumber" class="form-control" id="ssnNumber4"/>
											<form:errors path="ssnNumber" class="error" />
										</div>
									</div> 




									<div class="form-group">
										<label for="phoneNumber" class="col-md-4">Phone Number
										</label>
										<div class="col-md-6">
											<form:input path="phoneNumber"
												placeholder="Enter phoneNumber" class="form-control" id="phone"/>
											<form:errors path="phoneNumber" class="error" />
										</div>
									</div>
									<div class="form-group">
										<label for=role class="col-md-4">Role </label>
										<div class="col-md-6">
											<form:select path="role" items="${rolesList}" />
											<form:errors path="role" class="error" />
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
						
					</div>
				</div>





			</form:form>
					<button>
							<a href="getAllAccounts" class="a">view all records</a>&nbsp;&nbsp;
						</button>

		</div>
	</div>


</body>
</html>