<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <!-- adding jstl tags -->
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
     <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list leads</title>
</head>
<body>

	<h2>All Leads</h2>  
	<table>
  		<tr>
  	   	<th>FirstName</th>
  		<th>LastName</th>
  		<th>Email</th>
  		<th>Mobile</th>
  		<th>Source</th>  
  	</tr>
  	
  	<c:forEach var="lead" items ="${leads}">
  	
  		   <tr>
  			<!-- when i use href all the firstName filed will become the link -->
  			<!-- so when i click on this link it will take the id store into ?id & then it will call leadInfo  -->
  				<td><a href="leadInfo?id=${lead.id}">${lead.firstName}</a></td>
  				<td>${lead.lastName}</td>
  				<td>${lead.email}</td>
  				<td>${lead.mobile}</td>
  				<td>${lead.source}</td>
  		   </tr>
  				
  	</c:forEach>
  	</table>

</body>
</html>