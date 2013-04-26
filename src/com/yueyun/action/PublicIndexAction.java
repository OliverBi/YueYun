package com.yueyun.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Track;
import com.yueyun.service.TbAlbumService;
import com.yueyun.service.TbArtistService;
import com.yueyun.service.TbIndexService;
import com.yueyun.service.TbTrackService;

@SuppressWarnings("serial")
public class PublicIndexAction extends ActionSupport{
	private TbIndexService tbIndexService;
	
	private List<Album> newAlbumList;
	private List<Track> newRecTrackList;
	private List<Track> hotRecTrackList;
	private List<Track> trackRankList;
	private List<Artist> hotArtistList;
	
	public String execute(){
		newAlbumList = tbIndexService.getNewAlbumList();
		newRecTrackList = tbIndexService.getNewRecTrackList();
		hotRecTrackList = tbIndexService.getHotRecTrackList();
		trackRankList = tbIndexService.getTrackRankList();
		hotArtistList = tbIndexService.getHotArtistList();
		return Action.SUCCESS;
	}

	public TbIndexService getTbIndexService() {
		return tbIndexService;
	}

	public void setTbIndexService(TbIndexService tbIndexService) {
		this.tbIndexService = tbIndexService;
	}

	public List<Album> getNewAlbumList() {
		return newAlbumList;
	}

	public void setNewAlbumList(List<Album> newAlbumList) {
		this.newAlbumList = newAlbumList;
	}

	public List<Track> getNewRecTrackList() {
		return newRecTrackList;
	}

	public void setNewRecTrackList(List<Track> newRecTrackList) {
		this.newRecTrackList = newRecTrackList;
	}

	public List<Track> getHotRecTrackList() {
		return hotRecTrackList;
	}

	public void setHotRecTrackList(List<Track> hotRecTrackList) {
		this.hotRecTrackList = hotRecTrackList;
	}

	public List<Track> getTrackRankList() {
		return trackRankList;
	}

	public void setTrackRankList(List<Track> trackRankList) {
		this.trackRankList = trackRankList;
	}

	public List<Artist> getHotArtistList() {
		return hotArtistList;
	}

	public void setHotArtistList(List<Artist> hotArtistList) {
		this.hotArtistList = hotArtistList;
	}
}
