<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
==========================이곳은 쿠키폴더 입니다========================
-->
<%	
	String dap3 = request.getParameter("dap3");
	Cookie cookie = new Cookie("dap3",dap3);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
	response.sendRedirect("account.jsp");
%>