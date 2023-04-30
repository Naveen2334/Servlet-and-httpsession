<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 <form action="update" method="post">
      
      	<label>UserId:</label>
      	<input type="number" name="id" placeholder="enter userid"><br>
      	<label>UserName:</label>
      	<input type="text" name="username" placeholder="enter username"><br>
      	<label>UserEmail:</label>
      	<input type="email" name="email" placeholder="enter email"><br>
      	<label>UserPhone:</label>
      	<input type="number" name="phone" placeholder="enter phone" value="32454"><br>
      	
      	<label>Gender:</label>
      	<input type="radio" name="gender" value="Male">Male
      	<input type="radio" name="gender" value="Female">Female &nbsp;
      	<input type="radio" name="gender" value="Others">Others<br>
      	
      	<input type="submit" value="updates">
      	
      </form>
</body>
</html>