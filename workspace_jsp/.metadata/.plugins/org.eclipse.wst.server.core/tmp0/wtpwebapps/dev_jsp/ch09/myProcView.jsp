<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 포맷 JS에서 사용하기</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			method:"get"
		   ,url:"myProcTest.jsp"
		   ,success:function(data){
			   //alert(data);
			   var jsonDoc=JSON.parse(data);//array로 자동 전환
			   $("#d_json").text(data);
			 /*   if(jsonDoc.length>0){
				   for(var i=0;i<jsonDoc.length;i++){
					   alert(jsonDoc[i].mem_name);
				   }
			   } */
		   }
		})
		
	});

</script>
<div id="d_json"></div>
</body>
</html>