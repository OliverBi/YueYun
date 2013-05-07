package com.yueyun.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Collect;
import com.yueyun.domain.User;
import com.yueyun.service.TbCollectService;

@SuppressWarnings("serial")
public class UserCollectAjaxAction extends ActionSupport implements SessionAware{
	
	public static final String COLLECT_SUCCESS = "COLLECT_SUCCESS";
	public static final String COLLECT_FAIL = "COLLECT_FAIL";
	
	private TbCollectService tbCollectService;
	private String result;
	private Map<String, Object> session;
	
	private String trackId;
	private String albumId;
	
	private Collect collect;
	
	public String collectTrack(){
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		collect = tbCollectService.addCollectTrack(currentUser.getUserId(), Integer.parseInt(trackId));
		if(collect != null){
			result = "COLLECT_SUCCESS";
		}else{
			result = "COLLECT_FAIL";
		}
		return Action.SUCCESS;
	}
	
	public String collectAlbum(){
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		collect = tbCollectService.addCollectAlbum(currentUser.getUserId(), Integer.parseInt(albumId));
		if(collect != null){
			result = "COLLECT_SUCCESS";
		}else{
			result = "COLLECT_FAIL";
		}
		return Action.SUCCESS;
	}
	@JSON(serialize=false)
	public TbCollectService getTbCollectService() {
		return tbCollectService;
	}
	@JSON(serialize=false)
	public void setTbCollectService(TbCollectService tbCollectService) {
		this.tbCollectService = tbCollectService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	public Collect getCollect() {
		return collect;
	}
	public void setCollect(Collect collect) {
		this.collect = collect;
	}
	
}
