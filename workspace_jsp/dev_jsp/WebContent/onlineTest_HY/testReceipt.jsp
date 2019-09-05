<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO" %>
<%
	MemberVO mVO = (MemberVO)session.getAttribute("rmVO");
	String s_memid = null;
	String s_memname = null;
	if(mVO!=null){
		s_memid = mVO.getMem_id();
		s_memname = mVO.getMem_name();
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function receipt(){
		$("#f_receipt").attr("method","GET");
		$("#f_receipt").attr("action","examReceipt.kos");
		$("#f_receipt").submit();
	}
</script>
<title>자격시험 접수 - 정보처리기사</title>
<%@ include file ="../common/JEasyUICommon.jsp" %>
</head>
<body>
	<script>
		$.fn.datebox.defaults.formatter = function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10 ?("0"+m):m)+'-'+(d<10 ?("0"+d):d);
		};
		
		$.fn.datebox.defaults.parser = function(s){
			var t = Date.parse(s);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
		};
	
		$(document).ready(function(){
			$("#mem_name").textbox('setValue','<%=s_memname%>');
	 		$('#cb_subject').combobox({
	      		  url:'/onlineTest/subjectList.kos?work=onlineTest',
	      		  valueField:'SUB_CD',  //서버에 넘어가는 값
	      		  textField:'SUB_NAME', //화면에 출력되는 값
	      		  paneHeight:'auto',
	      		  onSelect:function(record){
	      			  alert(record.SUB_NAME);
	      		  }
	 		});
	    });
			
		
	</script>
	 <div class="easyui-panel" 
	 	  id="pl_takeatest" 
	 	  title="자격시험 접수" 
	 	  style="width:70%;
	 	  max-width:600px
	 	  ;padding:30px 30px" >
	 	  
	 		<!-- jquery에서 제공하는 attr()메소드에 쿼리스트링은 값이 넘어가지 않음 : hidden 처리 -->
		<form id="f_receipt">	 
			<input type="hidden" id="mem_id" name="mem_id" value="<%=s_memid%>">
			<input type="hidden" id="work" name="work" value="onlineTest"> 
			<div style="margin-bottom:30px">
				<input class="easyui-textbox" 
					   id="mem_name" 
					   name="mem_name" 
					   label="이름" 
					   labelPosition="top" 
					   style="width:70%;">
			</div>
		 	  
			<div style="margin-bottom:30px">
				<input class="easyui-datebox" 
					   id="exam_date" 
					   name="exam_date" 
					   label="응시일자" 
					   labelPosition="top" 
					   style="width:70%;">
			</div>
			 	  
	
	
				<div style="margin-bottom:20px">
					<select class="easyui-combobox" 
							id="cb_subject" 
							name="sub_cd" 
							label="수험 과목 선택: " 
							labelPosition="top" 
							style="width:70%;"
							data-options="prompt:'수험 과목을 선택하세요.'">
					</select>
				</div>
				<div>
					<a id="btn_start" 
					   href="javascript:receipt()" 
					   class="easyui-linkbutton" 
					   iconCls="icon-ok" 
					   style="width:70%;">접수</a>
				</div>
				<div style="margin-bottom:20px"></div>
		</form>
		</div>

	
</body>
</html>