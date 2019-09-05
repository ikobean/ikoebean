<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	List<String> nameList =
		(List<String>)request.getAttribute("nameList");
%>
<h1>
<strong>
<%
	out.print("세상에서 제일 귀여운 고양이는?  " +nameList.get(0));
%>
</strong>
</h1>
<br>
<%
	out.print("세상에서 제일 귀여운 고양이는 몇마리?  " +nameList.size() +"마리");
%>
<br>
<%
	out.print("세젤귀 고양이는 이름을 몇글자?  " +nameList.get(0).length() +"글자");
	nameList.add("귀여워");
	nameList.add("내복아 곧 동생이 생길거야");
	nameList.add("우리집 막내 김망충");

%>
<br>
<br>
 <%="세젤냥 이름은? "%> ${nameList.get(0)} 
<br>
 <%="세젤냥 이름 글자수 "%> ${nameList.get(0).length()} 
<br>
<%="내복이는 몇마리? "%> ${nameList.size()}
<br>
${nameList.get(2)}
<br>
<%="내복이는 동생 이름은? "%> ${nameList.get(3)}
<br>
<%
	for(String s:nameList){
%>
<br>
<%
	
	out.print(s);
	}
%>
<br>
${nameList.}	
<br>
${s}	
</body>
</html>