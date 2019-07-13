<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson" %>
<% 
	String p_tel= request.getParameter("p_tel");

	List<Map<String, Object>> odList = new ArrayList<>();
	Map<String,Object> odInfo = new HashMap<>();
	
	odInfo.put("mem_name","이순신");
	odInfo.put("mem_addr","서울시 마포구 공덕동");
	odInfo.put("mem_tel","025559999");
	odList.add(odInfo);
	odInfo=new HashMap<>();
	
	odInfo.put("mem_name","김유신");
	odInfo.put("mem_addr","서울시 영등포구 당산동");
	odInfo.put("mem_tel","026669999");
	odList.add(odInfo);
	odInfo=new HashMap<>();
	
	odInfo.put("mem_name","강감찬");
	odInfo.put("mem_addr","서울시 구로구 개봉동");
	odInfo.put("mem_tel","027779999");
	odList.add(odInfo);

	
	
	out.clear();
	Gson g = new Gson();
	String result = g.toJson(odList);
	out.print(result);
%>