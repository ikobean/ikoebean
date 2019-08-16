<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.SNSMessageVO" %>    
<%@ page import="com.vo.SNSMessageSet, com.vo.SNSRepleVO" %>
<%
	List<SNSMessageSet> msgList = null;
	msgList = (List<SNSMessageSet>)request.getAttribute("smsgList");
	int size = 0;
	if(msgList!=null)
		size = msgList.size();
	//out.print("size:"+size);
%>
<script>
	function snsdet(mno){
		
		$('#f_snsList').attr("method","post");
		$('#f_snsList').attr("action","/mySNS/test.mvc?crud=snsDet&mno="+mno); //전송을 하는 곳.
		$('#f_snsList').submit();
		
	}
	function snsUpd(mno){
		
		$('#f_snsList').attr("method","post");
		$('#f_snsList').attr("action","/mySNS/test.mvc?crud=snsUpd&mno="+mno); //전송을 하는 곳.
		$('#f_snsList').submit();
		
	}
	function snsRep(){
		alert("zz");
		//$("#snsRep").collapse('aria-expanded','true');
	}
	function snsDel(mno){
		//alert("del");
		$('#f_snsList').attr("method","post");
		$('#f_snsList').attr("action","/mySNS/test.mvc?crud=snsDel&mno="+mno); //전송을 하는 곳.
		$('#f_snsList').submit();
	}
	function favcnt(mno,fav){		
		//alert($("#mno").val());
		$.ajax({
			method:"get"
		   ,url:"/mySNS/test.mvc?crud=favcnt&mno="+mno+"&favcnt="+fav
		   ,success:function(data){
/* 			   alert(data); */
			   $("#d_msg").html(data);
		   }
		}); 
	}
</script>     
<div class="card bg-success text-white">
<%
//전역변수
		int i=0;
%>
<%
	for(i=0;i<size;i++){
		SNSMessageSet smSet = msgList.get(i);
		SNSMessageVO smVO = smSet.getMsgVO();
		List<SNSRepleVO> reList = smSet.getReList();
		int rsize = 0;
		if(reList!=null){
			rsize = reList.size();
		}
%>
<form id="f_snsList">

	<input type="hidden" id="mno" name="mno" value="<%=smSet.getMsgVO().getMno()%>">
	<input type="hidden" id="favcnt" name="favcnt" value="<%=smSet.getMsgVO().getFavcnt() %>">	
   <div class="card-header ">
	  <h5><%=smSet.getMsgVO().getMem_id() %></h5>
	  		&nbsp;&nbsp;
	  <%=smSet.getMsgVO().getMsg() %><br>
	  <div style="margin-bottom:30px"></div>
	  <span>
	  		&nbsp;&nbsp;&nbsp;&nbsp;
	  	
	  	<%=smSet.getMsgVO().getFavcnt()%>
	  	
	  		&nbsp;&nbsp;
	  	<a href="javascript:favcnt(<%=smSet.getMsgVO().getMno() %>,<%=smSet.getMsgVO().getFavcnt()%>)" role="button" class="btn btn-outline-light btn-sm text-light">♡</a>
	 		 &nbsp;&nbsp;&nbsp;&nbsp;
	  </span>
		 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <span>
		<a role="button" href="#snsRep" data-toggle="collapse"
		   class="btn btn-success btn-sm" id="btnRep" name="btnRep">댓글</a>
		 
		  <a role="button" href="javascript:snsDet(<%=smSet.getMsgVO().getMno() %>)" class="btn btn-success btn-sm" id="sns_det" name="sns_det">수정</a>
		  <a role="button" href="javascript:snsDel(<%=smSet.getMsgVO().getMno() %>)" class="btn btn-success btn-sm" id="sns_del" name="sns_del">삭제</a>
	  </span>
	  
		<div class="collapse" id="snsRep" name="snsRep">
  		<div  class="card-body bg-light text-dark" >Basiccardsdfssdfghsdf</div>
  		<a href="javascript:snsRep()" style="align: right">확인</a>
	  	</div>
	
  </div>
</form>	
	  <%
		if(rsize>0){//친구 상태글에 대한 댓글이 존재하는 경우
			for(int j=0;j<rsize;j++){
				SNSRepleVO srVO = reList.get(j);
%>  
  <div class="card-body bg-light text-dark"  style="padding:10px">
   <%=srVO.getMem_id()+"님의 댓글"%><br>
   &nbsp;&nbsp;
   <%=srVO.getMsg() %></div>
       
<%
			}//end of inner for 상태글에 대한 댓글 출력
		}///////end of 댓글이 있을 때
	}/////////////////end of outter for
	
%> 

	</div> 





