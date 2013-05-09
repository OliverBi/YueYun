package com.yueyun.dao;

/**
 * TbTrackNopreference entity. @author MyEclipse Persistence Tools
 */

public class TbTrackNopreference implements java.io.Serializable {

	// Fields

	private TbTrackNopreferenceId id;
	private Float nopreference;

	// Constructors

	/** default constructor */
	public TbTrackNopreference() {
	}

	/** minimal constructor */
	public TbTrackNopreference(TbTrackNopreferenceId id) {
		this.id = id;
	}

	/** full constructor */
	public TbTrackNopreference(TbTrackNopreferenceId id, Float nopreference) {
		this.id = id;
		this.nopreference = nopreference;
	}

	// Property accessors

	public TbTrackNopreferenceId getId() {
		return this.id;
	}

	public void setId(TbTrackNopreferenceId id) {
		this.id = id;
	}

	public Float getNopreference() {
		return this.nopreference;
	}

	public void setNopreference(Float nopreference) {
		this.nopreference = nopreference;
	}

}