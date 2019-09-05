<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%
//WebContent 밑에 있는 것을 찾을 ㄸㅐ는 req,res
//WEB-INF/view에 있는 애들은 ModelAndView를 경유.
//외부에 보여주고 싶지 않은 애들은 view에다가 !

   	//ModelAndView에 담긴 정보 꺼내오기
   	List<Map<String,Object>> memList = 
	(List<Map<String,Object>>)request.getAttribute("memberList");
	//out.print(memList);
	
	
	
	for(Map<String,Object> mem:memList){
		 
		for(int i=0; i<mem.size();i++){
		Object[] keys = mem.keySet().toArray();
			String key = (String)keys[i];
			out.print("key ===>"+key+"　　"+"value===>"+mem.get(key)+"<br>");
			
		}
			out.print("================================="+"<br>");
	}
   %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원목록[WEB-INF]</title>
</head>
<body>

<h1>
나는 ModelAndView로 끌어온 페이지다
</h1>
</body>
</html>