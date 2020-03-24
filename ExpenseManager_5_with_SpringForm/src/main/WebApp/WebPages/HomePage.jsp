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
          width: 33.333333%;
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
        
        #Expense {background-color:rgb(248, 234, 107);}
        #Income {background-color:rgb(248, 234, 107);}
        #Report {background-color:rgb(248, 234, 107);}
        </style>

        <!-- USING Jquery TO LOAD HTML PAGE INSIDE THE TAB -->
        <!-- <script src="jquery.js"></script>--> 
    <!-- <script> 
    $(function(){
      $("#includedContent").load("expense.html"); 
    });
    </script>  -->

        <!--FOR FLEX BOXES IN THE MAIN BODY  -->
        <!-- <style>
            .row-hl {
              background: #f4f4f4;
              height: 250px;
            }
        
            .item-hl {
              border: 1px solid #333;
            }
        </style> -->
</head>
<body>
     <!-- NAVBAR WITH RESPONSIVE TOGGLE-->
     <!-- Header -->
     <header >
     
     <%@ include file="Navigation.jsp" %>
   
     </header>
     <!-- End of Header -->
     <!-- Main Body -->
     <main>
         <div class="main-container">
            <button class="tablink" onclick="openPage('Expense', this, 'rgb(248, 234, 107)')">Expense</button>
            <button class="tablink" onclick="openPage('Income', this, 'rgb(248, 234, 107)')" id="defaultOpen">Income</button>
            <button class="tablink" onclick="openPage('Report', this, 'rgb(248, 234, 107)')">Report</button>
            
            <div id="Expense" class="tabcontent">
                <h3>Expense</h3>
              <include>
                <a href="${pageContext.request.contextPath}/expense" style="color: black;">Click Here To Enter New Expense</a>
                
                <!--<div w3-include-html="expense.html"></div>     NOT WORKING-->
                <!-- <div id="includedContent">Include Content</div> IN SINK WITH Jquery FUNCTION IN HEADER< NOT WORKING -->

            </div>
            
            <div id="Income" class="tabcontent">
              <h3>Income</h3>
              <include>
                <a href="${pageContext.request.contextPath}/income" style="color: black;">Click Here To Enter New Income</a>
            </include>
            </div>
            
            <div id="Report" class="tabcontent">
              <h3>Report</h3>
              <include>
                  <a href="${pageContext.request.contextPath}/expenseReport" style="color: black;">Click Here To Generate Expense Report</a>
                  <br>
                  <a href="${pageContext.request.contextPath}/incomeReport" style="color: black;">Click Here To Generate Income Report</a>
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
</html>