package com.yueyun.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Track;
import com.yueyun.domain.User;
import com.yueyun.service.TbPlayService;

@SuppressWarnings("serial")
public class UserPlayAction extends ActionSupport implements SessionAware{
	private String trackId;
	private String type;
	
	private String albumId;
	
	private Map<String, Object> session;
	
	private TbPlayService tbPlayService;
	
	private List<Track> userDefaultPlayList;
	
	private JSONObject userDefaultPlayListJson;
	private String userDefaultPlayListJsonStr;
	
	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	
	public String execute(){
		User currentUser = (User)this.session.get("SESSION_CURRENT_USER");
		
		if(trackId != null){
			tbPlayService.addTrackToUserDefaultPlayList(currentUser.getUserId(), Integer.parseInt(trackId));
		}else if(albumId != null){
			tbPlayService.addAlbumToUserDefaultPlayList(currentUser.getUserId(), Integer.parseInt(albumId));
		}else{
			this.userDefaultPlayList = tbPlayService.getUserDefaultPlayList(currentUser.getUserId());
			if(this.userDefaultPlayList != null){	
				this.userDefaultPlayListJson = new JSONObject();
				JSONArray playListArray = new JSONArray();
				for(Track track : userDefaultPlayList){
					JSONObject trackJson = new JSONObject();
					trackJson.put("id", track.getTrackId());
					trackJson.put("title", track.getTrackName());
					trackJson.put("artist", track.getTrackArtistString());
					trackJson.put("mp3", track.getTrackUrl());
					trackJson.put("album", track.getTrackAlbum().getAlbumName());
					trackJson.put("poster", track.getTrackAlbum().getAlbumImgList().get(2).getImageUrl());
					playListArray.add(trackJson);
				}
				this.userDefaultPlayListJson.put("playlist", playListArray);
				this.userDefaultPlayListJsonStr = this.userDefaultPlayListJson.toString();
			}
		}
		return Action.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public TbPlayService getTbPlayService() {
		return tbPlayService;
	}

	public void setTbPlayService(TbPlayService tbPlayService) {
		this.tbPlayService = tbPlayService;
	}

	public List<Track> getUserDefaultPlayList() {
		return userDefaultPlayList;
	}

	public void setUserDefaultPlayList(List<Track> userDefaultPlayList) {
		this.userDefaultPlayList = userDefaultPlayList;
	}

	public JSONObject getUserDefaultPlayListJson() {
		return userDefaultPlayListJson;
	}

	public void setUserDefaultPlayListJson(JSONObject userDefaultPlayListJson) {
		this.userDefaultPlayListJson = userDefaultPlayListJson;
	}

	public String getUserDefaultPlayListJsonStr() {
		return userDefaultPlayListJsonStr;
	}

	public void setUserDefaultPlayListJsonStr(String userDefaultPlayListJsonStr) {
		this.userDefaultPlayListJsonStr = userDefaultPlayListJsonStr;
	}

}
