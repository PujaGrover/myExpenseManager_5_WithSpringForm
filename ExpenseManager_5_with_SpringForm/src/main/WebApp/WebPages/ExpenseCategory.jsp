<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- BELOW TAG IS USED TO MAKE SPRING FORM AVAILABLE -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!--Main Body -->
	<main>
		<div class="main-container">
			<div>
				<h4>Add New Category to Expenses</h4>
			</div>
			<div class="form-container" align="center">
				<div>
					<font color="red">${message}</font>
				</div>
				<form:form
					action="${pageContext.request.contextPath}/saveExpenseCategory"
					method="post" modelAttribute="newExpenseCategory">
					<div class="form-group">
						<label for="expenseCategoryName">Expense Category</label>
						<form:input path="expenseCategoryName" type="text"
							class="form-control-sm" placeholder="new expense category" required="true" />
						<p>
							<form:errors path="expenseCategoryName" class="error" />
						</p>
					</div>
					<br>
					<div class="form-group">
						<label for="expenseCategoryDescription">Description</label>
						<form:textarea class="form-control-sm" rows="3"
							path="expenseCategoryDescription" placeholder="description" />
						<p>
							<form:errors path="expenseCategoryDescription" class="error" />
						</p>
					</div>
					<br>
					<div class="form-group">
						<button type="submit" class="btn ">Save Category</button>
					</div>
				</form:form>
			</div>
			<br>
			<!-- EXPENSE CATEGORY TABLE/CONTEXTUAL CLASSES -->
			<div class="container">
				<caption>
					<h5 style="text-align: center;">List of Existing Expense
						Categories</h5>
				</caption>
				<table class="table table-hover ">
					<thead>
						<tr id="table-color" >
							<th>Category ID</th>
							<th>Expense Category</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${expenseCategoryList}" var="expenseCategory">
							<tr class="table-light">
								<th scope="row">${expenseCategory.expenseCategoryID}</th>
								<td>${expenseCategory.expenseCategoryName}</td>
								<td>${expenseCategory.expenseCategoryDescription}</td>
							</tr>
							<tr id="table-color">
							<th scope="row"></th>
								<td></td>
								<td></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="text-align: center;">
					<small class="form-text text-muted">Deleting Expense
						Category will lead to loss of data!!</small>
				</div>
			</div>
			<hr>
			<hr>
		</div>
	</main>
	<!--End of Main Body -->
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


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>