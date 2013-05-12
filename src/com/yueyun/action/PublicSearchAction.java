package com.yueyun.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Track;
import com.yueyun.service.TbAlbumService;
import com.yueyun.service.TbArtistService;
import com.yueyun.service.TbTrackService;


@SuppressWarnings("serial")
public class PublicSearchAction extends ActionSupport implements SessionAware{

	private String searchType;
	private String searchContent;
	
	private List<Track> searchTrackList;
	private List<Artist> searchArtistList;
	private List<Album> searchAlbumList;
	
	private TbTrackService tbTrackService;
	private TbAlbumService tbAlbumService;
	private TbArtistService tbArtistService;
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute(){
		if(searchType.equals("track")){
			searchTrackList = tbTrackService.searchTrack(searchContent);
		}else if(searchType.equals("album")){
			searchAlbumList = tbAlbumService.searchAlbum(searchContent);
		}else if(searchType.equals("artist")){
			searchArtistList = tbArtistService.searchArtist(searchContent);
		}
		return Action.SUCCESS;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List<Track> getSearchTrackList() {
		return searchTrackList;
	}

	public void setSearchTrackList(List<Track> searchTrackList) {
		this.searchTrackList = searchTrackList;
	}

	public List<Artist> getSearchArtistList() {
		return searchArtistList;
	}

	public void setSearchArtistList(List<Artist> searchArtistList) {
		this.searchArtistList = searchArtistList;
	}

	public List<Album> getSearchAlbumList() {
		return searchAlbumList;
	}

	public void setSearchAlbumList(List<Album> searchAlbumList) {
		this.searchAlbumList = searchAlbumList;
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

}
