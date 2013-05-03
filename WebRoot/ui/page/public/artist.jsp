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
    
    <title><s:property value="artist.artistName"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/artist.css" rel="stylesheet"/>
	
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
	
	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp"></s:include>
  	<div id="artistPageBack" class="pageBack">
  		<div id="artistPageContainer" class="pageContainer">
  			<div class="artistPageLeftContainer">
  				<div class="artistTitleContainer"><s:property value="artist.artistName"/></div>
  				<div class="artistTracksContainer">
  					<div class="artistTracksTitle"></div>
  					<div class="artistTracksListContainer">
  						<%-- <div class="listSelectAll">
	  						<input id="selectAllTracks" type="checkbox"/>
	  						<label for="selectAllTracks"><s:text name="selectAll"/></label> 
	  					</div> --%>
	  					<s:iterator value="artistTrackList" id="track">
	  						<div class="listItem">
		  						<!-- <input type="checkbox"/> -->
		  						<div class="trackName">
		  							<a href="public/track?track.trackId=<s:property value='trackId'/>">
		  								<s:property value="trackName"/>
		  							</a>
		  						</div>
		  						<div class="albumName">
		  							<a href="public/album?album.albumId=<s:property value='trackAlbum.albumId'/>">
		  								<s:property value="trackAlbum.albumName"/>
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
	  					<%-- <!--Test Tracks-->
	  					<div class="listItem">
	  						<input type="checkbox"/>
	  						<div class="trackName">
	  							<a href="#">发如雪</a>
	  						</div>
	  						<div class="albumName">
	  							<a href="#">11月的肖邦</a>
	  						</div>
	  						<div class="trackOption">
	  							<a title="<s:text name='play'/>" class="play" href="#"></a>
	  							<a title="<s:text name='add'/>" class="add" href="#"></a>
	  							<a title="<s:text name='like'/>" class="like" href="#"></a>
	  							<a title="<s:text name='store'/>" class="collect" href="#"></a>
	  							<a title="<s:text name='share'/>" class="share" href="#"></a>
	  						</div>
	  					</div>
	  					<!--Test Tracks--> --%>
  					</div>
  				</div>
  				<div class="artistAlbumsContainer">
  					<div class="artistAlbumsTitle"></div>
  					<div class="artistAlbumsListContainer">
  						<s:iterator value="artistAlbumList" id="album">
  							<div class="aristAlbumItemContainer">
	  							<a href="public/album?album.albumId=<s:property value='albumId'/>">
	  								<img src="<s:property value='albumImgList[2].imageUrl'/>"/>
	  							</a>
	  							<div class="albumTitle">
	  								<a href="public/album?album.albumId=<s:property value='albumId'/>">
	  									<s:property value="albumName"/>
	  								</a>
	  							</div>
	  						</div>
  						</s:iterator>
  						<!-- <div class="aristAlbumItemContainer">
  							<a href="#">
  								<img src="ui/img/test/album/img1.jpg"/>
  							</a>
  							<div class="albumTitle">
  								<a href="#">12新作</a>
  							</div>
  						</div> -->
  					</div>
  				</div>
  			</div>
  			<div class="artistPageRightContainer">
  				<div class="artistImgContainer">
  					<img src="<s:property value='artist.artistImgList[3].imageUrl'/>"/>
  				</div>
  				<div class="artistInfoContainer">
  					<div class="artistInfoTitle"></div>
  					<div class="artistInfoDetail">
  						<span><s:property value="artist.artistDescription"/></span>
  					</div>
  				</div>
  			</div>
  			<div style="clear:both;height:100px;"></div>
  		</div>
  	</div>
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
