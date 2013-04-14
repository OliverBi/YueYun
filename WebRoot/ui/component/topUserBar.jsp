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
    			<a href="ui/page/public/index.jsp">
    				<s:text name="yueYun"></s:text>
    			</a>
    		</div>
    		<div id="topUserBarOptContainer">
    			<s:if test="%{#session.SESSION_USER_EMAIL!=null}">
    				<div class="topUserBarOpt">
    					<a href="user/userLogoutAction"><s:text name="logout" /></a>
    				</div>
    			</s:if>
    			<s:else>
    				<div class="topUserBarOpt">
    					<a href="ui/page/user/register.jsp"><s:text name="register" /></a>
    				</div>
    				<div class="topUserBarOpt">
    					<a href="ui/page/user/login.jsp"><s:text name="login" /></a>
    				</div>
    			</s:else>
    		</div>
    	</div>
    </div>
  </body>
</html>
