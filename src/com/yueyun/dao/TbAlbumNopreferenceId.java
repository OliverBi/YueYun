package com.yueyun.dao;

/**
 * TbAlbumNopreferenceId entity. @author MyEclipse Persistence Tools
 */

public class TbAlbumNopreferenceId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer albumId;

	// Constructors

	/** default constructor */
	public TbAlbumNopreferenceId() {
	}

	/** full constructor */
	public TbAlbumNopreferenceId(Integer userId, Integer albumId) {
		this.userId = userId;
		this.albumId = albumId;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbAlbumNopreferenceId))
			return false;
		TbAlbumNopreferenceId castOther = (TbAlbumNopreferenceId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getAlbumId() == castOther.getAlbumId()) || (this
						.getAlbumId() != null && castOther.getAlbumId() != null && this
						.getAlbumId().equals(castOther.getAlbumId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getAlbumId() == null ? 0 : this.getAlbumId().hashCode());
		return result;
	}

}