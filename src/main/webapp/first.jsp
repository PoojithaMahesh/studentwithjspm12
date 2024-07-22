<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String message="hiii"; %>
<%if(message!=null){ %>

<%=message %>

<%}else{ %>

<%="HII FROM ELSE BLOCK BECAUSE MSG IS NULL" %>
<%} %>

</body>
</html>