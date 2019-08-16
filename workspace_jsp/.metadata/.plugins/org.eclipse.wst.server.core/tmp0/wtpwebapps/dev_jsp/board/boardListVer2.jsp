<%@page import="com.util.PageBar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="com.util.PageBar" %>


<%
//총 레코드 개수
    int tot = 0;
	if(session.getAttribute("s_tot")!=null){
		tot = Integer.parseInt(session.getAttribute("s_tot").toString()) ;
	}
	out.print("total==> "+ tot);
	
	int size = 0;
	List<Map<String,Object>> boardList = 
			(List<Map<String,Object>>)request.getAttribute("boardList");
	if(boardList != null && boardList.size()>0){
		size= boardList.size();
	}
	
	////////// 페이지 네비게이션 추가분 ///////////
	int numPerPage = 2;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}

%>
    <!-- 
    	화면처리를 태그로 할 때와 스크립트로 할 때
    	1. 태그안에 코드를 작성하면 디자인과 코드가 분리가 안되어서 가독성이 떨어짐.
    	2. 스크립트로 처리할 때 화면에서 코드가 분리됨 (이벤트 처리나 dom 조작하는 코드작성시 접근성이 좋다.)
    	
     -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	//전역변수 선언 위치
	//목록 화면에서 사용자가 제목을 더블클릭 했을 때 셀에 대한 정보만 들어있으므로
	//선택한 로우에 숫자값을 가지고 숨어있는 필드 bm_no값을 가져와서 담는다.
	var g_no;
	var user_combo; 
	//콤보박스에서 선택한 값 담기
	var cb_value;
	//선택한 콤보에 대한 키워드
	var tb_value;
	/*
		각 로우별로 DB에서 새로 읽어들인 값이 출력이 되고 그 파일이름으로 다운로드 파일명을 찾아야 하므로
		이벤트가 발생할 때 마다 파일 이름은 달라지게 된다.
		자바코드로 읽어들인 정보를 자바스크립트 변수로 사용하는 것은 가능한 일이나 그 값은 상수처럼 정해진 값
		즉 정적인 성격을 가지고 있으므로 사용할 때 주의할 것.
		서버에서 바뀐 갑싱 화면에 즉시 반영될 수 없는 것은 서버페이지가 아닌 응답 페이지의 경우 이미 HTML 코드로
		변경된 페이지가 다운되고 출력되므로 절대로 유동적인 변화를 기대할 수 없다.
	*/
	function fileDown(fname){
		location.href="download.jsp?bs_file="+fname;
	}
	function addAction(){
		$('#f_boardAdd').attr("method","post");
		$('#f_boardAdd').attr("action","/board/test.nb?crud=boardAdd");
		$('#f_boardAdd').submit();
	}
	
	function boardDetail(p_bmno){
		//cmm_window_popup("test.nb?crud=boardDetail&bm_no="+p_bmno,"700","450","read");
		location.href="test.nb?crud=boardDetail&bm_no="+p_bmno;
	}
	/*
	 *학습목표
	 *나는 오라클 서버에서 조회된 결과를 담은 List<Map>을 화면 (datagrid)에 출력을 내보낼 수 있다.
	 화면 (dom구성)과 java코드가 만나는 부분에 대한 처리 방법에 대해 설명하고 코드에 적용할 수 있다.
	 화면은 html로 그리지만 조회된 결과를 html에 반영하기 위해 dom을 조작하는 방법에 대해 말할 수 있다.
	 그 둘 사이에서 json의 역할에 대해서 설명할 수 있다.
	 
	 결론
	 화면을 조작하는 여러가지 방법에 대한 경험을 가지고 다양한 ui솔루션이 제공하는 컴포넌트에
	 조회된 결과를 반영할 수 있도록 연습해두자.
	 각 device마다 혹은 시스템마다 서로 다른 ui 솔루션을 선택하고 사용할 수 있으므로
	 여러가지 경우의 수에 대해 미리 생각해 봄으로써 ui솔루션이 javascript기반이거나
	 xml기반 혹은 안드로이드에서 적용할 수 있도록 실습해 볼 것.
	 *
	 */
	function boardList(){//태그 조작(DOM조작)
		alert("boardList 호출성공");
		//alert(user_combo);
		//사용자가 선택한 콤보이름
		cb_value=user_combo;
		//선택한 콤보에 대한 키워드
		tb_value = $("#keyword").val();
		//alert(tb_value);
		location.href='test.nb?crud=boardList&cb_search='+cb_value
		 +'&keyword='+tb_value
 		 +'&pageNumber=1'
		 +'&pageSize=10' 
	 
		$("#dg_board").datagrid({
			 url:'test.nb?crud=boardList&cb_search='+cb_value
					 +'&keyword='+tb_value
			 		 +'&pageNumber=1'
					 +'&pageSize=10' 
			,singleSelect: 'true'
		/* 	,data:[
				 {bm_title:'테스트', bm_writer:"내복이", bm_hit:"35", bs_file:'avatar.png'}
				,{bm_title:'테스트2', bm_writer:"귀여워", bm_hit:"99", bs_file:'ikobean.png'}
			] */
			 ,onLoadSuccess:function(data){
				$("#pn_board").pagination({
					//total:data.total
					total:<%=tot%>
				});
			}
		});
	}//////////////////////////////// end of boardList
	 
	function pageMove(pageNumber, pageSize){
		//alert(pageNumber+","+pageSize);
		$("#dg_board").datagrid({
			url:"/board/test.nb?crud=boardList&pageNumber="+pageNumber+"&pageSize="+pageSize
		});
	}
	
	
	function addForm(){
		$('#dlg_boardAdd').dialog('open');
	}
	function updForm(){
		alert("updForm 호출성공");
	}
	function delForm(){
		alert("delForm 호출성공");
	}
	
	</script>
<meta charset="UTF-8">
<title>mvc패턴을 이용한 계층형 게시판</title>
<%@ include file="/common/JEasyUICommon.jsp" %>
</head>
<body>
	<script>

	//기존 날짜 포맷을 재정의하는 함수
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'/'+(m<10 ?("0"+m):m)+'/'+(d<10 ?("0"+d):d);
	};
	
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	};
		//th 태그에서 했던 일을 스크립트에서 하는 것
		$(document).ready(function (){

	
/*========================[[combobox 이벤트 처리]]================================*/
		$('#cb_search').combobox({
		    onChange:function(){
				user_combo = $(this).combobox('getValue');	    	
		    }
		});
/*==========================[[textbox 엔터 이벤트 처리]]============================*/
		$("#keyword").textbox('textbox').bind('keydown',function(e){
			if(e.keyCode==13){
				alert("엔터쳤구나!");
			 	$("#dg_board").datagrid({
					 url:'test.nb?crud=boardList&cb_search='+user_combo+'&keyword='+$("#keyword").val()
				});  
				boardList();  
			}
			
		});
		
/*==============================[[페이지네이션]]===================================*/
		
<%-- 		$("#pn_board").pagination({
			total:<%=tot%>
			,pageSize:10
		    ,pageList: [2,3,5,10]
  			,layout:['list','sep','first','prev','links','next','last','sep','refresh']
			//pageNumber:현재 내가 바라보는 페이지
			//pageSize:한 페이지에 뿌릴 로우수
			,onSelectPage: function(pageNumber, pageSize){
				pageMove(pageNumber, pageSize);
			}
		});--%>
		
	}); 
</script>
<!-- ===============[[글 목록화면 시작]]==================
	*JEasyUI의 datagrid api를 활용하여 작성	
		1) expression 활용해 화면처리
			:tr, td태그를 직접 작성해서 처리하는 방식
		2) json 포맷으로 처리해서 매핑
			:field명만 맞춰주면 자동으로 매핑
 -->
 <table title="글목록" id="dg_board" class="easyui-datagrid" data-options="toolbar:'#tb_board', footer:'#pn_board'"
 	 style ="width:1000px; height:500px;">
 	 <!-- 헤더 부분 추가 -->
 	 <thead>
	 	 <tr>
			<th data-options="field:'BM_TITLE',width:'450px'">제목</th>
            <th data-options="field:'BM_WRITER',width:'120px'">작성자</th>
          	<th data-options="field:'BM_DATE',width:'100px'">작성일자</th>
          	<th data-options="field:'BS_FILE',width:'200px'">첨부파일</th>
          	<th data-options="field:'BM_HIT',width:'100px'">조회수</th>
	 	 </tr>
 	 </thead>
 	 <!-- 데이터 출력 영역 -->
 	 <tbody>
 	 <%
 	 	if(size==0){
 	 %>
 	 	 <tr>
 	 	 	<td colspan="5"> 조회결과가 없습니다.</td>
	 	 </tr>
	<%
 	 	}
 	 	else if(size>0){
 	 		//for(int i=0; i<size;i++){
 	 		for(int i=nowPage*numPerPage; i<(nowPage*numPerPage)+numPerPage; i++){
 	 			if(size ==i) break;
 	 			Map<String,Object> rMap = boardList.get(i);
	%> 	 
	 	 <tr>
	 	 	<td>
	 	 	<!-- 너 댓글이니? -->
	<%
		String imgPath="\\board\\";
 		if(Integer.parseInt(rMap.get("BM_POS").toString())>0){
 			for(int j=0; j<Integer.parseInt(rMap.get("BM_POS").toString());j++){
 				out.print("&nbsp;&nbsp;");
 			}
 	%> 		
<img src="<%=imgPath %>reply.gif" border="0">
<% 
 		}
%>	
<a href="javascript:boardDetail('<%=rMap.get("BM_NO")%>')" style="text-decoration:none">
	<%= rMap.get("BM_TITLE") %>
</a>
	 	 	<td><%= rMap.get("BM_WRITER")%></td>
	 	 	<td><%= rMap.get("BM_DATE")%></td>
	 	 	<!-- 
	 	 	익스프레션을 사용하게 되면 자바코드로 읽어들인 값을 html태그 영역에 출력해 준 겨로가가 로컬 pc로 다운된다.
	 	 	소스보기를 해보면 익스프레션 식은 보이지 않고 처리 결과 즉 문자열만 확인할 수 있을 것이다.
	 	 	이것만 보더라도 서버에서 변경된 결과값들이 화면에 왜 즉시 반영될 수 없는 구조인지 확인할 수 있다.
	 	 	 -->
	 	 	<td><a href="javascript:fileDown('<%=rMap.get("BS_FILE") %>')"><%= rMap.get("BS_FILE")%></a>
	 	 	<td><%= rMap.get("BM_HIT")%></td>
	 	 	
	 	 </tr>
	 <%
	 	 	}//////////////end of for
	 	 }/////////////////end of else if
	 %>
 	 </tbody>
 </table>
 	<form>
 	<div id="tb_board" style="padding:2px 5px;">
	<!-- 조건검색 추가 콤보박스 -->
	<div style="margin-bottom:10px"></div>
		 <select class="easyui-combobox" id="cb_search" name="cb_search" style="width:100px;" panelHeight="auto">
		    <option selected value="">선택</option>
		    <option value="bm_title">제목</option>
		    <option value="bm_content">내용</option>
		    <option value="bm_writer">작성자</option>
		</select>
	</form>
	<input class="easyui-textbox" id="keyword" name="keyword" style="width:320px;">
	&nbsp;&nbsp;&nbsp;&nbsp;
 	<input class="easyui-datebox" id="db_date" name="db_date" label="작성일 :" labelAlign="right" style="width:200px;">
 		<div style="margin-bottom:10px"></div>
        <a href="javascript:boardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
        <a href="javascript:addForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a>
        <a href="javascript:updForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">수정</a>
        <a href="javascript:delForm()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">삭제</a>
    </div>
    
    <!-- ======================[[페이지네이션 추가 ]]=============================-->
<table border="1" borderColor="red" style="width:1000px;height:20px">
	<tr>
		<td align="center">
<!-- 			1 2 3 4 5 6 7 8 9 10
		<br>	 -->
<%
	String pagePath= "test.nb?crud=boardList";
	PageBar pb = new PageBar(numPerPage,size,nowPage,pagePath);
	String pagination = null;
	pagination = pb.getPageBar();
	out.print(pagination);
%>			 

		</td>

	</tr>

</table>
       		
<!-- ===============[[글 목록화면 끄읏]]================== -->

<!-- ===============[[글쓰기화면 시작]]==================

	*JEasyUI의 Dialog api를 활용하여 작성	
 
 -->
<div id="dlg_boardAdd" class="easyui-dialog" data-options="closed:'true', modal:'true', footer:'#tb_boardAdd'" style="width:600px;height:550px;padding:10px;" >
	<!-- 
		form 전송시 enctype 옵션이 추가되면 request객체로 사용자가 입력한 값을 꺼낼 수 없다. 
		MultipartRequest => cos.jar
	-->

	<form id="f_boardAdd" method="post" enctype="multipart/form-data">
<!-- 	<input type="hidden" name="crud" value="boardAdd" /> -->
		<input type="hidden" name="bm_no" value="0">
		<input type="hidden" name="bm_group" value="0">
		<input type="hidden" name="bm_pos" value="0">
		<input type="hidden" name="bm_step" value="0">
	
	    <table>
	    <tr>
	    	<td width="100px">제목</td>  
	    	<td width="500px">
	    	<input class="easyui-textbox" data-options="width:'250px'" id="bm_title" name="bm_title"></td>
	    </tr>
	       <tr>
	    	<td width="100px">작성자</td>
	    	<td width="500px">
	    	<input class="easyui-textbox" data-options="width:'250px'" id="bm_writer" name="bm_writer"></td>
	    </tr>
	       <tr>
	    	<td width="100px">이메일</td>
	    	<td width="500px">
	    	<input class="easyui-textbox" data-options="width:'250px'" id="bm_email" name="bm_email"></td>
	    </tr>
	       <tr>
	    	<td width="100px">내용</td>
	    	<td width="500px">
	    	<input class="easyui-textbox" data-options="width:'250px',height:'200px'" id="bm_content" name="bm_content"></td>
	    </tr>
	       <tr>
	    	<td width="100px">비번</td>
	    	<td width="500px">
	    	<input class="easyui-passwordbox" data-options="width:'250px'" id="bm_pw" name="bm_pw" required></td>
	    </tr>
	       <tr>
	    	<td width="100px">첨부파일</td>
	    	<td width="500px">
	    	<input class="easyui-filebox" data-options="width:'250px'" id="bs_file" name="bs_file"></td>
	    </tr>
	</table>
	</form>
</div>

<!-- 입력 화면 버튼 추가 -->
<div id="tb_boardAdd" align="right">
	<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save"> 저장</a>
	<a href="javascript:$('#dlg_boardAdd').dialog('close')" iconCls="icon-clear" class="easyui-linkbutton"> 닫기</a>
</div>



<!-- ===============[[글쓰기화면 끄읏]]================== -->
</body>
</html>