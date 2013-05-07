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
     <link type="text/css" href="ui/css/userInfo.css" rel="stylesheet"> 
  </head>
  
  <body>
    <div id="userInfoContainer">
    	<div class="userAvatarContainer">
    		<img src='<s:property value="#session.SESSION_CURRENT_USER.userAvatarUrl"/>' />
    	</div>
		<div class="userNameContainer"><s:property value="#session.SESSION_CURRENT_USER.userName"/></div>
		<div class="userSocialContainer">
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
  </body>
</html>
