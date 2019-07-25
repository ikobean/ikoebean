<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<script>
	function answer(p_dap){
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test2").cb[i].checked=1;
			}else{
				document.getElementById("f_test2").cb[i].checked=0;
			}
		}
	}

	function next(){
		var temp=1;
		for(var i=0; i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked==1){
				document.getElementById("f_test1").dap1.value=temp; //setValue 해주는 느낌~
			}else{
				temp = temp+1;
			}
		}
			document.getElementById("f_test1").submit();
	}
</script>
<body>


	<div class="easyui-panel" style="width:600px;height:500px;padding:20px"
		title="문제1" data-options="footer:'#footer'">
		<form id="f_test1" method="get" action="test2_hy.jsp">
		<input type="hidden" id="dap1" name="dap1"/>
		내복이의 귀엽지 않은 곳을 고르시오
		<div style="margin-bottom=20px"></div>
		<br>
		<input  type="checkbox" name="cb" value="1" onChange="answer(0)">
		1.솜방망이
		<div style="margin-bottom=20px"></div>
		<br>
		<input  type="checkbox" name="cb" value="2" onChange="answer(1)">
		2.눈동자
		<div style="margin-bottom=20px"></div>
		<br>
	    <input type="checkbox" name="cb" value="3" onChange="answer(2)">
	    3.뾰족귀
	    <div style="margin-bottom=20px"></div>
	    <br>
		<input type="checkbox" name="cb" value="4" onChange="answer(3)">
		4.없다
		<div style="margin-bottom=20px" ></div>
		</form>
		<br>
		<div id="footer" style="padding:5px;">
       		<span style="float:right">
	        	<a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-next',iconAlign:'right'">다음</a>
        	</span>
        </div>
	</div>
</body>
</html>