package com.cms.web.session.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cms.basic.util.CmsSessionContext;

public class CmsSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		CmsSessionContext.addSessoin(se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		CmsSessionContext.removeSession(se.getSession());
	}

}
