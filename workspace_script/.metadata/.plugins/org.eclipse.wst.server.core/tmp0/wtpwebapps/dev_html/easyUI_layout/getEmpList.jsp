<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//   ./getEmpList.jsp?pageNumber=+pageNumber+&pageSize="+pageSize
	String pageNumber=request.getParameter("pageNumber");
	String pageSize=request.getParameter("pageSize");
	out.print(pageNumber+","+pageSize);
%>