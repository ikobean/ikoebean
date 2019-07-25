<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");
	Cookie cookie = new Cookie("dap1",dap1);
	cookie.setMaxAge(60*10);
	cookie.setPath("./");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
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
	function prev(){
		location.href="test2_hy.jsp?dap1=<%=dap1%>";
	}
	function next(){
		var temp=1;
		for(var i=0; i<document.getElementById("f_test2").cb.length;i++){
			if(document.getElementById("f_test2").cb[i].checked==1){
				document.getElementById("f_test2").dap2.value=temp;//폼태그의 values를 temp값으로 설정한다.
			}else{
				temp = temp+1;
			}
		}
			document.getElementById("f_test2").submit();
	}
</script>


</head>
<body>


	<div class="easyui-panel" style="width:600px;height:500px;padding:20px"
		title="문제2" data-options="footer:'#footer'">
		<form id="f_test2" method="get" action="test3_hy.jsp">
		<input type="hidden" id="dap2" name="dap2"/>
		다음 중 내복이의 생일을 고르시오
		<div style="margin-bottom=20px"></div>
		<br>
		<input  type="checkbox" name="cb" value="1" onChange="answer(0)">
		1.2015.09.25
		<div style="margin-bottom=20px"></div>
		<br>
		<input  type="checkbox" name="cb" value="2" onChange="answer(1)">
		2.2013.09.21
		<div style="margin-bottom=20px"></div>
		<br>
	    <input type="checkbox" name="cb" value="3" onChange="answer(2)">
	    3.2000.09.01
	    <div style="margin-bottom=20px"></div>
	    <br>
		<input type="checkbox" name="cb" value="4" onChange="answer(3)">
		4.2018.12.25
		<div style="margin-bottom=20px" ></div>
		</form>
		<br>
		<div id="footer" style="padding:5px;">
		<a href="javascript:prev()" class="easyui-linkbutton" data-options="iconCls:'icon-befroe',iconAlign:'right'">이전</a>
       		<span style="float:right">
	        	<a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-next',iconAlign:'right'">다음</a>
        	</span>
        </div>
	</div>
</body>
</html>