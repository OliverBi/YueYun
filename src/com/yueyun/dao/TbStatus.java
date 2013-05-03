package com.yueyun.dao;

import java.sql.Timestamp;

/**
 * TbStatus entity. @author MyEclipse Persistence Tools
 */

public class TbStatus implements java.io.Serializable {

	// Fields

	private Integer statusId;
	private Integer userId;
	private String statusType;
	private String statusContent;
	private Integer shareTrackId;
	private Integer shareAlbumId;
	private Timestamp statusTime;

	// Constructors

	/** default constructor */
	public TbStatus() {
	}

	/** minimal constructor */
	public TbStatus(Integer userId, String statusType, String statusContent) {
		this.userId = userId;
		this.statusType = statusType;
		this.statusContent = statusContent;
	}

	/** full constructor */
	public TbStatus(Integer userId, String statusType, String statusContent,
			Integer shareTrackId, Integer shareAlbumId, Timestamp statusTime) {
		this.userId = userId;
		this.statusType = statusType;
		this.statusContent = statusContent;
		this.shareTrackId = shareTrackId;
		this.shareAlbumId = shareAlbumId;
		this.statusTime = statusTime;
	}

	// Property accessors

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getStatusContent() {
		return this.statusContent;
	}

	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}

	public Integer getShareTrackId() {
		return this.shareTrackId;
	}

	public void setShareTrackId(Integer shareTrackId) {
		this.shareTrackId = shareTrackId;
	}

	public Integer getShareAlbumId() {
		return this.shareAlbumId;
	}

	public void setShareAlbumId(Integer shareAlbumId) {
		this.shareAlbumId = shareAlbumId;
	}

	public Timestamp getStatusTime() {
		return this.statusTime;
	}

	public void setStatusTime(Timestamp statusTime) {
		this.statusTime = statusTime;
	}

}