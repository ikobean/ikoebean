<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file ="/common/JEasyUICommon.jsp" %>
</head>
<body>
	
<table class="easyui-datagrid" title="expression 사용 예제" style="width:400px;height:250px"
        data-options="fitColumns:true,singleSelect:true" toolbar="#tb_board">
    <thead>
        <tr>
            <th data-options="field:'code',width:100">Code</th>
            <th data-options="field:'name',width:100">Name</th>
            <th data-options="field:'price',width:100,align:'right'">Price</th>
        </tr>
    </thead>
<!-- dataset과 datagrid가 만나는 부분(매핑) -->
    <tbody>
<%
	for(int i=0; i<2; i++){
%>
    	<tr>
    		<td><%="a001" %></td>
    		<td><%="노트북" %></td>
    		<td><%="350,000" %></td>
    	</tr>
<%
	} ////////////////end of for --> dataset출력
%>
    </tbody>
<!--  -->
</table>
	<div id="tb_board" style="padding:2px 5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">수정</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">삭제</a>
    </div>
	
	
</body>
</html>