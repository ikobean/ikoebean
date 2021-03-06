<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo/demo.css">
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
<!-- 조회 결과가 있니? if문 -->
<!-- 네라면 반복문 처리 (if문 안에 for문) -->
	<table id="dg_member" class="easyui-datagrid" title="회원목록" data-options="url:'/ch05/memberList.do'"  width="400px" border="1">
		<thead> 
			<tr>
				<th data-options="field:'mem_id', width:80">아이디</th>
				<th data-options="field:'mem_pw', width:80">비밀번호</th>
				<th data-options="field:'mem_name', width:80">이름</th>
			</tr>
		</thead>
	</table>

<!-- 조회 결과가 없을 땐 조회 결과가 없습니다. 출력 -->
</body>
</html>