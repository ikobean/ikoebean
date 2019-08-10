<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/JEasyUICommon.jsp" %>
<title>자바 스크립트 노트 페이지</title>

</head>


<body class="easyui-layout">
    <div data-options="region:'north'" style="height:100px"></div>
    <div data-options="region:'center'">
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'west',collapsed:true" style="width:180px"></div>
            <div data-options="region:'center'"></div>
        </div>
    </div>
</body>



</html>