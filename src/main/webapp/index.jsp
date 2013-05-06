<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="css/groundwork.css">
	<title>Duty Doctors | Home Page</title>
</head>
<body>
	<tags:header/>
	
	<a href="#" id="login">Login</a> <br/>
	<a href="#" id="signup">Sign up</a> <br/>
	
	<!-- Login box -->
	<div class="one third padded">
		<form action="login.show" method="post">
			<p><input type="text" name="email" placeholder="Enter your registered email" /></p>
			<p><input type="password" name="pwd" placeholder="Enter your password" /></p>
			<p><input type="submit" name="login" value="Log In" /></p>
		</form>
	</div>
	<div class="one third padded">
		<form action="signup.show" method="post">
			<p><input type="text" name="email" placeholder="Enter a valid email address" /></p>
			<p><input type="text" name="fullname" placeholder="Enter your full name" /></p>
			<p><input type="password" name="password" placeholder="Enter your password" /></p>
			<p><input type="password" name="re_pwd" placeholder="Re-enter your password" /></p>
			<p><input type="submit" name="signup" value="Create my account" /></p>
		</form>
	</div>
	
	<tags:footer/>
</body>
</html>