<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="track.trackName"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/track.css" rel="stylesheet"/>
	
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
	
	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="ui/js/track.js" type="text/javascript"></script>
  </head>
  
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp"></s:include>
  	<div id="trackPageBack" class="pageBack">
  		<div id="trackPageContainer" class="pageContainer">
  			<div class="trackPageLeftContainer">
  				<div class="trackTitleContainer"><s:property value="track.trackName"/></div>
  				<div class="trackPlayContainer">
  					<a class="play" href="javascript:;" title="<s:text name='play'/>"></a>
  					<a class="add" href="javascript:;" title="<s:text name='add'/>"></a>
  					<input id="trackId" type="hidden" value="<s:property value='track.trackId'/>"/>
  				</div>
  				<div class="trackDetailContainer">
  					<span>歌手： <s:property value="track.trackArtistString"/></span>
  					<span>语言： </span>
  					<span>所属专辑： <s:property value="track.trackAlbum.albumName"/></span>
  					<span>唱片公司：</span>
  				</div>
  				<div class="trackOptionContainer">
  					<a class="trackOptionItem like" href="#">
  						<span class="likeImg"></span>
  						<span><s:text name="like"/></span>
  					</a>
  					<a class="trackOptionItem store" href="#">
  						<span class="storeImg"></span>
  						<span><s:text name="store"/></span>
  					</a>
  					<a class="trackOptionItem share" href="#">
  						<span class="shareImg"></span>
  						<span><s:text name="share"/></span>
  					</a>
  				</div>
  				<div class="trackDetailBorder"></div>
  				<div class="trackLyricContainer">
  					<div class="trackLyricTitle"><s:text name="lyric"/></div>
  					<div class="trackLyricContent">
  						<span></span>
  					</div>
  				</div>
  			</div>
  			<div class="trackPageRightContainer">
  				<div class="trackAlbumImgContainer">
  					<a href="public/album?album.albumId=<s:property value='track.trackAlbum.albumId'/>">
  						<img src="<s:property value='track.trackAlbum.albumImgList[3].imageUrl'/>"/>
  					</a>
  				</div>
  				<div class="trackAlbumTracksContainer">
  					<div class="trackAlbumTracksTitle"><s:text name="tracksInThisAlbum"/></div>
  					<s:iterator value="trackOtherTrackList" id="track">
  						<div class="trackAlbumTracksItem">
	  						<div class="trackName">
	  							<a href="public/track?track.trackId=<s:property value='trackId'/>">
	  								<s:property value="trackName"/>
	  							</a>
	  						</div>
	  						<%-- <div class="trackOption">
	  							<a title="<s:text name='play'/>" class="play" href="#"></a>
	  							<a title="<s:text name='add'/>" class="add" href="#"></a>
	  							<a title="<s:text name='like'/>" class="like" href="#"></a>
	  							<a title="<s:text name='store'/>" class="collect" href="#"></a>
	  							<a title="<s:text name='share'/>" class="share" href="#"></a>
		  					</div> --%>
	  					</div>
  					</s:iterator>
  					<%-- <!-- Test Track -->
  					<div class="trackAlbumTracksItem">
  						<div class="trackName">
  							<a href="#">夜的第七章</a>
  						</div>
  						<div class="trackOption">
  							<a title="<s:text name='play'/>" class="play" href="#"></a>
  							<a title="<s:text name='add'/>" class="add" href="#"></a>
  							<a title="<s:text name='like'/>" class="like" href="#"></a>
  							<a title="<s:text name='store'/>" class="collect" href="#"></a>
  							<a title="<s:text name='share'/>" class="share" href="#"></a>
	  					</div>
  					</div>
  					<!-- Test Track --> --%>
  				</div>
  			</div>
  			<div style="clear:both;height:100px;"></div>
  		</div>
  	</div>
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
