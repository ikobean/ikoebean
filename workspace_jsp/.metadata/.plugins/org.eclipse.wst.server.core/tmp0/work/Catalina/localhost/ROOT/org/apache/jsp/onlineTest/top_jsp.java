/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-08-10 06:59:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onlineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">자바52기</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("      <li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("      <li><a href=\"#\">소개</a></li>\r\n");
      out.write("      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Front-End노트<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"#\">HTML5</a></li>\r\n");
      out.write("          <li><a href=\"javascript:pageChange()\">CSS</a></li>\r\n");
      out.write("          <li><a href=\"#\">JavaScript</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Back-End노트<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"#\">Java</a></li>\r\n");
      out.write("          <li><a href=\"#\">서블릿</a></li>\r\n");
      out.write("          <li><a href=\"#\">JSP</a></li>\r\n");
      out.write("          <li><a href=\"#\">Spring</a></li>\r\n");
      out.write("          <li><a href=\"#\">안드로이드</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("      \r\n");
      out.write("  \r\n");
      out.write(" <!-- \r\n");
      out.write(" ===========================================================================================\r\n");
      out.write(" \t\t\t\t\t온라인 시험 솔루션 실습 - 자격시험 메뉴 추가\r\n");
      out.write(" ===========================================================================================\r\n");
      out.write("  -->    \r\n");
      out.write("        <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">자격시험<span class=\"caret\"></span></a>\r\n");
      out.write("        <ul class=\"dropdown-menu\">\r\n");
      out.write("          <li><a href=\"./testReceipt.jsp\">자격시험 접수</a></li>\r\n");
      out.write("          <li><a href=\"./reGoTest.jsp\">자격시험 보기</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </li>\r\n");
      out.write("  \r\n");
      out.write(" <!-- \r\n");
      out.write(" ===========================================================================================\r\n");
      out.write(" \t\t\t\t\t온라인 시험 솔루션 실습 - 자격시험 메뉴 추가\r\n");
      out.write(" ===========================================================================================\r\n");
      out.write(" -->    \r\n");
      out.write("     </ul>\r\n");
      out.write("<!-- 로그인 화면 처리 -->    \r\n");
      out.write("     <div id=\"loginForm\" class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        <form class=\"navbar-form navbar-right\">\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"mem_id\" name=\"mem_id\" size=\"10\" placeholder=\"아이디\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"mem_pw\" name=\"mem_pw\" size=\"10\" placeholder=\"비밀번호\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-dark\" onclick=\"loginAction()\">Login</button>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("<!-- 로그인 화면 처리 --> \r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("</nav>\r\n");
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
