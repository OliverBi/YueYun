package com.yueyun.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Status;
import com.yueyun.domain.User;
import com.yueyun.service.TbStatusService;

@SuppressWarnings("serial")
public class UserStatusAction extends ActionSupport implements SessionAware{
	public static final String PUBLISH_SUCCESS = "PUBLISH_SUCCESS";
	public static final String PUBLISH_FAIL = "PUBLISH_FAIL";
	
	private String statusContent;
	private String trackId;
	private String albumId;
	private TbStatusService tbStatusService;
	private String result;
	private Status status;
	
	private Map<String, Object> session;
	
	@JSON(serialize=false)
	public TbStatusService getTbStatusService() {
		return tbStatusService;
	}
	@JSON(serialize=false)
	public void setTbStatusService(TbStatusService tbStatusService) {
		this.tbStatusService = tbStatusService;
	}
	public String getStatusContent() {
		return statusContent;
	}
	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}
	
	public String publishCommonStatus(){
		User currentUser = (User)this.session.get("SESSION_CURRENT_USER");
		status = tbStatusService.addCommonStatus(currentUser.getUserId(), statusContent);
		if(status != null)
			result = PUBLISH_SUCCESS;
		else
			result = PUBLISH_FAIL;
		return Action.SUCCESS;
	}
	
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
