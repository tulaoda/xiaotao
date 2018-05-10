package com.xt.base;

import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


public abstract class BaseAction extends ActionSupport implements SessionAware,ApplicationAware {

	protected Map<String, Object> session;
	protected Map<String, Object> application;
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
