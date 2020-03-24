<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav
	class="navbar sticky-top navbar-collapse navbar-expand-sm navbar-light mb-3">
	<div class="container">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/homePage">myExpenseManager</a>
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/homePage">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/about">About</a></li>

				<!-- 	If the current user's userRole is not "admin" then the link to AdminPage.jsp won't appear in the menu.-->
				<li class="nav-item"><c:if test="${currentUser.role.roleID == 1}">
						<a class="nav-link"
							href="${pageContext.request.contextPath}/configure">Configure</a>
					</c:if></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>
