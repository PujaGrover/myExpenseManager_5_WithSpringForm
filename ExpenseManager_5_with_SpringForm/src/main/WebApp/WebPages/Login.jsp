<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
     <header >
        <nav class="navbar sticky-top navbar-collapse navbar-expand-sm navbar-light mb-3">
            <div class="container">
                <a class="navbar-brand" href="">myExpenseManager</a>
                <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                 <!--   
                  <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index">Home</a>
                        </li>
                        Removing configure. It appears only when admin logs in
                        <li class="nav-item">
                            <a class="nav-link disabled" href="configure">Configure</a>
                        </li>
                         
                        <li class="nav-item">
                            <a class="nav-link" href="signUp">SignUp</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                    </ul>
                    -->
                </div>
            </div>
        </nav>
     </header>
     <!-- End of Header -->
     <!-- Main Body -->
     <main>
        <div class="main-container">
            <div>
                <h4>Please login with  your username and password</h4>
            </div>
            <div class="form-container" align ="center">
            <p style="color: red;">${errorMessage}</p>
                <!-- USING ACTION IN FORM TAG TO LINK LOGIN BUTTON TO HOME -->
                <form action="${pageContext.request.contextPath}/validateLogin" method="post" >
                    <div class="form-group">
                        <label  for="userName">User Name</label>
                        <span>&nbsp;</span>
                        <input class="form-control-sm" type="text"  name="userName" placeholder="username" required>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="userPassword">Password</label>
                        <span>&nbsp;</span>
                        <input class="form-control-sm" type="password" name="userPassword" placeholder="password" required>             
                    </div>
                    <br>
                    <div class="form-group">
                        <button type="submit" class="btn " value="Login">Login</button>
                        <span>&nbsp;</span>
                        <!-- BUTTON NOT WORKING BECAUSE IT IS INSIDE THE FORM -->
                        <!-- <button type="submit" class="btn" href="signUp.html">Sign Up</button> -->
                    </div> 
                    <br>      
                </form>
                <div class="col-sm-10">
                     <small class="form-text text-muted">Please <a href="${pageContext.request.contextPath}/signUp">Sign Up Here</a> to register if you are a new user
                     </small>
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