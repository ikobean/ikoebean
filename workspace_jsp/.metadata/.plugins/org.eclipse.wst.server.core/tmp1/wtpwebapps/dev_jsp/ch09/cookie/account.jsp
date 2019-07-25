<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String daps[]= new String[3];
	//쿠키에 담긴 답안지 출력하기 p208 8번
	Cookie cookies[] = request.getCookies();
	if(cookies!=null&&cookies.length>0){
		for(int i=0; i<cookies.length;i++){
			if(cookies[i].getName().equals("dap1")){
				daps[0] =cookies[i].getValue();
			}
			if(cookies[i].getName().equals("dap2")){
				daps[1] =cookies[i].getValue();
			}
			if(cookies[i].getName().equals("dap3")){
				daps[2] =cookies[i].getValue();
			}
		}
	}
	//쿠키에 담긴 답안지 정보 출력하기
	for(String temp:daps){
		out.print("temp:"+temp);
		out.print("<br>");
	}
	String jungdap[] = {"2","3","3"};
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

<html>
<%@ include file="../../common/JEasyUICommon.jsp" %>
<head>
<meta charset="UTF-8">
<title>채점 결과</title>
</head>
<body> 
	<div class="easyui-panel" style="width:600px;height:500px;padding:20px" title="정답">
		정답수 : <%=rightNum%>
		<div style="margin-bottom=20px" ></div>
		오답수 : <%=wrongNum%>
		<div style="margin-bottom=100px" ></div>
		총점 <%=rightNum%>점
	</div>

</body>
</html>