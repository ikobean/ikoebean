/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-31 06:12:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onlineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vo.MemberVO;

public final class testReceipt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/onlineTest/../common/JEasyUICommon.jsp", Long.valueOf(1564466205580L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.vo.MemberVO");
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

	MemberVO mVO = (MemberVO)session.getAttribute("rmVO");
	String s_memid = null;
	String s_memname = null;
	if(mVO!=null){
		s_memid = mVO.getMem_id();
		s_memname = mVO.getMem_name();
	}


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction receipt(){\r\n");
      out.write("\t\t$(\"#f_receipt\").attr(\"method\",\"GET\");\r\n");
      out.write("\t\t$(\"#f_receipt\").attr(\"action\",\"examReceipt.kos\");\r\n");
      out.write("\t\t$(\"#f_receipt\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<title>자격시험 접수 - 정보처리기사</title>\r\n");
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
      out.write("\t\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\t\tvar d = date.getDate();\r\n");
      out.write("\t\t\treturn y+'-'+(m<10 ?(\"0\"+m):m)+'-'+(d<10 ?(\"0\"+d):d);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\t\treturn new Date(t);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn new Date();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$(\"#mem_name\").textbox('setValue','");
      out.print(s_memname);
      out.write("');\r\n");
      out.write("\t \t\t$('#cb_subject').combobox({\r\n");
      out.write("\t      \t\t  url:'/onlineTest/subjectList.kos?work=onlineTest',\r\n");
      out.write("\t      \t\t  valueField:'SUB_CD',  //서버에 넘어가는 값\r\n");
      out.write("\t      \t\t  textField:'SUB_NAME', //화면에 출력되는 값\r\n");
      out.write("\t      \t\t  paneHeight:'auto',\r\n");
      out.write("\t      \t\t  onSelect:function(record){\r\n");
      out.write("\t      \t\t\t  alert(record.SUB_NAME);\r\n");
      out.write("\t      \t\t  }\r\n");
      out.write("\t \t\t});\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t <div class=\"easyui-panel\" \r\n");
      out.write("\t \t  id=\"pl_takeatest\" \r\n");
      out.write("\t \t  title=\"자격시험 접수\" \r\n");
      out.write("\t \t  style=\"width:70%;\r\n");
      out.write("\t \t  max-width:600px\r\n");
      out.write("\t \t  ;padding:30px 30px\" >\r\n");
      out.write("\t \t  \r\n");
      out.write("\t \t\t<!-- jquery에서 제공하는 attr()메소드에 쿼리스트링은 값이 넘어가지 않음 : hidden 처리 -->\r\n");
      out.write("\t\t<form id=\"f_receipt\">\t \r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"mem_id\" name=\"mem_id\" value=\"");
      out.print(s_memid);
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"work\" name=\"work\" value=\"onlineTest\"> \r\n");
      out.write("\t\t\t<div style=\"margin-bottom:30px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" \r\n");
      out.write("\t\t\t\t\t   id=\"mem_name\" \r\n");
      out.write("\t\t\t\t\t   name=\"mem_name\" \r\n");
      out.write("\t\t\t\t\t   label=\"이름\" \r\n");
      out.write("\t\t\t\t\t   labelPosition=\"top\" \r\n");
      out.write("\t\t\t\t\t   style=\"width:70%;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t \t  \r\n");
      out.write("\t\t\t<div style=\"margin-bottom:30px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-datebox\" \r\n");
      out.write("\t\t\t\t\t   id=\"exam_date\" \r\n");
      out.write("\t\t\t\t\t   name=\"exam_date\" \r\n");
      out.write("\t\t\t\t\t   label=\"응시일자\" \r\n");
      out.write("\t\t\t\t\t   labelPosition=\"top\" \r\n");
      out.write("\t\t\t\t\t   style=\"width:70%;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t \t  \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t\t\t<select class=\"easyui-combobox\" \r\n");
      out.write("\t\t\t\t\t\t\tid=\"cb_subject\" \r\n");
      out.write("\t\t\t\t\t\t\tname=\"sub_cd\" \r\n");
      out.write("\t\t\t\t\t\t\tlabel=\"수험 과목 선택: \" \r\n");
      out.write("\t\t\t\t\t\t\tlabelPosition=\"top\" \r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width:70%;\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"prompt:'수험 과목을 선택하세요.'\">\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<a id=\"btn_start\" \r\n");
      out.write("\t\t\t\t\t   href=\"javascript:receipt()\" \r\n");
      out.write("\t\t\t\t\t   class=\"easyui-linkbutton\" \r\n");
      out.write("\t\t\t\t\t   iconCls=\"icon-ok\" \r\n");
      out.write("\t\t\t\t\t   style=\"width:70%;\">접수</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"margin-bottom:20px\"></div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
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
