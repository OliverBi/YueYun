package com.yueyun.domain;

public enum FriendType {
	FRIEND_FOLLOW{
		public String toString(){
			return "FRIEND_FOLLOW";
		}
	},
	FRIEND_FAN{
		public String toString(){
			return "FRIEND_FAN";
		}
	},
	FRIEND_BOTH{
		public String toString(){
			return "FRIEND_BOTH";
		}
	},
}
