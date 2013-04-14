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
    
    <title><s:property value="%{getText('homePage')}" /></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	
	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/index.css" rel="stylesheet"/>
   	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
	
	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
	
  </head>
  
  <body>
   	<s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp">
  		<s:param name="navItem">homePage</s:param>
  	</s:include>
  	<s:include value="../../component/imageSlider.jsp"></s:include>
   	
   	<div id="indexPageBack" class="pageBack">
   		<div id="indexPageContainer" class="pageContainer">
   			<div style="height:30px;"></div>
   			<!-- Left Part Content -->
   			<div id="indexLeftPageContainer">
   				<div id="newAlbumContainer">
   					<div class="title"></div>
   					<div class="newAlbumListContainer">
   						<ul class="newAlbumList">
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img1.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img2.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img3.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img4.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img5.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img6.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img7.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img8.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img9.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   						<!--Example-->
	   						<li class="newAlbumListItem">
	   							<a href="#">
	   								<img src="ui/img/test/newAlbum/img10.jpg" />
	   								<span class="albumName">继续宠爱十年</span>
	   								<span class="artistName">华语群星</span>
	   							</a>
	   						</li>
	   					</ul>
   					</div>
   				</div>
   				<div id="recommendContainer">
   					<div id="newRecommendContainer">
	   					<div class="title"></div>
	   					<div class="recommendTrackListContainer">
	   						<ul class="recommendTrackList">
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">2013-03-31</span>
	   							</li>
	   						</ul>
	   					</div>
	   				</div>
	   				<div id="hotRecommendContainer">
	   					<div class="title"></div>
	   					<div class="recommendTrackListContainer">
	   						<ul class="recommendTrackList">
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   							<!--Example-->
	   							<li class="recommendTrackItem">
	   								<a href="#">
	   									<span class="trackName">流浪记</span>
	   								</a>
	   								<a href="#">
	   									<span class="artistName">&nbsp;-&nbsp;杨宗纬</span>
	   								</a>
	   								<span class="count">123123</span>
	   							</li>
	   						</ul>
	   					</div>
	   				</div>
   				</div>
   				<div id="customAlbumContainer">
   					<div class="title"></div>
   					<div class="customAlbumListContainer">
   						<ul class="customAlbumList">
   							<li class="firstCustomAlbumItem">
   								<a href="#">
   									<img src="ui/img/test/customAlbum/img1.jpg" />
	   								<span class="albumName">我若离去，后会无期</span>
	   								<span class="albumDescription">人生若只如初见</span>
   								</a>
   							</li>
   							<li class="customAlbumItem">
   								<a href="#">
   									<img src="ui/img/test/customAlbum/img2.jpg" />
	   								<span class="albumName">我若离去，后会无期</span>
	   								<span class="albumDescription">人生若只如初见</span>
   								</a>
   							</li>
   							<li class="customAlbumItem">
   								<a href="#">
   									<img src="ui/img/test/customAlbum/img3.jpg" />
	   								<span class="albumName">我若离去，后会无期</span>
	   								<span class="albumDescription">人生若只如初见</span>
   								</a>
   							</li>
   							<li class="customAlbumItem">
   								<a href="#">
   									<img src="ui/img/test/customAlbum/img1.jpg" />
	   								<span class="albumName">我若离去，后会无期</span>
	   								<span class="albumDescription">人生若只如初见</span>
   								</a>
   							</li>
   							<li class="customAlbumItem">
   								<a href="#">
   									<img src="ui/img/test/customAlbum/img2.jpg" />
	   								<span class="albumName">我若离去，后会无期</span>
	   								<span class="albumDescription">人生若只如初见</span>
   								</a>
   							</li>
   						</ul>
   					</div>
   				</div>
   			</div>
   			<!-- Right Part Content -->
   			<div id="indexRightPageContainer">
   				<div id="chartContainer">
	   				<div class="title"></div>
	   				<div class="chartItemsContainer">
	   					<ol class="chartItems">
	   						<!--Example-->
	   						<li class="firstChartItem">
	   							<span class="rank">01</span>
	   							<a href="#">
	   								<span class="trackName">童话</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">光良</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">02</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">03</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">04</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">05</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">06</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">07</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">08</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">09</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   						<li class="chartItem">
	   							<span class="rank">10</span>
	   							<a href="#">
	   								<span class="trackName">春暖花开</span>
	   							</a>
	   							<a href="#">
	   								<span class="artistName">那英</span>
	   							</a>
	   						</li>
	   					</ol>
	   				</div>
	   			</div>
   				<div id="popularArtistContainer">
   					<div class="title"></div>
   					<div class="popularArtistsContainer">
   						<ul class="popularArtists">
   							<!--Example-->
   							<li class="popularArtistItem">
   								<a href="#">
   									<img src="ui/img/test/popularArtist/img1.jpg"/>
   								</a>
   								<a href="#">
   									<span class="artistName">陈奕迅</span>
   								</a>
   							</li>
   							<!--Example-->
   							<li class="popularArtistItem">
   								<a href="#">
   									<img src="ui/img/test/popularArtist/img2.jpg"/>
   								</a>
   								<a href="#">
   									<span class="artistName">陈奕迅</span>
   								</a>
   							</li>
   							<!--Example-->
   							<li class="popularArtistItem">
   								<a href="#">
   									<img src="ui/img/test/popularArtist/img3.jpg"/>
   								</a>
   								<a href="#">
   									<span class="artistName">陈奕迅</span>
   								</a>
   							</li>
   							<!--Example-->
   							<li class="popularArtistItem">
   								<a href="#">
   									<img src="ui/img/test/popularArtist/img1.jpg"/>
   								</a>
   								<a href="#">
   									<span class="artistName">陈奕迅</span>
   								</a>
   							</li>
   							<!--Example-->
   							<li class="popularArtistItem">
   								<a href="#">
   									<img src="ui/img/test/popularArtist/img2.jpg"/>
   								</a>
   								<a href="#">
   									<span class="artistName">陈奕迅</span>
   								</a>
   							</li>
   							<!--Example-->
   							<li class="popularArtistItem">
   								<a href="#">
   									<img src="ui/img/test/popularArtist/img1.jpg"/>
   								</a>
   								<a href="#">
   									<span class="artistName">陈奕迅</span>
   								</a>
   							</li>
   						</ul>
   					</div>
   				</div>
   			</div>
   		</div>
   	</div>
   	
   	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
