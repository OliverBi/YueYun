package com.yueyun.dao;

import java.sql.Timestamp;

/**
 * TbCollect entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TbCollect implements java.io.Serializable {

	// Fields

	private Integer collectId;
	private String collectType;
	private Integer userId;
	private Integer albumId;
	private Integer trackId;
	private Timestamp collectTime;

	// Constructors

	/** default constructor */
	public TbCollect() {
	}

	/** minimal constructor */
	public TbCollect(String collectType, Integer userId, Timestamp collectTime) {
		this.collectType = collectType;
		this.userId = userId;
		this.collectTime = collectTime;
	}

	/** full constructor */
	public TbCollect(String collectType, Integer userId, Integer albumId,
			Integer trackId, Timestamp collectTime) {
		this.collectType = collectType;
		this.userId = userId;
		this.albumId = albumId;
		this.trackId = trackId;
		this.collectTime = collectTime;
	}

	// Property accessors

	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	public String getCollectType() {
		return this.collectType;
	}

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public Timestamp getCollectTime() {
		return this.collectTime;
	}

	public void setCollectTime(Timestamp collectTime) {
		this.collectTime = collectTime;
	}

}