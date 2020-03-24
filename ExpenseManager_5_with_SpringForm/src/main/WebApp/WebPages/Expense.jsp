<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- BELOW TAG IS USED TO MAKE SPRING FORM AVAILABLE -->
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
<!-- To make errors come up in red color -->
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

		<%@ include file="Navigation.jsp"%>

	</header>
	<!-- End of Header -->
	<!-- Main Body -->
	<main>
		<div class="main-container">
			<div>
				<h4>Add New Expense</h4>
			</div>
			<div class="form-container" align="center">
				<div>
					<font color="red">${message}</font>
				</div>
				<form:form action="${pageContext.request.contextPath}/saveExpense"
					method="post" modelAttribute="newExpense">
					<div class="form-group">
						<label for="expenseDate">Date</label> <span>&nbsp;</span>
						<form:input class="form-control-sm" type="date" path="expenseDate"
							placeholder="date" />
						<p>
							<form:errors path="expenseDate" class="error" />
						</p>
					</div>
					<div class="form-group">
						<label for="expenseAmount">Expense Amount</label> <span>&nbsp;</span>
						<form:input class="form-control-sm" type="number"
							path="expenseAmount" placeholder="amount" />
						<p>
							<form:errors path="expenseAmount" class="error" />
						</p>
					</div>
					<div class="form-group">
						<label for="expenseDescription">Description</label> <span>&nbsp;</span>
						<form:textarea class="form-control-sm" rows="3"
							path="expenseDescription" placeholder="description" />
						<p>
							<form:errors path="expenseDescription" class="error" />
						</p>
					</div>
					<div class="form-group">
						<label for="expenseCategory">Expense Category</label> <span>&nbsp;</span>
						<form:select class="form-control-sm" type="text"
							path="expenseCategory.expenseCategoryID" items="${expenseCategories}" 
							itemLabel="expenseCategoryName" itemValue="expenseCategoryID" />
						<p>
							<form:errors path="expenseCategory" class="error" />
						</p>
					</div>
					<div class="col-sm-10">
						<button type="submit" class="btn">Save Expense</button>
					</div>
				</form:form>
			</div>
		</div>
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