<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- TO BE ADDED TO USE SPRING FORM -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!--Bootstrap library link(source: stackpath) -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<!--Link to myExpenseManager.css style sheet in css folder-->
<link rel="stylesheet" href="../myExpenseManager.css">

<title>myExpenseManager</title>
<!-- Form validation to match password and confirm password using JavaScript -->
<script type="text/javascript">
	function validate() {
		var password = document.signUp.userPassword.value;
		var confirmpassword = document.signUp.confirmPassword.value;

		if (password == null || password == "") {
			alert("Passwords cannot be empty..");
			document.signUp.password.focus();
			return false;
		}

		if (password != confirmpassword) {
			alert("Password not matching! Ensure the password and confirm-password match...")
			document.signUp.password.focus();
			return false;
		}
		return true;
	}
</script>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<!-- NAVBAR WITH RESPONSIVE TOGGLE-->
	<!-- Header -->
	<header>
		<nav
			class="navbar sticky-top navbar-collapse navbar-expand-sm navbar-light mb-3">
			<div class="container">
				<a class="navbar-brand disabled" href="">myExpenseManager</a>
				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarNav">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					
				</div>
			</div>
		</nav>
	</header>
	<!-- End of Header -->
	<!-- Main Body -->
	<main>
		<div class="main-container">
			<div>
				<h4>Please provide following details to set up a new account</h4>
			</div>	
			<div class="form-container" align="center">
			<div>
			 <p style="color: red;">${errorMessage}</p>
			</div>

				<form:form action="saveSignUp" name="signUp" method="post"
					modelAttribute="newUserDetail" onsubmit="return validate();">
					<div class="form-group">
						<label for="firstName">First Name</label> <span>&nbsp;</span>
						<form:input class="form-control-sm" type="text" path="firstName"
							placeholder="First Name" />
						<p>
							<form:errors path="firstName" class="error" />
						</p>
					</div>
					<div class="form-group">
						<label for="lastName">Last Name</label> <span>&nbsp;</span>
						<form:input class="form-control-sm" type="text" path="lastName"
							placeholder="Last Name" />
						<p>
							<form:errors path="lastName" class="error" />
						</p>
					</div>

					<div class="form-group">
						<label for="userName">User Name</label> <span>&nbsp;</span>
						<form:input class="form-control-sm" type="text" path="userName"
							placeholder="username" />
						<p>
							<form:errors path="userName" class="error" />
						</p>
					</div>


					<div class="form-group">
						<label for="userEmail">Email</label> <span>&nbsp;</span>
						<form:input class="form-control-sm" type="email" path="userEmail"
							placeholder="email@example.com" />
						<p>
							<form:errors path="userEmail" class="error" />
						</p>
					</div>
					<div class="form-group">
						<label for="userPassword">Password</label> <span>&nbsp;</span> 
						<form:input
							class="form-control-sm" type="password" path="userPassword"
							placeholder="password" />
							<p><form:errors path="userPassword" class="error" /></p>
					</div>
					<!--
					<div class="form-group">
						<label for="confirmPassword">Confirm Password</label> <span>&nbsp;</span>
						<input class="form-control-sm" type="password"
							name="confirmPassword" placeholder="confirm password">
					</div>
					 -->

					<div class="form-group">
						<span>&nbsp;</span>
						<button type="submit" class="btn">Save</button>
					</div>

				</form:form>
				<div class="col-sm-10">
					<small class="form-text text-muted">Please <a
						href="${pageContext.request.contextPath}/">Login Here</a> if you
						already have an account
					</small>
				</div>
			</div>
		</div>
		<br> <br>
	</main>
	<!-- End of Main Body -->
	<!-- Footer -->
	<footer class="footer fixed-bottom "
		style="padding: 8px 16px; margin: 16px 0px 0px;">
		<div class="container">
			<p>
				<span class="text-muted">&copy; 2020 - Puja Grover</span>
			</p>
		</div>
	</footer>
	<!-- End of Footer -->


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>