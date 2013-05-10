package com.yueyun.domain;

import java.util.List;

public class Find {
	private FindType findType;
	private String findTypeStr;
	private Album album;
	private Track track;
	private Integer listenerNum;
	private List<Track> albumTrackList;
	private List<User> trackListenerList;

	public FindType getFindType() {
		return findType;
	}

	public void setFindType(FindType findType) {
		this.findType = findType;
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

	public Integer getListenerNum() {
		return listenerNum;
	}

	public void setListenerNum(Integer listenerNum) {
		this.listenerNum = listenerNum;
	}

	public List<Track> getAlbumTrackList() {
		return albumTrackList;
	}

	public void setAlbumTrackList(List<Track> albumTrackList) {
		this.albumTrackList = albumTrackList;
	}

	public List<User> getTrackListenerList() {
		return trackListenerList;
	}

	public void setTrackListenerList(List<User> trackListenerList) {
		this.trackListenerList = trackListenerList;
	}

	public String getFindTypeStr() {
		findTypeStr = findType.toString();
		return findTypeStr;
	}

	public void setFindTypeStr(String findTypeStr) {
		this.findTypeStr = findTypeStr;
	}
}
