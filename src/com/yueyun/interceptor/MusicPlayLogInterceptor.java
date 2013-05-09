package com.yueyun.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.yueyun.domain.User;
import com.yueyun.service.TbFindService;

@SuppressWarnings("serial")
public class MusicPlayLogInterceptor extends AbstractInterceptor{

	private TbFindService tbFindService;
	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		User currentUser = (User)session.get("SESSION_CURRENT_USER");
		
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		String[] trackIdTemp = (String[])parameters.get("trackId");
		if(trackIdTemp != null){
			String trackId = trackIdTemp[0];
			tbFindService.addTrackPlayLog(currentUser.getUserId(), Integer.parseInt(trackId));
		}
		String[] albumIdTemp = (String[])parameters.get("albumId");
		if(albumIdTemp != null){
			String albumId = albumIdTemp[0];
			tbFindService.addAlbumPlayLog(currentUser.getUserId(), Integer.parseInt(albumId));
		}
		
		return invocation.invoke();
	}


	public TbFindService getTbFindService() {
		return tbFindService;
	}


	public void setTbFindService(TbFindService tbFindService) {
		this.tbFindService = tbFindService;
	}

}
