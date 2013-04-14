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
  						<li class="homePageMenuItemOn"><a href="#"><s:text name="homePage" /></a></li>
  						<li class="homePageMenuItem"><a href="#"><s:text name="collect" /></a></li>
  						<li class="homePageMenuItem"><a href="#"><s:text name="blog" /></a></li>
  						<li class="homePageMenuItem"><a href="#"><s:text name="photoAlbum" /></a></li>
  						<li class="homePageMenuItem"><a href="#"><s:text name="yueFriend" /></a></li>
  						<li class="homePageMenuItem"><a href="#"><s:text name="message" /></a></li>
  					</ul>
  				</div>
  				<div id="homePageAvatarContainer">
  					<div class="homePageAvatar">
  						<img src="ui/img/test/avatar_default_m.gif" />
  					</div>
  				</div>
  				<div id="homePageUserInfoContainer">
  					<div class="homePageUserNameContainer">MYMMoonDT</div>
  					<div class="homePageUserSocialContainer">
  						<ul>
  							<li>
  								<span><s:text name="follow"/></span>
  								<a href="#">0</a>
  							</li>
  							<li>
  								<span>|</span>
  							</li>
  							<li>
  								<span><s:text name="fan"/></span>
  								<a href="#">0</a>
  							</li>
  						</ul>
  					</div>
  				</div>
  			</div>
  			<div id="homePageContentContainer">
  				
  			</div>
  		</div>
  		<div style="height:40px;"></div>
  	</div>
  	
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
