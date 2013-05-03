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
    
    <title><s:text name="musicBox"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link type="text/css" href="ui/css/jplaySkin/black.sunday/jplayer.black.sunday.css" rel="stylesheet"/>
	<!-- <link type="text/css" href="ui/css/jplaySkin/blue.monday/jplayer.blue.monday.css" rel="stylesheet"/> -->
	<link type="text/css" href="ui/css/jquery-ui-1.10.2.custom.css" rel="stylesheet"/>
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>

	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="ui/js/jquery/jquery-ui-1.10.2.custom.js" type="text/javascript"></script>
  	<script src="ui/js/jquery/jquery.jplayer.js" type="text/javascript"></script>
  	<script src="ui/js/jquery/jplayer.playlist.js" type="text/javascript"></script>
 	<script src="ui/js/play.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<div id="jquery_jplayer_N"></div>
  	<div id="jp_container_N" class="jp-audio">
  		<div class="jp-type-playlist">
  			<div id="jpHeadContainer">
  				<div id="yueyunLogoContainer"></div>
  				<div id="yueyunUserContainer">
  					<a href="user/home" target="_blank"><s:property value="#session.SESSION_CURRENT_USER.userName"/></a>
  					<%-- <input id="userDefaultPlayList" type="hidden" value='<s:property value="userDefaultPlayListJsonStr"/>'/> --%>
  					<div id="userDefaultPlayList" style="display:none;"><s:property value="userDefaultPlayListJsonStr"/></div>
  				</div>
  				<div id="yueyunHomePageContainer">
  					<a href="public/index" target="_blank"><s:text name="yueyunHomepage"/></a>
  				</div>
  			</div>
  			<div id="jpControlContainer" class="jp-gui jp-interface">
				<ul class="jp-controls">
					<li><a tabindex="1" class="jp-previous" href="javascript:;">previous</a></li>
					<li><a tabindex="1" class="jp-play" href="javascript:;">play</a></li>
					<li><a tabindex="1" class="jp-pause" href="javascript:;" style="display: none;">pause</a></li>
					<li><a tabindex="1" class="jp-next" href="javascript:;">next</a></li>
					<li><a title="mute" tabindex="1" class="jp-mute" href="javascript:;">mute</a></li>
					<li><a title="unmute" tabindex="1" class="jp-unmute" href="javascript:;" style="display: none;">unmute</a></li>
				</ul>
				<div class="jp-progress">
					<div class="jp-seek-bar ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all">
						<div class="jp-play-bar ui-slider-range ui-widget-header ui-slider-range-min" style="width: 0%;"></div>
						<a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 0%;"></a>
					</div>
				</div>
				<div class="jp-volume-bar ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all">
					<div class="jp-volume-bar-value ui-slider-range ui-widget-header ui-slider-range-min" style="width: 80%;"></div>
					<a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 80%;"></a>
				</div>
				<div class="jp-time-holder">
					<div class="jp-current-time">00:00</div>
					<div class="jp-time-split">&nbsp;/&nbsp;</div>
					<div class="jp-duration">00:00</div>
				</div>
				<ul class="jp-toggles">
					<li><a title="shuffle" tabindex="1" class="jp-shuffle" href="javascript:;">shuffle</a></li>
					<li><a title="shuffle off" tabindex="1" class="jp-shuffle-off" href="javascript:;" style="display: none;">shuffle off</a></li>
					<li><a title="repeat" tabindex="1" class="jp-repeat" href="javascript:;">repeat</a></li>
					<li><a title="repeat off" tabindex="1" class="jp-repeat-off" href="javascript:;" style="display: none;">repeat off</a></li>
				</ul>
			</div>
			<div id="jpPlayListContainer">
				<div id="jpPlayListLeftContainer">
					<div class="myPlayListContainer">
						<div class="myPlayListTitle"><s:text name="myPlayList"/></div>
						<div class="myPlayListItemContainer">
							<a class="myPlayListItem" href="javascript:;">
								<span class="listImg"></span>
								<span>默认列表</span>
							</a>
						</div>
					</div>
				</div>
				<div id="jpPlayListMainContainer">
					<div id="jpPlayListTitleContainer">
						<div class="playListTitleItem track"><s:text name="track"/></div>
						<div class="playListTitleItem artist"><s:text name="artist"/></div>
						<div class="playListTitleItem album"><s:text name="album"/></div>
						<div class="playListTitleItem option"></div>
					</div>
	    			<div class="jp-playlist">
	    				<ul style="display: block;"></ul>
	    			</div>
    			</div>
    			<div id="jpPlayListRightContainer">
    				<div id="albumImgContainer">
    					<img src=""/>
    				</div>
    				<div id="albumTitleContainer">
    					<!-- 11月的肖邦 -->
    				</div>
    			</div>
    		</div>
    		<div class="jp-no-solution" style="display: none;">
				<span>Update Required</span>
				To play the media you will need to either update your browser to a recent version or update your
				<a target="_blank" href="http://get.adobe.com/flashplayer/">Flash plugin</a>.
			</div>
    	</div>
    </div>
  </body>
</html>
