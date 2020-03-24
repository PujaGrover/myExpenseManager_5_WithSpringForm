<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
< <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Bootstrap library link(source: stackpath) -->    
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
            <h4 style="color: rgb(122, 238, 197);">Welcome to myExpenseManger!!</h4>
            <h6>myExpenseManger is a financial web 
            application that allows you to manage your income and expenses</h6>
           <div>
           <p>To use this application you need to create an account 
            and register by providing some basic details about yourself. 
            This will allow us to save your interactions in a database 
            and help you by generating reports based upon the provided data.</p>
            <div>
           <p style="color: rgb(122, 238, 197); text-align: center;">Enjoy happy wealth savings with us :)</p>
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