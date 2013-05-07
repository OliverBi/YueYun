<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="%{getText('personalPage')}" /></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/collect.css" rel="stylesheet"/>
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>

	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="ui/js/jquery/jquery.hashchange.min.js" type="text/javascript"></script>
	<script src="ui/js/jquery/jquery.easytabs.min.js" type="text/javascript"></script>
	<script src="ui/js/collect.js" type="text/javascript"></script>
  </head>
  
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp">
  		<s:param name="navItem">personalPage</s:param>
  	</s:include>
  
  	<div id="collectPageBack" class="pageBack">
  		<div style="height:160px;"></div>
  		<div id="collectPageContainer" class="pageContainer">
  			<s:include value="../../component/homeNavBar.jsp">
  				<s:param name="homeNavItem">collectPage</s:param>
  			</s:include>
  			
  			<div id="collectPageContentContainer">
	  			<div id="collectPageMainContentContainer">
	  				<div id="collectPageTabContainer" class='tab-container'>
	  					<ul class='etabs'>
						    <li class='tab'>
						    	<a href="#collect-track">
						    		<span><s:text name="myCollectTrack"/></span>
						    	</a>
						    </li>
						    <li class='tab'>
						    	<a href="#collect-album">
						    		<span><s:text name="myCollectAlbum"/></span>
						    	</a>
						    </li>
						</ul>
						<div style="clear:both;"></div>
						<div class="panel-container">
							<div id="collect-track">
								<div id="collectPageMenuContainer">
			  						<div class="collectPageMenuItemOn">
			  							<a href="javascript:;"><s:text name="all"/></a>
			  						</div>
			  					</div>
			  					<div style="clear:both;"></div>
			  					<s:iterator value="userCollectTrackList" id="collect">
			  						<div class="collectTrackContainer">
										<div class="collectTrackContent">
											<a target="_blank" href="public/track?track.trackId=<s:property value='track.trackId'/>">
												<span class="playIcon"></span>
												<span><s:property value="track.trackName"/>&nbsp;-&nbsp;<s:property value="track.trackArtistString"/></span>
											</a>
										</div>
										<div class="collectTrackTimeContainer">
											<s:date name="collectTime" format="yyyy-MM-dd HH:mm"/>
											<s:text name="store"/>
										</div>
									</div>
			  					</s:iterator>
								<%-- <div class="collectTrackContainer">
									<div class="collectTrackContent">
										<a href="#">
											<span class="playIcon"></span>
											<span>红尘客栈 - 周杰伦</span>
										</a>
									</div>
									<div class="collectTrackTimeContainer">
										2013-3-15 11:22<s:text name="store"/>
									</div>
								</div> --%>
							</div>
							<div id="collect-album">
								<div id="collectPageMenuContainer">
			  						<div class="collectPageMenuItemOn">
			  							<a href="javascript:;"><s:text name="all"/></a>
			  						</div>
			  					</div>
			  					<div style="clear:both;"></div>
			  					<s:iterator value="userCollectAlbumList" id="collect">
			  						<div class="collectAlbumContainer">
										<div class="collectAlbumImgContainer">
											<a target="_blank" href="public/album?album.albumId=<s:property value='album.albumId'/>">
												<img src="<s:property value='album.albumImgList[2].imageUrl'/>"/>
											</a>
										</div>
										<div class="collectAlbumContentContainer">
											<a target="_blank" href="public/album?album.albumId=<s:property value='album.albumId'/>">
												<span><s:property value="album.albumName"/>&nbsp;-&nbsp;<s:property value="album.albumArtist.artistName"/></span>
												<span class="playIcon"></span>
											</a>
											<span class="collectAlbumTimeContainer">
												<s:date name="collectTime" format="yyyy-MM-dd HH:mm"/>
												<s:text name="store"/>
											</span>
										</div>
									</div>
			  					</s:iterator>
								<%-- <div class="collectAlbumContainer">
									<div class="collectAlbumImgContainer">
										<a target="_blank" href="#">
											<img src="ui/img/test/avatar_default_m.gif"/>
										</a>
									</div>
									<div class="collectAlbumContentContainer">
										<a target="_blank" href="#">
											<span>红尘客栈 - 周杰伦</span>
											<span class="playIcon"></span>
										</a>
										<span class="collectAlbumTimeContainer">
											2013-3-15 11:22<s:text name="store"/>
										</span>
									</div>
								</div> --%>
							</div>
						</div>
	  				</div>
	  			</div>
	  			<div id="collectPageSideContentContainer">
	  				<s:include value="../../component/userInfo.jsp"></s:include>
	  			</div>
	  			<div style="clear:both;"></div>
  			</div>
  		</div>
  		<div style="height:40px;"></div>
  	</div>
  	
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
