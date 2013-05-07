package com.yueyun.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Friend;
import com.yueyun.domain.User;
import com.yueyun.service.TbRelationService;

@SuppressWarnings("serial")
public class UserFriendAjaxAction  extends ActionSupport implements SessionAware{

	public static final String FOLLOW_FRIEND_SUCCESS = "FOLLOW_FRIEND_SUCCESS";
	public static final String FOLLOW_FRIEND_FAIL = "FOLLOW_FRIEND_FAIL";
	
	private Map<String, Object> session;
	private TbRelationService tbRelationService;
	
	private String friendId;
	private String result;
	private Friend friend;
	
	public String followFriend(){
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		friend = tbRelationService.addUserFriend(currentUser.getUserId(), Integer.parseInt(friendId));
		if(friend != null){
			result = "FOLLOW_FRIEND_SUCCESS";
		}else{
			result = "FOLLOW_FRIEND_FAIL";
		}
		return Action.SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
	public TbRelationService getTbRelationService() {
		return tbRelationService;
	}
	@JSON(serialize=false)
	public void setTbRelationService(TbRelationService tbRelationService) {
		this.tbRelationService = tbRelationService;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

}
