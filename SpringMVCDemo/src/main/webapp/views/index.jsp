<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome to Capgemini
	
<!-- 	<form action="add">
	Enter 1st Number: <input type="text" name="num1"><br>
	Enter 2nd Number: <input type="text" name="num2"><br>
	<input type="submit">
	</form> 
	
	-->
	
	<form action="addAlien" method="post" >
	Enter Your ID: <input type="text" name="aid"><br>
	Enter Name: <input type="text" name="aname"><br>
	<input type="submit">
	</form>
	
	<hr>
	<form action="getAlien"  method= "get">
	Enter Your ID: <input type="text" name="aid"><br>
	<input type="submit">
	</form>
	
	<hr>
	
	<form action="getAlienByName"  method= "get">
	Enter Your Name: <input type="text" name="aname"><br>
	<input type="submit">
	</form>
	
	<hr>
	
	<form action="getAliens"  method= get>
	Find All Data:<input type="submit">
	</form>
	
	
</body>
</html>