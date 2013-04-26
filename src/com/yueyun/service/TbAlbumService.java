package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbAlbum;
import com.yueyun.dao.TbAlbumDAO;
import com.yueyun.dao.TbTrack;
import com.yueyun.dao.TbTrackDAO;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Image;
import com.yueyun.domain.ImageSize;
import com.yueyun.domain.Track;

public class TbAlbumService {
	private TbAlbumDAO tbAlbumDAO;
	private TbTrackDAO tbTrackDAO;
	private TbArtistService tbArtistService;
	private TbTrackService tbTrackService;
	
	public List<Track> getAlbumTrackList(int albumId){
		List<Track> albumTrackList = null;
		List<TbTrack> tbAlbumTrackList = tbTrackDAO.findByTrackAlbumId(albumId);
		if(tbAlbumTrackList.size() > 0){
			albumTrackList = new ArrayList<Track>();
			for(TbTrack tbTrack : tbAlbumTrackList){
				albumTrackList.add(tbTrackService.getTrackInfo(tbTrack.getTrackId()));
			}
		}
		return albumTrackList;
	}
	
	public List<Album> getOtherAlbumList(int artistId, int albumId){
		List<Album> otherAlbumList = null;
		List<TbAlbum> tbOtherAlbumList = tbAlbumDAO.findByAlbumArtistId(artistId);
		if(tbOtherAlbumList.size() > 0){
			otherAlbumList = new ArrayList<Album>();
			for(TbAlbum tbAlbum : tbOtherAlbumList){
				if(!tbAlbum.getAlbumId().equals(albumId))
					otherAlbumList.add(getAlbumInfo(tbAlbum.getAlbumId()));
			}
		}
		return otherAlbumList;
	}
	
	public Album getAlbumInfo(int albumId){
		Album album = null;
		TbAlbum tbAlbum = tbAlbumDAO.findById(albumId);
		if(tbAlbum != null){
			album = new Album();
			album.setAlbumId(tbAlbum.getAlbumId());
			album.setAlbumName(tbAlbum.getAlbumName());
			album.setAlbumReleaseDate(tbAlbum.getAlbumReleaseDate());
			List<Image> albumImgList = new ArrayList<Image>();
			albumImgList.add(new Image(ImageSize.SMALL, tbAlbum.getAlbumImgSmall()));
			albumImgList.add(new Image(ImageSize.MEDIUM, tbAlbum.getAlbumImgMedium()));
			albumImgList.add(new Image(ImageSize.LARGE, tbAlbum.getAlbumImgLarge()));
			albumImgList.add(new Image(ImageSize.MEGA, tbAlbum.getAlbumImgMega()));
			album.setAlbumImgList(albumImgList);
			
			Artist artist = tbArtistService.getArtistInfo(tbAlbum.getAlbumArtistId());
			
			album.setAlbumArtist(artist);
		}
		return album;
	}

	public TbAlbumDAO getTbAlbumDAO() {
		return tbAlbumDAO;
	}

	public void setTbAlbumDAO(TbAlbumDAO tbAlbumDAO) {
		this.tbAlbumDAO = tbAlbumDAO;
	}

	public TbArtistService getTbArtistService() {
		return tbArtistService;
	}

	public void setTbArtistService(TbArtistService tbArtistService) {
		this.tbArtistService = tbArtistService;
	}

	public TbTrackService getTbTrackService() {
		return tbTrackService;
	}

	public void setTbTrackService(TbTrackService tbTrackService) {
		this.tbTrackService = tbTrackService;
	}

	public TbTrackDAO getTbTrackDAO() {
		return tbTrackDAO;
	}

	public void setTbTrackDAO(TbTrackDAO tbTrackDAO) {
		this.tbTrackDAO = tbTrackDAO;
	}
}
