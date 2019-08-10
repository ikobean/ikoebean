<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.vo.MemberVO"%>
<%
	MemberVO rmVO = (MemberVO)session.getAttribute("rmVO");
	String s_memid = rmVO.getMem_id(); 
	out.print("s_memid:"+s_memid);
%>
<!DOCTYPE html>
<html>
<head>
<!-- js는 ''이나 ""이 있어야 변수 취급이 됨. -->
<!-- 
	jquery api를 활용한 쿠키 활용
	쿠키 만들기
	$.cookie('name','value');
	$.cookie('name','value',{expires:1});
	$.cookie('name','value',{expires:1},path:'/');
	
	쿠키 읽기
	$.cookie('name');
	
	쿠키삭제
	$.removeCookie('name');
 -->
<meta charset="UTF-8">
<title>시험 응시</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
<script>
	function examStart(){
		///////////////////////////승인 처리 ajax////////////////////////////
		var uexam_no=$('#tb_examno').val();
		$.ajax({
			 method:'get'
			,url:'test.nb?crud=isOk&mem_id=<%=s_memid%>&exam_no='+uexam_no
					//+"&"+new Date().getTime()
			,success:function(data){ //data -> '승인' or '확인불가'
				//alert("data"+data);
				if(data=='승인'){//승인
					$.cookie("c_examno",uexam_no);
					/////////  문제지 배포 ajax ////////////////////////
					//문제지 정보를 가져온다.
					//그런데 페이지는 이미 서버에서 클라이언트로 다운로드가 된 상태이므로 새로운 요청을 하면 페이지가 변경되는
					//상황이다.
					//현재 페이지는 그대로 유지되면서 시험 시작 버튼을 클릭했을 때 내용정보만 가져와서 기존 페이지에
					//끼워넣고 싶다면 ajax를 사용할 것.
					$.ajax({
					    method:'get'
			 	   		,url:"test.nb?crud=swDesignExam&sub_cd="+g_subcd
				 	   //,dataType:'json'
				 	   ,success:function(data){
				 		   //alert(data);
				 		   var jsonDoc = JSON.parse(data);//자바스크립트 객체 배열
				 		   if(jsonDoc.length>0){
				 		   		var v_test1="";   
				 		   		var v_test2="";   
				 		   		var v_test3="";   
				 		   		var v_test4="";   
				 		   		//다음문제 이동시 선택한 답안정보를 꺼내서 쿠키에 저장 처리
				 		   		//checkbox가 4개씩 들어있으므로 브라우저는 이것을 배열로 처리
				 		   		//전체 보기가 16개이므로 16개 전체 배열을 사용하지 않고 4개씩 배열처리하기 위해서 
				 		   		v_test1+="<form id='f_test1'>";
				 		   		v_test1+=jsonDoc[0].d_no+","+jsonDoc[0].question+"<br><br>";
				 		   		v_test1+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,1)'>"+jsonDoc[0].answer1+"<br><br>";
				 		   		v_test1+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,1)'>"+jsonDoc[0].answer2+"<br><br>";
				 		   		v_test1+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,1)'>"+jsonDoc[0].answer3+"<br><br>";
				 		   		v_test1+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,1)'>"+jsonDoc[0].answer4+"<br><br>";
				 		   		v_test1+="</form>"
				 		   		$("#d_test1").html(v_test1);
				 		   		
				 		   		v_test2+="<form id='f_test2'>";
				 		   		v_test2+=jsonDoc[1].d_no+","+jsonDoc[1].question+"<br><br>";
				 		   		v_test2+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,2)'>"+jsonDoc[1].answer1+"<br><br>";
				 		   		v_test2+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,2)'>"+jsonDoc[1].answer2+"<br><br>";
				 		   		v_test2+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,2)'>"+jsonDoc[1].answer3+"<br><br>";
				 		   		v_test2+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,2)'>"+jsonDoc[1].answer4+"<br><br>";
				 		   		v_test2+="</form>"
				 		   		$("#d_test2").html(v_test2);
				 		   		
				 		   		v_test3+="<form id='f_test3'>";
				 		   		v_test3+=jsonDoc[2].d_no+","+jsonDoc[2].question+"<br><br>";                                   
				 		   		v_test3+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,3)'>"+jsonDoc[2].answer1+"<br><br>";
				 		   		v_test3+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,3)'>"+jsonDoc[2].answer2+"<br><br>";
				 		   		v_test3+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,3)'>"+jsonDoc[2].answer3+"<br><br>";
				 		   		v_test3+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,3)'>"+jsonDoc[2].answer4+"<br><br>";
				 		   		v_test3+="</form>"
				 		   		$("#d_test3").html(v_test3);
				 		   		
				 		   		v_test4+="<form id='f_test4'>";
				 		   		v_test4+=jsonDoc[3].d_no+","+jsonDoc[3].question+"<br><br>";
				 		   		v_test4+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='1' onChange='answer(0,4)'>"+jsonDoc[3].answer1+"<br><br>";
				 		   		v_test4+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='2' onChange='answer(1,4)'>"+jsonDoc[3].answer2+"<br><br>";
				 		   		v_test4+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='3' onChange='answer(2,4)'>"+jsonDoc[3].answer3+"<br><br>";
				 		   		v_test4+="&nbsp;&nbsp;<input type='checkbox' name='cb' value='4' onChange='answer(3,4)'>"+jsonDoc[3].answer4+"<br><br>";
				 		   		v_test4+="</form>"
				 		   		$("#d_test4").html(v_test4);
				 		   }///////////////////////////////////////end of if
				 	 }/////////////////////////////////////////////end of sccess
				 }); //////////////////////////////////////////////end of ajax
			$('#dlg_test1').dialog("open");
					/////////  문제지 배포 ajax ////////////////////////
				}/////////////end of outter if
				else{ //확인 불가
					//alert("data"+data);
					$('#d_isOk').html("<font color='red'> 수험번호를 확인하세요.</font>");
					return; //함수 탈출 for문의 break
				}
			}////////////end of success function 
		});//end of outter ajax
	
		
		};///////////////////////////////////////////////////end of function start


	//멀티선택을 배제하기 위한 함수 선언
	
	function answer(p_dap,num){ //p_dap 은 변수이고 1,2,3,4 
		//alert("fname:" +fname); //f_test1
		//브라우저가 돔 구성시 같은 이름이면 자동으로 배열로 변환해 줌.
		for(var i=0;i<document.getElementById("f_test"+num).cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test"+num).cb[i].checked=1;
				//alert("선택한값:"+document.getElementById("f_test"+num).cb[i].value);
				//1이면 체크가 되어있는 것. 0이면 체크가 안되어 있는 것
				$.cookie('c_test'+num, document.getElementById("f_test"+num).cb[i].value);
			}else{//체크가 안되어 있는 애들 
				document.getElementById("f_test"+num).cb[i].checked=0;
			}
		}
		
	}
	function prev(p_test){
		var dap;
		if(p_test=='dlg_test2'){
			$("#dlg_test2").dialog('close');
			$("#dlg_test1").dialog('open');
		}
		else if(p_test=='dlg_test3'){
			$("#dlg_test3").dialog('close');
			$("#dlg_test2").dialog('open');
		}
		else if(p_test=='dlg_test4'){
			$("#dlg_test4").dialog('close');
			$("#dlg_test3").dialog('open');
		}
		else if(p_test=='dlg_test4'){
			$("#dlg_test4").dialog('close');
			$("#dlg_test3").dialog('open');
		}
	}
	function next(p_test){
		var dap; //사용자가 선택한 답을 담기
		if(p_test=='dlg_test1'){
			//선택한 답안지의 값을 담는 변수 temp
			var temp=1; //체크박스가 넘어갈 때 마다 1씩 증가하기
			for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
				if(document.getElementById("f_test1").cb[i].checked==1){ //체크가 되어있으면 
					dap=temp;
				}else{
					temp = temp + 1;
				}
			}
			$.cookie('c_test1',dap);
			$("#dlg_test1").dialog('close');
			$("#dlg_test2").dialog('open');
		}
		else if(p_test=='dlg_test2'){
			//alert($.cookie('c_test1',dap));
			//선택한 답안지의 값을 담는 변수 temp
			var temp=1; //체크박스가 넘어갈 때 마다 1씩 증가하기
			for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
				if(document.getElementById("f_test2").cb[i].checked==1){ //체크가 되어있으면 
					dap=temp;
				}else{
					temp = temp + 1;
				}
			}
			$.cookie('c_test2',dap);
			$("#dlg_test2").dialog('close');
			$("#dlg_test3").dialog('open');
		}
		else if(p_test=='dlg_test3'){
			//alert($.cookie('c_test2',dap));
			//선택한 답안지의 값을 담는 변수 temp
			var temp=1; //체크박스가 넘어갈 때 마다 1씩 증가하기
			for(var i=0;i<document.getElementById("f_test3").cb.length;i++){
				if(document.getElementById("f_test3").cb[i].checked==1){ //체크가 되어있으면 
					dap=temp;
				}else{
					temp = temp + 1;
				}
			}
			$.cookie('c_test3',dap);
			$("#dlg_test3").dialog('close');
			$("#dlg_test4").dialog('open'); 
		}
		else if(p_test=='dlg_test4'){
			//선택한 답안지의 값을 담는 변수 temp
			var temp=1; //체크박스가 넘어갈 때 마다 1씩 증가하기
			for(var i=0;i<document.getElementById("f_test4").cb.length;i++){
				if(document.getElementById("f_test4").cb[i].checked==1){ //체크가 되어있으면 
					dap=temp;
				}else{
					temp = temp + 1;
				}
			}
			$.cookie('c_test4',dap);
			$("#dlg_test4").dialog('close');
			//다이얼로그 창을 새로운 페이지로 이관 (examResult.jsp)
			//$("#dlg_confirm").dialog('open');
			cmm_window_popup('examResult.jsp','640','400','examResult');
		}
	}

</script>

</head>
<body>
<script type="text/javascript"> 
	var g_subcd; //전역변수로 선언
	   	//DOM구성이 완료되었을 때 콤보박스를 초기화 할 것.
	   	//이 문서 전체를 가리키는 내장객체.
	   	$(document).ready(function(){
	   		//콤보 초기화
	   		$('#cb_subject').combobox({
	   		  url:"/onlineTestVer2/test.nb?crud=subjectList"
	   		  ,valueField:'SUB_CD'
	   		  ,textField:'SUB_NAME'
	   		  ,panelHeight:'auto'
	   		  ,onSelect:function(record){
	   			  alert(record.SUB_CD);
	   			  g_subcd = record.SUB_CD;
	   		  }
	   		});
	   	});
</script>
 <!-- 
 ===========================================================================================
 							시험과목 선택하고 수험번호 입력 창 만들기 시작
 ===========================================================================================
  -->

 <div class="easyui-panel" id="pl_takeatest" title="Take a Test" style="width:70%;max-width:400px;padding:30px 30px" >
	<div style="margin-bottom:20px">
		<select class="easyui-combobox" id="cb_subject" name="cb_subject" label="수험 과목 선택: " labelPosition="top" style="width:70%;"
		data-options="prompt:'수험 과목을 선택하세요.'">
		</select>
	</div>
	<div style="margin-bottom:30px">
		<input class="easyui-textbox" id="tb_examno" name="tb_examno" label="수험번호" labelPosition="top" style="width:50%;">
		<div id=d_isOk>
		</div>
	</div>
	<div>
		<a id="btn_start" href="javascript:examStart()" class="easyui-linkbutton" iconCls="icon-ok" style="width:70%;" >시험 시작 </a>
	</div>
	<div style="margin-bottom:20px"></div>
</div>

	
   <!-- 
 ===========================================================================================
 						 	시험과목 선택하고 수험번호 입력 창 만들기 시작
 ===========================================================================================
  -->


   <!-- 
 ===========================================================================================
 								시험문제 다이얼로그 시작
 ===========================================================================================
  -->


	<div id="dlg_test1" class="easyui-dialog" style="width:700px; height:300px" data-options="title:'문제1', closed:'false',buttons:'#btn_test1',modal:true">
		<div id="d_test1"> </div>
	</div>
	<div id="btn_test1">
		<a href="javascript:next('dlg_test1')" class="easyui-linkbutton" data-options="iconCls:'icon-next'">다음문제</a>
	</div>
	
	<!-- 시험문제2 -->
	<div id="dlg_test2" class="easyui-dialog" style="width:700px; height:300px" data-options="title:'문제2', closed:'true',buttons:'#btn_test2',modal:true">
		<div id="d_test2"> </div>
	</div>
	<div id="btn_test2">
		<a href="javascript:prev('dlg_test2')" class="easyui-linkbutton" data-options="iconCls:'icon-before'">이전문제</a>
		<a href="javascript:next('dlg_test2')" class="easyui-linkbutton" data-options="iconCls:'icon-next'">다음문제</a>
	</div>
	
	<!-- 시험문제3 -->
	<div id="dlg_test3" class="easyui-dialog" style="width:700px; height:300px" data-options="title:'문제3', closed:'true',buttons:'#btn_test3',modal:true">
		<div id="d_test3"> </div>
	</div>
	<div id="btn_test3">
		<a href="javascript:prev('dlg_test3')" class="easyui-linkbutton" data-options="iconCls:'icon-before'">이전문제</a>
		<a href="javascript:next('dlg_test3')" class="easyui-linkbutton" data-options="iconCls:'icon-next'">다음문제</a>
	</div>
	
	<!-- 시험문제4 -->
	<div id="dlg_test4" class="easyui-dialog" style="width:700px; height:300px" data-options="title:'문제4', closed:'true',buttons:'#btn_test4',modal:true">
		<div id="d_test4"></div>
	</div>
	<div id="btn_test4">
		<a href="javascript:prev('dlg_test4')" class="easyui-linkbutton" data-options="iconCls:'icon-before'">이전문제</a>
		<a href="javascript:next('dlg_test4')" class="easyui-linkbutton" data-options="iconCls:'icon-next'">끝</a>
	</div>
	
	<!-- 답안지 확인 -->
	<!-- 쿠키값 확인을 위해 examResult.jsp페이지로 이관함. -->
</body>
</html>

