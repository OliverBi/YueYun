package com.yueyun.service;

public class TbSearchService {
	private TbAlbumService tbAlbumService;
	private TbTrackService tbTrackService;
	private TbArtistService tbArtistService;
	
	public TbAlbumService getTbAlbumService() {
		return tbAlbumService;
	}
	public void setTbAlbumService(TbAlbumService tbAlbumService) {
		this.tbAlbumService = tbAlbumService;
	}
	public TbTrackService getTbTrackService() {
		return tbTrackService;
	}
	public void setTbTrackService(TbTrackService tbTrackService) {
		this.tbTrackService = tbTrackService;
	}
	public TbArtistService getTbArtistService() {
		return tbArtistService;
	}
	public void setTbArtistService(TbArtistService tbArtistService) {
		this.tbArtistService = tbArtistService;
	}
}
