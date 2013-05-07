package com.yueyun.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Status;
import com.yueyun.domain.User;
import com.yueyun.service.TbRelationService;
import com.yueyun.service.TbStatusService;

@SuppressWarnings("serial") 
public class UserHomeAction extends ActionSupport implements SessionAware{
	private List<Status> userAndFriendStatusList;
	private Map<String, Object> session;
	private TbStatusService tbStatusService;
	private TbRelationService tbRelationService;
	
	public String userLoginCheck(){
		if(session.get("SESSION_CURRENT_USER") != null){
			User currentUser = (User)session.get("SESSION_CURRENT_USER");
			currentUser.setUserFollowNum(tbRelationService.getUserFriendNum(currentUser.getUserId()));
			currentUser.setUserFanNum(tbRelationService.getFriendUserNum(currentUser.getUserId()));
			session.put("SESSION_CURRENT_USER", currentUser);
			userAndFriendStatusList = tbStatusService.getUserAndFriendStatus(currentUser.getUserId());
			return Action.SUCCESS;
		}
		else
			return Action.LOGIN;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Status> getUserAndFriendStatusList() {
		return userAndFriendStatusList;
	}

	public void setUserAndFriendStatusList(List<Status> userAndFriendStatusList) {
		this.userAndFriendStatusList = userAndFriendStatusList;
	}

	public TbStatusService getTbStatusService() {
		return tbStatusService;
	}

	public void setTbStatusService(TbStatusService tbStatusService) {
		this.tbStatusService = tbStatusService;
	}

	public TbRelationService getTbRelationService() {
		return tbRelationService;
	}

	public void setTbRelationService(TbRelationService tbRelationService) {
		this.tbRelationService = tbRelationService;
	}
}
