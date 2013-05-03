package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbTrackplaylist;
import com.yueyun.dao.TbTrackplaylistDAO;
import com.yueyun.dao.TbUserplaylist;
import com.yueyun.dao.TbUserplaylistDAO;
import com.yueyun.domain.Track;

public class TbPlayService {
	public static final String DEFAULT_PLAY_LIST = "默认列表";
	
	private TbTrackplaylistDAO tbTrackplaylistDAO;
	private TbUserplaylistDAO tbUserplaylistDAO;
	private TbTrackService tbTrackService;
	private TbAlbumService tbAlbumService;
	
	public Track addTrackToUserDefaultPlayList(int userId, int trackId){
		TbUserplaylist tbUserplaylist = new TbUserplaylist();
		tbUserplaylist.setUserId(userId);
		tbUserplaylist.setUserPlayListName(DEFAULT_PLAY_LIST);
		
		List<TbUserplaylist> userPlayListResult = tbUserplaylistDAO.findByExample(tbUserplaylist);
		if(userPlayListResult.size() == 1){
			tbUserplaylist = userPlayListResult.get(0);
			TbTrackplaylist tbTrackplaylist = new TbTrackplaylist();
			tbTrackplaylist.setUserPlayListId(tbUserplaylist.getUserPlayListId());
			tbTrackplaylist.setTrackId(trackId);
			tbTrackplaylistDAO.save(tbTrackplaylist);
			return tbTrackService.getTrackInfo(trackId);
		}
		return null;
	}
	
	public List<Track> addAlbumToUserDefaultPlayList(int userId, int albumId){
		TbUserplaylist tbUserplaylist = new TbUserplaylist();
		tbUserplaylist.setUserId(userId);
		tbUserplaylist.setUserPlayListName(DEFAULT_PLAY_LIST);
		
		List<TbUserplaylist> userPlayListResult = tbUserplaylistDAO.findByExample(tbUserplaylist);
		if(userPlayListResult.size() == 1){
			tbUserplaylist = userPlayListResult.get(0);
			List<Track> trackList = tbAlbumService.getAlbumTrackList(albumId);
			if(trackList.size() > 0){
				for(int i = trackList.size() - 1; i >= 0; i--){
					addTrackToUserDefaultPlayList(userId,trackList.get(i).getTrackId());
				}
				return trackList;
			}else{
				return null;
			}
		}
		return null;
	}
	
	public List<Track> getUserDefaultPlayList(int userId){
		List<Track> userDefaultPlayList = null;
		TbUserplaylist tbUserplaylist = new TbUserplaylist();
		tbUserplaylist.setUserId(userId);
		tbUserplaylist.setUserPlayListName(DEFAULT_PLAY_LIST);
		
		List<TbUserplaylist> userPlayListResult = tbUserplaylistDAO.findByExample(tbUserplaylist);
		if(userPlayListResult.size() == 1) {
			tbUserplaylist = userPlayListResult.get(0);
			List<TbTrackplaylist> trackPlayListResult = tbTrackplaylistDAO.findByUserPlayListId(tbUserplaylist.getUserPlayListId());
			if(trackPlayListResult.size() > 0){
				userDefaultPlayList = new ArrayList<Track>();
				/*for(TbTrackplaylist tbTrackplaylistItem : trackPlayListResult){
					Track track = tbTrackService.getTrackInfo(tbTrackplaylistItem.getTrackId());
					userDefaultPlayList.add(track);
				}*/
				for(int i = trackPlayListResult.size() - 1; i >= 0; i--){
					Track track = tbTrackService.getTrackInfo(trackPlayListResult.get(i).getTrackId());
					userDefaultPlayList.add(track);
				}
			}
		}
		return userDefaultPlayList;
	}

	public TbTrackplaylistDAO getTbTrackplaylistDAO() {
		return tbTrackplaylistDAO;
	}

	public void setTbTrackplaylistDAO(TbTrackplaylistDAO tbTrackplaylistDAO) {
		this.tbTrackplaylistDAO = tbTrackplaylistDAO;
	}

	public TbUserplaylistDAO getTbUserplaylistDAO() {
		return tbUserplaylistDAO;
	}

	public void setTbUserplaylistDAO(TbUserplaylistDAO tbUserplaylistDAO) {
		this.tbUserplaylistDAO = tbUserplaylistDAO;
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
}
