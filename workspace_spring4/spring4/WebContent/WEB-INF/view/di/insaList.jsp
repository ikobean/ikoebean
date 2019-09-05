<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> listBean =
		(List<String>)request.getAttribute("listBean");
		for(String insa:listBean){
%>
<br>
<%			
		out.print(insa);
}
	
%>
</body>

</html>