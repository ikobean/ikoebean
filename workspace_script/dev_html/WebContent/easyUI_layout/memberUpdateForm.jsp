<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면처리</title>
</head>
<body>
수정화면처리
<%
     //스크립틀릿 - 자바코딩이 가능함.
     //스크립틀릿은 jsp페이지에서만 사용가능
     String c_id = request.getParameter("id");
     out.print(c_id);
%>
</body>
</html>