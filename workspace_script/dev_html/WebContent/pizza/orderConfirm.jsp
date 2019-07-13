<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인서</title>
</head>
<body>
<%
	String user_name = request.getParameter("mem_name");
	String paper = request.getParameter("paper"); 	//주문
	String dep = request.getParameter("mem_addr"); //배송지
	//out.print(user_name+", "+paper+", "+dep);
%>
<!-- out.print 파라미터에 있는 값을 브라우저에 출력해 줌 -->
<table align="center" width="500px" border="1">

	<tr>
		<td width="100px">주문자</td>
		<td><% out.print(user_name);%></td>
	</tr>
	<tr>
		<td width="100px">주문내용</td>
		<td><% out.print(paper);%></td>
	</tr>
	<tr>
		<td width="100px">배송지</td>
		<td><% out.print(dep);%></td>
	</tr>
</table> 
</body>
</html>