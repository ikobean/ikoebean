<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 ㅐㅅㅇ성</title>
<%
	Cookie cookie = new Cookie("cookieName", "cookieValue");
	response.addCookie(cookie);
%>
<% Cookie cookie2 = new Cookie("name",URLEncoder.encode("내복이","UTF-8"));
	response.addCookie(cookie2);
%>
</head>
<body>
<%= cookie2.getName() %> 쿠키의 값 = "<%= cookie2.getValue() %>"
</body>
</html>