package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbRelation;
import com.yueyun.dao.TbRelationDAO;
import com.yueyun.domain.Friend;
import com.yueyun.domain.FriendType;
import com.yueyun.domain.User;

public class TbRelationService {
	private TbRelationDAO tbRelationDAO;
	private TbUserService tbUserService;

	public TbRelationDAO getTbRelationDAO() {
		return tbRelationDAO;
	}

	public void setTbRelationDAO(TbRelationDAO tbRelationDAO) {
		this.tbRelationDAO = tbRelationDAO;
	}
	
	public int getUserFriendNum(int userId){
		return tbRelationDAO.findByUserId(userId).size();
	}
	
	public int getFriendUserNum(int userId){
		return tbRelationDAO.findByFriendId(userId).size();
	}
	
	public Friend addUserFriend(int userId, int friendId){
		Friend friend = new Friend();
		TbRelation tbRelation = new TbRelation();
		tbRelation.setUserId(userId);
		tbRelation.setFriendId(friendId);
		tbRelationDAO.save(tbRelation);
		
		User user = tbUserService.getUserInfo(friendId);
		friend.setFriend(user);
		TbRelation tbRelationTemp = new TbRelation();
		tbRelationTemp.setUserId(friendId);
		tbRelationTemp.setFriendId(userId);
		if(tbRelationDAO.findByExample(tbRelationTemp).size() > 0){
			friend.setFriendType(FriendType.FRIEND_BOTH);
		}else{
			friend.setFriendType(FriendType.FRIEND_FOLLOW);
		}
		return friend;
	}
	
	public List<Friend> getUserFriend(int userId){
		List<Friend> userFriendsList = null;
		List<TbRelation> tbRelationList = tbRelationDAO.findByUserId(userId);
		if(tbRelationList.size() > 0){
			userFriendsList = new ArrayList<Friend>();
			for(TbRelation relation : tbRelationList){
				User user = tbUserService.getUserInfo(relation.getFriendId());
				Friend friend = new Friend();
				friend.setFriend(user);
				TbRelation relationTemp = new TbRelation();
				relationTemp.setUserId(relation.getFriendId());
				relationTemp.setFriendId(userId);
				if(tbRelationDAO.findByExample(relationTemp).size() > 0){
					friend.setFriendType(FriendType.FRIEND_BOTH);
				}else{
					friend.setFriendType(FriendType.FRIEND_FOLLOW);
				}
				userFriendsList.add(friend);
			}
		}
		return userFriendsList;
	}
	
	public List<Friend> getFriendUser(int userId){
		List<Friend> friendsUserList = null;
		List<TbRelation> tbRelationList = tbRelationDAO.findByFriendId(userId);
		if(tbRelationList.size() > 0){
			friendsUserList = new ArrayList<Friend>();
			for(TbRelation relation : tbRelationList){
				User user = tbUserService.getUserInfo(relation.getUserId());
				Friend friend = new Friend();
				friend.setFriend(user);
				TbRelation relationTemp = new TbRelation();
				relationTemp.setUserId(userId);
				relationTemp.setFriendId(relation.getUserId());
				if(tbRelationDAO.findByExample(relationTemp).size() > 0){
					friend.setFriendType(FriendType.FRIEND_BOTH);
				}else{
					friend.setFriendType(FriendType.FRIEND_FAN);
				}
				friendsUserList.add(friend);
			}
		}
		return friendsUserList;
	}

	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}
}
