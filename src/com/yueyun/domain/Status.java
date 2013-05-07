package com.yueyun.domain;

import java.util.Date;

public class Status implements Comparable<Status>{
	public static final long ONE_DAY_SECOND = 86400000;
	
	private Integer statusId;
	private User statusUser;
	private StatusType statusType;
	private String statusTypeStr;
	private String statusContent;
	private Track shareTrack;
	private Album shareAlbum;
	private Date statusTime;
	public User getStatusUser() {
		return statusUser;
	}
	public void setStatusUser(User statusUser) {
		this.statusUser = statusUser;
	}
	public StatusType getStatusType() {
		return statusType;
	}
	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}
	public String getStatusContent() {
		return statusContent;
	}
	public void setStatusContent(String statusContent) {
		this.statusContent = statusContent;
	}
	public Track getShareTrack() {
		return shareTrack;
	}
	public void setShareTrack(Track shareTrack) {
		this.shareTrack = shareTrack;
	}
	public Album getShareAlbum() {
		return shareAlbum;
	}
	public void setShareAlbum(Album shareAlbum) {
		this.shareAlbum = shareAlbum;
	}
	public Date getStatusTime() {
		return statusTime;
	}
	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	@Override
	public int compareTo(Status o) {
		if(this.getStatusTime().getTime() == o.getStatusTime().getTime())
			return 0;
		else if(this.getStatusTime().getTime() > o.getStatusTime().getTime())
			return -1;
		else
			return 1;
	}
	public String getStatusTypeStr() {
		statusTypeStr = statusType.toString();
		return statusTypeStr;
	}
	public void setStatusTypeStr(String statusTypeStr) {
		this.statusTypeStr = statusTypeStr;
	}
}
