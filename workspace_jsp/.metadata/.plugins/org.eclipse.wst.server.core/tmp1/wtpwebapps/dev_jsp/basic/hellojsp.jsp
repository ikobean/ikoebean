<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String mem_id = "apple";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border='1'>
<tr><td> 서블릿으로 화면그리는 건 아니다..</td></tr>
<tr><td> <%out.print(mem_id); %></td></tr>
</table>
</body>
</html>