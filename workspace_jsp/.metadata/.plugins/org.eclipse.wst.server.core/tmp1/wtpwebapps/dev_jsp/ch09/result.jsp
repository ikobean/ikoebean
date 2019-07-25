<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");    
	String dap2 = request.getParameter("dap2");    
	String dap3 = request.getParameter("dap3");
	String jungdap[] = {"2","3","3"};
	String daps[]={dap1,dap2,dap3};
	//out.print(dap1+", "+dap2+", "+dap3);
	//정답수 - rightNum
	int rightNum=0;
	//오답수 - wrongNum
	int wrongNum=0;
	for(int i=0; i<jungdap.length;i++){
		if(jungdap[i].equals(daps[i])){
			rightNum++;
		}else{
			wrongNum++;
		}
	}
%>
<!DOCTYPE html>
<html>
<%@ include file="../common/JEasyUICommon.jsp" %>
<head>
<meta charset="UTF-8">
<title>채점 결과</title>

</head>
<body> 
	<div class="easyui-panel" style="width:600px;height:500px;padding:20px"
		title="정답">
		정답수 : <%=rightNum%> <br>
		<div style="margin-bottom=20px"></div>
		오답수 : <%=wrongNum%> <br>
		<div style="margin-bottom=100px"></div>
		총점 <%=rightNum%>점
	</div>

</body>
</html>