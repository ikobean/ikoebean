/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-08-12 11:05:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.PageBar;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import com.util.PageBar;

public final class boardListVer2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/JEasyUICommon.jsp", Long.valueOf(1564466205580L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.google.gson.Gson");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("com.util.PageBar");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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


      out.write("\r\n");
      out.write("    <!-- \r\n");
      out.write("    \t화면처리를 태그로 할 때와 스크립트로 할 때\r\n");
      out.write("    \t1. 태그안에 코드를 작성하면 디자인과 코드가 분리가 안되어서 가독성이 떨어짐.\r\n");
      out.write("    \t2. 스크립트로 처리할 때 화면에서 코드가 분리됨 (이벤트 처리나 dom 조작하는 코드작성시 접근성이 좋다.)\r\n");
      out.write("    \t\r\n");
      out.write("     -->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//전역변수 선언 위치\r\n");
      out.write("\t//목록 화면에서 사용자가 제목을 더블클릭 했을 때 셀에 대한 정보만 들어있으므로\r\n");
      out.write("\t//선택한 로우에 숫자값을 가지고 숨어있는 필드 bm_no값을 가져와서 담는다.\r\n");
      out.write("\tvar g_no;\r\n");
      out.write("\tvar user_combo; \r\n");
      out.write("\t//콤보박스에서 선택한 값 담기\r\n");
      out.write("\tvar cb_value;\r\n");
      out.write("\t//선택한 콤보에 대한 키워드\r\n");
      out.write("\tvar tb_value;\r\n");
      out.write("\t/*\r\n");
      out.write("\t\t각 로우별로 DB에서 새로 읽어들인 값이 출력이 되고 그 파일이름으로 다운로드 파일명을 찾아야 하므로\r\n");
      out.write("\t\t이벤트가 발생할 때 마다 파일 이름은 달라지게 된다.\r\n");
      out.write("\t\t자바코드로 읽어들인 정보를 자바스크립트 변수로 사용하는 것은 가능한 일이나 그 값은 상수처럼 정해진 값\r\n");
      out.write("\t\t즉 정적인 성격을 가지고 있으므로 사용할 때 주의할 것.\r\n");
      out.write("\t\t서버에서 바뀐 갑싱 화면에 즉시 반영될 수 없는 것은 서버페이지가 아닌 응답 페이지의 경우 이미 HTML 코드로\r\n");
      out.write("\t\t변경된 페이지가 다운되고 출력되므로 절대로 유동적인 변화를 기대할 수 없다.\r\n");
      out.write("\t*/\r\n");
      out.write("\tfunction fileDown(fname){\r\n");
      out.write("\t\tlocation.href=\"download.jsp?bs_file=\"+fname;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addAction(){\r\n");
      out.write("\t\t$('#f_boardAdd').attr(\"method\",\"post\");\r\n");
      out.write("\t\t$('#f_boardAdd').attr(\"action\",\"/board/test.nb?crud=boardAdd\");\r\n");
      out.write("\t\t$('#f_boardAdd').submit();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction boardDetail(p_bmno){\r\n");
      out.write("\t\t//cmm_window_popup(\"test.nb?crud=boardDetail&bm_no=\"+p_bmno,\"700\",\"450\",\"read\");\r\n");
      out.write("\t\tlocation.href=\"test.nb?crud=boardDetail&bm_no=\"+p_bmno;\r\n");
      out.write("\t}\r\n");
      out.write("\t/*\r\n");
      out.write("\t *학습목표\r\n");
      out.write("\t *나는 오라클 서버에서 조회된 결과를 담은 List<Map>을 화면 (datagrid)에 출력을 내보낼 수 있다.\r\n");
      out.write("\t 화면 (dom구성)과 java코드가 만나는 부분에 대한 처리 방법에 대해 설명하고 코드에 적용할 수 있다.\r\n");
      out.write("\t 화면은 html로 그리지만 조회된 결과를 html에 반영하기 위해 dom을 조작하는 방법에 대해 말할 수 있다.\r\n");
      out.write("\t 그 둘 사이에서 json의 역할에 대해서 설명할 수 있다.\r\n");
      out.write("\t \r\n");
      out.write("\t 결론\r\n");
      out.write("\t 화면을 조작하는 여러가지 방법에 대한 경험을 가지고 다양한 ui솔루션이 제공하는 컴포넌트에\r\n");
      out.write("\t 조회된 결과를 반영할 수 있도록 연습해두자.\r\n");
      out.write("\t 각 device마다 혹은 시스템마다 서로 다른 ui 솔루션을 선택하고 사용할 수 있으므로\r\n");
      out.write("\t 여러가지 경우의 수에 대해 미리 생각해 봄으로써 ui솔루션이 javascript기반이거나\r\n");
      out.write("\t xml기반 혹은 안드로이드에서 적용할 수 있도록 실습해 볼 것.\r\n");
      out.write("\t *\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction boardList(){//태그 조작(DOM조작)\r\n");
      out.write("\t\talert(\"boardList 호출성공\");\r\n");
      out.write("\t\t//alert(user_combo);\r\n");
      out.write("\t\t//사용자가 선택한 콤보이름\r\n");
      out.write("\t\tcb_value=user_combo;\r\n");
      out.write("\t\t//선택한 콤보에 대한 키워드\r\n");
      out.write("\t\ttb_value = $(\"#keyword\").val();\r\n");
      out.write("\t\t//alert(tb_value);\r\n");
      out.write("\t\tlocation.href='test.nb?crud=boardList&cb_search='+cb_value\r\n");
      out.write("\t\t +'&keyword='+tb_value\r\n");
      out.write(" \t\t +'&pageNumber=1'\r\n");
      out.write("\t\t +'&pageSize=10' \r\n");
      out.write("\t \r\n");
      out.write("\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t url:'test.nb?crud=boardList&cb_search='+cb_value\r\n");
      out.write("\t\t\t\t\t +'&keyword='+tb_value\r\n");
      out.write("\t\t\t \t\t +'&pageNumber=1'\r\n");
      out.write("\t\t\t\t\t +'&pageSize=10' \r\n");
      out.write("\t\t\t,singleSelect: 'true'\r\n");
      out.write("\t\t/* \t,data:[\r\n");
      out.write("\t\t\t\t {bm_title:'테스트', bm_writer:\"내복이\", bm_hit:\"35\", bs_file:'avatar.png'}\r\n");
      out.write("\t\t\t\t,{bm_title:'테스트2', bm_writer:\"귀여워\", bm_hit:\"99\", bs_file:'ikobean.png'}\r\n");
      out.write("\t\t\t] */\r\n");
      out.write("\t\t\t ,onLoadSuccess:function(data){\r\n");
      out.write("\t\t\t\t$(\"#pn_board\").pagination({\r\n");
      out.write("\t\t\t\t\t//total:data.total\r\n");
      out.write("\t\t\t\t\ttotal:");
      out.print(tot);
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}//////////////////////////////// end of boardList\r\n");
      out.write("\t \r\n");
      out.write("\tfunction pageMove(pageNumber, pageSize){\r\n");
      out.write("\t\t//alert(pageNumber+\",\"+pageSize);\r\n");
      out.write("\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\turl:\"/board/test.nb?crud=boardList&pageNumber=\"+pageNumber+\"&pageSize=\"+pageSize\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addForm(){\r\n");
      out.write("\t\t$('#dlg_boardAdd').dialog('open');\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction updForm(){\r\n");
      out.write("\t\talert(\"updForm 호출성공\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction delForm(){\r\n");
      out.write("\t\talert(\"delForm 호출성공\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>mvc패턴을 이용한 계층형 게시판</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css?1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/commons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.cookie.js\"></script>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<script>\r\n");
      out.write("\r\n");
      out.write("\t//기존 날짜 포맷을 재정의하는 함수\r\n");
      out.write("\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\tvar d = date.getDate();\r\n");
      out.write("\t\treturn y+'/'+(m<10 ?(\"0\"+m):m)+'/'+(d<10 ?(\"0\"+d):d);\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\treturn new Date(t);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn new Date();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\t//th 태그에서 했던 일을 스크립트에서 하는 것\r\n");
      out.write("\t\t$(document).ready(function (){\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("/*========================[[combobox 이벤트 처리]]================================*/\r\n");
      out.write("\t\t$('#cb_search').combobox({\r\n");
      out.write("\t\t    onChange:function(){\r\n");
      out.write("\t\t\t\tuser_combo = $(this).combobox('getValue');\t    \t\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("/*==========================[[textbox 엔터 이벤트 처리]]============================*/\r\n");
      out.write("\t\t$(\"#keyword\").textbox('textbox').bind('keydown',function(e){\r\n");
      out.write("\t\t\tif(e.keyCode==13){\r\n");
      out.write("\t\t\t\talert(\"엔터쳤구나!\");\r\n");
      out.write("\t\t\t \t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\t\t url:'test.nb?crud=boardList&cb_search='+user_combo+'&keyword='+$(\"#keyword\").val()\r\n");
      out.write("\t\t\t\t});  \r\n");
      out.write("\t\t\t\tboardList();  \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("/*==============================[[페이지네이션]]===================================*/\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t}); \r\n");
      out.write("</script>\r\n");
      out.write("<!-- ===============[[글 목록화면 시작]]==================\r\n");
      out.write("\t*JEasyUI의 datagrid api를 활용하여 작성\t\r\n");
      out.write("\t\t1) expression 활용해 화면처리\r\n");
      out.write("\t\t\t:tr, td태그를 직접 작성해서 처리하는 방식\r\n");
      out.write("\t\t2) json 포맷으로 처리해서 매핑\r\n");
      out.write("\t\t\t:field명만 맞춰주면 자동으로 매핑\r\n");
      out.write(" -->\r\n");
      out.write(" <table title=\"글목록\" id=\"dg_board\" class=\"easyui-datagrid\" data-options=\"toolbar:'#tb_board', footer:'#pn_board'\"\r\n");
      out.write(" \t style =\"width:1000px; height:500px;\">\r\n");
      out.write(" \t <!-- 헤더 부분 추가 -->\r\n");
      out.write(" \t <thead>\r\n");
      out.write("\t \t <tr>\r\n");
      out.write("\t\t\t<th data-options=\"field:'BM_TITLE',width:'450px'\">제목</th>\r\n");
      out.write("            <th data-options=\"field:'BM_WRITER',width:'120px'\">작성자</th>\r\n");
      out.write("          \t<th data-options=\"field:'BM_DATE',width:'100px'\">작성일자</th>\r\n");
      out.write("          \t<th data-options=\"field:'BS_FILE',width:'200px'\">첨부파일</th>\r\n");
      out.write("          \t<th data-options=\"field:'BM_HIT',width:'100px'\">조회수</th>\r\n");
      out.write("\t \t </tr>\r\n");
      out.write(" \t </thead>\r\n");
      out.write(" \t <!-- 데이터 출력 영역 -->\r\n");
      out.write(" \t <tbody>\r\n");
      out.write(" \t ");

 	 	if(size==0){
 	 
      out.write("\r\n");
      out.write(" \t \t <tr>\r\n");
      out.write(" \t \t \t<td colspan=\"5\"> 조회결과가 없습니다.</td>\r\n");
      out.write("\t \t </tr>\r\n");
      out.write("\t");

 	 	}
 	 	else if(size>0){
 	 		//for(int i=0; i<size;i++){
 	 		for(int i=nowPage*numPerPage; i<(nowPage*numPerPage)+numPerPage; i++){
 	 			if(size ==i) break;
 	 			Map<String,Object> rMap = boardList.get(i);
	
      out.write(" \t \r\n");
      out.write("\t \t <tr>\r\n");
      out.write("\t \t \t<td>\r\n");
      out.write("\t \t \t<!-- 너 댓글이니? -->\r\n");
      out.write("\t");

		String imgPath="\\board\\";
 		if(Integer.parseInt(rMap.get("BM_POS").toString())>0){
 			for(int j=0; j<Integer.parseInt(rMap.get("BM_POS").toString());j++){
 				out.print("&nbsp;&nbsp;");
 			}
 	
      out.write(" \t\t\r\n");
      out.write("<img src=\"");
      out.print(imgPath );
      out.write("reply.gif\" border=\"0\">\r\n");
 
 		}

      out.write("\t\r\n");
      out.write("<a href=\"javascript:boardDetail('");
      out.print(rMap.get("BM_NO"));
      out.write("')\" style=\"text-decoration:none\">\r\n");
      out.write("\t");
      out.print( rMap.get("BM_TITLE") );
      out.write("\r\n");
      out.write("</a>\r\n");
      out.write("\t \t \t<td>");
      out.print( rMap.get("BM_WRITER"));
      out.write("</td>\r\n");
      out.write("\t \t \t<td>");
      out.print( rMap.get("BM_DATE"));
      out.write("</td>\r\n");
      out.write("\t \t \t<!-- \r\n");
      out.write("\t \t \t익스프레션을 사용하게 되면 자바코드로 읽어들인 값을 html태그 영역에 출력해 준 겨로가가 로컬 pc로 다운된다.\r\n");
      out.write("\t \t \t소스보기를 해보면 익스프레션 식은 보이지 않고 처리 결과 즉 문자열만 확인할 수 있을 것이다.\r\n");
      out.write("\t \t \t이것만 보더라도 서버에서 변경된 결과값들이 화면에 왜 즉시 반영될 수 없는 구조인지 확인할 수 있다.\r\n");
      out.write("\t \t \t -->\r\n");
      out.write("\t \t \t<td><a href=\"javascript:fileDown('");
      out.print(rMap.get("BS_FILE") );
      out.write("')\">");
      out.print( rMap.get("BS_FILE"));
      out.write("</a>\r\n");
      out.write("\t \t \t<td>");
      out.print( rMap.get("BM_HIT"));
      out.write("</td>\r\n");
      out.write("\t \t \t\r\n");
      out.write("\t \t </tr>\r\n");
      out.write("\t ");

	 	 	}//////////////end of for
	 	 }/////////////////end of else if
	 
      out.write("\r\n");
      out.write(" \t </tbody>\r\n");
      out.write(" </table>\r\n");
      out.write(" \t<form>\r\n");
      out.write(" \t<div id=\"tb_board\" style=\"padding:2px 5px;\">\r\n");
      out.write("\t<!-- 조건검색 추가 콤보박스 -->\r\n");
      out.write("\t<div style=\"margin-bottom:10px\"></div>\r\n");
      out.write("\t\t <select class=\"easyui-combobox\" id=\"cb_search\" name=\"cb_search\" style=\"width:100px;\" panelHeight=\"auto\">\r\n");
      out.write("\t\t    <option selected value=\"\">선택</option>\r\n");
      out.write("\t\t    <option value=\"bm_title\">제목</option>\r\n");
      out.write("\t\t    <option value=\"bm_content\">내용</option>\r\n");
      out.write("\t\t    <option value=\"bm_writer\">작성자</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<input class=\"easyui-textbox\" id=\"keyword\" name=\"keyword\" style=\"width:320px;\">\r\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write(" \t<input class=\"easyui-datebox\" id=\"db_date\" name=\"db_date\" label=\"작성일 :\" labelAlign=\"right\" style=\"width:200px;\">\r\n");
      out.write(" \t\t<div style=\"margin-bottom:10px\"></div>\r\n");
      out.write("        <a href=\"javascript:boardList()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">조회</a>\r\n");
      out.write("        <a href=\"javascript:addForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">입력</a>\r\n");
      out.write("        <a href=\"javascript:updForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">수정</a>\r\n");
      out.write("        <a href=\"javascript:delForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\">삭제</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <!-- ======================[[페이지네이션 추가 ]]=============================-->\r\n");
      out.write("<table border=\"1\" borderColor=\"red\" style=\"width:1000px;height:20px\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">\r\n");
      out.write("<!-- \t\t\t1 2 3 4 5 6 7 8 9 10\r\n");
      out.write("\t\t<br>\t -->\r\n");

	String pagePath= "test.nb?crud=boardList";
	PageBar pb = new PageBar(numPerPage,size,nowPage,pagePath);
	String pagination = null;
	pagination = pb.getPageBar();
	out.print(pagination);

      out.write("\t\t\t \r\n");
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("       \t\t\r\n");
      out.write("<!-- ===============[[글 목록화면 끄읏]]================== -->\r\n");
      out.write("\r\n");
      out.write("<!-- ===============[[글쓰기화면 시작]]==================\r\n");
      out.write("\r\n");
      out.write("\t*JEasyUI의 Dialog api를 활용하여 작성\t\r\n");
      out.write(" \r\n");
      out.write(" -->\r\n");
      out.write("<div id=\"dlg_boardAdd\" class=\"easyui-dialog\" data-options=\"closed:'true', modal:'true', footer:'#tb_boardAdd'\" style=\"width:600px;height:550px;padding:10px;\" >\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t\tform 전송시 enctype 옵션이 추가되면 request객체로 사용자가 입력한 값을 꺼낼 수 없다. \r\n");
      out.write("\t\tMultipartRequest => cos.jar\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("\t<form id=\"f_boardAdd\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("<!-- \t<input type=\"hidden\" name=\"crud\" value=\"boardAdd\" /> -->\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"bm_no\" value=\"0\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"bm_group\" value=\"0\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"bm_pos\" value=\"0\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"bm_step\" value=\"0\">\r\n");
      out.write("\t\r\n");
      out.write("\t    <table>\r\n");
      out.write("\t    <tr>\r\n");
      out.write("\t    \t<td width=\"100px\">제목</td>  \r\n");
      out.write("\t    \t<td width=\"500px\">\r\n");
      out.write("\t    \t<input class=\"easyui-textbox\" data-options=\"width:'250px'\" id=\"bm_title\" name=\"bm_title\"></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t       <tr>\r\n");
      out.write("\t    \t<td width=\"100px\">작성자</td>\r\n");
      out.write("\t    \t<td width=\"500px\">\r\n");
      out.write("\t    \t<input class=\"easyui-textbox\" data-options=\"width:'250px'\" id=\"bm_writer\" name=\"bm_writer\"></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t       <tr>\r\n");
      out.write("\t    \t<td width=\"100px\">이메일</td>\r\n");
      out.write("\t    \t<td width=\"500px\">\r\n");
      out.write("\t    \t<input class=\"easyui-textbox\" data-options=\"width:'250px'\" id=\"bm_email\" name=\"bm_email\"></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t       <tr>\r\n");
      out.write("\t    \t<td width=\"100px\">내용</td>\r\n");
      out.write("\t    \t<td width=\"500px\">\r\n");
      out.write("\t    \t<input class=\"easyui-textbox\" data-options=\"width:'250px',height:'200px'\" id=\"bm_content\" name=\"bm_content\"></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t       <tr>\r\n");
      out.write("\t    \t<td width=\"100px\">비번</td>\r\n");
      out.write("\t    \t<td width=\"500px\">\r\n");
      out.write("\t    \t<input class=\"easyui-passwordbox\" data-options=\"width:'250px'\" id=\"bm_pw\" name=\"bm_pw\" required></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t       <tr>\r\n");
      out.write("\t    \t<td width=\"100px\">첨부파일</td>\r\n");
      out.write("\t    \t<td width=\"500px\">\r\n");
      out.write("\t    \t<input class=\"easyui-filebox\" data-options=\"width:'250px'\" id=\"bs_file\" name=\"bs_file\"></td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 입력 화면 버튼 추가 -->\r\n");
      out.write("<div id=\"tb_boardAdd\" align=\"right\">\r\n");
      out.write("\t<a href=\"javascript:addAction()\" class=\"easyui-linkbutton\" iconCls=\"icon-save\"> 저장</a>\r\n");
      out.write("\t<a href=\"javascript:$('#dlg_boardAdd').dialog('close')\" iconCls=\"icon-clear\" class=\"easyui-linkbutton\"> 닫기</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ===============[[글쓰기화면 끄읏]]================== -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
