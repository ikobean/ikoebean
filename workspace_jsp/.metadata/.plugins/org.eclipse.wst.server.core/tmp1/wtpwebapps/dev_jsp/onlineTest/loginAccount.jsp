<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//MemberController에서 세션에 담아놓은 값 읽어오기
//세션값은 서버의 cache 메모리에 기억되어 있어서 
//페이지 이동과 상관없이 그 시간 동안은 무조건 유지된다.
	String mem_name=(String)session.getAttribute("mem_name");
%>

<script type="text/javascript">
		wrong('<%=mem_name%>'); //''안해주면 값으로 변수로 취급받아서 값을 넘겨주지 못함. 자바스크립트에서 익스프레션 쓸 때.
</script>
     <div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right">
         	<label for="msg">
         		<font color="white"> <%=mem_name %></font>
         	</label>
          <button type="button" id="btn_logout" class="btn btn-dark" onclick="logoutAction()">LogOut</button>
        </form>
      </div>