package com.cms.core.errors;

public class CmsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmsException() {
		super();
	}

	public CmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CmsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CmsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CmsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
