<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/JEasyUICommon.jsp"%>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#dg_member').datagrid({
				title : "회원관리 ver1.0",
				toolbar : '#td_member',
				columns : [ [ {
					field : 'MEM_ID',
					title : '아이디',
					width : 100
				}, {
					field : 'MEM_NAME',
					title : '이름',
					width : 100
				}, {
					field : 'MEM_ADDR',
					title : '주소',
					width : 100,
					align : 'left'
				} ] ]
			});////////////end of datagrid
			$('#dlg_ins').dialog({
				title : "회원가입",
				width : 400,
				height : 500,
				footer : "#tb_ins",
				closed : true
			});
			$('#btn_ins').linkbutton({
				onClick : function() {
					$('#dlg_ins').dialog('open');
				}
			})
			$('#btn_close').linkbutton({
				onClick : function() {
					$('#dlg_ins').dialog('close');
				}
			})
			$('#btn_save').linkbutton({
				onClick : function() {
				
					$('#dlg_ins').dialog('close');
					$('#f_ins').attr('method','GET');
					$('#f_ins').attr('action','./memberInsert.kos');
					$('#f_ins').submit();
				}
			})
		});
	</script>


	<table id="dg_member"></table>

	<div id="td_member" style="padding: 5px;">
		<a id="btn_ins" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true">가입 </a>

	</div>
	<!--=================회원가입====================-->

	<div id="dlg_ins" style="padding: 30px 60px;">
		<form id="f_ins">
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="mem_id" label="ID" labelPosition="top"
					style="width: 70%;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="mem_name" label="Name" labelPosition="top"
					style="width: 70%;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="mem_addr" label="Address" labelPosition="top"
					style="width: 70%;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="mem_zipcode" label="Zipcode" labelPosition="top"
					style="width: 70%;">
			</div>
			<div style="margin-bottom: 10px">
				<input class="easyui-passwordbox" name="mem_pw" label="Password"
					labelPosition="top" style="width: 70%;">
			</div>
		</form>
		</table>
	</div>
	<!-- 회원가입 텍스트박스 -->


	<div id="tb_ins" style="padding: 5px;">
		<a id="btn_save" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true">저장 </a> <a
			id="btn_close" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true">닫기</a>
	</div>

	<!--=================회원가입====================-->

</body>
</html>