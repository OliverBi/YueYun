package com.yueyun.domain;

import java.util.List;

public class Artist {
	private Integer artistId;
	private String artistName;
	private List<Image> artistImgList;
	private String artistDescription;
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public List<Image> getArtistImgList() {
		return artistImgList;
	}
	public void setArtistImgList(List<Image> artistImgList) {
		this.artistImgList = artistImgList;
	}
	public String getArtistDescription() {
		return artistDescription;
	}
	public void setArtistDescription(String artistDescription) {
		this.artistDescription = artistDescription;
	}
	public Integer getArtistId() {
		return artistId;
	}
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
}
