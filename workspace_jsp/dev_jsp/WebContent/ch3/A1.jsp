<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A1.jsp</title>
</head>
<body>
여기
<%
	String name ="john";
	session.setAttribute("name", name);
	response.sendRedirect("B1.jsp");
	
%>

</body>
</html>