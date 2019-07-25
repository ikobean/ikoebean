/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-24 07:14:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch09.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/ch09/cookie/../../common/JEasyUICommon.jsp", Long.valueOf(1563935568698L));
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
      out.write("<!--\r\n");
      out.write("==========================이곳은 쿠키폴더 입니다========================\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
	
	String dap1 = request.getParameter("dap1");
	Cookie cookie = new Cookie("dap1",dap1);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>문제2</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css?1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t//멀티선택을 배제하기 위한 함수 선언\r\n");
      out.write("\tfunction answer(p_dap){ //p_dap 은 변수이고 1,2,3,4 \r\n");
      out.write("\t\t//브라우저가 돔 구성시 같은 이름이면 자동으로 배열로 변환해 줌.\r\n");
      out.write("\t\tfor(var i=0;i<document.getElementById(\"f_test2\").cb.length;i++){\r\n");
      out.write("\t\t\tif(p_dap==i){\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"f_test2\").cb[i].checked=1;\r\n");
      out.write("\t\t\t\t//1이면 체크가 되어있는 것. 0이면 체크가 안되어 있는 것\r\n");
      out.write("\t\t\t}else{//체크가 안되어 있는 애들 \r\n");
      out.write("\t\t\t\tdocument.getElementById(\"f_test2\").cb[i].checked=0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction prev(){\r\n");
      out.write("\t\tlocation.href=\"test1.jsp?dap1=");
      out.print(dap1);
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//다음 문제 선택시 이전 문제 답안지 기억하기 - hidden 속성에\r\n");
      out.write("\tfunction next(){\r\n");
      out.write("\t\tvar temp=1;\r\n");
      out.write("\t\tfor(var i=0;i<document.getElementById(\"f_test2\").cb.length;i++){\r\n");
      out.write("\t\t\tif(document.getElementById(\"f_test2\").cb[i].checked==1){\r\n");
      out.write("\t\t\t\t//두번째 꺼 선택했을 때는 2가 돼야하니까 else에서 1더하기 . dap1(hidden)에 담아주기.\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"f_test2\").dap2.value = temp;\r\n");
      out.write("\t\t\t\t//alert(\"값\"+document.getElementById(\"f_test2\").dap1.value)\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\ttemp = temp + 1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"f_test2\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<div class=\"easyui-panel\" style=\"width:600px;height:500px;padding:20px\"\r\n");
      out.write("\t\ttitle=\"문제2\" data-options=\"footer:'#footer'\">\r\n");
      out.write("\t\t<form id=\"f_test2\" method=\"get\" action=\"test3.jsp\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"dap2\" name=\"dap2\"/>\r\n");
      out.write("\t\t다음 중에서 자바에서 제공하는 타입이 아닌것은?\r\n");
      out.write("\t\t<div style=\"margin-bottom=20px\"></div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<input type=\"checkbox\" name=\"cb\" value=\"1\" onChange=\"answer(0)\">\r\n");
      out.write("\t\t1.int\r\n");
      out.write("\t\t<div style=\"margin-bottom=20px\"></div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<input type=\"checkbox\" name=\"cb\" value=\"2\" onChange=\"answer(1)\">\r\n");
      out.write("\t\t2.String\r\n");
      out.write("\t\t<div style=\"margin-bottom=20px\"></div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t    <input type=\"checkbox\" name=\"cb\" value=\"3\" onChange=\"answer(2)\">\r\n");
      out.write("\t    3.varchar2\r\n");
      out.write("\t    <div style=\"margin-bottom=20px\"></div>\r\n");
      out.write("\t    <br>\r\n");
      out.write("\t\t<input type=\"checkbox\" name=\"cb\" value=\"4\" onChange=\"answer(3)\">\r\n");
      out.write("\t\t4.Object\r\n");
      out.write("\t\t<div style=\"margin-bottom=20px\" ></div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div id=\"footer\" style=\"padding:5px;\">\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("       \t\t\t<a href=\"javascript:prev()\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-before',iconAlign:'left'\" >이전</a>\r\n");
      out.write("       \t\t</span>\r\n");
      out.write("       \t\t<span style=\"float:right\">\r\n");
      out.write("\t        \t<a href=\"javascript:next()\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-next',iconAlign:'right'\">다음</a>\r\n");
      out.write("        \t</span>\r\n");
      out.write("        </div>\r\n");
      out.write("\t</div>\r\n");
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
