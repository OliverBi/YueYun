package com.yueyun.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Track;
import com.yueyun.domain.User;
import com.yueyun.service.TbPlayService;

@SuppressWarnings("serial")
public class UserPlayAjaxAction extends ActionSupport implements SessionAware{
	public static final String SUCCESS_ADD_PLAYLIST = "SUCCESS_ADD_PLAYLIST";
	public static final String FAIL_ADD_PLAYLIST = "FAIL_ADD_PLAYLIST";
	
	private String trackId;
	private String type;
	private String albumId;
	private String result;
	private Track track;
	private List<Track> album;
	private JSONObject trackJson;
	private JSONObject albumJson;
	
	private Map<String, Object> session;
	
	private TbPlayService tbPlayService;
	
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute(){
		
		User currentUser = (User)this.session.get("SESSION_CURRENT_USER");
		if(trackId != null){
			track = tbPlayService.addTrackToUserDefaultPlayList(currentUser.getUserId(), Integer.parseInt(trackId));
			if(track != null){
				result = "SUCCESS_ADD_PLAYLIST";
				trackJson = new JSONObject();
				trackJson.put("id", track.getTrackId());
				trackJson.put("title", track.getTrackName());
				trackJson.put("artist", track.getTrackArtistString());
				trackJson.put("mp3", track.getTrackUrl());
				trackJson.put("album", track.getTrackAlbum().getAlbumName());
				trackJson.put("poster", track.getTrackAlbum().getAlbumImgList().get(2).getImageUrl());
			}else{
				result = "FAIL_ADD_PLAYLIST";
			}
		}else if(albumId != null){
			album = tbPlayService.addAlbumToUserDefaultPlayList(currentUser.getUserId(), Integer.parseInt(albumId));
			if(album != null){
				result = "SUCCESS_ADD_PLAYLIST";
				albumJson = new JSONObject();
				JSONArray albumJsonArray = new JSONArray();
				for(Track trackTemp : album){
					JSONObject trackJsonTemp = new JSONObject();
					trackJsonTemp.put("id", trackTemp.getTrackId());
					trackJsonTemp.put("title", trackTemp.getTrackName());
					trackJsonTemp.put("artist", trackTemp.getTrackArtistString());
					trackJsonTemp.put("mp3", trackTemp.getTrackUrl());
					trackJsonTemp.put("album", trackTemp.getTrackAlbum().getAlbumName());
					trackJsonTemp.put("poster", trackTemp.getTrackAlbum().getAlbumImgList().get(2).getImageUrl());
					albumJsonArray.add(trackJsonTemp);
				}
				albumJson.put("trackList", albumJsonArray);
			}else{
				result = "FAIL_ADD_PLAYLIST";
			}
		}
		return Action.SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@JSON(serialize=false)
	public TbPlayService getTbPlayService() {
		return tbPlayService;
	}
	@JSON(serialize=false)
	public void setTbPlayService(TbPlayService tbPlayService) {
		this.tbPlayService = tbPlayService;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public JSONObject getTrackJson() {
		return trackJson;
	}
	public void setTrackJson(JSONObject trackJson) {
		this.trackJson = trackJson;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	public List<Track> getAlbum() {
		return album;
	}
	public void setAlbum(List<Track> album) {
		this.album = album;
	}
	public JSONObject getAlbumJson() {
		return albumJson;
	}
	public void setAlbumJson(JSONObject albumJson) {
		this.albumJson = albumJson;
	}
}
