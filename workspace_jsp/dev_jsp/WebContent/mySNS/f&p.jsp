<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩 및 선물구성</title>
<%@ include file="/common/myCommon.jsp" %>
<% int total = 0;
   int count = 0;
%>
</head>
<body>
<style>
	#top_menus a, #top_login a{
		color:black;
	}
	#topMenu_bar a:hover{
		 color: #8b8b8b;
		 background-color: white;
	}
	#guideLineLink{
		background-color: blue;
	}
	#titleWrapper{
		display: table;
		background-color: green;
		width: 100%;
		height: 130px;
		vertical-align: middle;
		text-align: center;
	}
	#inlineTitle{
		display: table-cell;
		height: 130px;
		vertical-align: middle;
		text-align: center;
	}
</style>
<br>
<div class="row" id="topMenu_bar">
	<div class="col-xs-1"></div>
	<div class="col-xs-2 " align="right">
		<a href="#">
			<span><i class="glyphicon glyphicon-chevron-left"></i></span>
			<span>내페이지</span>
		</a>
	</div>
	   <!--===============[ 메뉴 ] =============-->
   	<div class="col-xs-6 " align="center">
		<a href="#" >지리는 펀딩</a>         
    </div>
        <!--===============[ 타이틀 ]==============-->
    <div class="col-xs-2" align="left">
      	<a href="#">
      	<span><i class="glyphicon glyphicon-wrench"></i></span>
      	<span>창작자 센터</span>
      	</a>
    </div>
    <div class="col-xs-1"></div>
</div>
<hr color="gray">

<div id="titleWrapper" class="row">
	<div id="inlineTitle">
		준비중mem_title
	</div>
</div>
<div class="row" >
	<div class="col-xs-2"></div>
	<div id="guideLineLink" class="col-xs-8" align="center" ><a href="#">펀딩 준비에 앞서 공개 검토 가이드라인, 창작자 센터, 텀블벅 커뮤니티 운영원칙을 확인해주세요.</a></div>
	<div class="col-xs-2"></div>
</div>
<div class="row" >
	<div class="col-xs-2"></div>
	<div id="completeCheck" class="col-xs-8" align="center"><a href="#">총<%=total %>개 섹션 중<%=count %>개를 완성하셨습니다. 모든 섹션을 완성하시면 프로젝트 검토를 요청하실 수 있습니다.</a></div>
	<div class="col-xs-2"></div>
</div>
</body>
</html>