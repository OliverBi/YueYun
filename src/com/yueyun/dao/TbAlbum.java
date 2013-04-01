package com.yueyun.dao;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAlbum entity. @author MyEclipse Persistence Tools
 */

public class TbAlbum implements java.io.Serializable {

	// Fields

	private String albumId;
	private String albumName;
	private String albumImgSmall;
	private String albumImgMedium;
	private String albumImgLarge;
	private Timestamp releaseDate;
	private Set tbTracks = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbAlbum() {
	}

	/** minimal constructor */
	public TbAlbum(String albumId, String albumName) {
		this.albumId = albumId;
		this.albumName = albumName;
	}

	/** full constructor */
	public TbAlbum(String albumId, String albumName, String albumImgSmall,
			String albumImgMedium, String albumImgLarge, Timestamp releaseDate,
			Set tbTracks) {
		this.albumId = albumId;
		this.albumName = albumName;
		this.albumImgSmall = albumImgSmall;
		this.albumImgMedium = albumImgMedium;
		this.albumImgLarge = albumImgLarge;
		this.releaseDate = releaseDate;
		this.tbTracks = tbTracks;
	}

	// Property accessors

	public String getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(String albumId) {
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

	public Timestamp getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set getTbTracks() {
		return this.tbTracks;
	}

	public void setTbTracks(Set tbTracks) {
		this.tbTracks = tbTracks;
	}

}