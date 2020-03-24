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
    <!-- FOR TABS -->
<style>
    * {box-sizing: border-box}
    
    /* Style tab links */
    .tablink {
      background-color:rgb(203,238,226);
      color: black;
      float: left;
      border: none;
      outline: none;
      cursor: pointer;
      padding: 14px 16px;
      font-size: 17px;
      width: 25%;
    }
    
    .tablink:hover {
      background-color: #777;
    }
    
    /* Style the tab content (and add height:100% for full page content) */
    .tabcontent {
      color: black;
      display: none;
      padding: 100px 20px;
      height: 100%;
    }
    
    #UserRoles {background-color:rgb(248, 234, 107);}
    #AddIncomeSource {background-color:rgb(248, 234, 107);}
    #AddExpenseCategory {background-color:rgb(248, 234, 107);}
    #AdminReport {background-color:rgb(248, 234, 107);}
    </style>

</head>
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
            <button class="tablink" onclick="openPage('UserRoles', this, 'rgb(248, 234, 107)')">User Roles</button>
            <button class="tablink" onclick="openPage('AddIncomeSource', this, 'rgb(248, 234, 107)')" id="defaultOpen">Income Source</button>
            <button class="tablink" onclick="openPage('AddExpenseCategory', this, 'rgb(248, 234, 107)')">Expense Category</button>
            <button class="tablink" onclick="openPage('AdminReport', this, 'rgb(248, 234, 107)')">Report</button>
            
            <div id="UserRoles" class="tabcontent">
                <h3>Assign User Roles</h3>
                <include>
                <a href="${pageContext.request.contextPath}/userRoles" style="color: black;">Click Here To Assign Roles To User</a>
                </include>
            </div>
     
            <div id="AddIncomeSource" class="tabcontent">
              <h3>Income Source</h3>
              <include>
                <a href="${pageContext.request.contextPath}/incomeSource" style="color: black;">Click Here To Enter New Income Source</a>
            </include>
            </div>
            
            <div id="AddExpenseCategory" class="tabcontent">
              <h3>Expense Category</h3>
              <include>
                  <a href="${pageContext.request.contextPath}/expenseCategory" style="color: black;">Click Here To Add Expense Category</a>
              </include>
            </div>

            <div id="AdminReport" class="tabcontent">
                <h3>Expense Category</h3>
                <include>
                    <a href="${pageContext.request.contextPath}/adminReport" style="color: black;">Click Here To Get Report Based On Category</a>
                </include>
              </div>
            
            <script>
            function openPage(pageName,elmnt,color) {
              var i, tabcontent, tablinks;
              tabcontent = document.getElementsByClassName("tabcontent");
              for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
              }
              tablinks = document.getElementsByClassName("tablink");
              for (i = 0; i < tablinks.length; i++) {
                tablinks[i].style.backgroundColor = "";
              }
              document.getElementById(pageName).style.display = "block";
              elmnt.style.backgroundColor = color;
            }
            
            // Get the element with id="defaultOpen" and click on it
            document.getElementById("defaultOpen").click();
            </script>

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
