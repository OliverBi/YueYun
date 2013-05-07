package com.yueyun.domain;

import java.util.Date;

public class User {
	private Integer userId;
	private String userName;
	private String userEmail;
	private Date userBirthday;
	private String userGender;
	private String userDescription;
	private String userAvatarUrl;
	private Integer userFollowNum;
	private Integer userFanNum;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	public String getUserAvatarUrl() {
		return userAvatarUrl;
	}
	public void setUserAvatarUrl(String userAvatarUrl) {
		this.userAvatarUrl = userAvatarUrl;
	}
	public Integer getUserFollowNum() {
		return userFollowNum;
	}
	public void setUserFollowNum(Integer userFollowNum) {
		this.userFollowNum = userFollowNum;
	}
	public Integer getUserFanNum() {
		return userFanNum;
	}
	public void setUserFanNum(Integer userFanNum) {
		this.userFanNum = userFanNum;
	} 
}
