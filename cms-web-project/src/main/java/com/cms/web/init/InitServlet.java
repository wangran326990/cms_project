package com.cms.web.init;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cms.basic.util.AuthUtil;
import com.cms.basic.util.BaseInfoUtil;
import com.cms.core.model.BaseInfo;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化spring的工厂
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//初始化权限信息
		Map<String,Set<String>> auths = AuthUtil.initAuth("com.cms.web.controllers");
		this.getServletContext().setAttribute("allAuths", auths);
		System.out.println("------------------------系统初始化成功:"+auths+"-----------------------------");
		//init BaseInfo
		BaseInfo bi =BaseInfoUtil.getInstance().read();
		this.getServletContext().setAttribute("baseInfo", bi);
	}
	
	public static WebApplicationContext getWc() {
		return wc;
	}

}