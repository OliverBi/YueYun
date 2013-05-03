package com.yueyun.service;

import java.util.ArrayList;
import java.util.List;

import com.yueyun.dao.TbRelation;
import com.yueyun.dao.TbRelationDAO;
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
	
	public List<User> getUserFriend(int userId){
		List<User> userFriendsList = null;
		List<TbRelation> tbRelationList = tbRelationDAO.findByUserId(userId);
		if(tbRelationList.size() > 0){
			userFriendsList = new ArrayList<User>();
			for(TbRelation relation : tbRelationList){
				User friend = tbUserService.getUserInfo(relation.getFriendId());
				userFriendsList.add(friend);
			}
		}
		return userFriendsList;
	}

	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}
}
