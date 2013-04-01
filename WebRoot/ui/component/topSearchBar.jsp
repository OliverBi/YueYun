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
    <link type="text/css" href="ui/css/topSearchBar.css" rel="stylesheet">
  </head>
  
  <body>
    <div id="topSearchBarBack">
    	<div id="topSearchBarContainer">
    		<div id="topSearchBarLogoContainer"></div>
    		<div id="topSearchBarYueYunFontContainer"></div>
    		<div id="topSearchBarSearchBarContainer">
    			<s:include value="searchBar.jsp"></s:include>
    		</div>
    	</div>
    </div>
  </body>
</html>
