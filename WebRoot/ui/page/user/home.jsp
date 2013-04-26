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
	<script type="text/javascript">
		$(document).ready(function(){
			function HomeManager(){
				this.init();
			}
			HomeManager.prototype.init = function(){
				$("#homePageUserStatusContainer textarea").keyup(function(){
					if($.trim($(this).val()).length > 0){
						if($.trim($(this).val()).length <= 140){
							$("#homePageUserStatusOptContainer input[type='button']").removeAttr("disabled");
							$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButtonDisabled").addClass("homePageUserStatusPulishButton");
							var leftSize = 140;
							leftSize = leftSize - $.trim($(this).val()).length;
							$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
						}else{
							$("#homePageUserStatusOptContainer input[type='button']").attr("disabled","disabled");
							$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButton").addClass("homePageUserStatusPulishButtonDisabled");
							var leftSize = 0;
							$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
						}
					}else{
						$("#homePageUserStatusOptContainer input[type='button']").attr("disabled","disabled");
						$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButton").addClass("homePageUserStatusPulishButtonDisabled");
						var leftSize = 140;
						$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
					}
				});
			};
			
			var homeManager = new HomeManager();
		});
	</script>
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
  						<li class="homePageMenuItem"><a href="#"><s:text name="store" /></a></li>
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
  				<div id="homePageUserStatusContainer">
  					<form>
	  					<div id="homePageUserStatusSizeContainer">
	  						<span><s:text name="canInput140Char" /></span>
	  					</div>
	  					<div>
	  						<textarea></textarea>
	  					</div>
	  					<div id="homePageUserStatusOptContainer">
	  						<input class="homePageUserStatusPulishButtonDisabled" 
	  							type="button" 
	  							value="<s:text name='publish'/>"
	  							disabled="disabled"/>
	  					</div>
  					</form>
  				</div>
  			</div>
  			<div id="homePageContentContainer">
  				<div id="homePageMainContainer">
  					<div id="homePageStatusMenuContainer">
  						<div class="homePageStatusMenuItemOn">
  							<a href="#"><s:text name="all"/></a>
  						</div>
  						<div class="homePageStatusMenuItem">
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
  						</div>
  					</div>
  					<div style="height:20px;clear:both;"></div>
  					<div class="homePageStatusItemContainer">
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
  					</div>
  					<div class="homePageStatusItemContainer">
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
  					</div>
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
