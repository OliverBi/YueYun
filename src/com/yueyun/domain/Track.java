package com.yueyun.domain;

import java.util.List;

public class Track {
	private Integer trackId;
	private String trackName;
	private List<Artist> trackArtistList;
	private String trackArtistString;
	private Album trackAlbum;
	private Integer trackDuration;
	private String trackUrl;
	private Integer trackPlayCount;
	private Integer trackListeners;
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public List<Artist> getTrackArtistList() {
		return trackArtistList;
	}
	public void setTrackArtistList(List<Artist> trackArtistList) {
		this.trackArtistList = trackArtistList;
	}
	public Album getTrackAlbum() {
		return trackAlbum;
	}
	public void setTrackAlbum(Album trackAlbum) {
		this.trackAlbum = trackAlbum;
	}
	public Integer getTrackDuration() {
		return trackDuration;
	}
	public void setTrackDuration(Integer trackDuration) {
		this.trackDuration = trackDuration;
	}
	public String getTrackUrl() {
		return trackUrl;
	}
	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}
	public Integer getTrackPlayCount() {
		return trackPlayCount;
	}
	public void setTrackPlayCount(Integer trackPlayCount) {
		this.trackPlayCount = trackPlayCount;
	}
	public Integer getTrackListeners() {
		return trackListeners;
	}
	public void setTrackListeners(Integer trackListeners) {
		this.trackListeners = trackListeners;
	}
	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	public String getTrackArtistString() {
		String artistString = "";
		for(int i = 0; i < trackArtistList.size(); i++){
			if(i == 0){
				artistString += trackArtistList.get(i).getArtistName();
			}
			else {
				artistString += "&" + trackArtistList.get(i).getArtistName();
			}
		}
		trackArtistString = artistString;
		return trackArtistString;
	}
	public void setTrackArtistString(String trackArtistString) {
		this.trackArtistString = trackArtistString;
	}
}
