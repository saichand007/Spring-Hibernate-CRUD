<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Customers List</h1>
		</div>
	</div>
  
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer"  class="add-button"
		 onClick="window.location.href='showFormAdd';return false;"/>
		 
		 <br/>
	
			<table>
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>


				<c:forEach var="temp" items="${customers}">
				
				<c:url var="updateLink" value="/customer/showFormUpdate">
				<c:param name="customerId" value="${temp.id}"></c:param>
				</c:url>
				
					<c:url var="deleteLink" value="/customer/showFormDelete">
				<c:param name="customerID" value="${temp.id}"></c:param>
				</c:url>
					<tr>
						<td>${temp.firstName }</td>
						<td>${temp.lastName }</td>
						<td>${temp.email }</td>
						<td>
						<a href="${updateLink}">Update</a>!!<a href="${deleteLink}">Delete</a>
						</td>

					</tr>
				</c:forEach>


			</table>

		</div>
	</div>

</body>
</html>