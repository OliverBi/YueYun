package com.yueyun.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserLogoutAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute(){
		session.remove("SESSION_CURRENT_USER");
		return Action.SUCCESS;
	}
	
}
