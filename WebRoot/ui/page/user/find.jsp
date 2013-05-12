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
    
    <title><s:text name="find"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/find.css" rel="stylesheet"/>
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>

	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="ui/js/jquery/jquery.wookmark.min.js" type="text/javascript"></script>
	<script src="ui/js/find.js" type="text/javascript"></script>
  </head>
  
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp">
  		<s:param name="navItem">findPage</s:param>
  	</s:include>
  	
  	<div id="findPageBack" class="pageBack">
  		<div id="findPageContainer" class="pageContainer">
  			<div id="tilesTitleContainer">
  				
  			</div>
  			<div id="tilesContainer" role="main">
  				<ul id="tiles">
  					<s:iterator value="findList" id="find">
  						<s:if test="findTypeStr == 'FIND_ALBUM'">
  							<li class="albumTile">
		  						<div class="albumImgContainer">
		  							<a target="_blank" href="public/album?album.albumId=<s:property value='album.albumId'/>">
		  								<img src="<s:property value='album.albumImgList[2].imageUrl'/>"/>
		  							</a>
		  						</div>
		  						<div class="albumTitleContainer">
		  							<s:property value="album.albumName"/>&nbsp;-&nbsp;
		  							<s:property value="album.albumArtist.artistName"/>
		  						</div>
		  						<div class="albumSocialInfoContainer">
		  							<img src="ui/img/find/ear_pic.png"/>
		  							<span><s:property value="listenerNum"/></span>
		  						</div>
		  						<div class="albumTrackListContainer">
		  							<div class="title"><s:text name="trackList"/>:</div>
		  							<s:iterator value="albumTrackList" id="track">
		  								<div class="trackItem">
			  								<a target="_blank" href="public/track?track.trackId=<s:property value='trackId'/>">
			  									<s:property value="trackName"/>
			  								</a>
			  							</div>
		  							</s:iterator>
		  							<!-- <div class="trackItem">
		  								<a href="#">
		  									发如雪
		  								</a>
		  							</div>
		  							<div class="trackItem">
		  								<a href="#">
		  									蓝色风暴
		  								</a>
		  							</div> -->
		  						</div>
		  					</li>
  						</s:if>
  						<s:elseif test="findTypeStr == 'FIND_TRACK'">
  							<li class="trackTile">
		  						<div class="trackImgContainer">
		  							<a target="_blank" href="public/track?track.trackId=<s:property value='track.trackId'/>">
		  								<img src="ui/img/find/track_play_icon.png"/>
		  							</a>
		  						</div>
		  						<div class="trackTitleContainer">
		  							<s:property value="track.trackName"/>&nbsp;-&nbsp;
		  							<s:property value="track.trackArtistString"/>
		  						</div>
		  						<div style="clear:both;"></div>
		  						<div class="trackSocialInfoContainer">
		  							<img src="ui/img/find/ear_pic.png"/>
		  							<span><s:property value="listenerNum"/></span>
		  						</div>
		  						<div class="trackListenerListContainer">
		  							<s:iterator value="trackListenerList" id="listener">
		  								<div class="listenerItem">
			  								<div class="imgContainer">
			  									<img src="<s:property value='userAvatarUrl'/>"/>
			  								</div>
			  								<div class="content">
			  									<span class="user"><s:property value='userName'/></span>
			  									<span><s:text name="heardTA"/></span>
			  								</div>
			  								<div style="clear:both;"></div>
			  							</div>
		  							</s:iterator>
		  							<%-- <div class="listenerItem">
		  								<div class="imgContainer">
		  									<img src="ui/img/test/album/img1.jpg"/>
		  								</div>
		  								<div class="content">
		  									<span class="user">MYMMoonDT</span>
		  									<span>听过TA</span>
		  								</div>
		  								<div style="clear:both;"></div>
		  							</div>
		  							--%>
		  						</div>
		  					</li>
  						</s:elseif>
  					</s:iterator>
  					<%-- <li class="albumTile">
  						<div class="albumImgContainer">
  							<a href="#">
  								<img src="ui/img/test/album/img2.jpg"/>
  							</a>
  						</div>
  						<div class="albumTitleContainer">
  							We are never ever getting back together - Taylor Swift
  						</div>
  						<div class="albumSocialInfoContainer">
  							<img src="ui/img/find/ear_pic.png"/>
  							<span>120</span>
  						</div>
  						<div class="albumTrackListContainer">
  							<div class="title">歌曲列表:</div>
  							<div class="trackItem">
  								<a href="#">
  									发如雪
  								</a>
  							</div>
  							<div class="trackItem">
  								<a href="#">
  									蓝色风暴
  								</a>
  							</div>
  						</div>
  					</li>
  					<li class="trackTile">
  						<div class="trackImgContainer">
  							<a href="#">
  								<img src="ui/img/find/track_play_icon.png"/>
  							</a>
  						</div>
  						<div class="trackTitleContainer">
  							发如雪 - 周杰伦
  						</div>
  						<div style="clear:both;"></div>
  						<div class="trackSocialInfoContainer">
  							<img src="ui/img/find/ear_pic.png"/>
  							<span>120</span>
  						</div>
  						<div class="trackListenerListContainer">
  							<div class="listenerItem">
  								<div class="imgContainer">
  									<img src="ui/img/test/album/img1.jpg"/>
  								</div>
  								<div class="content">
  									<span class="user">MYMMoonDT</span>
  									<span>听过TA</span>
  								</div>
  								<div style="clear:both;"></div>
  							</div>
  							<div class="listenerItem">
  								<div class="imgContainer">
  									<img src="ui/img/test/album/img1.jpg"/>
  								</div>
  								<div class="content">
  									<span class="user">MYMMoonDT</span>
  									<span>听过TA</span>
  								</div>
  								<div style="clear:both;"></div>
  							</div>
  						</div>
  					</li> --%>
  				</ul>
  			</div>
  		</div>
  	</div>
  	
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
