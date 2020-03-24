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
</head>
<body>
	<!-- NAVBAR WITH RESPONSIVE TOGGLE-->
	<!-- Header -->
	<header>
		 <%@ include file="Navigation.jsp" %>
	</header>
	<!-- End of Header -->
	<!-- Main Body -->
	<main>
		<div class="main-container">
			<div>
				<h4>Income Report</h4>
				<h6>Please select month and year to see the income transactions</h6>
			</div>
			<div></div>
			<div class="form-container" align="center">
				<form action="${pageContext.request.contextPath}/showIncomeReport"
						method="get">
					<div align="center">
						<div class="form-group">
							<label for="month">Month</label> <span>&nbsp;</span> 
							<select
								class="form-control-sm" type="text" name="month"
								id="month">
								<option value="01">January</option>
								<option value="02">February</option>
								<option value="03">March</option>
								<option value="04">April</option>
								<option value="05">May</option>
								<option value="06">June</option>
								<option value="07">July</option>
								<option value="08">August</option>
								<option value="09">September</option>
								<option value="10">October</option>
								<option value="11">November</option>
								<option value="12">December</option>
							</select> 
							<label for="year">Year</label> <span>&nbsp;</span> 
							<select
								class="form-control-sm" type="text" name="year"
								id="year">
								<option>2020</option>
								<option>2019</option>
								<option>2018</option>
								<option>2017</option>
								<option>2016</option>
								<option>2015</option>
								<option>2014</option>
								<option>2013</option>
								<option>2012</option>
								<option>2011</option>
								<option>2010</option>
								<option>2009</option>
							</select> 
							<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							<div>
								<button type="submit" class="btn ">Show Report</button>
							</div>
						</div>
					</div>
				</form>
				<hr>
				<hr>
				<div>
					<caption>
						<h5 style="text-align: center;">List Of All Income
							Transactions In This Month</h5>
					</caption>
					<table class="table table-hover">
						<thead>
							<tr id="table-color">
								<th>Date</th>
								<th>Amount</th>
								<th>Description</th>
								<th>Source</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${allIncomesByYearAndMonth}" var="income">
							<tr class="table-light">
								<td>${income.incomeDate.plusDays(1)}</td>
								<td>${income.incomeAmount}</td>
								<td>${income.incomeDescription}</td>
								<td>${income.incomeSource.incomeSourceName}</td>
							</tr>
							<tr id="table-color">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<br> <label for="totalIncome">Total Income</label> <span>&nbsp;</span>
				<input class="form-control-sm" type="number" name="totalIncome"
					placeholder="total income" value="${totalIncome}" >
				<div>
					<hr>
					<hr>					
				</div>

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