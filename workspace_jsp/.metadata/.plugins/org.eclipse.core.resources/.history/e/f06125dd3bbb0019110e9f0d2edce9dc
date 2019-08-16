<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> b_boardList=
     			(List<Map<String,Object>>)request.getAttribute("b_boardList");
	String imsi = null;
	Gson g = new Gson();
	imsi=g.toJson(b_boardList);
	out.print(imsi);
%>


