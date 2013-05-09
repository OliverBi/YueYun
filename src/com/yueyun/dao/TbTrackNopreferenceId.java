package com.yueyun.dao;

/**
 * TbTrackNopreferenceId entity. @author MyEclipse Persistence Tools
 */

public class TbTrackNopreferenceId implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer trackId;

	// Constructors

	/** default constructor */
	public TbTrackNopreferenceId() {
	}

	/** full constructor */
	public TbTrackNopreferenceId(Integer userId, Integer trackId) {
		this.userId = userId;
		this.trackId = trackId;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbTrackNopreferenceId))
			return false;
		TbTrackNopreferenceId castOther = (TbTrackNopreferenceId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getTrackId() == castOther.getTrackId()) || (this
						.getTrackId() != null && castOther.getTrackId() != null && this
						.getTrackId().equals(castOther.getTrackId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getTrackId() == null ? 0 : this.getTrackId().hashCode());
		return result;
	}

}