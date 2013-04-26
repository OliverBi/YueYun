package com.yueyun.dao;

import java.sql.Timestamp;

/**
 * TbAlbum entity. @author MyEclipse Persistence Tools
 */

public class TbAlbum implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private String albumName;
	private String albumImgSmall;
	private String albumImgMedium;
	private String albumImgLarge;
	private String albumImgMega;
	private Timestamp albumReleaseDate;
	private Integer albumArtistId;

	// Constructors

	/** default constructor */
	public TbAlbum() {
	}

	/** minimal constructor */
	public TbAlbum(String albumName) {
		this.albumName = albumName;
	}

	/** full constructor */
	public TbAlbum(String albumName, String albumImgSmall,
			String albumImgMedium, String albumImgLarge, String albumImgMega,
			Timestamp albumReleaseDate, Integer albumArtistId) {
		this.albumName = albumName;
		this.albumImgSmall = albumImgSmall;
		this.albumImgMedium = albumImgMedium;
		this.albumImgLarge = albumImgLarge;
		this.albumImgMega = albumImgMega;
		this.albumReleaseDate = albumReleaseDate;
		this.albumArtistId = albumArtistId;
	}

	// Property accessors

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumImgSmall() {
		return this.albumImgSmall;
	}

	public void setAlbumImgSmall(String albumImgSmall) {
		this.albumImgSmall = albumImgSmall;
	}

	public String getAlbumImgMedium() {
		return this.albumImgMedium;
	}

	public void setAlbumImgMedium(String albumImgMedium) {
		this.albumImgMedium = albumImgMedium;
	}

	public String getAlbumImgLarge() {
		return this.albumImgLarge;
	}

	public void setAlbumImgLarge(String albumImgLarge) {
		this.albumImgLarge = albumImgLarge;
	}

	public String getAlbumImgMega() {
		return this.albumImgMega;
	}

	public void setAlbumImgMega(String albumImgMega) {
		this.albumImgMega = albumImgMega;
	}

	public Timestamp getAlbumReleaseDate() {
		return this.albumReleaseDate;
	}

	public void setAlbumReleaseDate(Timestamp albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public Integer getAlbumArtistId() {
		return this.albumArtistId;
	}

	public void setAlbumArtistId(Integer albumArtistId) {
		this.albumArtistId = albumArtistId;
	}

}