/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-22 12:00:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import com.vo.ZipCodeVO;
import com.google.gson.Gson;

public final class memberMgr_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/member/../common/JEasyUICommon.jsp", Long.valueOf(1563768128430L));
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
    _jspx_imports_classes.add("com.vo.ZipCodeVO");
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

 	List<ZipCodeVO> zipList = 
		(List<ZipCodeVO>)request.getAttribute("zipList");
	int size=0;	
	if(zipList!=null && zipList.size()>0){
		size = zipList.size();	
	} 

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원목록</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t //전역변수 선언  - 선택한 로우의 주소를 담는다.\r\n");
      out.write("\t  var g_address;\r\n");
      out.write("\t  var del_id;\r\n");
      out.write("\t  //해당하는 페이지의 DOM구성이 완료되었을 때\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$('#dg_member').datagrid({\r\n");
      out.write("\t\t\t\turl:\"memberList.kos?work=member\",\r\n");
      out.write("\t\t\t\tsingleSelcet:true,\t\t\r\n");
      out.write("\t\t\t\ttitle:\"회원관리 ver1.0\",\r\n");
      out.write("\t\t\t\ttoolbar:'#tb_member',\r\n");
      out.write("\t\t\t\tcolumns:[[\r\n");
      out.write("\t\t\t\t    {field:'MEM_ID',title:'아이디',width:150},\r\n");
      out.write("\t                {field:'MEM_PW',title:'비밀번호',width:150},\r\n");
      out.write("\t                {field:'MEM_NAME',title:'이름',width:150},\r\n");
      out.write("\t                {field:'MEM_ADDR',title:'주소',width:300},\r\n");
      out.write("\t                {field:'MEM_ZIPCODE',title:'우편번호',width:300}\r\n");
      out.write("\t            ]]\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t////////////end of datagrid\r\n");
      out.write("\t\t\t $('#dlg_ins').dialog({\r\n");
      out.write("\t\t\t\ttitle:\"회원가입\",\r\n");
      out.write("\t\t\t\twidth:400,\r\n");
      out.write("\t\t\t\theight:500,\r\n");
      out.write("\t\t\t\tfooter:\"#tb_ins\",\r\n");
      out.write("\t\t\t\tclosed:true\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t\t$('#dg_zipcode').datagrid({\r\n");
      out.write("\t\t\t\t title : \"우편번호 검색 결과\"\r\n");
      out.write("\t\t\t\t,columns : [[ \r\n");
      out.write("\t\t\t\t\t{field : 'zipcode',title : '우편번호',width : 100,align : 'center'},\r\n");
      out.write("\t\t\t\t    {field : 'address',\ttitle : '주소',\twidth : 380,align : 'left'} \r\n");
      out.write("\t\t\t\t]],\r\n");
      out.write("\t\t\t/* \tdata:[\r\n");
      out.write("\t\t\t\t\t{\"zipcode\":15067, \"address\":\"서울시 금천구 가산동\"}\r\n");
      out.write("\t\t\t\t] */\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t$('#dlg_zip').dialog({\r\n");
      out.write("\t\t\t\ttitle : \"우편번호 검색기\",\r\n");
      out.write("\t\t\t\twidth : 400,\r\n");
      out.write("\t\t\t\theight : 500,\r\n");
      out.write("\t\t\t\tclosed : true\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t\t $('#btn_ins').linkbutton({\r\n");
      out.write("\t\t\t\tonClick : function() {\r\n");
      out.write("\t\t\t\t\t$('#dlg_ins').dialog('open');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$('#btn_close').linkbutton({\r\n");
      out.write("\t\t\t\tonClick : function() {\r\n");
      out.write("\t\t\t\t\t$('#dlg_ins').dialog('close');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t \t\t$('#btn_save').linkbutton({\r\n");
      out.write("\t\t\t\tonClick : function() {\r\n");
      out.write("\t\t\t\t\t$('#dlg_ins').dialog('close');\r\n");
      out.write("\t\t\t\t\t$('#f_ins').attr('method','GET');\r\n");
      out.write("\t\t\t\t\t$('#f_ins').attr('action','./memberInsert.kos');\r\n");
      out.write("\t\t\t\t\t$('#f_ins').submit();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t\t$('#dong').textbox('textbox').bind('keydown', function(e){\r\n");
      out.write("\t\t\t    if (e.keyCode == 13){    // when press ENTER key, accept the inputed value.\r\n");
      out.write("\t\t\t\t\t//alert(\"엔터쳤을 때\");\r\n");
      out.write("\t\t\t    \t$('#dg_zipcode').datagrid({\r\n");
      out.write("\t\t\t    \t\turl:'./zipcodeList.kos?work=member&dong='+$(this).val()\r\n");
      out.write("\t\t\t    \t   ,singleSelcet:true\r\n");
      out.write("\t\t\t    \t   //index는 0부터 카운트 됨\r\n");
      out.write("\t\t\t    \t   //getSelectedrow\r\n");
      out.write("\t\t\t    \t   //활용예)row.address, row.zipcode\r\n");
      out.write("\t\t\t    \t   ,onSelect:function(index,row){\r\n");
      out.write("\t\t\t    \t\t   var row=$(this).datagrid('getSelected');\r\n");
      out.write("\t\t\t    \t\t   g_address=row.address\r\n");
      out.write("\t\t\t    \t\t   $('#mem_addr').textbox('setValue',g_address);\r\n");
      out.write("\t\t\t    \t   }\r\n");
      out.write("\t\t\t    \t   ,onDblClickCell: function(index,field,value){\r\n");
      out.write("\t\t\t    \t\t   \t\t//alert(index+\",\"+field+\",\"+value);\r\n");
      out.write("\t\t\t    \t\t   \t\tif('zipcode'==field){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//우편번호 textbox에 출력 id\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#mem_zipcode').textbox('setValue',value);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#dg_zipcode').datagrid('clearSelections');\r\n");
      out.write("\t\t\t    \t\t   \t\t}\r\n");
      out.write("\t\t\t    \t\t   \t $('#dlg_zipcode').dialog('close');\r\n");
      out.write("\t\t\t    \t\t}\r\n");
      out.write("\t\t\t    \t});//////////end of datagrid\r\n");
      out.write("\t\t\t    }////////////////end of enter key\r\n");
      out.write("\t\t\t});//////////////////end of textbox \r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t\t $('#btn_search').linkbutton({\r\n");
      out.write("\t\t\t\tonClick : function() {\r\n");
      out.write("\t\t\t\t\tvar u_dong=$('#dong').val();\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\tmethod: 'get'\r\n");
      out.write("\t\t\t\t\t   ,url:'./zipcodeList.kos?work=member&dong='+u_dong\r\n");
      out.write("\t\t\t\t\t   ,success:function(data){\r\n");
      out.write("\t\t\t\t\t\t   //alert('data: '+data);\r\n");
      out.write("\t\t\t\t\t\t   $(\"#dg_zipcode\").datagrid({\r\n");
      out.write("\t\t\t\t\t\t\t   url:'./zipcodeList.kos?work=member&dong='+u_dong\r\n");
      out.write("\t\t\t\t\t\t   });\r\n");
      out.write("\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});  \r\n");
      out.write("\t\t \t$('#btn_zip').linkbutton({\r\n");
      out.write("\t\t\t\tonClick : function() {\r\n");
      out.write("\t\t\t\t\t$('#dlg_zip').dialog('open');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}); \r\n");
      out.write("\t\t\t $('#btn_del').linkbutton({\r\n");
      out.write("\t\t\t\tonClick : function() {\r\n");
      out.write("\t\t\t\t\t\t$('#f_del').attr('method','GET');\r\n");
      out.write("\t\t\t\t\t\t$('#f_del').attr('action','./memberDelete.kos');\r\n");
      out.write("\t\t\t\t\t\t$('#f_del').submit();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}); \r\n");
      out.write("\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"dg_member\"></table>\r\n");
      out.write("\t  <!-- 테이블 안에 들어갈 링크버튼 추가 -->\r\n");
      out.write("\t<div id=\"tb_member\" style=\"padding: 5px;\">\r\n");
      out.write("\t\t<a id=\"btn_ins\" href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-add',plain:true\">가입 </a>\r\n");
      out.write("\t\t\t<a id=\"btn_del\" href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-cancel',plain:true\">삭제 </a>\r\n");
      out.write("\t</div> \r\n");
      out.write("\t<!--\r\n");
      out.write("\t사용자가 화면에 입력한 값을 서버측에 전달할 때는 name 속성이 반드시 필요하다.\r\n");
      out.write("\t입력받는 컴포넌트에 값이 담기기 때문에 반드시 form 전송으로 처리한다.\r\n");
      out.write("\tform태그는 여러개를 사용할 수 있고 아이디로 구분하여 서로 다른 서버 계층으로 전송이 가능하다.\r\n");
      out.write("\t화면에는 존재하지 않지만 개발자가 업무 처리를 위한 목적으로 따로 전달하고 싶은 정보가 있을 때도 form 태그 사용\r\n");
      out.write("\t이 때 사용하는 컴포넌트는 hidden 속성으로 처리한다.\r\n");
      out.write("\thidden 속성은 input type text 속성과 동일하게 사용하면 된다.\r\n");
      out.write("\t아이디와 이름 속성을 반드시 부여하여 서버에 전송할 때와 ajax 처리 할 때를 준비해 둔다.\r\n");
      out.write("\t아이디는 절대로 중복되면 안된다.\r\n");
      out.write("\t실제 서버로 전송할 때는 form 태그에 메소드 방식과 목적지를 기술하지 말고\r\n");
      out.write("\tjquery api를 사용하여 필수 처리 한다.\r\n");
      out.write("\t화면에 담겨있는 정보들은 가독성이 떨어지고 화면 내용이 많아지게 되면 찾기가 불편함.\r\n");
      out.write("\t -->\r\n");
      out.write("\t <!-- =========================우편번호 검색기 ========================이 부분 때문에 점이 생김-->\r\n");
      out.write("  \t \t<div id=\"dlg_zip\" style=\"paddion:30px 60px;\">\r\n");
      out.write("\t \t\t<input class=\"easyui-textbox\" id=\"dong\" name=\"dong\" data-options=\"prompt:'Enter a Dong'\" labelPosition=\"top\" style=\"width:70%\"/>\r\n");
      out.write("\t\t\t<a id=\"btn_search\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search',plain:true\">우편번호검색</a> \r\n");
      out.write("\t\t\t<div style='margin-bottom:10px'></div>\r\n");
      out.write("\t \t\t<table border=\"1\" id=\"dg_zipcode\"></table>\r\n");
      out.write("\t \t</div> \r\n");
      out.write("\t<!-- =========================우편번호 검색기 ========================-->\r\n");
      out.write("\t<!-- =========================  회원삭제\t =========================-->\r\n");
      out.write("\t<form id=\"f_del\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"work\" name=\"work\" value=\"member\"/><!-- id 브라우저(화면) name 서버 value =값 -->\r\n");
      out.write("\t</form> \r\n");
      out.write("\t<!-- =========================  회원삭제  =========================-->\r\n");
      out.write("\t<!--==========================  회원가입  =========================-->\r\n");
      out.write("\t<div id=\"dlg_ins\" class=\"easyui-dialog\" style=\"padding: 30px 60px;\">\r\n");
      out.write("\t\t<form id=\"f_ins\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"work\" name=\"work\" value=\"member\"> <!--  id 브라우저(화면) name 서버 value =값-->\r\n");
      out.write("\t\t\t<div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"mem_id\" name=\"mem_id\" label=\"ID\" labelPosition=\"top\" style=\"width:70%;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"mem_name\" name=\"mem_name\" label=\"Name\" labelPosition=\"top\" style=\"width:70%;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t <div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"mem_addr\" name=\"mem_addr\" label=\"Address\" labelPosition=\"top\" style=\"width:70%;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"mem_zipcode\" name=\"mem_zipcode\" label=\"Zipcode\" labelPosition=\"top\" style=\"width:70%;\">\r\n");
      out.write("\t\t\t\t<a id=\"btn_zip\" href=\"#\" class=\"easyui-linkbutton\">우편번호 </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-passwordbox\" id=\"mem_pw\" name=\"mem_pw\" label=\"Password\" labelPosition=\"top\" style=\"width:70%;\">\r\n");
      out.write("\t\t\t</div> \r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div> \r\n");
      out.write("\t<!-- 회원가입 텍스트박스 -->\r\n");
      out.write("\t<div id=\"tb_ins\" style=\"padding: 5px;\">\r\n");
      out.write("\t\t<a id=\"btn_save\" href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-save',plain:true\">저장 </a> \r\n");
      out.write("\t\t<a id=\"btn_close\" href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-cancel',plain:true\">닫기</a>\r\n");
      out.write("\t</div> \r\n");
      out.write("\t<!--=================회원가입====================-->\r\n");
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
