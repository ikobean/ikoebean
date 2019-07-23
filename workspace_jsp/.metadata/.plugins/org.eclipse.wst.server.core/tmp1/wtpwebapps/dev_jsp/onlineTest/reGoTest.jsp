<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 응시</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
      <script> 
      	//DOM구성이 완료되었을 때 콤보박스를 초기화 할 것.
      	//이 문서 전체를 가리키는 내장객체.
      	$(document).ready(function (){
      		//콤보 초기화
      		$('#cb_subject').combobox({
      		  url:'/onlineTest/subjectList.kos?work=onlineTest',
      		  valueField:'SUB_CD',
      		  textField:'SUB_NAME',
      		  paneHeight:'auto',
      		  onSelect:function(record){
      			  alert(record.SUB_NAME);
      		  }
      		});
      	});
      </script>
 <!-- 
 ===========================================================================================
 					test take 창 만들기 시작
 ===========================================================================================
  -->

 <div class="easyui-panel" id="pl_takeatest" title="Take a Test" style="width:70%;max-width:400px;padding:30px 30px" >
	<div style="margin-bottom:20px">
		<select class="easyui-combobox" id="cb_subject" name="cb_subject" label="수험 과목 선택: " labelPosition="top" style="width:70%;"
		data-options="prompt:'수험 과목을 선택하세요.'">
		</select>
	</div>
	<div style="margin-bottom:30px">
		<input class="easyui-textbox" id="tb_examno" name="tb_examno" label="수험번호" labelPosition="top" style="width:70%;">
	</div>
	<div>
		<a id="btn_start" href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:70%;">시험 시작 </a>
	</div>
	<div style="margin-bottom:20px"></div>
</div>

   <!-- 
 ===========================================================================================
 					test take 창 만들기 끝
 ===========================================================================================
  -->
</div>
</body>
</html>