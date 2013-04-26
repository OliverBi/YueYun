package com.yueyun.dao;

/**
 * TbNewalbum entity. @author MyEclipse Persistence Tools
 */

public class TbNewalbum implements java.io.Serializable {

	// Fields

	private Integer newAlbumId;
	private Integer albumId;
	private Integer albumRank;

	// Constructors

	/** default constructor */
	public TbNewalbum() {
	}

	/** full constructor */
	public TbNewalbum(Integer albumId, Integer albumRank) {
		this.albumId = albumId;
		this.albumRank = albumRank;
	}

	// Property accessors

	public Integer getNewAlbumId() {
		return this.newAlbumId;
	}

	public void setNewAlbumId(Integer newAlbumId) {
		this.newAlbumId = newAlbumId;
	}

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getAlbumRank() {
		return this.albumRank;
	}

	public void setAlbumRank(Integer albumRank) {
		this.albumRank = albumRank;
	}

}