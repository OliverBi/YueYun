package com.yueyun.dao;

/**
 * TbRelation entity. @author MyEclipse Persistence Tools
 */

public class TbRelation implements java.io.Serializable {

	// Fields

	private Integer relationId;
	private Integer userId;
	private Integer friendId;

	// Constructors

	/** default constructor */
	public TbRelation() {
	}

	/** full constructor */
	public TbRelation(Integer userId, Integer friendId) {
		this.userId = userId;
		this.friendId = friendId;
	}

	// Property accessors

	public Integer getRelationId() {
		return this.relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return this.friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

}