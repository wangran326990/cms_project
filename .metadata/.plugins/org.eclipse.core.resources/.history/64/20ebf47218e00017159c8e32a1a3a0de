package com.cms.web.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cms.core.errors.CmsException;
import com.cms.core.model.User;


public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); 
		HandlerMethod hm = (HandlerMethod)handler;
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser == null){
			response.sendRedirect(request.getContextPath()+"/login");
		}else{
			boolean isAdmin = (boolean)session.getAttribute("isAdmin");
			if(!isAdmin){
				Set<String> actions = (Set<String>)session.getAttribute("allActions");
				String aname = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
				if(!actions.contains(aname)) throw new CmsException("没有权限访问该功能");
			}
		}
		return super.preHandle(request, response, handler);
	}
}