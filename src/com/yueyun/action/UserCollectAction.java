package com.yueyun.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Collect;
import com.yueyun.domain.User;
import com.yueyun.service.TbCollectService;

@SuppressWarnings("serial")
public class UserCollectAction extends ActionSupport implements SessionAware{
	private TbCollectService tbCollectService;

	private List<Collect> userCollectTrackList;
	private List<Collect> userCollectAlbumList;
	
	private Map<String, Object> session;
	
	public String execute(){
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		setUserCollectTrackList(tbCollectService.getCollectTrack(currentUser.getUserId()));
		setUserCollectAlbumList(tbCollectService.getCollectAlbum(currentUser.getUserId()));
		return Action.SUCCESS;
	}
	
	public TbCollectService getTbCollectService() {
		return tbCollectService;
	}

	public void setTbCollectService(TbCollectService tbCollectService) {
		this.tbCollectService = tbCollectService;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Collect> getUserCollectTrackList() {
		return userCollectTrackList;
	}

	public void setUserCollectTrackList(List<Collect> userCollectTrackList) {
		this.userCollectTrackList = userCollectTrackList;
	}

	public List<Collect> getUserCollectAlbumList() {
		return userCollectAlbumList;
	}

	public void setUserCollectAlbumList(List<Collect> userCollectAlbumList) {
		this.userCollectAlbumList = userCollectAlbumList;
	}
}
