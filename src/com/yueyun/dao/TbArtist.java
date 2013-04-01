package com.yueyun.dao;

import java.util.HashSet;
import java.util.Set;

/**
 * TbArtist entity. @author MyEclipse Persistence Tools
 */

public class TbArtist implements java.io.Serializable {

	// Fields

	private String artistId;
	private String artistName;
	private String artistImgSmall;
	private String artistImgMedium;
	private String artistImgLarge;
	private Set tbTracks = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbArtist() {
	}

	/** minimal constructor */
	public TbArtist(String artistId, String artistName) {
		this.artistId = artistId;
		this.artistName = artistName;
	}

	/** full constructor */
	public TbArtist(String artistId, String artistName, String artistImgSmall,
			String artistImgMedium, String artistImgLarge, Set tbTracks) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistImgSmall = artistImgSmall;
		this.artistImgMedium = artistImgMedium;
		this.artistImgLarge = artistImgLarge;
		this.tbTracks = tbTracks;
	}

	// Property accessors

	public String getArtistId() {
		return this.artistId;
	}

	public void setArtistId(String artistId) {
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

	public Set getTbTracks() {
		return this.tbTracks;
	}

	public void setTbTracks(Set tbTracks) {
		this.tbTracks = tbTracks;
	}

}