package org.apache.jsp.WEB_002dINF.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_form_modelAttribute_method_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_password_size_path_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_select_path;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_errors_path_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_option_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_errors_path_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sf_input_size_path_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sf_form_modelAttribute_method_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_password_size_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_select_path = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_errors_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_option_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_errors_path_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sf_input_size_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sf_form_modelAttribute_method_id.release();
    _jspx_tagPool_sf_password_size_path_nobody.release();
    _jspx_tagPool_sf_select_path.release();
    _jspx_tagPool_sf_errors_path_nobody.release();
    _jspx_tagPool_sf_option_value.release();
    _jspx_tagPool_sf_errors_path_cssClass_nobody.release();
    _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody.release();
    _jspx_tagPool_sf_input_size_path_nobody.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/admin/main.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/validate/main.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/jquery-1.7.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/core/jquery.cms.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\"#addForm\").cmsvalidate();\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<h3 class=\"admin_link_bar\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "inc.jsp", out, false);
      out.write("\r\n");
      out.write("\t</h3>\r\n");
      out.write("\t");
      //  sf:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_sf_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_sf_form_modelAttribute_method_id.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_sf_form_0.setPageContext(_jspx_page_context);
      _jspx_th_sf_form_0.setParent(null);
      _jspx_th_sf_form_0.setMethod("post");
      _jspx_th_sf_form_0.setModelAttribute("userDto");
      _jspx_th_sf_form_0.setId("addForm");
      int[] _jspx_push_body_count_sf_form_0 = new int[] { 0 };
      try {
        int _jspx_eval_sf_form_0 = _jspx_th_sf_form_0.doStartTag();
        if (_jspx_eval_sf_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t<table width=\"800\" cellspacing=\"0\" cellPadding=\"0\">\r\n");
            out.write("\t\t<thead><tr><td colspan=\"2\">添加用户功能</td></tr></thead>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\" width=\"200px\">用户名(必须是英文):</td>\r\n");
            out.write("\t\t\t<td class=\"leftTd\">");
            if (_jspx_meth_sf_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            //  sf:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_sf_errors_0 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_sf_errors_path_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_sf_errors_0.setPageContext(_jspx_page_context);
            _jspx_th_sf_errors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
            _jspx_th_sf_errors_0.setCssClass("errorContainer");
            _jspx_th_sf_errors_0.setPath("username");
            int[] _jspx_push_body_count_sf_errors_0 = new int[] { 0 };
            try {
              int _jspx_eval_sf_errors_0 = _jspx_th_sf_errors_0.doStartTag();
              if (_jspx_th_sf_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_sf_errors_0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_sf_errors_0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_sf_errors_0.doFinally();
              _jspx_tagPool_sf_errors_path_cssClass_nobody.reuse(_jspx_th_sf_errors_0);
            }
            out.write("</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">显示名称(可以是中文):</td><td class=\"leftTd\">");
            if (_jspx_meth_sf_input_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">用户密码:</td><td>");
            if (_jspx_meth_sf_password_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            //  sf:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_sf_errors_1 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_sf_errors_path_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_sf_errors_1.setPageContext(_jspx_page_context);
            _jspx_th_sf_errors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
            _jspx_th_sf_errors_1.setCssClass("errorContainer");
            _jspx_th_sf_errors_1.setPath("password");
            int[] _jspx_push_body_count_sf_errors_1 = new int[] { 0 };
            try {
              int _jspx_eval_sf_errors_1 = _jspx_th_sf_errors_1.doStartTag();
              if (_jspx_th_sf_errors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_sf_errors_1[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_sf_errors_1.doCatch(_jspx_exception);
            } finally {
              _jspx_th_sf_errors_1.doFinally();
              _jspx_tagPool_sf_errors_path_cssClass_nobody.reuse(_jspx_th_sf_errors_1);
            }
            out.write("</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">确认密码:</td><td><input type=\"password\" id=\"confirmPwd\" name=\"confirmPwd\" size=\"30\"/></td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">联系电话:</td><td>");
            if (_jspx_meth_sf_input_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">电子邮件:</td><td>");
            if (_jspx_meth_sf_input_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            //  sf:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_sf_errors_2 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_sf_errors_path_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_sf_errors_2.setPageContext(_jspx_page_context);
            _jspx_th_sf_errors_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
            _jspx_th_sf_errors_2.setPath("email");
            int[] _jspx_push_body_count_sf_errors_2 = new int[] { 0 };
            try {
              int _jspx_eval_sf_errors_2 = _jspx_th_sf_errors_2.doStartTag();
              if (_jspx_th_sf_errors_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_sf_errors_2[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_sf_errors_2.doCatch(_jspx_exception);
            } finally {
              _jspx_th_sf_errors_2.doFinally();
              _jspx_tagPool_sf_errors_path_nobody.reuse(_jspx_th_sf_errors_2);
            }
            out.write("</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td class=\"rightTd\">状态:</td>\r\n");
            out.write("\t\t\t<td>\r\n");
            out.write("\t\t\t\t");
            //  sf:select
            org.springframework.web.servlet.tags.form.SelectTag _jspx_th_sf_select_0 = (org.springframework.web.servlet.tags.form.SelectTag) _jspx_tagPool_sf_select_path.get(org.springframework.web.servlet.tags.form.SelectTag.class);
            _jspx_th_sf_select_0.setPageContext(_jspx_page_context);
            _jspx_th_sf_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
            _jspx_th_sf_select_0.setPath("status");
            int[] _jspx_push_body_count_sf_select_0 = new int[] { 0 };
            try {
              int _jspx_eval_sf_select_0 = _jspx_th_sf_select_0.doStartTag();
              if (_jspx_eval_sf_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  sf:option
                  org.springframework.web.servlet.tags.form.OptionTag _jspx_th_sf_option_0 = (org.springframework.web.servlet.tags.form.OptionTag) _jspx_tagPool_sf_option_value.get(org.springframework.web.servlet.tags.form.OptionTag.class);
                  _jspx_th_sf_option_0.setPageContext(_jspx_page_context);
                  _jspx_th_sf_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_select_0);
                  _jspx_th_sf_option_0.setValue(new String("0"));
                  int[] _jspx_push_body_count_sf_option_0 = new int[] { 0 };
                  try {
                    int _jspx_eval_sf_option_0 = _jspx_th_sf_option_0.doStartTag();
                    if (_jspx_eval_sf_option_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      java.lang.Object value = null;
                      java.lang.String displayValue = null;
                      if (_jspx_eval_sf_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                        out = _jspx_page_context.pushBody();
                        _jspx_push_body_count_sf_option_0[0]++;
                        _jspx_th_sf_option_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                        _jspx_th_sf_option_0.doInitBody();
                      }
                      value = (java.lang.Object) _jspx_page_context.findAttribute("value");
                      displayValue = (java.lang.String) _jspx_page_context.findAttribute("displayValue");
                      do {
                        out.write('停');
                        out.write('用');
                        int evalDoAfterBody = _jspx_th_sf_option_0.doAfterBody();
                        value = (java.lang.Object) _jspx_page_context.findAttribute("value");
                        displayValue = (java.lang.String) _jspx_page_context.findAttribute("displayValue");
                        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                          break;
                      } while (true);
                      if (_jspx_eval_sf_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                        out = _jspx_page_context.popBody();
                        _jspx_push_body_count_sf_option_0[0]--;
                    }
                    if (_jspx_th_sf_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      return;
                    }
                  } catch (Throwable _jspx_exception) {
                    while (_jspx_push_body_count_sf_option_0[0]-- > 0)
                      out = _jspx_page_context.popBody();
                    _jspx_th_sf_option_0.doCatch(_jspx_exception);
                  } finally {
                    _jspx_th_sf_option_0.doFinally();
                    _jspx_tagPool_sf_option_value.reuse(_jspx_th_sf_option_0);
                  }
                  out.write("\r\n");
                  out.write("\t\t\t\t\t");
                  //  sf:option
                  org.springframework.web.servlet.tags.form.OptionTag _jspx_th_sf_option_1 = (org.springframework.web.servlet.tags.form.OptionTag) _jspx_tagPool_sf_option_value.get(org.springframework.web.servlet.tags.form.OptionTag.class);
                  _jspx_th_sf_option_1.setPageContext(_jspx_page_context);
                  _jspx_th_sf_option_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_select_0);
                  _jspx_th_sf_option_1.setValue(new String("1"));
                  int[] _jspx_push_body_count_sf_option_1 = new int[] { 0 };
                  try {
                    int _jspx_eval_sf_option_1 = _jspx_th_sf_option_1.doStartTag();
                    if (_jspx_eval_sf_option_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      java.lang.Object value = null;
                      java.lang.String displayValue = null;
                      if (_jspx_eval_sf_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                        out = _jspx_page_context.pushBody();
                        _jspx_push_body_count_sf_option_1[0]++;
                        _jspx_th_sf_option_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                        _jspx_th_sf_option_1.doInitBody();
                      }
                      value = (java.lang.Object) _jspx_page_context.findAttribute("value");
                      displayValue = (java.lang.String) _jspx_page_context.findAttribute("displayValue");
                      do {
                        out.write('启');
                        out.write('用');
                        int evalDoAfterBody = _jspx_th_sf_option_1.doAfterBody();
                        value = (java.lang.Object) _jspx_page_context.findAttribute("value");
                        displayValue = (java.lang.String) _jspx_page_context.findAttribute("displayValue");
                        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                          break;
                      } while (true);
                      if (_jspx_eval_sf_option_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                        out = _jspx_page_context.popBody();
                        _jspx_push_body_count_sf_option_1[0]--;
                    }
                    if (_jspx_th_sf_option_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      return;
                    }
                  } catch (Throwable _jspx_exception) {
                    while (_jspx_push_body_count_sf_option_1[0]-- > 0)
                      out = _jspx_page_context.popBody();
                    _jspx_th_sf_option_1.doCatch(_jspx_exception);
                  } finally {
                    _jspx_th_sf_option_1.doFinally();
                    _jspx_tagPool_sf_option_value.reuse(_jspx_th_sf_option_1);
                  }
                  out.write("\r\n");
                  out.write("\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_sf_select_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_sf_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_sf_select_0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_sf_select_0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_sf_select_0.doFinally();
              _jspx_tagPool_sf_select_path.reuse(_jspx_th_sf_select_0);
            }
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t  <td class=\"rightTd\">角色:</td>\r\n");
            out.write("\t\t\t<td>\r\n");
            out.write("\t\t\t\t");
            out.write("\r\n");
            out.write("\t\t\t\t");
            if (_jspx_meth_sf_checkboxes_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t <td class=\"rightTd\">用户组:</td>\r\n");
            out.write("\t\t\t<td>\r\n");
            out.write("\t\t\t\t");
            out.write("\r\n");
            out.write("\t\t\t\t");
            if (_jspx_meth_sf_checkboxes_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_sf_form_0, _jspx_page_context, _jspx_push_body_count_sf_form_0))
              return;
            out.write("\r\n");
            out.write("\t\t\t</td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t\t<td colspan=\"2\" class=\"centerTd\"><input type=\"submit\" value=\"添加用户\"/><input type=\"reset\"/></td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t</table>\r\n");
            out.write("\t");
            int evalDoAfterBody = _jspx_th_sf_form_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_sf_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sf_form_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sf_form_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sf_form_0.doFinally();
        _jspx_tagPool_sf_form_modelAttribute_method_id.reuse(_jspx_th_sf_form_0);
      }
      out.write("\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_sf_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_0 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_size_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_0.setPath("username");
    _jspx_th_sf_input_0.setSize("30");
    int[] _jspx_push_body_count_sf_input_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_0 = _jspx_th_sf_input_0.doStartTag();
      if (_jspx_th_sf_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_0.doFinally();
      _jspx_tagPool_sf_input_size_path_nobody.reuse(_jspx_th_sf_input_0);
    }
    return false;
  }

  private boolean _jspx_meth_sf_input_1(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_1 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_size_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_1.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_1.setPath("nickname");
    _jspx_th_sf_input_1.setSize("30");
    int[] _jspx_push_body_count_sf_input_1 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_1 = _jspx_th_sf_input_1.doStartTag();
      if (_jspx_th_sf_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_1.doFinally();
      _jspx_tagPool_sf_input_size_path_nobody.reuse(_jspx_th_sf_input_1);
    }
    return false;
  }

  private boolean _jspx_meth_sf_password_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:password
    org.springframework.web.servlet.tags.form.PasswordInputTag _jspx_th_sf_password_0 = (org.springframework.web.servlet.tags.form.PasswordInputTag) _jspx_tagPool_sf_password_size_path_nobody.get(org.springframework.web.servlet.tags.form.PasswordInputTag.class);
    _jspx_th_sf_password_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_password_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_password_0.setPath("password");
    _jspx_th_sf_password_0.setSize("30");
    int[] _jspx_push_body_count_sf_password_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_password_0 = _jspx_th_sf_password_0.doStartTag();
      if (_jspx_th_sf_password_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_password_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_password_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_password_0.doFinally();
      _jspx_tagPool_sf_password_size_path_nobody.reuse(_jspx_th_sf_password_0);
    }
    return false;
  }

  private boolean _jspx_meth_sf_input_2(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_2 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_size_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_2.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_2.setPath("phone");
    _jspx_th_sf_input_2.setSize("30");
    int[] _jspx_push_body_count_sf_input_2 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_2 = _jspx_th_sf_input_2.doStartTag();
      if (_jspx_th_sf_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_2.doFinally();
      _jspx_tagPool_sf_input_size_path_nobody.reuse(_jspx_th_sf_input_2);
    }
    return false;
  }

  private boolean _jspx_meth_sf_input_3(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_sf_input_3 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_sf_input_size_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_sf_input_3.setPageContext(_jspx_page_context);
    _jspx_th_sf_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_input_3.setPath("email");
    _jspx_th_sf_input_3.setSize("30");
    int[] _jspx_push_body_count_sf_input_3 = new int[] { 0 };
    try {
      int _jspx_eval_sf_input_3 = _jspx_th_sf_input_3.doStartTag();
      if (_jspx_th_sf_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_input_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_input_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_input_3.doFinally();
      _jspx_tagPool_sf_input_size_path_nobody.reuse(_jspx_th_sf_input_3);
    }
    return false;
  }

  private boolean _jspx_meth_sf_checkboxes_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:checkboxes
    org.springframework.web.servlet.tags.form.CheckboxesTag _jspx_th_sf_checkboxes_0 = (org.springframework.web.servlet.tags.form.CheckboxesTag) _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody.get(org.springframework.web.servlet.tags.form.CheckboxesTag.class);
    _jspx_th_sf_checkboxes_0.setPageContext(_jspx_page_context);
    _jspx_th_sf_checkboxes_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_checkboxes_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${roles}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_sf_checkboxes_0.setItemLabel("name");
    _jspx_th_sf_checkboxes_0.setItemValue("id");
    _jspx_th_sf_checkboxes_0.setPath("roleIds");
    int[] _jspx_push_body_count_sf_checkboxes_0 = new int[] { 0 };
    try {
      int _jspx_eval_sf_checkboxes_0 = _jspx_th_sf_checkboxes_0.doStartTag();
      if (_jspx_th_sf_checkboxes_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_checkboxes_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_checkboxes_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_checkboxes_0.doFinally();
      _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody.reuse(_jspx_th_sf_checkboxes_0);
    }
    return false;
  }

  private boolean _jspx_meth_sf_checkboxes_1(javax.servlet.jsp.tagext.JspTag _jspx_th_sf_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sf_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sf:checkboxes
    org.springframework.web.servlet.tags.form.CheckboxesTag _jspx_th_sf_checkboxes_1 = (org.springframework.web.servlet.tags.form.CheckboxesTag) _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody.get(org.springframework.web.servlet.tags.form.CheckboxesTag.class);
    _jspx_th_sf_checkboxes_1.setPageContext(_jspx_page_context);
    _jspx_th_sf_checkboxes_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sf_form_0);
    _jspx_th_sf_checkboxes_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${groups }", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_sf_checkboxes_1.setPath("groupIds");
    _jspx_th_sf_checkboxes_1.setItemLabel("name");
    _jspx_th_sf_checkboxes_1.setItemValue("id");
    int[] _jspx_push_body_count_sf_checkboxes_1 = new int[] { 0 };
    try {
      int _jspx_eval_sf_checkboxes_1 = _jspx_th_sf_checkboxes_1.doStartTag();
      if (_jspx_th_sf_checkboxes_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sf_checkboxes_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sf_checkboxes_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sf_checkboxes_1.doFinally();
      _jspx_tagPool_sf_checkboxes_path_items_itemValue_itemLabel_nobody.reuse(_jspx_th_sf_checkboxes_1);
    }
    return false;
  }
}
