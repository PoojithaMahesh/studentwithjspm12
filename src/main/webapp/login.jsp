<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<h1><%=message %></h1>
<%}else{ %>
<h1><%="Welcome to LoginPAge please Login" %></h1>
<%} %>

<form action="login" method="post">
Email::<input type="email" name="email">
Password::<input type="password" name="password">
<input type="submit" name="LOGIN">

</form>
</body>
</html>