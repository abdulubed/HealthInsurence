<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan Registration</title>
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


<!-- form styles -->
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

<!-- Date of birth picker -->
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({

			numberOfMonths : 2,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() + 1);
				$("#datepicker1").datepicker("option", "minDate", dt);
			}
		});
		$("#datepicker1").datepicker({
			numberOfMonths : 2,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() - 1);
				$("#datepicker").datepicker("option", "maxDate", dt);
			}
		});
	});
</script>

<!-- <script>
  $(function() {
        $( "#datepicker" ).datepicker({
            dateFormat : 'mm/dd/yy',
            changeMonth : true,
            changeYear : true,
            yearRange: '-100y:c+nn',
            maxDate: '-0d'
        });
    });
 </script> -->

<script type="text/javascript">
	(function($, W, D) {
		var JQUERY4U = {};
		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#myForm").validate({
					rules : {

						planName : {
							required : true,
						},
						planDescription : {
							required : true,
						},
						startDate : {
							required : true,
						},
						endDate : {
							required : true,
						}
					},

					messages : {
						planName : "Please Enter plan name",
						planDescription : "Please Enter plan description",
						startDate : "Please select start date",
						endDate : "Please select end date"
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

				<h2 style="color: #39BC09;">${plan}</h2>




			<form:form name="myForm" id="myForm" class="form-horizontal"
				action="/insertPlanData" modelAttribute="planModel" method="post">

				<div class="panel panel-info">
					<div class="panel-heading">Plan Registration Page</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">


									<div class="form-group">
										<label for="planName" class="col-md-4">Plan Name *</label>
										<div class="col-md-6">
											<form:input path="planName" />
											<form:errors path="planName" />
										</div>
									</div>

									<div class="form-group">
										<label for="planDescription" class="col-md-4">Plan
											Description *</label>
										<div class="col-md-6">
											<form:textarea path="planDescription" />
											<form:errors path="planDescription" />
										</div>
									</div>

									<div class="form-group">
										<label for="startDate" class="col-md-4">Plan StartDate
											*</label>
										<div class="col-md-6">
											<form:input path="startDate" id="datepicker" />
											<form:errors path="startDate" />
										</div>
									</div>

									<div class="form-group">
										<label for="endDate" class="col-md-4">Plan EndDate *</label>
										<div class="col-md-6">
											<form:input path="endDate" id="datepicker1" />
											<form:errors path="endDate" />
										</div>
									</div>
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
					<a href="getAllPlans" class="a">view all plans</a>&nbsp;&nbsp;
					</button>
	</div>
	</div>


</body>
</html>