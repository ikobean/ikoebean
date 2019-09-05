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
	//댓글등록
	function insRep(mno){
		//alert(mno);
	 	$('#f_insRep'+mno).attr("method","post");
		$('#f_insRep'+mno).attr("action","/mySNS/test.mvc?crud=insRep"); //전송을 하는 곳.
		$('#f_insRep'+mno).submit(); 

	}
	function snsdet(mno){
		$('#f_snsList').attr("method","post");
		$('#f_snsList').attr("action","/mySNS/test.mvc?crud=snsDet"); //전송을 하는 곳.
		$('#f_snsList').submit();
		
	}
	function snsUpd(mno){
		$('#f_snsList').attr("method","post");
		$('#f_snsList').attr("action","/mySNS/test.mvc?crud=snsUpd&mno="+mno); //전송을 하는 곳.
		$('#f_snsList').submit();
		
	}
	
	function snsRep(mno){
 		$("#snsRep"+mno).collapse("show");

	}
	
	function snsDel(mno,mem_pw){
		alert(dao_pw);
		var dao_pw= ("#dao_pw"+mno).val();
		alert(mem_pw);
		//$("#mem_pw").val();
		/* if(mem_pw==) */
 		$('#f_pw'+mno).attr("method","post");
		$('#f_pw'+mno).attr("action","/mySNS/test.mvc?crud=snsDel"); //전송을 하는 곳.
		$('#f_pw'+mno).submit() 
	}
	
	function favcnt(mno,fav){		
		alert(mno);
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
		<a role="button" href="javascript:snsRep(<%=smSet.getMsgVO().getMno()%>)" data-toggle="collapse in"
		   		class="btn btn-success btn-sm" id="btnRep" name="btnRep">댓글</a>
		   		
		<a role="button" href="javascript:snsDet(<%=smSet.getMsgVO().getMno() %>)" 
		   		class="btn btn-success btn-sm" id="sns_det" name="sns_det">수정</a>
		   		
		<a role="button" href="#modal_pw<%=smSet.getMsgVO().getMno() %>" 
		   		class="btn btn-success btn-sm" id="sns_del" name="sns_del" data-toggle="modal" >삭제</a>
	  </span>   		
		   		
	  <div style="margin-bottom:30px"></div>
	 </form>	
	<!-- ==========================[[    modal창     ]] ======================================= -->
	<form id="f_pw<%=smSet.getMsgVO().getMno() %>" name="f_pw">
		<input type="hidden" id="mno" name="mno" value="<%=smSet.getMsgVO().getMno()%>">
		<input type="hidden" id="dao_pw<%=smSet.getMsgVO().getMno()%>" name="dao_pw" value="<%=smSet.getMsgVO().getMem_pw()%>" >
		<div class="modal" role="dialog" id="modal_pw<%=smSet.getMsgVO().getMno() %>">
			<div  class="modal-dialog modal-sm modal-dialog-centered" >
				 <div class="modal-content">
					<div class="modal-body">
				  		<input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter password" id="mem_pw" name="mem_pw" >
				  	 <div class="modal-footer">
				  		<a role="button"  href="javascript:snsDel(<%=smSet.getMsgVO().getMno()%>,<%=smSet.getMsgVO().getMem_pw()%>)" class="btn btn-success btn-sm">비번맞나</a>
				  	</div>
			  		</div>
			  	</div>
		  	</div>
		 </div> 	
	</form>
	<!-- ==========================[[    modal창 끝          ]] ======================================= -->
		  <!-- 댓글 다는 창 -->
		  <form id="f_insRep<%=smSet.getMsgVO().getMno()%>" name="f_insRep">
		  	<input type="hidden" id="rno" name="rno" value="0">
		  	<input type="hidden" id="mno" name="mno" value="<%=smSet.getMsgVO().getMno()%>">
		  	
		 	<div id="snsRep<%=smSet.getMsgVO().getMno()%>" name="snsRep" class="collapse in" >
	  			<div  class="card-body bg-light text-dark" >
					<div class="form-inline">
					<input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter your ID" rows="1"  id="mem_id<%=smSet.getMsgVO().getMno()%>" name="mem_id">
					<input type="text" class="form-control mb-2 mr-sm-2" placeholder="Enter password" rows="1"  id="mem_pw<%=smSet.getMsgVO().getMno()%>" name="mem_pw" >
			 		&nbsp;&nbsp;
					</div>
					<div style="margin-bottom:20px"></div>
	  				<input type="text" class="form-control mb-2 mr-sm-2"" id="msg" name="msg"> 
	  		 		<a role="button" href="javascript:insRep(<%=smSet.getMsgVO().getMno()%>)" class="btn btn-success btn-sm mr-sm-2" id="sns_del" name="sns_del">댓글등록</a>
	  			</div>
		  </div>
		 </form>
		<div style="margin-bottom:5px"></div>
</div>
	  <%
		if(rsize>0){//친구 상태글에 대한 댓글이 존재하는 경우
			for(int j=0;j<rsize;j++){
				SNSRepleVO srVO = reList.get(j);
%>  
  <div id="card_reple" class="card-body bg-light text-dark"  style="padding:10px">
   	<strong><%=srVO.getMem_id()%></strong><%="님" %>
   	<div style="margin-bottom:5px"></div>
  	 	 &nbsp;&nbsp;&nbsp;&nbsp;
   	 	 <h6><%=srVO.getMsg() %>
   	 	 <span style="float:right" > 
   	     	<a role="button" href="#modal_pw<%=smSet.getMsgVO().getMno() %>" 
		 		class="btn btn-success btn-sm" id="sns_del" name="sns_del" data-toggle="modal" >삭제</a>
		 </span>
	</div>
   <div style="margin-bottom:1px"></div>
  
       
<%
			}//end of inner for 상태글에 대한 댓글 출력
		}///////end of 댓글이 있을 때
	}/////////////////end of outter for
	
%> 
</div> 
<script>


</script>





