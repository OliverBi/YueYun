package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbHotartist;
import com.yueyun.dao.TbHotartistDAO;
import com.yueyun.dao.TbHotrecommendtrack;
import com.yueyun.dao.TbHotrecommendtrackDAO;
import com.yueyun.dao.TbNewalbum;
import com.yueyun.dao.TbNewalbumDAO;
import com.yueyun.dao.TbNewrecommendtrack;
import com.yueyun.dao.TbNewrecommendtrackDAO;
import com.yueyun.dao.TbTrackrank;
import com.yueyun.dao.TbTrackrankDAO;
import com.yueyun.domain.Album;
import com.yueyun.domain.Artist;
import com.yueyun.domain.Track;

public class TbIndexService {
	private TbNewalbumDAO tbNewAlbumDAO;
	private TbNewrecommendtrackDAO tbNewRecommendTrackDAO;
	private TbHotrecommendtrackDAO tbHotRecommendTrackDAO;
	private TbTrackrankDAO tbTrackRankDAO;
	private TbHotartistDAO tbHotArtistDAO;

	private TbTrackService tbTrackService;
	private TbAlbumService tbAlbumService;
	private TbArtistService tbArtistService;
	
	public List<Album> getNewAlbumList(){
		List<Album> newAlbumList = null;
		List<TbNewalbum> tbNewAlbumList = tbNewAlbumDAO.findAll();
		if(tbNewAlbumList.size() > 0){
			newAlbumList = new ArrayList<Album>();
			for(TbNewalbum tbNewAlbum : tbNewAlbumList){
				newAlbumList.add(tbAlbumService.getAlbumInfo(tbNewAlbum.getAlbumId()));
			}
		}
		return newAlbumList;
	}
	
	public List<Track> getNewRecTrackList(){
		List<Track> newRecTrackList = null;
		List<TbNewrecommendtrack> tbNewRecTrackList = tbNewRecommendTrackDAO.findAll();
		if(tbNewRecTrackList.size() > 0){
			newRecTrackList = new ArrayList<Track>();
			for(TbNewrecommendtrack tbNewRecTrack : tbNewRecTrackList){
				newRecTrackList.add(tbTrackService.getTrackInfo(tbNewRecTrack.getTrackId()));
			}
		}
		return newRecTrackList;
	}
	
	public List<Track> getHotRecTrackList(){
		List<Track> hotRecTrackList = null;
		List<TbHotrecommendtrack> tbHotRecTrackList = tbHotRecommendTrackDAO.findAll();
		if(tbHotRecTrackList.size() > 0){
			hotRecTrackList = new ArrayList<Track>();
			for(TbHotrecommendtrack tbHotRecTrack : tbHotRecTrackList){
				hotRecTrackList.add(tbTrackService.getTrackInfo(tbHotRecTrack.getTrackId()));
			}
		}
		return hotRecTrackList;
	}
	
	public List<Track> getTrackRankList(){
		List<Track> trackRankList = null;
		List<TbTrackrank> tbTrackRankList = tbTrackRankDAO.findAll();
		if(tbTrackRankList.size() > 0){
			trackRankList = new ArrayList<Track>();
			for(TbTrackrank tbTrackrank : tbTrackRankList){
				trackRankList.add(tbTrackService.getTrackInfo(tbTrackrank.getTrackId()));
			}
		}
		return trackRankList;
	}
	
	public List<Artist> getHotArtistList(){
		List<Artist> hotArtistList = null;
		List<TbHotartist> tbHotartistList = tbHotArtistDAO.findAll();
		if(tbHotartistList.size() > 0){
			hotArtistList = new ArrayList<Artist>();
			for(TbHotartist tbHotartist : tbHotartistList){
				hotArtistList.add(tbArtistService.getArtistInfo(tbHotartist.getArtistId()));
			}
		}
		return hotArtistList;
	}
	
	public TbNewalbumDAO getTbNewAlbumDAO() {
		return tbNewAlbumDAO;
	}
	public void setTbNewAlbumDAO(TbNewalbumDAO tbNewAlbumDAO) {
		this.tbNewAlbumDAO = tbNewAlbumDAO;
	}
	public TbNewrecommendtrackDAO getTbNewRecommendTrackDAO() {
		return tbNewRecommendTrackDAO;
	}
	public void setTbNewRecommendTrackDAO(
			TbNewrecommendtrackDAO tbNewRecommendTrackDAO) {
		this.tbNewRecommendTrackDAO = tbNewRecommendTrackDAO;
	}
	public TbHotrecommendtrackDAO getTbHotRecommendTrackDAO() {
		return tbHotRecommendTrackDAO;
	}
	public void setTbHotRecommendTrackDAO(
			TbHotrecommendtrackDAO tbHotRecommendTrackDAO) {
		this.tbHotRecommendTrackDAO = tbHotRecommendTrackDAO;
	}
	public TbTrackrankDAO getTbTrackRankDAO() {
		return tbTrackRankDAO;
	}
	public void setTbTrackRankDAO(TbTrackrankDAO tbTrackRankDAO) {
		this.tbTrackRankDAO = tbTrackRankDAO;
	}
	public TbHotartistDAO getTbHotArtistDAO() {
		return tbHotArtistDAO;
	}
	public void setTbHotArtistDAO(TbHotartistDAO tbHotArtistDAO) {
		this.tbHotArtistDAO = tbHotArtistDAO;
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
