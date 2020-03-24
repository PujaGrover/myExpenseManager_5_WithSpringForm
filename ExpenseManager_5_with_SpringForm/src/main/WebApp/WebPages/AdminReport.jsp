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
<!-- Main Body -->
     <main>
        <div class="main-container">
            <div>
                <h4>Admin Report</h4>
                <h6>Please select month and year to see user expense in each category</h6>
            </div>
            <div>
                
            </div>
            <div class="form-container" align ="center">
                <form>
                    <div align ="center">
                        <div class="form-group">
                            <label for="month">Month</label>
                            <span>&nbsp;</span>
                            <select  class="form-control-sm" type="text"  name="expenseCategoryID" id="expenseCategoryID">
                                <option>January</option>
                                <option>February</option>
                                <option>March</option>
                                <option>April</option>
                                <option>May</option>
                                <option>June</option>
                                <option>July</option>
                                <option>August</option>
                                <option>September</option>
                                <option>October</option>
                                <option>November</option>
                                <option>December</option>
                            </select>
                            <label for="month">Year</label>
                            <span>&nbsp;</span>
                            <select  class="form-control-sm" type="text"  name="expenseCategoryID" id="expenseCategoryID">
                                <option>2020</option>
                                <option>2019</option>
                                <option>2018</option>
                                <option>2017</option>
                                <option>2016</option>
                                <option>2015</option>
                            </select>
                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <div>
                                <button type="submit" class="btn ">Show Report</button>
                            </div>
                        </form>  
                        <hr>
				        <hr> 
                        </div>
                        <div>
                            <caption>
                                <h5 style="text-align: center;">List Of User Expense In Each Category In This Month</h5>
                            </caption>
                            <table class="table table-hover">
                                <thead>
                                    <tr id="table-color">
                                        <th>Category</th>
                                        <th>Expense</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="table-light">
                                        <td>###</td>
                                        <td>###</td>
                                    </tr>
                                    <tr id="table-color">
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <label for="totalIncome">Total Expense</label>
                        <span>&nbsp;</span>
                        <input class="form-control-sm" type="number"  name="totalExpense" placeholder="total expense">
                        <div>
                        <hr>
                        <hr>  
                        </div>
                    </div>
                
            </div>
         </div>
     </main>
    <!-- End of Main Body -->
    <!-- Footer -->
    <footer class="footer fixed-bottom " style=" padding: 8px 16px; margin: 16px 0px 0px;">
        <div class="container">
            <p><span class="text-muted">&copy; 2020 - Puja Grover</span></p>
        </div>
    </footer>
    <!-- End of Footer -->


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>