<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = request.getParameter("menu");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=0 width="1000" height="500">
<!-- top 영억 -->
	<tr>
	<td height="50" >
	
	<jsp:include page="top.jsp" flush="false"/></td>
	</tr>
<!-- body 영억 -->
	<tr>
		<td>
			<table border=1 width="1000" height="400">
				<tr>
<!-- menu 영억 -->
					<td width="200" >
					<jsp:include page="menu.jsp" flush="false"/>
						
					</td>
<!-- main 영억 -->					
					<td>
<%
	if("login".equals(menu)){
%>	
		<jsp:include page="login.jsp" flush="false"/>
<%

	}
	else if("test".equals(menu)){
	
%>
		<jsp:include page="test.jsp" flush="false"/>
<%
	}
	else if("board".equals(menu)){

%>
		<jsp:include page="board.jsp" flush="false"/>
<%
	}
%>
					</td>
				</tr>
			
			</table>
		</td>
	</tr>
<!-- bottom 영억 -->
	<tr>
		<td height="50">
		<jsp:include page="bottom.jsp" flush="false"/>
		
		</td>
	</tr>
</table>
</body>
</html>