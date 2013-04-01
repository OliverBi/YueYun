package com.yueyun.action;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.service.TbUserService;

@SuppressWarnings("serial")
public class UserLoginAction extends ActionSupport {
	private String userEmail;
	private String userPassword;
	private TbUserService tbUserService;
	private String result;
	
	public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
	public static final String LOGIN_FAIL = "LOGIN_FAIL";
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@JSON(serialize=false)
	public TbUserService getTbUserService() {
		return tbUserService;
	}
	@JSON(serialize=false)
	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}
	public String userLoginCheck(){
		if(tbUserService.checkLoginInfo(this.userEmail, this.userPassword))
			this.result = UserLoginAction.LOGIN_SUCCESS;
		else
			this.result = UserLoginAction.LOGIN_FAIL;
		return Action.SUCCESS;
	}
}
