package com.yueyun.dao;

/**
 * TbNewrecommendtrack entity. @author MyEclipse Persistence Tools
 */

public class TbNewrecommendtrack implements java.io.Serializable {

	// Fields

	private Integer newRecommendTrackId;
	private Integer trackId;
	private Integer trackRank;

	// Constructors

	/** default constructor */
	public TbNewrecommendtrack() {
	}

	/** full constructor */
	public TbNewrecommendtrack(Integer trackId, Integer trackRank) {
		this.trackId = trackId;
		this.trackRank = trackRank;
	}

	// Property accessors

	public Integer getNewRecommendTrackId() {
		return this.newRecommendTrackId;
	}

	public void setNewRecommendTrackId(Integer newRecommendTrackId) {
		this.newRecommendTrackId = newRecommendTrackId;
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