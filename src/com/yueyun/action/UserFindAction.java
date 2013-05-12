package com.yueyun.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.yueyun.domain.Find;
import com.yueyun.domain.FindType;
import com.yueyun.domain.User;
import com.yueyun.recommender.AlbumNoPreferenceDataModel;
import com.yueyun.recommender.MusicNoPreferenceRecommender;
import com.yueyun.recommender.TrackNoPreferenceDataModel;
import com.yueyun.service.TbAlbumService;
import com.yueyun.service.TbFindService;
import com.yueyun.service.TbTrackService;
import com.yueyun.service.TbUserService;

@SuppressWarnings("serial")
public class UserFindAction extends ActionSupport implements SessionAware{
	
	public static final int RECOMMEND_NUM = 10;
	
	private DataSource dataSource;
	
	private Map<String, Object> session;
	
	private TbAlbumService tbAlbumService;
	private TbTrackService tbTrackService;
	private TbUserService tbUserService;
	private TbFindService tbFindService;
	
	private List<Find> findList;
	
	public String execute(){
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		
		TrackNoPreferenceDataModel trackNoPreferenceDataModel = new TrackNoPreferenceDataModel(dataSource);
		AlbumNoPreferenceDataModel albumNoPreferenceDataModel = new AlbumNoPreferenceDataModel(dataSource);
		try{
			MusicNoPreferenceRecommender trackRecommender = new MusicNoPreferenceRecommender(trackNoPreferenceDataModel);
			MusicNoPreferenceRecommender albumRecommender = new MusicNoPreferenceRecommender(albumNoPreferenceDataModel);
			List<RecommendedItem> trackRecommendItems =  trackRecommender.recommend(currentUser.getUserId(), RECOMMEND_NUM);
			List<RecommendedItem> albumRecommendItems = albumRecommender.recommend(currentUser.getUserId(), RECOMMEND_NUM);
			
			findList = new ArrayList<Find>();
			
			for(RecommendedItem item : albumRecommendItems){
				Find find = new Find();
				find.setFindType(FindType.FIND_ALBUM);
				find.setAlbum(tbAlbumService.getAlbumInfo(new Long(item.getItemID()).intValue()));
				find.setListenerNum(tbFindService.getAlbumListenerNum(new Long(item.getItemID()).intValue()));
				find.setAlbumTrackList(tbAlbumService.getAlbumTrackList(new Long(item.getItemID()).intValue()));
				findList.add(find);
			}
			
			for(RecommendedItem item : trackRecommendItems){
				Find find = new Find();
				find.setFindType(FindType.FIND_TRACK);
				find.setTrack(tbTrackService.getTrackInfo(new Long(item.getItemID()).intValue()));
				find.setListenerNum(tbFindService.getTrackListenerNum(new Long(item.getItemID()).intValue()));
				find.setTrackListenerList(tbFindService.getTrackListenerList(new Long(item.getItemID()).intValue()));
				findList.add(find);
			}
			
			//Add Test Data
			/*Find find = new Find();
			find.setFindType(FindType.FIND_TRACK);
			find.setTrack(tbTrackService.getTrackInfo(110));
			find.setListenerNum(tbFindService.getTrackListenerNum(110));
			find.setTrackListenerList(tbFindService.getTrackListenerList(110));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_TRACK);
			find.setTrack(tbTrackService.getTrackInfo(120));
			find.setListenerNum(tbFindService.getTrackListenerNum(120));
			find.setTrackListenerList(tbFindService.getTrackListenerList(120));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_TRACK);
			find.setTrack(tbTrackService.getTrackInfo(130));
			find.setListenerNum(tbFindService.getTrackListenerNum(130));
			find.setTrackListenerList(tbFindService.getTrackListenerList(130));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_TRACK);
			find.setTrack(tbTrackService.getTrackInfo(131));
			find.setListenerNum(tbFindService.getTrackListenerNum(131));
			find.setTrackListenerList(tbFindService.getTrackListenerList(131));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_TRACK);
			find.setTrack(tbTrackService.getTrackInfo(134));
			find.setListenerNum(tbFindService.getTrackListenerNum(134));
			find.setTrackListenerList(tbFindService.getTrackListenerList(134));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_ALBUM);
			find.setAlbum(tbAlbumService.getAlbumInfo(16));
			find.setListenerNum(tbFindService.getAlbumListenerNum(16));
			find.setAlbumTrackList(tbAlbumService.getAlbumTrackList(16));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_ALBUM);
			find.setAlbum(tbAlbumService.getAlbumInfo(17));
			find.setListenerNum(tbFindService.getAlbumListenerNum(17));
			find.setAlbumTrackList(tbAlbumService.getAlbumTrackList(17));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_ALBUM);
			find.setAlbum(tbAlbumService.getAlbumInfo(18));
			find.setListenerNum(tbFindService.getAlbumListenerNum(18));
			find.setAlbumTrackList(tbAlbumService.getAlbumTrackList(18));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_ALBUM);
			find.setAlbum(tbAlbumService.getAlbumInfo(19));
			find.setListenerNum(tbFindService.getAlbumListenerNum(19));
			find.setAlbumTrackList(tbAlbumService.getAlbumTrackList(19));
			findList.add(find);
			
			find = new Find();
			find.setFindType(FindType.FIND_ALBUM);
			find.setAlbum(tbAlbumService.getAlbumInfo(20));
			find.setListenerNum(tbFindService.getAlbumListenerNum(20));
			find.setAlbumTrackList(tbAlbumService.getAlbumTrackList(20));
			findList.add(find);*/
			
			Collections.shuffle(findList);
			
		}catch(TasteException ex){
			
		}
		return Action.SUCCESS;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public TbAlbumService getTbAlbumService() {
		return tbAlbumService;
	}

	public void setTbAlbumService(TbAlbumService tbAlbumService) {
		this.tbAlbumService = tbAlbumService;
	}

	public TbTrackService getTbTrackService() {
		return tbTrackService;
	}

	public void setTbTrackService(TbTrackService tbTrackService) {
		this.tbTrackService = tbTrackService;
	}

	public TbUserService getTbUserService() {
		return tbUserService;
	}

	public void setTbUserService(TbUserService tbUserService) {
		this.tbUserService = tbUserService;
	}

	public List<Find> getFindList() {
		return findList;
	}

	public void setFindList(List<Find> findList) {
		this.findList = findList;
	}

	public TbFindService getTbFindService() {
		return tbFindService;
	}

	public void setTbFindService(TbFindService tbFindService) {
		this.tbFindService = tbFindService;
	}
}
