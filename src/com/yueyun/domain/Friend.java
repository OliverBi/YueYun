package com.yueyun.domain;

public class Friend {
	private User friend;
	private FriendType friendType;
	private String friendTypeStr;
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}
	public FriendType getFriendType() {
		return friendType;
	}
	public void setFriendType(FriendType friendType) {
		this.friendType = friendType;
	}
	public String getFriendTypeStr() {
		friendTypeStr = friendType.toString();
		return friendTypeStr;
	}
	public void setFriendTypeStr(String friendTypeStr) {
		this.friendTypeStr = friendTypeStr;
	}
	
}
