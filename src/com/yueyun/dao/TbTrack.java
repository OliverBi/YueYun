package com.yueyun.dao;

/**
 * TbTrack entity. @author MyEclipse Persistence Tools
 */

public class TbTrack implements java.io.Serializable {

	// Fields

	private String trackId;
	private TbArtist tbArtist;
	private TbAlbum tbAlbum;
	private String trackName;
	private Integer trackDuration;
	private String trackUrl;
	private Integer playCount;
	private Integer listeners;

	// Constructors

	/** default constructor */
	public TbTrack() {
	}

	/** minimal constructor */
	public TbTrack(String trackId, String trackName, Integer playCount,
			Integer listeners) {
		this.trackId = trackId;
		this.trackName = trackName;
		this.playCount = playCount;
		this.listeners = listeners;
	}

	/** full constructor */
	public TbTrack(String trackId, TbArtist tbArtist, TbAlbum tbAlbum,
			String trackName, Integer trackDuration, String trackUrl,
			Integer playCount, Integer listeners) {
		this.trackId = trackId;
		this.tbArtist = tbArtist;
		this.tbAlbum = tbAlbum;
		this.trackName = trackName;
		this.trackDuration = trackDuration;
		this.trackUrl = trackUrl;
		this.playCount = playCount;
		this.listeners = listeners;
	}

	// Property accessors

	public String getTrackId() {
		return this.trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public TbArtist getTbArtist() {
		return this.tbArtist;
	}

	public void setTbArtist(TbArtist tbArtist) {
		this.tbArtist = tbArtist;
	}

	public TbAlbum getTbAlbum() {
		return this.tbAlbum;
	}

	public void setTbAlbum(TbAlbum tbAlbum) {
		this.tbAlbum = tbAlbum;
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

	public Integer getPlayCount() {
		return this.playCount;
	}

	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}

	public Integer getListeners() {
		return this.listeners;
	}

	public void setListeners(Integer listeners) {
		this.listeners = listeners;
	}

}