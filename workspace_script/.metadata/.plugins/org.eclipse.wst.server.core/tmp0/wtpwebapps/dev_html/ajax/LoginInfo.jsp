<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.Gson" %>

<% 

	String p_id=request.getParameter("p_id");

	List<Map<String,Object>> logList = new ArrayList<>();
	Map<String,Object> logInfo = new HashMap<>();
	
	logInfo.put("mem_id","ikobean");
	logInfo.put("mem_pw","111");
	logList.add(logInfo);
	logInfo=new HashMap<>();
	
	logInfo.put("mem_id","fuku");
	logInfo.put("mem_pw","111");
	logList.add(logInfo);
	logInfo=new HashMap<>();
	
	logInfo.put("mem_id","lucky");
	logInfo.put("mem_pw","111");
	logList.add(logInfo);
	
	out.clear();
	Gson g = new Gson();
	String result = g.toJson(logList);
	out.print(result);

%>