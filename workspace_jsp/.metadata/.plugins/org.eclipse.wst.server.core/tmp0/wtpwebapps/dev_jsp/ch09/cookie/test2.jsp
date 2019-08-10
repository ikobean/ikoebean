<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
==========================이곳은 쿠키폴더 입니다========================
-->

<%	
	String dap1 = request.getParameter("dap1");
	Cookie cookie = new Cookie("dap1",dap1);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2</title>
<%@ include file="../../common/JEasyUICommon.jsp" %>
<script>
	//멀티선택을 배제하기 위한 함수 선언
	function answer(p_dap){ //p_dap 은 변수이고 1,2,3,4 
		//브라우저가 돔 구성시 같은 이름이면 자동으로 배열로 변환해 줌.
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test2").cb[i].checked=1;
				//1이면 체크가 되어있는 것. 0이면 체크가 안되어 있는 것
			}else{//체크가 안되어 있는 애들 
				document.getElementById("f_test2").cb[i].checked=0;
			}
		}
	}
	function prev(){
		location.href="test1.jsp?dap1=<%=dap1%>";
	}
	//다음 문제 선택시 이전 문제 답안지 기억하기 - hidden 속성에
	function next(){
		var temp=1;
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(document.getElementById("f_test2").cb[i].checked==1){
				//두번째 꺼 선택했을 때는 2가 돼야하니까 else에서 1더하기 . dap1(hidden)에 담아주기.
				document.getElementById("f_test2").dap2.value = temp;
				//alert("값"+document.getElementById("f_test2").dap1.value)
			}else{
				temp = temp + 1;
			}
		}
		document.getElementById("f_test2").submit();
	}
</script>
</head>
<body>
		<div class="easyui-panel" style="width:600px;height:500px;padding:20px"
		title="문제2" data-options="footer:'#footer'">
		<form id="f_test2" method="get" action="test3.jsp">
		<input type="hidden" id="dap2" name="dap2"/>
		다음 중에서 자바에서 제공하는 타입이 아닌것은?
		<div style="margin-bottom=20px"></div>
		<br>
		<input type="checkbox" name="cb" value="1" onChange="answer(0)">
		1.int
		<div style="margin-bottom=20px"></div>
		<br>
		<input type="checkbox" name="cb" value="2" onChange="answer(1)">
		2.String
		<div style="margin-bottom=20px"></div>
		<br>
	    <input type="checkbox" name="cb" value="3" onChange="answer(2)">
	    3.varchar2
	    <div style="margin-bottom=20px"></div>
	    <br>
		<input type="checkbox" name="cb" value="4" onChange="answer(3)">
		4.Object
		<div style="margin-bottom=20px" ></div>
		</form>
		<br>
		<div id="footer" style="padding:5px;">
			<span>
       			<a href="javascript:prev()" class="easyui-linkbutton" data-options="iconCls:'icon-before',iconAlign:'left'" >이전</a>
       		</span>
       		<span style="float:right">
	        	<a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-next',iconAlign:'right'">다음</a>
        	</span>
        </div>
	</div>
</body>
</html>