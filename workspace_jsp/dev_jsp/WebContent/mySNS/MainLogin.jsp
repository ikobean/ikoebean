<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script>
	function signIn(){
		alert("하이");
	 	$('#f_signin').attr("method","post");
		$('#f_signin').attr("action","/mySNS/test.mvc?crud=signIn"); //전송을 하는 곳.
		$('#f_signin').submit(); 
		
	}

</script>
</head>
<body>
   <style>
        .jumbotron {
            background-image: url('../../images/nikuq.png');
            background-size: cover;
            }
    </style>
<div align="center">
<div class="jumbotron bg-info text-dark">
  <h1 class="display-4">HELLO</h1>
  <p class="lead">여기서 말하는 모든 이야기들은 비밀이야!</p>
  <hr class="my-4">
  <p>두근두근>_<</p>
  
    <!-- 로그인화면 -->
  <form action="/action_page.php" class="was-validated">
	  <div class="form-group">
		<!--<div class="col-sm-10"> -->
	    <label for="uname"></label>
	    <input type="text" class="form-control col-sm-3" id="uname" placeholder="Enter your ID" name="uname" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback text-dark">Please fill out this field.</div>
	  </div>
	  <div class="form-group">
	    <label for="pwd"></label>
	    <input type="password" class="form-control col-sm-3" id="pwd" placeholder="Enter password" name="pswd" required>
	    <div class="valid-feedback ">Valid.</div>
	    <div class="invalid-feedback text-dark">Please fill out this field.</div>
	  </div>
	  <div class="form-group form-check">
	    <label class="form-check-label ">
	      <input class="form-check-input" type="checkbox" name="remember" required> 여기서 말하는 건 다 비밀이야!
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback text-dark">Check this checkbox to continue.</div>
	    </label>
	  </div>
	  <div align=center>
		<a role="button" class="btn btn-warning text-dark">Login</a>
		<a role="button" class="btn btn-warning text-dark" href="#signIn" data-toggle="modal">Signin</a>
	  </div>
 </form> 
	<!-- ==========================[[    modal창     ]] ======================================= -->
	<form id="f_signin" name="f_signin">
		<div class="modal" role="dialog" id="signIn">
			<div  class="modal-dialog modal-m modal-dialog-centered" >
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">회원가입</h5>
					</div>	
					<div class="modal-body">
					  	<input type="text" class="form-control mb-4 mr-sm-4" placeholder="아이디를 입력하세요" id="mem_id" name="mem_id" >
					  	<input type="text" class="form-control mb-4 mr-sm-4" placeholder="닉네임을 입력하세요" id="mem_name" name="mem_name" >
					  	<input type="text" class="form-control mb-4 mr-sm-4" placeholder="이메일을 입력하세요" id="mem_email" name="mem_email" >
					  	<input type="text" class="form-control mb-4 mr-sm-4" placeholder="비밀번호를 입력하세요" id="mem_pw" name="mem_pw" >
				  	 <div class="modal-footer">
				  		<a role="button"  href="javascript:signIn()" class="btn btn-success btn-sm">가입하기</a>
				  	</div>
			  		</div>
			  	</div>
		  	</div>
		 </div> 	
	</form>
	<!-- ==========================[[    modal창 끝          ]] ======================================= -->

 

</div>
</div>
</body>
</html>