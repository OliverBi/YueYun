package com.yueyun.domain;

public enum StatusType {
	COMMON{
		public String toString(){
			return "COMMON";
		}
	},
	SHARE_ALBUM{
		public String toString(){
			return "SHARE_ALBUM";
		}
	},
	SHARE_TRACK{
		public String toString(){
			return "SHARE_TRACK";
		}
	}
}
