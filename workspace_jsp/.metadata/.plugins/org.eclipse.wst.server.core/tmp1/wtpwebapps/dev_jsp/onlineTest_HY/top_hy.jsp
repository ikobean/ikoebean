<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">자바52기</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">소개</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Front-End노트<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">HTML5</a></li>
          <li><a href="#">CSS</a></li>
          <li><a href="#">JavaScript</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Back-End노트<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Java</a></li>
          <li><a href="#">서블릿</a></li>
          <li><a href="#">JSP</a></li>
          <li><a href="#">Spring</a></li>
          <li><a href="#">안드로이드</a></li>
        </ul>
      </li>
      

  
 <!-- 
 ===========================================================================================
 					온라인 시험 솔루션 실습 - 자격시험 메뉴 추가
 ===========================================================================================
  -->    
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">자격시험<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">자격시험 접수</a></li>
          <li><a id="m_takeatest"  class="easyui-dialog" href="#" onclick=>자격시험 보기</a></li>
        </ul>
      </li>
  
 <!-- 
 ===========================================================================================
 					온라인 시험 솔루션 실습 - 자격시험 메뉴 추가
 ===========================================================================================
 --> 
 
    
     </ul>    
 
     <div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right" action="/action_page.php">
          <div class="form-group">
            <input type="text" class="form-control" id="usrname" size="10" placeholder="아이디">
          </div>
          <div class="form-group">
            <input type="text" class="form-control" id="psw" size="10" placeholder="비밀번호">
          </div>
          <button type="button" class="btn btn-dark" onclick="loginAction()">Login</button>
        </form>
      </div>
  </div>
</nav>
</body>
</html>