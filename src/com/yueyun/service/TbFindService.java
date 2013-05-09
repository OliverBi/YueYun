package com.yueyun.service;

import com.yueyun.dao.TbAlbumNopreference;
import com.yueyun.dao.TbAlbumNopreferenceDAO;
import com.yueyun.dao.TbAlbumNopreferenceId;
import com.yueyun.dao.TbTrackNopreference;
import com.yueyun.dao.TbTrackNopreferenceDAO;
import com.yueyun.dao.TbTrackNopreferenceId;

public class TbFindService {
	private TbTrackNopreferenceDAO tbTrackNopreferenceDAO;
	private TbAlbumNopreferenceDAO tbAlbumNopreferenceDAO;
	
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
}
