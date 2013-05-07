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
	<link type="text/css" href="ui/css/home.css" rel="stylesheet"/>
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
	
	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<%-- <script src="ui/js/jquery/jquery-position.js" type="text/javascript"></script> --%>
	<script src="ui/js/home.js" type="text/javascript"></script>
  </head>
  	
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp">
  		<s:param name="navItem">personalPage</s:param>
  	</s:include>
  	
  	<div id="homePageBack" class="pageBack">
  		<div style="height:160px;"></div>
  		<div id="homePageContainer" class="pageContainer">
  			<div id="homePageHeaderContainer">
  				<div id="homePageMenuContainer">
  					<ul class="homePageMenuItems">
  						<li class="homePageMenuItemOn"><a href="user/home"><s:text name="homePage" /></a></li>
  						<%-- <li class="homePageMenuItem"><a href="#"><s:text name="collect" /></a></li> --%>
  						<li class="homePageMenuItem"><a href="user/collect"><s:text name="store" /></a></li>
  						<%-- <li class="homePageMenuItem"><a href="#"><s:text name="blog" /></a></li> --%>
  						<%-- <li class="homePageMenuItem"><a href="#"><s:text name="photoAlbum" /></a></li> --%>
  						<li class="homePageMenuItem"><a href="user/friend"><s:text name="yueFriend" /></a></li>
  						<%-- <li class="homePageMenuItem"><a href="#"><s:text name="message" /></a></li> --%>
  					</ul>
  				</div>
  				<div id="homePageAvatarContainer">
  					<div class="homePageAvatar">
  						<!-- <img src="ui/img/test/avatar_default_m.gif" /> -->
  						<img src='<s:property value="#session.SESSION_CURRENT_USER.userAvatarUrl"/>' />
  					</div>
  				</div>
  				<div id="homePageUserInfoContainer">
  					<div class="homePageUserNameContainer"><s:property value="#session.SESSION_CURRENT_USER.userName"/></div>
  					<div class="homePageUserSocialContainer">
  						<ul>
  							<li>
  								<span><s:text name="follow"/></span>
  								<a href="javascript:;"><s:property value="#session.SESSION_CURRENT_USER.userFollowNum"/></a>
  							</li>
  							<li>
  								<span>|</span>
  							</li>
  							<li>
  								<span><s:text name="fan"/></span>
  								<a href="javascript:;"><s:property value="#session.SESSION_CURRENT_USER.userFanNum"/></a>
  							</li>
  						</ul>
  					</div>
  				</div>
  				<div id="homePageUserStatusContainer">
  					<form id="statusForm">
	  					<div id="homePageUserStatusSizeContainer">
	  						<span><s:text name="canInput140Char" /></span>
	  					</div>
	  					<div>
	  						<textarea id="statusContent" name="statusContent"></textarea>
	  					</div>
	  					<div id="homePageUserStatusOptContainer">
	  						<input class="homePageUserStatusPulishButtonDisabled" 
	  							type="button" 
	  							value="<s:text name='publish'/>"
	  							disabled="disabled"/>
	  					</div>
	  					<div id="homePageUserStatusSuccessContainer" style="display:none;">
	  						<span class="successIcon"></span>
	  						<span><s:text name="publicSuccessfully"/></span>
	  					</div>
  					</form>
  				</div>
  			</div>
  			<div id="homePageContentContainer">
  				<div id="homePageMainContainer">
  					<div id="homePageStatusMenuContainer">
  						<div class="homePageStatusMenuItemOn">
  							<a href="javascript:;"><s:text name="all"/></a>
  						</div>
  						<%-- <div class="homePageStatusMenuItem">
  							<a href="#"><s:text name="collect"/></a>
  						</div>
  						<div class="homePageStatusMenuItem">
  							<a href="#"><s:text name="store"/></a>
  						</div>
  						<div class="homePageStatusMenuItem">
  							<a href="#"><s:text name="picture"/></a>
  						</div>
  						<div class="homePageStatusMenuItem">
  							<a href="#"><s:text name="blog"/></a>
  						</div> --%>
  					</div>
  					<div style="height:20px;clear:both;"></div>
  					<div style="min-height:500px;">
  					<s:iterator value="userAndFriendStatusList" id="status">
  						<s:if test="#status.statusTypeStr == 'COMMON'">
  							<div class="homePageStatusItemContainer">
		  						<div class="homePageStatusAvatarContainer">
		  							<a href="javascript:;">
		  								<img src="<s:property value='statusUser.userAvatarUrl'/>"/>
		  							</a>
		  						</div>
		  						<div class="homePageStatusContentContainer">
		  							<a class="userName" href="javascript:;"><s:property value="statusUser.userName"/>:</a>
		  							<span class="statusContent"><s:property value="statusContent"/></span>
		  						</div>
		  						<div class="homePageStatusBottomContainer">
		  							<div class="statusTime"><s:date name="statusTime" format="yyyy-MM-dd HH:mm"/></div>
		  						</div>
		  					</div> 
  						</s:if>
  						<s:elseif test="#status.statusTypeStr == 'SHARE_TRACK'">
  							<div class="homePageStatusItemContainer">
		  						<div class="homePageStatusAvatarContainer">
		  							<a href="javascript:;">
		  								<img src="<s:property value='statusUser.userAvatarUrl'/>"/>
		  							</a>
		  						</div>
		  						<div class="homePageStatusContentContainer">
		  							<a class="userName" href="javascript:;"><s:property value="statusUser.userName"/>:</a>
		  							<span class="statusContent"><s:property value="statusContent"/></span>
		  						</div>
		  						<div class="homePageStatusShareTrackContainer">
				  					<a target="_blank" href="public/track?track.trackId=<s:property value='shareTrack.trackId'/>">
				  						<span class="playIcon"></span>
				  						<span><s:property value="shareTrack.trackName"/>&nbsp;-&nbsp;<s:property value="shareTrack.trackArtistString"/></span>
				  					</a>		
				  				</div>
		  						<div class="homePageStatusBottomContainer">
		  							<div class="statusTime"><s:date name="statusTime" format="yyyy-MM-dd HH:mm"/></div>
		  						</div>
		  					</div> 
  						</s:elseif>
  						<s:elseif test="#status.statusTypeStr == 'SHARE_ALBUM'">
  							<div class="homePageStatusItemContainer">
		  						<div class="homePageStatusAvatarContainer">
		  							<a href="javascript:;">
		  								<img src="<s:property value='statusUser.userAvatarUrl'/>"/>
		  							</a>
		  						</div>
		  						<div class="homePageStatusContentContainer">
		  							<a class="userName" href="javascript:;"><s:property value="statusUser.userName"/>:</a>
		  							<span class="statusContent"><s:property value="statusContent"/></span>
		  						</div>
		  						<div class="homePageStatusShareAlbumContainer">
				  					<a target="_blank" class="albumImg" href="public/album?album.albumId=<s:property value='shareAlbum.albumId'/>">
				  						<img src="<s:property value='shareAlbum.albumImgList[1].imageUrl'/>"/>
				  					</a>
				  					<a target="_blank" href="public/album?album.albumId=<s:property value='shareAlbum.albumId'/>">
				  						<span><s:property value="shareAlbum.albumName"/>&nbsp;-&nbsp;<s:property value="shareAlbum.albumArtist.artistName"/></span>
				  						<span class="playIcon"></span>
				  					</a>
				  				</div>
		  						<div class="homePageStatusBottomContainer">
		  							<div class="statusTime"><s:date name="statusTime" format="yyyy-MM-dd HH:mm"/></div>
		  						</div>
		  					</div>
  						</s:elseif>
  					</s:iterator>
  					</div>
  					<%-- <div class="homePageStatusItemContainer">
  						<div class="homePageStatusAvatarContainer">
  							<a href="">
  								<img src="ui/img/test/avatar_default_m.gif"/>
  							</a>
  						</div>
  						<div class="homePageStatusContentContainer">
  							<a class="userName" href="">MYMMoonDT:</a>
  							<span class="statusContent">这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果</span>
  						</div>
  						<div class="homePageStatusShareTrackContainer">
		  					<a href="#">
		  						<span class="playIcon"></span>
		  						<span>I know you are in trouble - Taylor Swift</span>
		  					</a>		
		  				</div>
  						<div class="homePageStatusBottomContainer">
  							<div class="statusTime">今天 12:30</div>
  						</div>
  					</div> --%>
  					
  					<%-- <div class="homePageStatusItemContainer">
  						<div class="homePageStatusAvatarContainer">
  							<a href="">
  								<img src="ui/img/test/avatar_default_m.gif"/>
  							</a>
  						</div>
  						<div class="homePageStatusContentContainer">
  							<a class="userName" href="">MYMMoonDT:</a>
  							<span class="statusContent">这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果</span>
  						</div>
  						<div class="homePageStatusShareAlbumContainer">
		  					<a class="albumImg" href="#">
		  						<img src="ui/img/test/avatar_default_m.gif"/>
		  					</a>
		  					<a href="#">
		  						<span>Everything has changed - Taylor Swift</span>
		  						<span class="playIcon"></span>
		  					</a>
		  				</div>
  						<div class="homePageStatusBottomContainer">
  							<div class="statusTime">今天 12:30</div>
  						</div>
  					</div> --%>
  					<%-- <div class="homePageStatusItemContainer">
  						<div class="homePageStatusAvatarContainer">
  							<a href="">
  								<img src="ui/img/test/avatar_default_m.gif"/>
  							</a>
  						</div>
  						<div class="homePageStatusContentContainer">
  							<a class="userName" href="">MYMMoonDT:</a>
  							<span class="statusContent">这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果</span>
  						</div>
  						<div class="homePageStatusBottomContainer">
  							<div class="statusTime">今天 12:30</div>
  						</div>
  					</div> --%>
  					
  					<%-- <div class="homePageStatusItemContainer">
  						<div class="homePageStatusAvatarContainer">
  							<a href="">
  								<img src="ui/img/test/avatar_default_m.gif"/>
  							</a>
  						</div>
  						<div class="homePageStatusContentContainer">
  							<a class="userName" href="">MYMMoonDT:</a>
  							<span class="statusContent">这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果这是我的第一条状态，用来测试页面显示效果</span>
  						</div>
  						<div class="homePageStatusBottomContainer">
  							<div class="statusTime">今天 12:30</div>
  						</div>
  					</div> --%>
  					<div style="height:60px;">
  					</div>
  				</div>
  				<div id="homePageSideContainer"></div>
  				<div style="clear:both;"></div>
  			</div>
  		</div>
  		<div style="height:40px;"></div>
  	</div>
  	
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
