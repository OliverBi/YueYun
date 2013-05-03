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
    
    <title><s:property value="album.albumName"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/album.css" rel="stylesheet"/>
   	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
	
	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="ui/js/album.js" type="text/javascript"></script>
  </head>
  
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp"></s:include>
  	<div id="albumPageBack" class="pageBack">
  		<div id="albumPageContainer" class="pageContainer">
  			<div class="albumPageLeftContainer">
	  			<div class="albumImgContainer">
	  				<img src="<s:property value='album.albumImgList[2].imageUrl'/>"/>
	  			</div>
	  			<div class="albumInfoContainer">
	  				<div class="albumInfoTitleContainer"><s:property value="album.albumName"/></div>
	  				<div class="albumInfoPlayContainer"></div>
	  				<input id="albumId" type="hidden" value="<s:property value='album.albumId'/>"/>
	  				<div class="albumInfoContentContainer">
	  					<span>歌手： <s:property value="album.albumArtist.artistName"/></span>
	  					<span>语言： </span>
	  					<span>发行时间：<s:date name="album.albumReleaseDate" format="yyyy-MM-dd"/></span>
	  					<span>唱片公司：</span>
	  				</div>
	  				<div class="albumInfoOptionContainer">
	  					<a class="albumInfoOptionItem store" href="javascript:void(0);">
	  						<span class="storeImg"></span>
	  						<span><s:text name="store"/></span>
	  					</a>
	  					<a class="albumInfoOptionItem share" href="javascript:void(0);">
	  						<span class="shareImg"></span>
	  						<span><s:text name="share"/></span>
	  					</a>
	  					<a class="albumInfoOptionItem good" href="javascript:void(0);">
	  						<span class="goodImg"></span>
	  						<span><s:text name="good"/></span>
	  					</a>
	  					<a class="albumInfoOptionItem bad" href="javascript:void(0);">
	  						<span class="badImg"></span>
	  						<span><s:text name="bad"/></span>
	  					</a>
	  				</div>
	  			</div>
	  			<div style="clear:both;"></div>
	  			<div class="albumTracksContainer">
	  				<div class="albumTracksTitleContainer"></div>
	  				<div style="clear:both;"></div>
	  				<div class="albumTracksListContainer">
	  					<%-- <div class="listSelectAll">
	  						<input id="selectAllTracks" type="checkbox"/>
	  						<label for="selectAllTracks"><s:text name="selectAll"/></label> 
	  					</div> --%>
	  					<s:iterator value="albumTrackList" id="trackItem">
	  						<div class="listItem">
		  						<!-- input type="checkbox"/> -->
		  						<div class="trackName">
		  							<a href="public/track?track.trackId=<s:property value='trackId'/>">
		  								<s:property value="trackName"/>
		  							</a>
		  						</div>
		  						<div class="artistName">
		  							<a href="public/artist?artist.artistId=<s:property value='trackArtistList[0].artistId'/>">
		  								<s:property value="trackArtistString"/>
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
	  					<%-- Example 
	  						<div class="listItem">
	  						<input type="checkbox"/>
	  						<div class="trackName">
	  							<a href="#">发如雪</a>
	  						</div>
	  						<div class="artistName">
	  							<a href="#">周杰伦</a>
	  						</div>
	  						<div class="trackOption">
	  							<a title="<s:text name='play'/>" class="play" href="#"></a>
	  							<a title="<s:text name='add'/>" class="add" href="#"></a>
	  							<a title="<s:text name='like'/>" class="like" href="#"></a>
	  							<a title="<s:text name='store'/>" class="collect" href="#"></a>
	  							<a title="<s:text name='share'/>" class="share" href="#"></a>
	  						</div>
	  					</div> --%>
	  				</div>
	  			</div>
	  			<div style="clear:both;"></div>
  			</div>
  			<div class="albumPageRightContainer">
  				<div class="albumOthersContainer">
  					<div class="albumOthersTitleContainer"></div>
  					<div class="albumOthersContentContainer">
  						<s:if test="albumOtherAlbumList.isEmpty">
  							<span><s:text name="TADonotHaveOtherAlbums"/></span>
  						</s:if>
  						<s:else>
	  						<s:iterator value="albumOtherAlbumList" id="ablum">
	  							<div class="albumOthersItemContainer">
		  							<a href="public/album?album.albumId=<s:property value='albumId'/>">
		  								<img src="<s:property value='albumImgList[2].imageUrl'/>" class="albumImage"/>
		  							</a>
		  							<div class="albumTitle">	
		  								<a href="public/album?album.albumId=<s:property value='albumId'/>">
		  									<s:property value="albumName"/>
		  								</a>
		  							</div>
		  							<div class="albumDate"><s:date name="albumReleaseDate" format="yyyy-MM-dd"/></div>
		  						</div>
	  						</s:iterator>
  						</s:else>
  						<!-- Example
  							<div class="albumOthersItemContainer">
  							<a href="#">
  								<img src="ui/img/test/album/img1.jpg" class="albumImage"/>
  							</a>
  							<div class="albumTitle">	
  								<a href="#">11月的肖邦</a>
  							</div>
  							<div class="albumDate">2012-5-12</div>
  						</div> -->
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
