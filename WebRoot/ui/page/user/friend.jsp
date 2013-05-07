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
	<link type="text/css" href="ui/css/friend.css" rel="stylesheet"/>
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>

	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="ui/js/jquery/jquery.hashchange.min.js" type="text/javascript"></script>
	<script src="ui/js/jquery/jquery.easytabs.min.js" type="text/javascript"></script>
	<script src="ui/js/friend.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp">
  		<s:param name="navItem">personalPage</s:param>
  	</s:include>
  
  	<div id="friendPageBack" class="pageBack">
  		<div style="height:160px;"></div>
  		<div id="friendPageContainer" class="pageContainer">
  			<s:include value="../../component/homeNavBar.jsp">
  				<s:param name="homeNavItem">friendPage</s:param>
  			</s:include>
  			
  			<div id="friendPageContentContainer">
	  			<div id="friendPageMainContentContainer">
	  				<div id="friendPageTabContainer" class="tab-container">
	  					<ul class='etabs'>
	  						<li class='tab'>
	  							<a href='#friend-follow'>
	  								<span><s:text name="myFollowPeople"/></span>
	  							</a>
	  						</li>
	  						<li class='tab'>
	  							<a href='#friend-fan'>
	  								<span><s:text name="peopleFollowMe"/></span>
	  							</a>
	  						</li>
	  					</ul>
	  					<div style="clear:both;"></div>
	  					<div class="panel-container">
	  						<div id="friend-follow">
	  							<div id="friendPageMenuContainer">
			  						<div class="friendPageMenuItemOn">
			  							<a href="javascript:;"><s:text name="all"/></a>
			  						</div>
			  					</div>
			  					<div style="clear:both;"></div>
			  					<s:iterator value="userFollowFriendList" id="friend">
			  						<div class="friendContainer">
		  								<div class="friendImgContainer">
		  									<img src="<s:property value='friend.userAvatarUrl'/>"/>
		  								</div>
		  								<div class="friendInfoContainer">
		  									<div class="friendNameContainer"><s:property value="friend.userName"/></div>
		  									<div class="friendGenderContainer">
		  										<s:if test='friend.userGender == "M"'>
		  											<span class="male"></span>
		  										</s:if>
		  										<s:elseif test='friend.userGender == "F"'>
		  											<span class="female"></span>
		  										</s:elseif>
		  									</div>
		  									<div class="friendDescriptionContainer">
		  										<s:text name="description"/>:&nbsp;
		  										<s:property value="friend.userDescription"/>
		  									</div>
		  								</div>
		  								<div class="friendOptionContainer">
		  									<a class="followed" href="javascript:;">
		  										<span><s:text name="followed"/></span>
		  									</a>
		  								</div>
		  							</div> 
			  					</s:iterator>
	  							<%-- <div class="friendContainer">
	  								<div class="friendImgContainer">
	  									<img src="ui/img/test/avatar_default_m.gif"/>
	  								</div>
	  								<div class="friendInfoContainer">
	  									<div class="friendNameContainer">MYMMoonDT</div>
	  									<div class="friendGenderContainer">
	  										<span class="female"></span>
	  									</div>
	  									<div class="friendDescriptionContainer">简介: 是个好人</div>
	  								</div>
	  								<div class="friendOptionContainer">
	  									<a class="followed" href="javascript:;">
	  										<span><s:text name="followed"/></span>
	  									</a>
	  								</div>
	  							</div> --%>
	  							
	  							<%-- <div class="friendContainer">
	  								<div class="friendImgContainer">
	  									<img src="ui/img/test/avatar_default_m.gif"/>
	  								</div>
	  								<div class="friendInfoContainer">
	  									<div class="friendNameContainer">MYMMoonDT</div>
	  									<div class="friendGenderContainer">
	  										<span class="male"></span>
	  									</div>
	  									<div class="friendDescriptionContainer">简介: 是个好人</div>
	  								</div>
	  								<div class="friendOptionContainer">
	  									<a class="follow" href="javascript:;">
	  										<span><s:text name="followTa"/></span>
	  									</a>
	  								</div>
	  							</div> --%>
	  						</div>
	  						<div id="friend-fan">
	  							<div id="friendPageMenuContainer">
			  						<div class="friendPageMenuItemOn">
			  							<a href="javascript:;"><s:text name="all"/></a>
			  						</div>
			  					</div>
			  					<div style="clear:both;"></div>
			  					<s:iterator value="friendFollowUserList" id="friend">
			  						<div class="friendContainer">
		  								<div class="friendImgContainer">
		  									<img src="<s:property value='friend.userAvatarUrl'/>"/>
		  								</div>
		  								<div class="friendInfoContainer">
		  									<div class="friendNameContainer"><s:property value="friend.userName"/></div>
		  									<div class="friendGenderContainer">
		  										<s:if test='friend.userGender == "M"'>
		  											<span class="male"></span>
		  										</s:if>
		  										<s:elseif test='friend.userGender == "F"'>
		  											<span class="female"></span>
		  										</s:elseif>
		  									</div>
		  									<div class="friendDescriptionContainer">
		  										<s:text name="description"/>:&nbsp;
		  										<s:property value="friend.userDescription"/>
		  									</div>
		  								</div>
		  								<div class="friendOptionContainer">
		  									<input type="hidden" value="<s:property value="friend.userId"/>"/>
		  									<s:if test="friendTypeStr == 'FRIEND_FAN'">
		  										<a class="follow" href="javascript:;">
		  											<span><s:text name="followTa"/></span>
		  										</a>
		  									</s:if>
		  									<s:else>
		  										<a class="followBoth" href="javascript:;">
		  											<span><s:text name="bothFollow"/></span>
		  										</a>
		  									</s:else>
		  								</div>
		  							</div>
			  					</s:iterator>
	  						</div>
	  					</div>
	  				</div>
	  			</div>
	  			<div id="friendPageSideContentContainer">
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
