package com.yueyun.dao;

/**
 * TbAlbumNopreference entity. @author MyEclipse Persistence Tools
 */

public class TbAlbumNopreference implements java.io.Serializable {

	// Fields

	private TbAlbumNopreferenceId id;
	private Float nopreference;

	// Constructors

	/** default constructor */
	public TbAlbumNopreference() {
	}

	/** minimal constructor */
	public TbAlbumNopreference(TbAlbumNopreferenceId id) {
		this.id = id;
	}

	/** full constructor */
	public TbAlbumNopreference(TbAlbumNopreferenceId id, Float nopreference) {
		this.id = id;
		this.nopreference = nopreference;
	}

	// Property accessors

	public TbAlbumNopreferenceId getId() {
		return this.id;
	}

	public void setId(TbAlbumNopreferenceId id) {
		this.id = id;
	}

	public Float getNopreference() {
		return this.nopreference;
	}

	public void setNopreference(Float nopreference) {
		this.nopreference = nopreference;
	}

}