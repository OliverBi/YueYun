package com.yueyun.dao;

/**
 * TbTrackrank entity. @author MyEclipse Persistence Tools
 */

public class TbTrackrank implements java.io.Serializable {

	// Fields

	private Integer trackRankId;
	private Integer trackId;
	private Integer trackRank;

	// Constructors

	/** default constructor */
	public TbTrackrank() {
	}

	/** full constructor */
	public TbTrackrank(Integer trackId, Integer trackRank) {
		this.trackId = trackId;
		this.trackRank = trackRank;
	}

	// Property accessors

	public Integer getTrackRankId() {
		return this.trackRankId;
	}

	public void setTrackRankId(Integer trackRankId) {
		this.trackRankId = trackRankId;
	}

	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public Integer getTrackRank() {
		return this.trackRank;
	}

	public void setTrackRank(Integer trackRank) {
		this.trackRank = trackRank;
	}

}