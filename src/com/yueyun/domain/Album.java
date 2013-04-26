package com.yueyun.domain;

import java.util.Date;
import java.util.List;

public class Album {
	private Integer albumId;
	private String albumName;
	private Date albumReleaseDate;
	private List<Image> albumImgList;
	private Artist albumArtist;
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Date getAlbumReleaseDate() {
		return albumReleaseDate;
	}
	public void setAlbumReleaseDate(Date albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}
	public List<Image> getAlbumImgList() {
		return albumImgList;
	}
	public void setAlbumImgList(List<Image> albumImgList) {
		this.albumImgList = albumImgList;
	}
	public Artist getAlbumArtist() {
		return albumArtist;
	}
	public void setAlbumArtist(Artist albumArtist) {
		this.albumArtist = albumArtist;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
}
