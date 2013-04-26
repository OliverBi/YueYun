package com.yueyun.dao;

/**
 * TbTrack entity. @author MyEclipse Persistence Tools
 */

public class TbTrack implements java.io.Serializable {

	// Fields

	private Integer trackId;
	private String trackName;
	private Integer trackDuration;
	private String trackUrl;
	private Integer trackPlayCount;
	private Integer trackListeners;
	private Integer trackAlbumId;

	// Constructors

	/** default constructor */
	public TbTrack() {
	}

	/** minimal constructor */
	public TbTrack(String trackName) {
		this.trackName = trackName;
	}

	/** full constructor */
	public TbTrack(String trackName, Integer trackDuration, String trackUrl,
			Integer trackPlayCount, Integer trackListeners, Integer trackAlbumId) {
		this.trackName = trackName;
		this.trackDuration = trackDuration;
		this.trackUrl = trackUrl;
		this.trackPlayCount = trackPlayCount;
		this.trackListeners = trackListeners;
		this.trackAlbumId = trackAlbumId;
	}

	// Property accessors

	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return this.trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public Integer getTrackDuration() {
		return this.trackDuration;
	}

	public void setTrackDuration(Integer trackDuration) {
		this.trackDuration = trackDuration;
	}

	public String getTrackUrl() {
		return this.trackUrl;
	}

	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	public Integer getTrackPlayCount() {
		return this.trackPlayCount;
	}

	public void setTrackPlayCount(Integer trackPlayCount) {
		this.trackPlayCount = trackPlayCount;
	}

	public Integer getTrackListeners() {
		return this.trackListeners;
	}

	public void setTrackListeners(Integer trackListeners) {
		this.trackListeners = trackListeners;
	}

	public Integer getTrackAlbumId() {
		return this.trackAlbumId;
	}

	public void setTrackAlbumId(Integer trackAlbumId) {
		this.trackAlbumId = trackAlbumId;
	}

}