<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
==========================이곳은 쿠키폴더 입니다========================
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <%
	String dap1 = request.getParameter("dap1");
	//out.print("1번문제 답:"+dap1);
%>
<title>문제1</title>
<%@ include file="../../common/JEasyUICommon.jsp" %>
<script type="text/javascript">
//멀티선택을 배제하기 위한 함수 선언
	function answer(p_dap){ //p_dap 은 변수이고 1,2,3,4 
		//브라우저가 돔 구성시 같은 이름이면 자동으로 배열로 변환해 줌.
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test1").cb[i].checked=1;
				//1이면 체크가 되어있는 것. 0이면 체크가 안되어 있는 것
			}else{//체크가 안되어 있는 애들 
				document.getElementById("f_test1").cb[i].checked=0;
			}
		}
		
	}
	//다음 문제 선택시 이전 문제 답안지 기억하기 - hidden 속성에
	function next(){
		var temp=1;
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked==1){ //체크가 되어있으면 
				//두번째 꺼 선택했을 때는 2가 돼야하니까 else에서 1더하기 . dap1(hidden)에 담아주기.
				document.getElementById("f_test1").dap1.value = temp; //value=1,2,3,4 템프 
				//alert("값"+document.getElementById("f_test1").dap1.value)
			}else{
				temp = temp + 1;
			}
		}
		document.getElementById("f_test1").submit();
	}
</script>
</head>
<body>
	<script>
		$("document").ready(function (){
			//돔 스캔이 완료되었을 때
			//체크박스 갯수만큼 반복해서 답안지가 같은 값을 찾고
			//값이 같으면 checked 속성을 1로 초기화 해줌.
			//다른 경우는 모두 0으로 초기화 함
			for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
					//alert("값"+document.getElementById("f_test1").cb[i].value)
					if(<%=dap1%>==document.getElementById("f_test1").cb[i].value){
						document.getElementById("f_test1").cb[i].checked=1;
					}else{
						document.getElementById("f_test1").cb[i].checked=0;
					}
			}
		});
	
	</script>
	<div class="easyui-panel" style="width:600px;height:500px;padding:20px"
		title="문제1" data-options="footer:'#footer'">
		<form id="f_test1" method="get" action="test2.jsp">
		<input type="hidden" id="dap1" name="dap1"/>
		DML구문 중에서 성격이 다른 하나를 고르시오.
		<div style="margin-bottom=20px"></div>
		<br>
		<input  type="checkbox" name="cb" value="1" onChange="answer(0)">
		1.INSERT
		<div style="margin-bottom=20px"></div>
		<br>
		<input  type="checkbox" name="cb" value="2" onChange="answer(1)">
		2.SELECT
		<div style="margin-bottom=20px"></div>
		<br>
	    <input type="checkbox" name="cb" value="3" onChange="answer(2)">
	    3.UPDATE
	    <div style="margin-bottom=20px"></div>
	    <br>
		<input type="checkbox" name="cb" value="4" onChange="answer(3)">
		4.DELETE
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