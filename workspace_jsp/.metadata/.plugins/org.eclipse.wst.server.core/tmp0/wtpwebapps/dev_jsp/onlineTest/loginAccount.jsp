<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.vo.MemberVO" %>
<%
//MemberController에서 세션에 담아놓은 값 읽어오기
//세션값은 서버의 cache 메모리에 기억되어 있어서 
//페이지 이동과 상관없이 그 시간 동안은 무조건 유지된다.
	//String mem_name=(String)session.getAttribute("mem_name");
	//request.getAttribute("rmVO"); 시간이 아니라 forward를 통해서 유지
	//forward의 경우 화면 호출시 파라미터에 request와 response가 담겨 있다.
	//servlet에서 객체 주입 받은 원본이므로 그 원본에서 값을 꺼내는 방식
	//session의 경우 컴터의 cache 메모리에 담긴 정보는 꺼내는 것이므로 어디서든 꺼낼 수 있다.
	//톰캣의 경우 기본시간은 30분이고 그 시간을 연장하려면 web.xml 설정추가하면 더 연장할 수 있음.
	MemberVO rmVO= (MemberVO)session.getAttribute("rmVO");
	String mem_name = rmVO.getMem_name();
	//out.print(rmVO.getMem_id()+","+rmVO.getMem_name());
%>

<%-- <script type="text/javascript">
		wrong('<%=mem_name%>'); //''안해주면 값으로 변수로 취급받아서 값을 넘겨주지 못함. 자바스크립트에서 익스프레션 쓸 때.
</script> --%>

 <script type="text/javascript">
		wrong('<%=mem_name%>'); 
</script> 
     <div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right">
         	<label for="msg">
         		<font color="white"> <%=rmVO.getMem_name()%></font>
         	</label>
          <button type="button" id="btn_logout" class="btn btn-dark" onclick="logoutAction()">LogOut</button>
        </form>
      </div>