package org.apache.jsp.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nav_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>欢迎使用Java第二课堂后台管理程序</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/admin/main.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.cms.core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#left\").myaccordion();\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"left\">\r\n");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isAdmin }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("<ul class=\"navMenu navSelected\">\r\n");
          out.write("\t<h3 class=\"navTitle\">\r\n");
          out.write("\t\t<span class=\"navTilteTxt\">用户管理</span>\r\n");
          out.write("\t</h3>\r\n");
          out.write("\t<li class=\"navChild\">\r\n");
          out.write("\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/user/users\" target=\"content\">用户信息管理</a>\r\n");
          out.write("\t</li>\r\n");
          out.write("\t<li class=\"navChild\">\r\n");
          out.write("\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/group/groups\" target=\"content\">用户组管理</a>\r\n");
          out.write("\t</li>\r\n");
          out.write("\t<li class=\"navChild\">\r\n");
          out.write("\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/role/roles\" target=\"content\">用户角色管理</a>\r\n");
          out.write("\t</li>\r\n");
          out.write("</ul>\r\n");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\r\n");
      out.write("<ul class=\"navMenu navSelected\">\r\n");
      out.write("\t<h3 class=\"navTitle\">\r\n");
      out.write("\t\t<span class=\"navTilteTxt\">文章管理</span>\r\n");
      out.write("\t</h3>\r\n");
      out.write("\t");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_1.setPageContext(_jspx_page_context);
      _jspx_th_c_if_1.setParent(null);
      _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isAdmin }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
      if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t<li class=\"navChild\">\r\n");
          out.write("\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/channel/channels\" target=\"content\">栏目信息管理</a>\r\n");
          out.write("\t</li>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      out.write("\r\n");
      out.write("\t<li class=\"navChild\">\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/admin/topic/audits\" target=\"content\">文章信息管理</a>\r\n");
      out.write("\t</li>\r\n");
      out.write("</ul>\r\n");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_2.setPageContext(_jspx_page_context);
      _jspx_th_c_if_2.setParent(null);
      _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isAdmin }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
      if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t<ul class=\"navMenu navSelected\">\r\n");
          out.write("\t\t<h3 class=\"navTitle\">\r\n");
          out.write("\t\t\t<span class=\"navTilteTxt\">系统配置</span>\r\n");
          out.write("\t\t</h3>\r\n");
          out.write("\t\t<li class=\"navChild\">\r\n");
          out.write("\t\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/cmsLink/links\" target=\"content\">超级链接管理</a>\r\n");
          out.write("\t\t</li>\r\n");
          out.write("\t\t<li class=\"navChild\">\r\n");
          out.write("\t\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/system/baseinfo\" target=\"content\">网站信息管理</a>\r\n");
          out.write("\t\t</li>\r\n");
          out.write("\t\t<li class=\"navChild\">\r\n");
          out.write("\t\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/pic/indexPics\" target=\"content\">首页图片管理</a>\r\n");
          out.write("\t\t</li>\r\n");
          out.write("\t\t<li class=\"navChild\">\r\n");
          out.write("\t\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/backups\" target=\"content\">网站数据备份</a>\r\n");
          out.write("\t\t</li>\r\n");
          out.write("\t\t<li class=\"navChild\">\r\n");
          out.write("\t\t\t<a href=\"");
          out.print(request.getContextPath() );
          out.write("/admin/system/cleans\" target=\"content\">系统清理管理</a>\r\n");
          out.write("\t\t</li>\r\n");
          out.write("\t</ul>\r\n");
          int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
