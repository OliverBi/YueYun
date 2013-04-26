package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbAlbum;
import com.yueyun.dao.TbAlbumDAO;
import com.yueyun.dao.TbArtist;
import com.yueyun.dao.TbArtistDAO;
import com.yueyun.dao.TbArtistlist;
import com.yueyun.dao.TbArtistlistDAO;
import com.yueyun.dao.TbTrack;
import com.yueyun.dao.TbTrackDAO;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Image;
import com.yueyun.domain.ImageSize;
import com.yueyun.domain.Track;

public class TbMusicService {
	private TbTrackDAO tbTrackDAO;
	private TbAlbumDAO tbAlbumDAO;
	private TbArtistDAO tbArtistDAO;
	private TbArtistlistDAO tbArtistListDAO;
	
	public Track getTrackInfo(int trackId){
		Track track = null;
		TbTrack tbTrack = tbTrackDAO.findById(trackId);
		if(tbTrack != null){
			track = new Track();
			track.setTrackId(tbTrack.getTrackId());
			track.setTrackName(tbTrack.getTrackName());
			track.setTrackUrl(tbTrack.getTrackUrl());
			track.setTrackDuration(tbTrack.getTrackDuration());
			track.setTrackPlayCount(tbTrack.getTrackPlayCount());
			track.setTrackListeners(tbTrack.getTrackListeners());
			
			if(tbTrack.getTrackAlbumId() != null){
				Album album = getAlbumInfo(tbTrack.getTrackAlbumId());
				track.setTrackAlbum(album);
			}
			
			List<TbArtistlist> tbArtistList = tbArtistListDAO.findByTrackId(trackId);
			if(tbArtistList != null){
				List<Artist> artistList = new ArrayList<Artist>();
				for(TbArtistlist tbArtistListItem : tbArtistList){
					Artist artist = getArtistInfo(tbArtistListItem.getArtistId());
					if(artist != null){
						artistList.add(artist);
					}
				}
				track.setTrackArtistList(artistList);
			}
		}
		return track;
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
			
			Artist artist = getArtistInfo(tbAlbum.getAlbumArtistId());
			
			album.setAlbumArtist(artist);
		}
		return album;
	}

	public TbTrackDAO getTbTrackDAO() {
		return tbTrackDAO;
	}

	public void setTbTrackDAO(TbTrackDAO tbTrackDAO) {
		this.tbTrackDAO = tbTrackDAO;
	}

	public TbAlbumDAO getTbAlbumDAO() {
		return tbAlbumDAO;
	}

	public void setTbAlbumDAO(TbAlbumDAO tbAlbumDAO) {
		this.tbAlbumDAO = tbAlbumDAO;
	}

	public TbArtistDAO getTbArtistDAO() {
		return tbArtistDAO;
	}

	public void setTbArtistDAO(TbArtistDAO tbArtistDAO) {
		this.tbArtistDAO = tbArtistDAO;
	}

	public TbArtistlistDAO getTbArtistListDAO() {
		return tbArtistListDAO;
	}

	public void setTbArtistListDAO(TbArtistlistDAO tbArtistListDAO) {
		this.tbArtistListDAO = tbArtistListDAO;
	}
}
