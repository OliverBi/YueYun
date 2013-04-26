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
    <link type="text/css" href="ui/css/topUserBar.css" rel="stylesheet">
  </head>
  <body>
    <div id="topUserBarBack">
    	<div id="topUserBarContainer">
    		<div id="topUserBarLogoContainer">
    			<a href="public/index">
    				<s:text name="yueYun"></s:text>
    			</a>
    		</div>
    		<div id="topUserBarOptContainer">
    			<s:if test="%{#session.SESSION_CURRENT_USER!=null}">
    				<div class="topUserBarOpt">
    					<a href="user/userLogoutAction"><s:text name="logout" /></a>
    				</div>
    			</s:if>
    			<s:else>
    				<div class="topUserBarOpt">
    					<a href="user/register"><s:text name="register" /></a>
    				</div>
    				<div class="topUserBarOpt">
    					<a href="user/login"><s:text name="login" /></a>
    				</div>
    			</s:else>
    		</div>
    	</div>
    </div>
  </body>
</html>
