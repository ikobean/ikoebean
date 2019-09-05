<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>   
<%
	List<Map<String,Object>> memList = 
			(List<Map<String,Object>>)request.getAttribute("memList");
	
	int size=0;
	if(memList!=null){
	out.print("memList.size()=========>"+memList.size()+"<br>");
	
	
	 	for(int j=0;j<memList.size();j++){
			out.print(memList.get(j)+"<br>");	
		}
		
		for(Map<String,Object> map: memList){
			Object[] keys = map.keySet().toArray();
			for(int k=0;k<map.size();k++){
				out.print(keys[k]+"<br>");
				out.print(map.get(keys[k])+"<br>");
			}
		} 
	}
%>
<!DOCTYPE html>
<html>
<script>
	function boardList(){
		document.getElementById("f_boardList").submit();
	}
</script>
<head>
<meta charset="UTF-8">
<title>webapp</title>
</head>
<body>
<h1>[[webapp]]boardList</h1>
<h2>게시판 목록</h2>

<form id="f_boardList" method="post" action="boardList3">
	<button onClick="boardList()">조회</button>
</form>

</body>
</html>