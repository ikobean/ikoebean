/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-07-19 03:27:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberMgrVer2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/member/../common/JEasyUICommon.jsp", Long.valueOf(1563429224306L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>회원관리</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function (){\r\n");
      out.write("\t\t$('#dg_member').datagrid({\r\n");
      out.write("\t\t\turl:\"memberList.kos\",\r\n");
      out.write("\t\t\ttitle:\"회원관리 ver1.0\",\r\n");
      out.write("\t\t\ttoolbar:\"#tb_member\",\r\n");
      out.write("\t\t    columns:[[\r\n");
      out.write("\t\t        {field:'MEM_ID',title:'아이디',width:150},\r\n");
      out.write("\t\t        {field:'MEM_NAME',title:'이름',width:150},\r\n");
      out.write("\t\t        {field:'MEM_ADDR',title:'주소',width:300,align:'left'}\r\n");
      out.write("\t\t    ]]\r\n");
      out.write("\t\t});///////////end of datagrid\r\n");
      out.write("\t\t$('#dlg_ins').dialog({\r\n");
      out.write("\t\t\ttitle:\"회원가입\"\r\n");
      out.write("\t\t   ,width:500\r\n");
      out.write("\t\t   ,height: 550\r\n");
      out.write("\t\t   ,footer:\"#tb_ins\"\r\n");
      out.write("\t\t   ,closed:false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#btn_save').linkbutton({\r\n");
      out.write("\t\t\tonClick:function(){\r\n");
      out.write("\t\t\t\t//alert('save');\r\n");
      out.write("\t\t\t\t$('#dlg_ins').dialog('close');\r\n");
      out.write("\t\t\t\t$('#f_ins').attr('method','get');\r\n");
      out.write("\t\t\t\t$('#f_ins').attr('action','./memberInsert.kos');\r\n");
      out.write("\t\t\t\t$('#f_ins').submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#btn_close').linkbutton({\r\n");
      out.write("\t\t\tonClick:function(){\r\n");
      out.write("\t\t\t\talert('close');\r\n");
      out.write("\t\t\t\t$('#dlg_ins').dialog('close');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<table id=\"dg_member\"></table>\r\n");
      out.write("<div id=\"tb_member\" style=\"padding:5px;\">\r\n");
      out.write("<a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\">가입</a>\r\n");
      out.write("</div>\r\n");
      out.write("<!--======================= 회원가입 =======================-->\r\n");
      out.write("<div id=\"dlg_ins\" style=\"width:100%;max-width:480px;padding:30px 60px;\">\r\n");
      out.write("<!-- \r\n");
      out.write("사용자가 화면에 입력한 값을 서버측에 전달할 때는 name속성이 반드시 필요하다.\r\n");
      out.write("입력받는 컴포넌트에 값이 담기기 때문에 반드시 form전송으로 처리한다.\r\n");
      out.write("form태그는 여러개를 사용할 수 있고 아이디로 구분하여 서로 다른 서버 계층으로 \r\n");
      out.write("전송이 가능하다.\r\n");
      out.write("화면에는 존재하지 않지만 개발자가 업무처리를 위한 목적으로 따로 전달하고 싶은 \r\n");
      out.write("정보가 있을 때도 form태그를 사용할 것.\r\n");
      out.write("이때 사용하는 컴포넌트는 hidden 속성으로 처리한다.\r\n");
      out.write("hidden속성은 input type text속성과 동일하게 사용하면 된다.\r\n");
      out.write("아이디와 이름 속성을 반드시시 부여 하여\r\n");
      out.write("서버에 전송할 때와 ajax처리 할 때를 준비해 둔다.\r\n");
      out.write("아이디는 절대로 중복되면 안된다.\r\n");
      out.write("실제 서버로 전송할 때는 form태그에 메소드 방식과 목적지를 기술하지 말고\r\n");
      out.write("jquery api를 사용하여 함수 처리한다.\r\n");
      out.write("화면에 담겨 있는 정보들은 가독성이 떨어지고 화면 내용이 많아지게 되면\r\n");
      out.write("찾기가 불편함.\r\n");
      out.write(" \r\n");
      out.write(" -->\r\n");
      out.write("\t<form id=\"f_ins\">    \r\n");
      out.write("\t\t<input type=\"hidden\" id=\"work\" name=\"work\" value=\"member\"/>\r\n");
      out.write("     <div style=\"margin-bottom:10px\">\r\n");
      out.write("         <input class=\"easyui-textbox\" id=\"mem_id\" name=\"mem_id\" label=\"아이디:\" labelPosition=\"top\" data-options=\"prompt:'Enter a ID'\" style=\"width:110px;\">\r\n");
      out.write("     </div>\r\n");
      out.write("     <div style=\"margin-bottom:10px\">\r\n");
      out.write("         <input class=\"easyui-textbox\" id=\"mem_name\" name=\"mem_name\" label=\"이름:\" labelPosition=\"top\" data-options=\"prompt:'Enter a Name'\" style=\"width:150px;\">\r\n");
      out.write("     </div>\r\n");
      out.write("     <div style=\"margin-bottom:10px\">\r\n");
      out.write("         <input class=\"easyui-textbox\" id=\"mem_zipcode\" name=\"mem_zipcode\" label=\"우편번호:\" labelPosition=\"top\" data-options=\"prompt:'Enter a ZipCode'\" style=\"width:100px;\">\r\n");
      out.write("     </div>\r\n");
      out.write("     <div style=\"margin-bottom:10px\">\r\n");
      out.write("         <input class=\"easyui-textbox\" id=\"mem_addr\" name=\"mem_addr\" label=\"주소:\" labelPosition=\"top\" data-options=\"prompt:'Enter a ADDRESS'\" style=\"width:300px;\">\r\n");
      out.write("     </div>\r\n");
      out.write("     <div style=\"margin-bottom:10px\">\r\n");
      out.write("         <input class=\"easyui-textbox\" id=\"mem_pw\" name=\"mem_pw\" label=\"비번:\" labelPosition=\"top\" data-options=\"prompt:'Enter a PASSWORD'\" style=\"width:110px;\">\r\n");
      out.write("     </div>\r\n");
      out.write("     </form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"tb_ins\" style=\"padding:5px;\">\r\n");
      out.write("<a id=\"btn_save\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-save'\">저장</a>\r\n");
      out.write("<a id=\"btn_close\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-cancel'\">닫기</a>\r\n");
      out.write("</div>\r\n");
      out.write("<!--======================= 회원가입 =======================-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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