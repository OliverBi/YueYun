package com.yueyun.domain;

import java.util.Date;

public class Collect {
	private Integer collectId;
	private CollectType collectType;
	private User user;
	private Album album;
	private Track track;
	private Date collectTime;
	public Integer getCollectId() {
		return collectId;
	}
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	public CollectType getCollectType() {
		return collectType;
	}
	public void setCollectType(CollectType collectType) {
		this.collectType = collectType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
}
