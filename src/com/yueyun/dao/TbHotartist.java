package com.yueyun.dao;

/**
 * TbHotartist entity. @author MyEclipse Persistence Tools
 */

public class TbHotartist implements java.io.Serializable {

	// Fields

	private Integer hotArtistId;
	private Integer artistId;
	private Integer artistRank;

	// Constructors

	/** default constructor */
	public TbHotartist() {
	}

	/** full constructor */
	public TbHotartist(Integer artistId, Integer artistRank) {
		this.artistId = artistId;
		this.artistRank = artistRank;
	}

	// Property accessors

	public Integer getHotArtistId() {
		return this.hotArtistId;
	}

	public void setHotArtistId(Integer hotArtistId) {
		this.hotArtistId = hotArtistId;
	}

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public Integer getArtistRank() {
		return this.artistRank;
	}

	public void setArtistRank(Integer artistRank) {
		this.artistRank = artistRank;
	}

}