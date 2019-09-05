<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Map<String,Object> dohu = 
		(Map<String,Object>)request.getAttribute("someMap");

out.print(dohu.get("first"));
%>
</head>
<body>

</body>
</html>