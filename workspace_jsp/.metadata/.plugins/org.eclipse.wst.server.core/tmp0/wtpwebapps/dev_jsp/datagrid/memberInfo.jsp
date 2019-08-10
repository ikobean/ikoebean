<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="../common/JEasyUICommon.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="dg"></table>
<script>
$('#dg').datagrid({
    columns:[[
        {field:'code',title:'Code',width:100},
        {field:'name',title:'Name',width:100},
        {field:'price',title:'Price',width:100,align:'right'}
    ]]
   ,data:[
	 	{"code":"A001","name":"홍길동","price":1000}
	]
});


</script>
</body>
</html>