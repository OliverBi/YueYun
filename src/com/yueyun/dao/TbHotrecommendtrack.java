package com.yueyun.dao;

/**
 * TbHotrecommendtrack entity. @author MyEclipse Persistence Tools
 */

public class TbHotrecommendtrack implements java.io.Serializable {

	// Fields

	private Integer hotRecommendTrackId;
	private Integer trackId;
	private Integer trackRank;

	// Constructors

	/** default constructor */
	public TbHotrecommendtrack() {
	}

	/** full constructor */
	public TbHotrecommendtrack(Integer trackId, Integer trackRank) {
		this.trackId = trackId;
		this.trackRank = trackRank;
	}

	// Property accessors

	public Integer getHotRecommendTrackId() {
		return this.hotRecommendTrackId;
	}

	public void setHotRecommendTrackId(Integer hotRecommendTrackId) {
		this.hotRecommendTrackId = hotRecommendTrackId;
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