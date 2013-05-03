package com.yueyun.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.yueyun.dao.TbStatus;
import com.yueyun.dao.TbStatusDAO;
import com.yueyun.domain.Status;
import com.yueyun.domain.StatusType;
import com.yueyun.domain.User;

public class TbStatusService {
	private TbStatusDAO tbStatusDAO;
	private TbUserService tbUserService;
	private TbRelationService tbRelationService;
	private TbAlbumService tbAlbumService;
	private TbTrackService tbTrackService;
	
	public TbStatusDAO getTbStatusDAO() {
		return tbStatusDAO;
	}

	public void setTbStatusDAO(TbStatusDAO tbStatusDAO) {
		this.tbStatusDAO = tbStatusDAO;
	}
	
	public Status addCommonStatus(int userId, String statusContent){
		TbStatus tbStatus = new TbStatus();
		tbStatus.setUserId(userId);
		tbStatus.setStatusContent(statusContent);
		tbStatus.setStatusType(StatusType.COMMON.toString());
		Date currentTime = new Date();
		tbStatus.setStatusTime(new Timestamp(currentTime.getTime()));
		tbStatusDAO.save(tbStatus);
		
		Status status = new Status();
		status.setStatusId(tbStatus.getUserId());
		status.setStatusContent(tbStatus.getStatusContent());
		status.setStatusUser(tbUserService.getUserInfo(tbStatus.getUserId()));
		status.setStatusType(StatusType.valueOf(tbStatus.getStatusType()));
		status.setStatusTime(tbStatus.getStatusTime());
		
		return status;
	}

	public List<Status> getUserStatus(int userId){
		List<Status> userStatusList = null;
		List<TbStatus> tbUserStatusList = tbStatusDAO.findByUserId(userId);
		if(tbUserStatusList.size() > 0){
			userStatusList = new ArrayList<Status>();
			for(TbStatus tbStatus : tbUserStatusList){
				Status status = new Status();
				status.setStatusId(tbStatus.getStatusId());
				status.setStatusUser(tbUserService.getUserInfo(tbStatus.getUserId()));
				status.setStatusContent(tbStatus.getStatusContent());
				status.setStatusTime(tbStatus.getStatusTime());
				if(StatusType.valueOf(tbStatus.getStatusType()).equals(StatusType.COMMON)){
					status.setStatusType(StatusType.COMMON);
				}else if(StatusType.valueOf(tbStatus.getStatusType()).equals(StatusType.SHARE_TRACK)){
					status.setStatusType(StatusType.SHARE_TRACK);
					status.setShareTrack(tbTrackService.getTrackInfo(tbStatus.getShareTrackId()));
				}else if(StatusType.valueOf(tbStatus.getStatusType()).equals(StatusType.SHARE_ALBUM)){
					status.setStatusType(StatusType.SHARE_ALBUM);
					status.setShareAlbum(tbAlbumService.getAlbumInfo(tbStatus.getShareAlbumId()));
				}
				userStatusList.add(status);
			}
		}
		return userStatusList;
	}
	
	public List<Status> getUserAndFriendStatus(int userId){
		List<Status> userAndFriendStatusList = null;
		List<Status> userStatusList = getUserStatus(userId);
		if(userStatusList != null){
			userAndFriendStatusList = new ArrayList<Status>();
			for(Status status : userStatusList){
				userAndFriendStatusList.add(status);
			}
		}
		List<User> userFriendList = tbRelationService.getUserFriend(userId);
		if(userFriendList != null){
			for(User user : userFriendList){
				List<Status> friendStatusList = getUserStatus(user.getUserId());
				if(friendStatusList != null){
					if(userAndFriendStatusList == null)
						userAndFriendStatusList = new ArrayList<Status>();
					for(Status status : friendStatusList){
						userAndFriendStatusList.add(status);
					}
				}
			}
		}
		Collections.sort(userAndFriendStatusList);
		return userAndFriendStatusList;
	}
	
	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	public TbRelationService getTbRelationService() {
		return tbRelationService;
	}

	public void setTbRelationService(TbRelationService tbRelationService) {
		this.tbRelationService = tbRelationService;
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
