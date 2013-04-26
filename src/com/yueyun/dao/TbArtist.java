package com.yueyun.dao;

/**
 * TbArtist entity. @author MyEclipse Persistence Tools
 */

public class TbArtist implements java.io.Serializable {

	// Fields

	private Integer artistId;
	private String artistName;
	private String artistImgSmall;
	private String artistImgMedium;
	private String artistImgLarge;
	private String artistImgMega;
	private String artistDescription;

	// Constructors

	/** default constructor */
	public TbArtist() {
	}

	/** minimal constructor */
	public TbArtist(String artistName) {
		this.artistName = artistName;
	}

	/** full constructor */
	public TbArtist(String artistName, String artistImgSmall,
			String artistImgMedium, String artistImgLarge,
			String artistImgMega, String artistDescription) {
		this.artistName = artistName;
		this.artistImgSmall = artistImgSmall;
		this.artistImgMedium = artistImgMedium;
		this.artistImgLarge = artistImgLarge;
		this.artistImgMega = artistImgMega;
		this.artistDescription = artistDescription;
	}

	// Property accessors

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return this.artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistImgSmall() {
		return this.artistImgSmall;
	}

	public void setArtistImgSmall(String artistImgSmall) {
		this.artistImgSmall = artistImgSmall;
	}

	public String getArtistImgMedium() {
		return this.artistImgMedium;
	}

	public void setArtistImgMedium(String artistImgMedium) {
		this.artistImgMedium = artistImgMedium;
	}

	public String getArtistImgLarge() {
		return this.artistImgLarge;
	}

	public void setArtistImgLarge(String artistImgLarge) {
		this.artistImgLarge = artistImgLarge;
	}

	public String getArtistImgMega() {
		return this.artistImgMega;
	}

	public void setArtistImgMega(String artistImgMega) {
		this.artistImgMega = artistImgMega;
	}

	public String getArtistDescription() {
		return this.artistDescription;
	}

	public void setArtistDescription(String artistDescription) {
		this.artistDescription = artistDescription;
	}

}