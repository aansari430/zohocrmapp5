<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>	
		<h2>New Lead</h2>
		
	<form action="saveLead" method="post" >
		<pre>   <!-- using this all the field will be in diffrent line -->
	
		<!--here in name attribute we can not give whatever name we want to 
 give , it should exactly matches to the variable name in the Lead.java (Entity class) ie firstName -->
			First Name <input type="text" name="firstName"/> 
			Last Name <input type="text" name="lastName"/>
			Email <input type="text" name="email"/>   
			Mobile <input type="text" name="mobile"/>	
			Source:   <!-- NOW WE WILL ADD ONE DROP-DOWN BOX -->
			<select name="source" id="cars">      <!-- name attribute is source -->
			  <option value="news paper">News paper</option>
			  <option value="online">Online</option>
			  <option value="webinar">Webinar</option>
			  <option value="radio">Radio</option>
			</select>
			  <input type="submit" value="save"/>
			
		</pre>
	</form>	


</body>
</html>