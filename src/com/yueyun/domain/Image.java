package com.yueyun.domain;

public class Image {
	private ImageSize imageSize;
	private String imageUrl;
	public Image(ImageSize size, String url){
		this.imageSize = size;
		this.imageUrl = url;
	}
	public ImageSize getImageSize() {
		return imageSize;
	}
	public void setImageSize(ImageSize imageSize) {
		this.imageSize = imageSize;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
