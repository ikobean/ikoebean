<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A.jsp</title>
</head>
<body>
<%
	String name="john";
	//요청에 객체에 담기
    request.setAttribute("name", name);
	//아래코드는 페이지 이름이 바뀐다.-> 기존 요청은 끊어지고 새로운 요청이 일어남.
	//만일 이문제를 꼭 해결하고 싶다면 어떡하지?
	//session이면 해결가능함.-저장소 작다.
	//response.sendRedirect("B.jsp");//이동
	//doGet(HttpServletRequest res)
	RequestDispatcher view = request.getRequestDispatcher("B.jsp");
	//실제로 페이지 이동이 일어나는 부분
	view.forward(request,response);
	//주소가 변경됨 - 기존에 요청이 끊어지고 새로운 요청이 응답
	//request객체가 같은 원본이 아니다.
%>
여기
</body>
</html>







