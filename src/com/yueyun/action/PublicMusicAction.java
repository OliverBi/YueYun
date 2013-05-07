package com.yueyun.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Track;
import com.yueyun.service.TbAlbumService;
import com.yueyun.service.TbArtistService;
import com.yueyun.service.TbTrackService;

@SuppressWarnings("serial")
public class PublicMusicAction extends ActionSupport{
	private TbTrackService tbTrackService;
	private TbAlbumService tbAlbumService;
	private TbArtistService tbArtistService;
	
	private Track track;
	private Album album;
	private Artist artist;
	
	private List<Track> albumTrackList;
	private List<Album> albumOtherAlbumList;
	
	private List<Track> artistTrackList;
	private List<Album> artistAlbumList;
	
	private List<Track> trackOtherTrackList;
	
	public String getTrackInfo(){
		if(track.getTrackId() == null){
			return Action.ERROR;
		}else{
			this.track = tbTrackService.getTrackInfo(track.getTrackId());
			this.trackOtherTrackList = tbTrackService.getOtherTrackList(track.getTrackId());
			return Action.SUCCESS;
		}
	}
	
	public String getArtistInfo(){
		if(artist.getArtistId() == null){
			return Action.ERROR;
		}else{
			this.artist = tbArtistService.getArtistInfo(artist.getArtistId());
			this.artistTrackList = tbArtistService.getArtistTrackList(artist.getArtistId());
			this.artistAlbumList = tbArtistService.getArtistAlbumList(artist.getArtistId());
			return Action.SUCCESS;
		}
	}
	
	public String getAlbumInfo(){
		if(album.getAlbumId() == null){
			return Action.ERROR;
		}else{
			this.album = tbAlbumService.getAlbumInfo(album.getAlbumId());
			this.albumTrackList = tbAlbumService.getAlbumTrackList(album.getAlbumId());
			this.albumOtherAlbumList = tbAlbumService.getOtherAlbumList(
					album.getAlbumArtist().getArtistId(),album.getAlbumId());
			return Action.SUCCESS;
		}
	}
	
	public TbTrackService getTbTrackService() {
		return tbTrackService;
	}
	public void setTbTrackService(TbTrackService tbTrackService) {
		this.tbTrackService = tbTrackService;
	}
	public TbAlbumService getTbAlbumService() {
		return tbAlbumService;
	}
	public void setTbAlbumService(TbAlbumService tbAlbumService) {
		this.tbAlbumService = tbAlbumService;
	}
	public TbArtistService getTbArtistService() {
		return tbArtistService;
	}
	public void setTbArtistService(TbArtistService tbArtistService) {
		this.tbArtistService = tbArtistService;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Track> getAlbumTrackList() {
		return albumTrackList;
	}

	public void setAlbumTrackList(List<Track> albumTrackList) {
		this.albumTrackList = albumTrackList;
	}

	public List<Album> getAlbumOtherAlbumList() {
		return albumOtherAlbumList;
	}

	public void setAlbumOtherAlbumList(List<Album> albumOtherAlbumList) {
		this.albumOtherAlbumList = albumOtherAlbumList;
	}

	public List<Track> getArtistTrackList() {
		return artistTrackList;
	}

	public void setArtistTrackList(List<Track> artistTrackList) {
		this.artistTrackList = artistTrackList;
	}

	public List<Album> getArtistAlbumList() {
		return artistAlbumList;
	}

	public void setArtistAlbumList(List<Album> artistAlbumList) {
		this.artistAlbumList = artistAlbumList;
	}

	public List<Track> getTrackOtherTrackList() {
		return trackOtherTrackList;
	}

	public void setTrackOtherTrackList(List<Track> trackOtherTrackList) {
		this.trackOtherTrackList = trackOtherTrackList;
	}
}
