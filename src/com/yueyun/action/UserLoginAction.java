package com.yueyun.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.dao.TbUser;
import com.yueyun.domain.User;
import com.yueyun.service.TbUserService;

@SuppressWarnings("serial")
public class UserLoginAction extends ActionSupport implements SessionAware{
	private String userEmail;
	private String userPassword;
	private TbUserService tbUserService;
	private String result;
	private Map<String, Object> session;
	
	public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
	public static final String LOGIN_FAIL = "LOGIN_FAIL";
	public static final String IS_LOGIN = "IS_LOGIN";
	public static final String NOT_LOGIN_STRING = "NOT_LOGIN";
	
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
		TbUser tbUser = tbUserService.checkLoginInfo(this.userEmail, this.userPassword);
		if(tbUser != null){
			User currentUser = new User();
			currentUser.setUserId(tbUser.getUserId());
			currentUser.setUserName(tbUser.getUserName());
			currentUser.setUserEmail(tbUser.getUserEmail());
			currentUser.setUserBirthday(new Date(tbUser.getUserBirthday().getTime()));
			currentUser.setUserAvatarUrl(tbUser.getUserAvatarUrl());
			currentUser.setUserGender(tbUser.getUserGender());
			currentUser.setUserDescription(tbUser.getUserDescription());
			this.session.put("SESSION_CURRENT_USER", currentUser);
			this.result = UserLoginAction.LOGIN_SUCCESS;
		}
		else{
			this.result = UserLoginAction.LOGIN_FAIL;
		}
		return Action.SUCCESS;
	}
	
	public String isUserLogin(){
		if(this.session.get("SESSION_CURRENT_USER") != null){
			this.result = "IS_LOGIN";
		}
		else {
			this.result = "NOT_LOGIN";
		}
		return Action.SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
