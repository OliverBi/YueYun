package com.yueyun.dao;

/**
 * TbArtistlist entity. @author MyEclipse Persistence Tools
 */

public class TbArtistlist implements java.io.Serializable {

	// Fields

	private Integer artistListId;
	private Integer trackId;
	private Integer artistId;

	// Constructors

	/** default constructor */
	public TbArtistlist() {
	}

	/** full constructor */
	public TbArtistlist(Integer trackId, Integer artistId) {
		this.trackId = trackId;
		this.artistId = artistId;
	}

	// Property accessors

	public Integer getArtistListId() {
		return this.artistListId;
	}

	public void setArtistListId(Integer artistListId) {
		this.artistListId = artistListId;
	}

	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

}