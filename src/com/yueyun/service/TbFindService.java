package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbAlbumNopreference;
import com.yueyun.dao.TbAlbumNopreferenceDAO;
import com.yueyun.dao.TbAlbumNopreferenceId;
import com.yueyun.dao.TbTrackNopreference;
import com.yueyun.dao.TbTrackNopreferenceDAO;
import com.yueyun.dao.TbTrackNopreferenceId;
import com.yueyun.domain.User;

public class TbFindService {
	private TbTrackNopreferenceDAO tbTrackNopreferenceDAO;
	private TbAlbumNopreferenceDAO tbAlbumNopreferenceDAO;
	
	private TbUserService tbUserService;
	
	public List<User> getTrackListenerList(int trackId){
		List<User> trackListenerList = null;
		List<TbTrackNopreference> result = tbTrackNopreferenceDAO.findByProperty("id.trackId", trackId);
		if(result.size() > 0){
			trackListenerList = new ArrayList<User>();
			for(TbTrackNopreference item : result){
				trackListenerList.add(tbUserService.getUserInfo(item.getId().getUserId()));
			}
		}
		return trackListenerList;
	}
	
	public int getTrackListenerNum(int trackId){
		return tbTrackNopreferenceDAO.findByProperty("id.trackId", trackId).size();
	}
	
	public int getAlbumListenerNum(int albumId){
		return tbAlbumNopreferenceDAO.findByProperty("id.albumId", albumId).size();
	}
	
	public void addTrackPlayLog(int userId, int trackId){
		TbTrackNopreference noPreference = new TbTrackNopreference();
		TbTrackNopreferenceId noPreferenceId = new TbTrackNopreferenceId();
		noPreferenceId.setUserId(userId);
		noPreferenceId.setTrackId(trackId);
		noPreference.setId(noPreferenceId);
		if(tbTrackNopreferenceDAO.findById(noPreferenceId) == null)
			tbTrackNopreferenceDAO.save(noPreference);
	}
	
	public void addAlbumPlayLog(int userId, int albumId){
		TbAlbumNopreference noPreference = new TbAlbumNopreference();
		TbAlbumNopreferenceId noPreferenceId = new TbAlbumNopreferenceId();
		noPreferenceId.setUserId(userId);
		noPreferenceId.setAlbumId(albumId);
		noPreference.setId(noPreferenceId);
		if(tbAlbumNopreferenceDAO.findById(noPreferenceId) == null)
			tbAlbumNopreferenceDAO.save(noPreference);
	}
	
	public TbTrackNopreferenceDAO getTbTrackNopreferenceDAO() {
		return tbTrackNopreferenceDAO;
	}
	public void setTbTrackNopreferenceDAO(TbTrackNopreferenceDAO tbTrackNopreferenceDAO) {
		this.tbTrackNopreferenceDAO = tbTrackNopreferenceDAO;
	}
	public TbAlbumNopreferenceDAO getTbAlbumNopreferenceDAO() {
		return tbAlbumNopreferenceDAO;
	}
	public void setTbAlbumNopreferenceDAO(TbAlbumNopreferenceDAO tbAlbumNopreferenceDAO) {
		this.tbAlbumNopreferenceDAO = tbAlbumNopreferenceDAO;
	}

	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}
}
