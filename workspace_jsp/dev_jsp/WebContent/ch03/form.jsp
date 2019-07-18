<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<!--  <form action="/ch3/viewParameter.jsp" method="post">-->
<!--  <form action="/ch3/pet.do" method="post">-->
 <form action="/ch3/pet.do" method="get"> 
이름 : <input type="text" name="name" size="10"> <br>
주소: <input type="text" name="address" size="30"> <br>
좋아하는 동물 :
	<input type="checkbox" name="pet" value="dog"> 강아지
	<input type="checkbox" name="pet" value="cat"> 고양이
	<input type="checkbox" name="pet" value="pig"> 돼지
	<br>
	<input type="submit" value="전송">
</form>
</body>
</html>
<!-- hidden 눈에 보이지는 않지만 업무처리에 따라 전송하고 싶을 때
	type자리에 넣어서 value값을 전송할 수 있음.
, submit -->