package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbAlbum;
import com.yueyun.dao.TbAlbumDAO;
import com.yueyun.dao.TbArtist;
import com.yueyun.dao.TbArtistDAO;
import com.yueyun.dao.TbArtistlist;
import com.yueyun.dao.TbArtistlistDAO;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Image;
import com.yueyun.domain.ImageSize;
import com.yueyun.domain.Track;

public class TbArtistService {
	private TbArtistDAO tbArtistDAO;
	private TbArtistlistDAO tbArtistlistDAO;
	private TbAlbumDAO tbAlbumDAO;
	private TbTrackService tbTrackService;
	private TbAlbumService tbAlbumService;
	
	public List<Artist> searchArtist(String content){
		List<TbArtist> tbArtistList = tbArtistDAO.findByArtistPartName(content);
		List<Artist> artistList = null;
		if(tbArtistList.size() > 0){
			artistList = new ArrayList<Artist>();
			for(TbArtist tbArtist : tbArtistList){
				artistList.add(getArtistInfo(tbArtist.getArtistId()));
			}
		}
		return artistList;
	}
	
	public List<Track> getArtistTrackList(int artistId){
		List<Track> artistTrackList = null;
		List<TbArtistlist> tbArtistTrackList = tbArtistlistDAO.findByArtistId(artistId);
		if(tbArtistTrackList.size() > 0){
			artistTrackList = new ArrayList<Track>();
			for(TbArtistlist tbArtistTrackItem : tbArtistTrackList){
				artistTrackList.add(tbTrackService.getTrackInfo(tbArtistTrackItem.getTrackId()));
			}
		}
		return artistTrackList;
	}
	
	public List<Album> getArtistAlbumList(int artistId){
		List<Album> artistAlbumList = null;
		List<TbAlbum> tbArtistAlbumList = tbAlbumDAO.findByAlbumArtistId(artistId);
		if(tbArtistAlbumList.size() > 0){
			artistAlbumList = new ArrayList<Album>();
			for(TbAlbum tbAlbum : tbArtistAlbumList){
				artistAlbumList.add(tbAlbumService.getAlbumInfo(tbAlbum.getAlbumId()));
			}
		}
		return artistAlbumList;
	}
	
	public Artist getArtistInfo(int artistId){
		Artist artist = null;
		TbArtist tbArtist = tbArtistDAO.findById(artistId);
		if(tbArtist != null){
			artist = new Artist();
			artist.setArtistId(tbArtist.getArtistId());
			artist.setArtistName(tbArtist.getArtistName());
			artist.setArtistDescription(tbArtist.getArtistDescription());
			List<Image> artistImgList = new ArrayList<Image>();
			artistImgList.add(new Image(ImageSize.SMALL, tbArtist.getArtistImgSmall()));
			artistImgList.add(new Image(ImageSize.MEDIUM, tbArtist.getArtistImgMedium()));
			artistImgList.add(new Image(ImageSize.LARGE, tbArtist.getArtistImgLarge()));
			artistImgList.add(new Image(ImageSize.MEGA, tbArtist.getArtistImgMega()));
			artist.setArtistImgList(artistImgList);
		}
		return artist;
	}

	public TbArtistDAO getTbArtistDAO() {
		return tbArtistDAO;
	}

	public void setTbArtistDAO(TbArtistDAO tbArtistDAO) {
		this.tbArtistDAO = tbArtistDAO;
	}

	public TbTrackService getTbTrackService() {
		return tbTrackService;
	}

	public void setTbTrackService(TbTrackService tbTrackService) {
		this.tbTrackService = tbTrackService;
	}

	public TbArtistlistDAO getTbArtistlistDAO() {
		return tbArtistlistDAO;
	}

	public void setTbArtistlistDAO(TbArtistlistDAO tbArtistlistDAO) {
		this.tbArtistlistDAO = tbArtistlistDAO;
	}

	public TbAlbumService getTbAlbumService() {
		return tbAlbumService;
	}

	public void setTbAlbumService(TbAlbumService tbAlbumService) {
		this.tbAlbumService = tbAlbumService;
	}

	public TbAlbumDAO getTbAlbumDAO() {
		return tbAlbumDAO;
	}

	public void setTbAlbumDAO(TbAlbumDAO tbAlbumDAO) {
		this.tbAlbumDAO = tbAlbumDAO;
	}
}
