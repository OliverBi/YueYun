package com.yueyun.dao;

/**
 * TbUserplaylist entity. @author MyEclipse Persistence Tools
 */

public class TbUserplaylist implements java.io.Serializable {

	// Fields

	private Integer userPlayListId;
	private Integer userId;
	private String userPlayListName;

	// Constructors

	/** default constructor */
	public TbUserplaylist() {
	}

	/** full constructor */
	public TbUserplaylist(Integer userId, String userPlayListName) {
		this.userId = userId;
		this.userPlayListName = userPlayListName;
	}

	// Property accessors

	public Integer getUserPlayListId() {
		return this.userPlayListId;
	}

	public void setUserPlayListId(Integer userPlayListId) {
		this.userPlayListId = userPlayListId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPlayListName() {
		return this.userPlayListName;
	}

	public void setUserPlayListName(String userPlayListName) {
		this.userPlayListName = userPlayListName;
	}

}