<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include 액션태그</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	int i=10;
%>
<%
	String name = "내복이";
%>
1. 첫번째 코드 <br><!-- 실행순서1 -->
2. 두번째 코드 <br><!-- 실행순서2 -->
<jsp:include page="B.jsp" flush="false">
		<jsp:param value="<%=i%>" name="p1"/> 
		<jsp:param value="<%=name%>" name="cat"/> 
	</jsp:include>
	<br>
3. 세번째 코드 <br><!-- 실행순서6-->
4. 네번째 코드 <br><!-- 실행순서7-->
</body>
</html>