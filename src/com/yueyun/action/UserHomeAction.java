package com.yueyun.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial") 
public class UserHomeAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	
	public String userLoginCheck(){
		//Login Auto
		//
		
		if(session.get("SESSION_CURRENT_USER") != null)
			return Action.SUCCESS;
		else
			return Action.LOGIN;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
