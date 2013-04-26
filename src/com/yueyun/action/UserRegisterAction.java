package com.yueyun.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.dao.TbUser;
import com.yueyun.service.TbUserService;

@SuppressWarnings("serial")
public class UserRegisterAction extends ActionSupport implements SessionAware{
	private TbUser registerUser;
	private TbUserService tbUserService;
	private String result;
	private String registerVCode;
	private Map<String, Object> session;
	
	public static final String REGISTER_FIRSTSTEP_SUCCESS = "REGISTER_FIRSTSTEP_SUCCESS";
	public static final String REGISTER_SECONDSTEP_SUCCESS = "REGISTER_SECONDSTEP_SUCCESS";
	public static final String REGISTER_FAIL_USERNAME_EXIST = "REGISTER_FAIL_USERNAME_EXIST";
	public static final String REGISTER_FAIL_USEREMAIL_EXIST = "REGISTER_FAIL_USEREMAIL_EXIST";
	public static final String REGISTER_FAIL_USERNAME_USEREMAIL_EXIST = "REGISTER_FAIL_USERNAME_USEREMAIL_EXIST";
	public static final String REGISTER_FAIL_VERIFYCODE_WRONG = "REGISTER_FAIL_VERIFYCODE_WRONG";
	
	public TbUser getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(TbUser registerUser) {
		this.registerUser = registerUser;
	}
	@JSON(serialize=false)
	public TbUserService getTbUserService() {
		return tbUserService;
	}
	@JSON(serialize=false)
	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getRegisterVCode() {
		return registerVCode;
	}
	public void setRegisterVCode(String registerVCode) {
		this.registerVCode = registerVCode;
	}
	@JSON(serialize=false)
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String userRegisterCheck()
	{
		result = tbUserService.checkRegisterInfo(this.registerUser);
		return Action.SUCCESS;
	}
	public String userVerifyCheck(){
		String verifyCode = (String)session.get("SESSION_VERIFY_CODE");
		if(verifyCode.equals(this.registerVCode)){
			tbUserService.registerNewUser(registerUser);
			result = REGISTER_SECONDSTEP_SUCCESS;
		}
		else
			result = REGISTER_FAIL_VERIFYCODE_WRONG;
		return Action.SUCCESS;
	}
}
