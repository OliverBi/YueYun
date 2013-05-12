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
    
    <title><s:text name="search"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/search.css" rel="stylesheet"/>
   	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
	
	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp"></s:include>
	
	<div id="searchBack" class="pageBack">
		<div id="searchContainer" class="pageContainer">
			<div id="searchResultTitle">
				<s:text name="searchResult"/>
			</div>
			<div id="searchResultContainer">
				<div id="searchResultMainContainer">
					<s:if test="searchType == 'track'">
						<div class="searchTrackResultTitle">
							<s:text name="track"/>
						</div>
						<div class="searchTrackResultContainer">
							<s:iterator value="searchTrackList" id="track">
								<div class="trackItem">
									<div class="trackImg">
										<img src="ui/img/search/listener.png"/>
									</div>
									<div class="trackName">
										<a target="_blank" href="public/track?track.trackId=<s:property value='trackId'/>">
											<s:property value="trackName"/>
										</a>
									</div>
									<div class="aritstName">
										<a target="_blank" href="public/artist?artist.artistId=<s:property value='trackArtistList[0].artistId'/>">
											<s:property value="trackArtistString"/>
										</a>
									</div>
								</div>
							</s:iterator>
						</div>
					</s:if>
					<s:elseif test="searchType == 'artist'">
						<div class="searchArtistResultTitle">
							<s:text name="artist"/>
						</div>
						<div class="searchArtistResultContainer">
							<s:iterator value="searchArtistList" id="artist">
								<div class="artistItem">
									<div class="artistImg">
										<a href="public/artist?artist.artistId=<s:property value='artistId'/>">
											<img src="<s:property value="artistImgList[2].imageUrl"/>"/>
										</a>
									</div>
									<div class="artistInfo">
										<div class="artistName">
											<a href="public/artist?artist.artistId=<s:property value='artistId'/>">
												<s:property value="artistName"/>
											</a>
										</div>
										<div>TA的单曲:</div>
										<div>TA的专辑:</div>
									</div>
								</div>
							</s:iterator>
						</div>
					</s:elseif>
					<s:elseif test="searchType == 'album'">
						<div class="searchAlbumResultTitle">
							<s:text name="album"/>
						</div>
						<div class="searchAlbumResultContainer">
							<s:iterator value="searchAlbumList" id="album">
								<div class="albumItem">
									<div class="albumImg">
										<a href="public/album?album.albumId=<s:property value='albumId'/>">
											<img src="<s:property value='albumImgList[2].imageUrl'/>"/>
										</a>
									</div>
									<div class="albumInfo">
										<div class="albumName">
											<a href="public/album?album.albumId=<s:property value='albumId'/>">
												<s:property value="albumName"/>
											</a>
										</div>
										<div class="artistName">
											歌手:<a href="public/artist?artist.artistId=<s:property value='albumArtist.artistId'/>">&nbsp;
												<s:property value="albumArtist.artistName"/>
											</a>
										</div>
										<div>发行时间:</div>
									</div>
								</div>
							</s:iterator>
						</div>
					</s:elseif>
					<%-- <div class="searchTrackResultTitle">
						<s:text name="track"/>
					</div>
					<div class="searchTrackResultContainer">
						<div class="trackItem">
							<div class="trackImg">
								<img src="ui/img/search/listener.png"/>
							</div>
							<div class="trackName">
								<a href="#">
									红尘客栈
								</a>
							</div>
							<div class="aritstName">
								<a href="#">
									周杰伦
								</a>
							</div>
						</div>
					</div> --%>
					<%-- <div class="searchArtistResultTitle">
						<s:text name="artist"/>
					</div>
					<div class="searchArtistResultContainer">
						<div class="artistItem">
							<div class="artistImg">
								<a href="#">
									<img src="ui/img/test/img1.jpg"/>
								</a>
							</div>
							<div class="artistInfo">
								<div class="artistName">
									<a href="#">周杰伦</a>
								</div>
								<div>TA的单曲:</div>
								<div>TA的专辑:</div>
							</div>
						</div>
					</div>
					<div class="searchAlbumResultTitle">
						<s:text name="album"/>
					</div>
					<div class="searchAlbumResultContainer">
						<div class="albumItem">
							<div class="albumImg">
								<a href="#">
									<img src="ui/img/play/album_bg.jpg"/>
								</a>
							</div>
							<div class="albumInfo">
								<div class="albumName">
									<a href="#">12新作</a>
								</div>
								<div class="artistName">
									歌手:<a href="#">&nbsp;周杰伦</a>
								</div>
								<div>发行时间:</div>
							</div>
						</div>
					</div> --%>
				</div>
				<div id="searchResultSideContainer">
					
				</div>
				<div style="clear:both;"></div>
			</div>
		</div>
	</div>
  
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
