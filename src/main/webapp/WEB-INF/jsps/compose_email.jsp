<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="menu.jsp" %>
    
<html>
<head>
<meta charset="ISO-8859-1">
<title>compose</title>
</head>
<body>

	<h2>Compose Email</h2>
	${msg}
	<form action="sendEmail",method="post">
		<pre>
	 
			To <input type="text" name="to" value="${email}" />   <!-- here we will use the value attribute whatever ModelMap we did that email by default will display here -->
			Subject <input type="text" name="sub"/>   <!-- I will put one text area box , name attribute as msg with 10 rows & 50 columns-->  
		<textarea name="msg" rows="10" cols="50">  
		
		</textarea>
			<input type="submit" value="send" />
		</pre>
	</form>

</body>
</html>