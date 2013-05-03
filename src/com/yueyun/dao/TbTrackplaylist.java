package com.yueyun.dao;

/**
 * TbTrackplaylist entity. @author MyEclipse Persistence Tools
 */

public class TbTrackplaylist implements java.io.Serializable {

	// Fields

	private Integer trackPlayListId;
	private Integer trackId;
	private Integer userPlayListId;

	// Constructors

	/** default constructor */
	public TbTrackplaylist() {
	}

	/** full constructor */
	public TbTrackplaylist(Integer trackId, Integer userPlayListId) {
		this.trackId = trackId;
		this.userPlayListId = userPlayListId;
	}

	// Property accessors

	public Integer getTrackPlayListId() {
		return this.trackPlayListId;
	}

	public void setTrackPlayListId(Integer trackPlayListId) {
		this.trackPlayListId = trackPlayListId;
	}

	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public Integer getUserPlayListId() {
		return this.userPlayListId;
	}

	public void setUserPlayListId(Integer userPlayListId) {
		this.userPlayListId = userPlayListId;
	}

}