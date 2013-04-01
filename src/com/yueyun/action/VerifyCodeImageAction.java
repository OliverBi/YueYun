package com.yueyun.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.tool.VerifyCode;
import com.yueyun.tool.VerifyImage;

@SuppressWarnings("serial")
public class VerifyCodeImageAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	
	private ByteArrayInputStream imageStream;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	public String execute() throws Exception{
		String verifyCode = VerifyCode.getVerifyCode();
		         imageStream = VerifyImage.getImageAsInputStream(verifyCode);
		         session.put("SESSION_VERIFY_CODE", verifyCode);
	    return Action.SUCCESS;
	}
	
}
