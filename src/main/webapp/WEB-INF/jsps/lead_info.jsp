<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Info</title>
</head>
<body>

	<h2>Lead Info</h2>
<!-- Lets Display the data -->
	First Name: ${lead.firstName}<br/>
	Last Name: ${lead.lastName}<br/>
	Email: ${lead.email}<br/>
	Mobile: ${lead.mobile}<br/>
	Source: ${lead.source}<br/> 
  <form action="composeEmail" method="post">
 		<input type="hidden" name="email" value="${lead.email}"/>  <!-- Adding one Hidden filed & name attribute will be email-->
  		<input type="submit" value="Email"/>
  </form>
  
  <form action="convertLead", method="post">
  	   <input type="hidden" name="id" value="${lead.id}"/>   <!-- Adding one Hidden filed because once we have the id , based on the id i can get lead data  -->
	   <input type="submit" value="convert"/>
	</form>
	
</body>
</html>