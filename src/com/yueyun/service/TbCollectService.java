package com.yueyun.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yueyun.dao.TbCollect;
import com.yueyun.dao.TbCollectDAO;
import com.yueyun.domain.Album;
import com.yueyun.domain.Collect;
import com.yueyun.domain.CollectType;
import com.yueyun.domain.Track;

public class TbCollectService {
	private TbCollectDAO tbCollectDAO;
	
	private TbUserService tbUserService;
	private TbAlbumService tbAlbumService;
	private TbTrackService tbTrackService;

	public TbCollectDAO getTbCollectDAO() {
		return tbCollectDAO;
	}

	public void setTbCollectDAO(TbCollectDAO tbCollectDAO) {
		this.tbCollectDAO = tbCollectDAO;
	}
	
	public Collect addCollectAlbum(int userId, int albumId){
		Collect collect = null;
		TbCollect tbCollect = new TbCollect();
		tbCollect.setUserId(userId);
		tbCollect.setAlbumId(albumId);
		List<TbCollect> tbUserCollectList = tbCollectDAO.findByExample(tbCollect);
		if(tbUserCollectList.size() > 0){
			if(tbUserCollectList.size() == 1){
				tbCollect = tbUserCollectList.get(0);
			}else{
				tbCollect = null;
			}
		}else{
			tbCollect.setCollectType(CollectType.COLLECT_ALBUM.toString());
			Date currentTime = new Date();
			tbCollect.setCollectTime(new Timestamp(currentTime.getTime()));
			tbCollectDAO.save(tbCollect);
		}
		if(tbCollect != null){
			collect = new Collect();
			collect.setCollectId(tbCollect.getCollectId());
			collect.setUser(tbUserService.getUserInfo(tbCollect.getUserId()));
			collect.setCollectType(CollectType.valueOf(tbCollect.getCollectType()));
			collect.setAlbum(tbAlbumService.getAlbumInfo(tbCollect.getAlbumId()));
			collect.setCollectTime(tbCollect.getCollectTime());
		}
		return collect;
	}
	
	public Collect addCollectTrack(int userId, int trackId){
		Collect collect = null;
		TbCollect tbCollect = new TbCollect();
		tbCollect.setUserId(userId);
		tbCollect.setTrackId(trackId);
		List<TbCollect> tbUserCollectList = tbCollectDAO.findByExample(tbCollect);
		if(tbUserCollectList.size() > 0){
			if(tbUserCollectList.size() == 1){
				tbCollect = tbUserCollectList.get(0);
			}else{
				tbCollect = null;
			}
		}else{
			tbCollect.setCollectType(CollectType.COLLECT_TRACK.toString());
			Date currentTime = new Date();
			tbCollect.setCollectTime(new Timestamp(currentTime.getTime()));
			tbCollectDAO.save(tbCollect);
		}
		if(tbCollect != null){
			collect = new Collect();
			collect.setCollectId(tbCollect.getCollectId());
			collect.setUser(tbUserService.getUserInfo(tbCollect.getUserId()));
			collect.setCollectType(CollectType.valueOf(tbCollect.getCollectType()));
			collect.setTrack(tbTrackService.getTrackInfo(tbCollect.getTrackId()));
			collect.setCollectTime(tbCollect.getCollectTime());
		}
		
		return collect;
	}
	
	public List<Collect> getCollectTrack(int userId){
		List<Collect> collectTrackList = null;
		TbCollect tbCollect = new TbCollect();
		tbCollect.setUserId(userId);
		tbCollect.setCollectType(CollectType.COLLECT_TRACK.toString());
		List<TbCollect> tbCollectTrackList = tbCollectDAO.findByExample(tbCollect);
		if(tbCollectTrackList.size() > 0){
			collectTrackList = new ArrayList<Collect>();
			for(TbCollect tbCollectItem : tbCollectTrackList){
				Collect collect = new Collect();
				collect.setCollectId(tbCollectItem.getCollectId());
				collect.setUser(tbUserService.getUserInfo(tbCollectItem.getUserId()));
				collect.setCollectType(CollectType.valueOf(tbCollectItem.getCollectType()));
				collect.setCollectTime(tbCollectItem.getCollectTime());
				collect.setTrack(tbTrackService.getTrackInfo(tbCollectItem.getTrackId()));
				collectTrackList.add(collect);
			}
		}
		return collectTrackList;
	}
	
	public List<Collect> getCollectAlbum(int userId){
		List<Collect> collectTrackList = null;
		TbCollect tbCollect = new TbCollect();
		tbCollect.setUserId(userId);
		tbCollect.setCollectType(CollectType.COLLECT_ALBUM.toString());
		List<TbCollect> tbCollectTrackList = tbCollectDAO.findByExample(tbCollect);
		if(tbCollectTrackList.size() > 0){
			collectTrackList = new ArrayList<Collect>();
			for(TbCollect tbCollectItem : tbCollectTrackList){
				Collect collect = new Collect();
				collect.setCollectId(tbCollectItem.getCollectId());
				collect.setUser(tbUserService.getUserInfo(tbCollectItem.getUserId()));
				collect.setCollectType(CollectType.valueOf(tbCollectItem.getCollectType()));
				collect.setCollectTime(tbCollectItem.getCollectTime());
				collect.setAlbum(tbAlbumService.getAlbumInfo(tbCollectItem.getAlbumId()));
				collectTrackList.add(collect);
			}
		}
		return collectTrackList;
	}

	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	public TbAlbumService getTbAlbumService() {
		return tbAlbumService;
	}

	public void setTbAlbumService(TbAlbumService tbAlbumService) {
		this.tbAlbumService = tbAlbumService;
	}

	public TbTrackService getTbTrackService() {
		return tbTrackService;
	}

	public void setTbTrackService(TbTrackService tbTrackService) {
		this.tbTrackService = tbTrackService;
	}
}
