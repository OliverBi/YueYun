package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbArtistlist;
import com.yueyun.dao.TbArtistlistDAO;
import com.yueyun.dao.TbTrack;
import com.yueyun.dao.TbTrackDAO;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Track;

public class TbTrackService {
	private TbTrackDAO tbTrackDAO;
	private TbArtistlistDAO tbArtistListDAO;
	private TbAlbumService tbAlbumService;
	private TbArtistService tbArtistService;
	
	public List<Track> getOtherTrackList(int trackId){
		List<Track> otherTrackList = null;
		TbTrack tbCurrentTrack = tbTrackDAO.findById(trackId);
		List<TbTrack> tbOtherTrackList = tbTrackDAO.findByTrackAlbumId(tbCurrentTrack.getTrackAlbumId());
		if(tbOtherTrackList.size() > 0){
			otherTrackList = new ArrayList<Track>();
			for(TbTrack tbTrack : tbOtherTrackList){
				if(!tbTrack.getTrackId().equals(trackId))
					otherTrackList.add(getTrackInfo(tbTrack.getTrackId()));
			}
		}
		return otherTrackList;
	}
	
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
				Album album = tbAlbumService.getAlbumInfo(tbTrack.getTrackAlbumId());
				track.setTrackAlbum(album);
			}
			
			List<TbArtistlist> tbArtistList = tbArtistListDAO.findByTrackId(trackId);
			if(tbArtistList != null){
				List<Artist> artistList = new ArrayList<Artist>();
				for(TbArtistlist tbArtistListItem : tbArtistList){
					Artist artist = tbArtistService.getArtistInfo(tbArtistListItem.getArtistId());
					if(artist != null){
						artistList.add(artist);
					}
				}
				track.setTrackArtistList(artistList);
			}
		}
		return track;
	}

	public TbTrackDAO getTbTrackDAO() {
		return tbTrackDAO;
	}

	public void setTbTrackDAO(TbTrackDAO tbTrackDAO) {
		this.tbTrackDAO = tbTrackDAO;
	}

	public TbArtistlistDAO getTbArtistListDAO() {
		return tbArtistListDAO;
	}

	public void setTbArtistListDAO(TbArtistlistDAO tbArtistListDAO) {
		this.tbArtistListDAO = tbArtistListDAO;
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
}
