package com.yueyun.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Friend;
import com.yueyun.domain.User;
import com.yueyun.service.TbRelationService;

@SuppressWarnings("serial")
public class UserFriendAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	
	private TbRelationService tbRelationService;
	
	private List<Friend> userFollowFriendList;
	private List<Friend> friendFollowUserList;
	
	public String execute(){
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		setUserFollowFriendList(tbRelationService.getUserFriend(currentUser.getUserId()));
		setFriendFollowUserList(tbRelationService.getFriendUser(currentUser.getUserId()));
		return Action.SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public TbRelationService getTbRelationService() {
		return tbRelationService;
	}

	public void setTbRelationService(TbRelationService tbRelationService) {
		this.tbRelationService = tbRelationService;
	}

	public List<Friend> getUserFollowFriendList() {
		return userFollowFriendList;
	}

	public void setUserFollowFriendList(List<Friend> userFollowFriendList) {
		this.userFollowFriendList = userFollowFriendList;
	}

	public List<Friend> getFriendFollowUserList() {
		return friendFollowUserList;
	}

	public void setFriendFollowUserList(List<Friend> friendFollowUserList) {
		this.friendFollowUserList = friendFollowUserList;
	}
}
