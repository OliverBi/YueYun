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
	  				<div style="height:600px;">
  					</div>
	  			</div>
	  			<div id="friendPageSideContentContainer">
	  				<s:include value="../../component/userInfo.jsp"></s:include>
	  			</div>
	  			<div style="clear:both;"></div>
  			</div>
  		</div>
  	</div>
  	
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
