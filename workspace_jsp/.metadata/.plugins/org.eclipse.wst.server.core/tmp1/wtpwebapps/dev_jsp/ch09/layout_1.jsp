<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String c_name=null;
	Cookie cookies[] = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			out.print("쿠키정보: "+cookies[i].getValue());
			if(cookies[i].getName().equals("c_name")){
				c_name=cookies[i].getValue();
			out.print("c_name"+c_name);
			}
	}
	if(c_name==null){
		response.sendRedirect("a.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Add and Remove Layout - jQuery EasyUI Demo</title>
   <!-- easyui.css는 jeasyui가 제공하는 콤포넌트(예:datagrid, layout 등)에 디자인을 입힐 때 사용됨 -->
   <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
   <!--  icon.css는 아이콘 이미지 처리하는데 사용됨 -->
   <link rel="stylesheet" type="text/css" href="../themes/icon.css">
   <!--  jeasyui 데모페이지에 사용되는 css임 -->
   <link rel="stylesheet" type="text/css" href="../demo/demo.css">
   <!-- jeasyui가 jquery 기반이므로 호환성을 검증한 스크립트 코드만 따로 모아둠 -->
   <script type="text/javascript" src="../js/jquery.min.js"></script>
   <!-- 
   jeasyui가 jquery 기반이므로 아래 파일을 import하기 전에 반드시 jquery.min.js가
   import 되어있어야 함. 순서 반드시 지킬 것!   
    -->
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
    <script type="text/javascript">
 	//입력 다이얼로그 창 열기
 	
 	/**************************************************************
 	*입력화면에서 저장버튼 클릭했을 때 
 	* 사용자가 입력한 정보를 서버로 (Tomcat) 전송해야함.
 	* get 인터셉트를 한다. 누가 (브라우저)->서버로 요청이 전송되지 않음.
 	* 한 번 요청된 페이지는 각 사용자 pc에 그 내용이 다운로드
 	* 두 번째 같은 페이지를 요청하면 서버에 전달한 다음 응답을 받아오는 것이 아니라
 	* xxx.html?1 주소창에 다른 글자를 한자로 붙이면 새로운 요청으로 인식
 	* xxx.html?mem_id=test&mem_pw=123 (보안상 취약함)
 	* 브라우저마다(탭마다도 해당)
 	* 브라우저가 열릴 때 마다 네이버 서버측에서 너에게 세션아이디
 	* 사용자 컴퓨터에 있는 정보가 그대로 다시 출력된다.
 	* 클라이언트 측에 다운로드(html, css,js)
 	* <form>태그 ->method ->get(default-인터셉트)|post,action->
 	*****************************************************************/
		    function myformatter(date){
		        var y = date.getFullYear();
		        var m = date.getMonth()+1;
		        var d = date.getDate();
		        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		    }
		    function myparser(s){
		        if (!s) return new Date();
		        var ss = (s.split('-'));
		        var y = parseInt(ss[0],10);
		        var m = parseInt(ss[1],10);
		        var d = parseInt(ss[2],10);
		        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		            return new Date(y,m-1,d);
		        } else {
		            return new Date();
		            }
		        }
		  
		
		 	function add(){
		 		//alert("하이");
		 		$("#f_add").submit();//전송. 어디로 가는거지? ->아까 액션에 있던 이름을 말해주면 돼! 전송방식? get
		 	}
		 	
		 	function cancel(){
		 		$('#dlg_add').dialog('close');
		 	}
		 	
		 	//입력 다이얼로그창 열기
		 	function addForm(){
		 		$('#dlg_add').dialog('open');
		 	}
		 	
		 	//수정 다이얼로그 열기
		 	function updForm(){
		 		var row = $("#dg_member").datagrid("getSelected");
		 		//datagridid 초기화시 소문자로 작성하였으므로 반드시 소문자로 접근해야함.
		 		//만일 대문자로 작성하면 undefine
		 		var c_id = row.id;
		 		//alert(c_id;)
		 		//톰캣 서버로 이 아이디와 같은 상세정보를 조회하면 화면에 출력
		 		location.href="./memberUpdateForm.jsp?id="+c_id;
		 	}
		 	
		    //이름으로 검색하기
		    function nameSearch(){
		    	alert("nameSearch호출 성공");
		    }
		    //로그인 요청시 호출
		    function loginAction(){
		    	//front-end언어는 오라클 서버와 연동할 수 없다. 상수처리한다.
		    	var db_name = "내복";
				var db_id = "test";
				var db_pw = "123";
				var u_id = $("#r_id").val();
				var u_pw = $("#r_pw").val();
				if(db_id==u_id){//아이디가 존재하니?
					if(db_pw==u_pw){//비번까지 같은거야"
						//로그인 폼 숨기고 대신 로그인 성공화면 show
						$("#r_login").hide();
						$("#r_logout").show();
						//span태그에 메시지를 추가  - 김유신님 환영합니다.
						$("#s_msg").html("<b>"+db_name+"</b>님 환영합니다.")
						}else{//비번이 틀린 거 같아
							alert("비번이 틀렸습니다.");
							$("#r_pw").textbox('setValue','');
						}
						}else{//아이디가 존재하지 않아
						alert("아이디가 없습니다.");
						}
		    }
		    //로그아웃 요청시 구현
		   	function logoutAction(){
		   	 	$("#r_logout").hide();
		   	 	$("#r_login").show();
		   	 	$("#r_id").textbox('setValue','');//속성,벨류
		   	 	$("#r_pw").textbox('setValue','');//속성,벨류
		   	 	}
    	</script>
	</head>
<body>
<!--  
	/*****************************************************************
 		
 		밑에 위에 갖다 쓴거는 함수를 써서 그 때만 바꿔준거~
 		
 		날짜 포맷 형식을 디폴트에서 사용자 정의로 변경하므로
 		body태그 안에 해당 콤포넌트가 정의되기 전에 처리함.
 		
 		databox에 대한 날짜 포맷 재정의함
	 	
		
 	******************************************************************/ -->

	<style>
		#r_login {<!--
			border: 1px solid green; -->
			width: 180px;
			height: 110px;
		}
	</style>
	<script type="text/javascript">
		$.fn.datebox.defaults.formatter = function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10 ? "0"+m:m)+'-'+(d<10 ? "0"+d:d);
			}
		
		$.fn.datebox.defaults.parser = function(s){
			var t = Date.parse(s);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
		}
        $(document).ready(function(){
            /*회원 관리에 필요한 데이터 그리드 추가 - 설정*/
            $("#dg_member").datagrid({
         	   singleSelect:'true'
                ,toolbar:"#rbar_member"
         	   ,columns:[[
         		    {field:'id' ,title:'아이디', width:100} /* 아이디 */
         		   ,{field:'name',title:'이름', width:120} /* 이름    */
         		   ,{field:'address',title:'주소', width:300} /* 주소   */
         		   ,{field:'hp',title:'hp', width:140} /* hp  */   	   
         	   ]]           	   
            });///////////////////end of dg_member
            /*사원 관리에 필요한 데이터 그리드 추가 - 설정*/
        $("#dg_emp").datagrid({
            url:'jsonEmp.json'
           ,columns:[[
         		{field:'empno',title:'사원번호', width:100} 
         		,{field:'ename',title:'사원명', width:120, edtior:'text'} 
         		,{field:'hiredate',title:'입사일자', width:300} 
         		,{field:'deptno',title:'부서번호', width:140,
         			formatter:function(value,row){
         				return row.deptno||value;
         		}}
         		  
         		
         	]]
               ,editor:{
            	   type:'combobox'
            	  ,option:{
            		  valueField:'deptno'
            		 ,textField:'dname'
            	  }
               }
         	   ,url:'./jsonEmp.json'
         	   ,singleSelect:'true'
               ,toolbar:"#rbar_emp"
              
            });///////////////////end of dg_emp
        	
        	
        	//세개 페이지 (회원관리,대여관리,상품관리) 숨김 처리하기 시작
        			$("#r_member").hide();
            		$("#r_rental").hide();
            		$("#r_prod").hide();
            		$("#r_emp").hide();
            		  //로그인 성공했을 때 화면을 숨기자
                    $("#r_logout").hide();
           //easyui에서 제공하는 tree객체에 onClick 이벤트 처리하기 시작
            $('#te_menu').tree({ //따로 함수 선언하지 않고 즉시 처리
            	//파라미터로 넘어오는 node는 사용자가 선택한 엘리먼트 정보 가짐
			onClick: function(node){ //트리메뉴 선택헀을 때 이벤트 처리
			//alert(node.text);  // alert node text property when clicked
			//node.text하면 선택한 노드문자열 가져옴.
            if("회원관리"==node.text){//너 회원관리 누른거야?
            		//show메소드 호출하면 화면에 출력되고
            		//hide메소드 호출하면 화면에 숨김 처리됨.
            		$("#r_member").show();
            		$("#r_rental").hide();
            		$("#r_prod").hide();
            		$("#r_emp").hide();
            }
            else if("대여관리"==node.text){
         			$("#r_member").hide();
        			$("#r_rental").show();
        			$("#r_prod").hide();
        			$("#r_emp").hide();
            	
            }
            else if("상품관리"==node.text){
         			$("#r_member").hide();
        			$("#r_rental").hide();
        			$("#r_prod").show();
        			$("#r_emp").hide();
              }
            else if("사원관리"==node.text){
         			$("#r_member").hide();
        			$("#r_rental").hide();
        			$("#r_prod").hide();
            		$("#r_emp").show();
              }
	       }
       });////////////end of tree
   
  });///////////////////////end of ready function(돔 구성 완료됐을 때 실행)
    </script>

	<div id="cc" class="easyui-layout" style="width: 1000px; height: 550px">
		<div data-options="region:'west',split:true" title="HIFIVE"
			style="width: 250px;">
			<div style="margin: 20px 0;"></div>
			<!--====================로그인 화면 처리 시작================== -->
			<div id="r_login" align="center">

				<input id="r_id" name="mem_id">
				<div style="margin: 5px 0;"></div>

				<input id="r_pw" name="mem_pw">
				<div style="margin: 5px 0;"></div>
				
				<a href="javascript:loginAction()" class="easyui-linkbutton">로그인</a>
				<a href="javascript:loginAction()" class="easyui-linkbutton">회원가입</a>
						 <!-- 네이버아이디로로그인 버튼 노출 영역 -->
				<!-- <div id="naver_id_login"></div> -->
				<script type="text/javascript">
				  	<!--네이버로 로그인 성공했을 때 이동할 페이지================보기 싫어서 죽여놓음===============-->
		/* 		  	var naver_id_login = new naver_id_login("JGAjK7E5iTq5emPmn6y0", "http://localhost:8000/dev_html/ajax/index_ajax.html");
				  	var state = naver_id_login.getUniqState();
				  	naver_id_login.setButton("green", 2,40);
				  	naver_id_login.setDomain("http://localhost:8000/dev_html/easyUI_layout/layout_1.html");
				  	naver_id_login.setState(state);
				  	naver_id_login.setPopup();
				  	naver_id_login.init_naver_id_login(); */
			 	</script> 
				<script type="text/javascript">
				          $('#r_id').textbox({
				    //buttonText:'ID',
				    iconCls:'icon-man',
				    iconAlign:'right',
				    prompt:'아이디'
		})    
			          $('#r_pw').textbox({
				    //buttonText:'Password',
				    iconCls:'icon-lock',
				    iconAlign:'right',
				    prompt:'비밀번호'
		})
   </script>
			</div>

			<!--============================== 로그인 화면 처리 끝 ============================== -->
			<!--=========================== 로그아웃 화면 처리 시작 ============================== -->
			<div id="r_logout" align="center">
				<span id="s_msg"></span>
				<div style="margin: 5px 0;"></div>
				<a href="javascript:logoutAction()" class="easyui-linkbutton">로그아웃</a>
				<a href="javascript:memberUpdate()" class="easyui-linkbutton">정보수정</a>
			</div>

			<!--=========================== 로그아웃 화면 처리 끝 ================================ -->
			<!--============================== 메뉴 트리 시작 ================================== -->
			<!--  <div style="margin:20px 0; margin-left: 15px"> -->
			<ul id="te_menu" class="easyui-tree">
				<li data-options="state:'closed'"><span>회원관리</span>
					<ul>
						<li><span>회원등록</span></li>
						<li><span>회원수정</span></li>
						<li><span>회원삭제</span></li>
					</ul></li>

				<li data-options="state:'closed'"><span>대여관리</span>
					<ul>
						<li>대여목록</li>
						<li>대여등록</li>
						<li>대여수정</li>
						<li>대여삭제</li>
					</ul></li>
				<li data-options="state:'closed'"><span>상품관리</span>
					<ul>
						<li>상품목록</li>
						<li>상품등록</li>
						<li>상품수정</li>
						<li>상품삭제</li>

					</ul></li>
				<li data-options="state:'closed'"><span>사원관리</span>
					<ul>
						<li>사원목록</li>
						<li>사원등록</li>
						<li>사원수정</li>
						<li>사원삭제</li>

					</ul></li>
			</ul>
			<!--============================== 메뉴 트리 끝 ============================== -->

		</div>
		<div data-options="region:'center',title:'Rental 관리 시스템'">
			<!--회원관리-->
			<div style="margin: 5px 0;"></div>
			<div id="r_member">Home - 회원관리
			<div style="margin: 5px 0;"></div>

<!-- 
===============================================================================
								회원 관리 페이지 구현 
==============================================================================
 -->
				<!--data-options="title:'회원목록'"-->

				<table id="dg_member"
					data-options="url:'./jsonMember.json',title:'회원목록'" width="700px"
					height="450px" class="easyui-datagrid"></table>



				<!--============================== 회원 관리 화면에 필요한 툴바 시작 ============================== -->
				<div id="rbar_member">
					<table align='left' width="750px">
						<!-- 조건 검색 추가 -->
						<tr>
							<td>
								<div style="margin: 5px 0;"></div>
								<div style="margin-bottom: 10px">
									<label> &nbsp 이름 :</label> <input class="easyui-searchbox"
										data-options="prompt:'Enter your name please!' , searcher:nameSearch"
										style="width: 140px;"> <label> &nbsp H.P :</label> <input
										class="easyui-maskedbox" mask="999-9999-9999"
										style="width: 140px"> <label> &nbsp 생년월일 :</label> <input
										class="easyui-datebox" style="width: 140px">
									<div style="margin: 5px 0;"></div>
								</div>
							</td>
						</tr>
						<!-- 툴바 버튼 추가 -->
						<tr>
							<td>
								<div id="ft" style="padding: 2px 5px;">
									<a href="#" class="easyui-linkbutton" iconCls="icon-search"
										plain="true">조회</a> <a href="javascript:addForm()"
										class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
									<a href="javascript:updForm()" class="easyui-linkbutton"
										iconCls="icon-edit" plain="true">수정</a> <a href="#"
										class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>

								</div>

							</td>
						</tr>

					</table>
				</div>


				<!--============================== 회원 관리 화면에 필요한 툴바 끝! ============================== -->
				<!-- ============================= 회원 정보 등록 화면 시작 ===================================== -->
				<!-- 
		easyUI에서 제공하는 API활용시 주요속성
		id를 통해서 자바스크립트로 이벤트 처리하거나 옵션 추가 등 기능처리가 이루어짐
		해당 콤포넌트에 대한 상세 속성들은 data-options 에 추가하면 됨
		자바스크립트에서도 속성을 추가하거나 변경할 수 있음. - 방법확인 해 줄 것
		태그 안에서 속성 추가시 더블 쿼테이션으로 묶어주고 속성과 값은 따로 분리하되
		기호는 : 콜론을 사용함.
		태그마다 스타일 속성을 따로 처리할 때는 style 속성에 값 자리에 속성과 값을 주면 됨.
		제공되는 콤퍼넌트들은 모두 자바스크립트 코드로도 화면 처리 가능함.
		3가지 방법에 대해서는 별도로 혼자서 반드시 해볼것.
		외부에 CSS 사용보다는 각 태그 내에 있는 style 속성이 우선하여 적용됨.
  -->
				<div id="dlg_add"
					data-options="footer:'#rbar_add', closed:true,cache:false, modal:true "
					class="easyui-dialog" title="회원등록"
					style="width: 600px; height: 550px; padding: 10px">
					<form id="f_add" method="get" action="memberAdd.jsp">
						<table border='1'>
							<tr>
								<td>아이디</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your id'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your name'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your address'"
									style="width: 440px;"></td>
							</tr>
							<tr>
								<td>번호</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your hp'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your gender'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>생일</td>
								<td><input class="easyui-datebox"
									data-options="prompt:'Enter your birthday',formatter:myformatter,parser:myparser"
									style="width: 440px;"></td>
							</tr>
							<tr>
								<td>코멘트</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your comments'" multiline="true"
									style="width: 440px; height: 50px;"></td>
							</tr>
						</table>
					</form>
				</div>
				<div id="rbar_add">
					<a href="javascript:add()" class="easyui-linkbutton"
						iconCls="icon-ok" plain="true">저장</a> <a
						href="javascript:cancel()" class="easyui-linkbutton"
						iconCls="icon-cancel" plain="true">취소</a>
				</div>


				<!-- ============================= 회원 정보 등록 화면 끝! ===================================== -->


				<!-- ============================= 회원 정보 수정 화면 시작 ===================================== -->

				<!-- ============================= 회원 정보 수정 화면 끝! ===================================== -->


				<!-- ============================= 회원 정보 삭제 화면 시작 ===================================== -->

				<!-- ============================= 회원 정보 삭제 화면 끝! ===================================== -->

				<!-- 
				===============================================================================
								사원 관리 페이지 구현 
				===============================================================================
				 -->
			</div>
			<!-- 사원관리 -->
			<div style="margin: 5px 0;"></div>
			<div id="r_emp">
				사원관리
			<div style="margin: 5px 0;"></div>

				<!-- 
				===============================================================================
												사원 관리 페이지 구현 
				==============================================================================

				-->
				<!--data-options="title:'사원목록'"-->

				<table id="dg_emp" data-options="title:'사원목록'" width="700px"
					height="450px" class="easyui-datagrid">
					
				</table>
				<!--============================== 사원 관리 화면에 필요한 툴바 시작 ============================== -->
				<div id="rbar_emp">
					<table align='left' width="750px">
						<!-- 조건 검색 추가 -->
						<tr>
							<td>
								<div style="margin: 5px 0;"></div>
								<div style="margin-bottom: 10px">
									<label> &nbsp 이름 :</label> <input class="easyui-searchbox"
										data-options="prompt:'Enter your name please!' , searcher:nameSearch"
										style="width: 140px;"> <label> &nbsp H.P :</label> <input
										class="easyui-maskedbox" mask="999-9999-9999"
										style="width: 140px"> <label> &nbsp 생년월일 :</label> <input
										class="easyui-datebox" style="width: 140px">
									<div style="margin: 5px 0;"></div>
								</div>
							</td>
						</tr>
						<!-- 툴바 버튼 추가 -->
						<tr>
							<td>
								<div id="ft" style="padding: 2px 5px;">
									<a href="#" class="easyui-linkbutton" iconCls="icon-search"
										plain="true">조회</a> <a href="javascript:addForm()"
										class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
									<a href="javascript:updForm()" class="easyui-linkbutton"
										iconCls="icon-edit" plain="true">수정</a> <a href="#"
										class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>

								</div>

							</td>
						</tr>

					</table>
				</div>


				<!--============================== 사원 관리 화면에 필요한 툴바 끝! ============================== -->
				<!-- ============================= 사원 정보 등록 화면 시작 ===================================== -->
				<!-- 
		easyUI에서 제공하는 API활용시 주요속성
		id를 통해서 자바스크립트로 이벤트 처리하거나 옵션 추가 등 기능처리가 이루어짐
		해당 콤포넌트에 대한 상세 속성들은 data-options 에 추가하면 됨
		자바스크립트에서도 속성을 추가하거나 변경할 수 있음. - 방법확인 해 줄 것
		태그 안에서 속성 추가시 더블 쿼테이션으로 묶어주고 속성과 값은 따로 분리하되
		기호는 : 콜론을 사용함.
		태그마다 스타일 속성을 따로 처리할 때는 style 속성에 값 자리에 속성과 값을 주면 됨.
		제공되는 콤퍼넌트들은 모두 자바스크립트 코드로도 화면 처리 가능함.
		3가지 방법에 대해서는 별도로 혼자서 반드시 해볼것.
		외부에 CSS 사용보다는 각 태그 내에 있는 style 속성이 우선하여 적용됨.
  -->
				<div id="dlg_add"
					data-options="footer:'#rbar_add', closed:true, cache:false, modal:true "
					class="easyui-dialog" title="회원등록"
					style="width: 600px; height: 550px; padding: 10px">
					<form id="f_add" method="get" action="memberAdd.jsp">
						<table border='1'>
							<tr>
								<td>아이디</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your id'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your name'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your address'"
									style="width: 440px;"></td>
							</tr>
							<tr>
								<td>번호</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your hp'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your gender'" style="width: 440px;">
								</td>
							</tr>
							<tr>
								<td>생일</td>
								<td><input class="easyui-datebox"
									data-options="prompt:'Enter your birthday',formatter:myformatter,parser:myparser"
									style="width: 440px;"></td>
							</tr>
							<tr>
								<td>코멘트</td>
								<td><input class="easyui-textbox"
									data-options="prompt:'Enter your comments'" multiline="true"
									style="width: 440px; height: 50px;"></td>
							</tr>
						</table>
					</form>
				</div>
				<div id="rbar_add">
					<a href="javascript:add()" class="easyui-linkbutton"
						iconCls="icon-ok" plain="true">저장</a> <a
						href="javascript:cancel()" class="easyui-linkbutton"
						iconCls="icon-cancel" plain="true">취소</a>
				</div>


				<!-- ============================= 회원 정보 등록 화면 끝! ===================================== -->


				<!-- ============================= 회원 정보 수정 화면 시작 ===================================== -->

				<!-- ============================= 회원 정보 수정 화면 끝! ===================================== -->


				<!-- ============================= 회원 정보 삭제 화면 시작 ===================================== -->

				<!-- ============================= 회원 정보 삭제 화면 끝! ===================================== -->

				<!-- 
	===============================================================================
									회원 관리 페이지 구현 
	===============================================================================
	-->

				</div>









			<!--대여관리-->
			<div id="r_rental">대여관리</div>

			<!--상품관리-->
			<div id="r_prod">상품관리</div>
		</div>
	</div>
</body>
</html>
