<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
  <script type="text/javascript">
	       var url;
	       function newUser(){
	           $('#dlg').dialog('open').dialog('center').dialog('setTitle','New User');
	           $('#fm').form('clear');
	           url = 'save_user.php';
	       }
	       function editUser(){
	           var row = $('#dg').datagrid('getSelected');
	           if (row){
	               $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');
	               $('#fm').form('load',row);
	               url = 'update_user.php?id='+row.id;
	           }
	       }
	       function saveUser(){
	           $('#fm').form('submit',{
	               url: url,
	               onSubmit: function(){
	                   return $(this).form('validate');
	               },
	               success: function(result){
	                   var result = eval('('+result+')');
	                   if (result.errorMsg){
	                       $.messager.show({
	                           title: 'Error',
	                           msg: result.errorMsg
	                       });
	                   } else {
	                       $('#dlg').dialog('close');        // close the dialog
	                       $('#dg').datagrid('reload');    // reload the user data
	                   }
	               }
	           });
	       }
	       function destroyUser(){
	           var row = $('#dg').datagrid('getSelected');
	           if (row){
	               $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
	                   if (r){
	                       $.post('destroy_user.php',{id:row.id},function(result){
	                           if (result.success){
	                               $('#dg').datagrid('reload');    // reload the user data
	                            } else {
	                                $.messager.show({    // show error message
	                                    title: 'Error',
	                                    msg: result.errorMsg
	                                });
	                            }
	                        },'json');
	                    }
	                });
	            }
	        }
	    </script>

</head>
<body>
<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:250px"
	           url="get_users.php"
	           toolbar="#toolbar" pagination="true"
	           rownumbers="true" fitColumns="true" singleSelect="true">
	       <thead>
	           <tr>
	               <th field="bm_no" width="50">글번호</th>
	               <th field="bm_title" width="50">제목</th>
	               <th field="bm_writer" width="50">작성자</th>
	               <th field="bm_date" width="50">작성일</th>
	               <th field="bm_file" width="50">첨부파일</th>
	               <th field="bm_hit" width="50">조회수</th>
	           </tr>
	       </thead>
	       
	   </table>
	    <div id="toolbar">
	       		<!-- 콤보박스 -->
		       <select class="easyui-combobox" name="inform" style="width:100px;">
	                <option value="cb_title">제목</option>
	                <option value="cb_title">내용</option>
	                <option value="cb_writer">작성자</option>
		       </select>
		       <input class="easyui-textbox" iconCls="icon-search" style="width:100px;">
	       <!-- 데이트박스 -->
				<input class="easyui-datebox" id="db_date" name="db_date" label="작성일 : " style="width:200px;">
			<div style="margin-bottom:10px" />
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">조회</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">입력</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">수정</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">삭제</a>
	   
	   </div>
	   
	   <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
	       <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
	           <h3>User Information</h3>
	           <div style="margin-bottom:10px">
	               <input name="firstname" class="easyui-textbox" required="true" label="First Name:" style="width:100%">
	           </div>
	           <div style="margin-bottom:10px">
	               <input name="lastname" class="easyui-textbox" required="true" label="Last Name:" style="width:100%">
	           </div>
	           <div style="margin-bottom:10px">
	               <input name="phone" class="easyui-textbox" required="true" label="Phone:" style="width:100%">
	           </div>
	           <div style="margin-bottom:10px">
	               <input name="email" class="easyui-textbox" required="true" validType="email" label="Email:" style="width:100%">
	           </div>
	       </form>
	   </div>
	   <div id="dlg-buttons">
	       <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
	       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
	   </div>
	 
</body>
</html>