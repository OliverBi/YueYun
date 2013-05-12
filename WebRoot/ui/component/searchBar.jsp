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
    
    <link type="text/css" href="ui/css/searchBar.css" rel="stylesheet">
    <script src="ui/js/searchBar.js" type="text/javascript"></script>
  </head>
  
  <body>
    <div class="searchBarContainer">
    	<form action="public/search">
			<div class="searchComboxContainer">
				<div class="comboxDisplayValueContainer"><s:text name="track"/></div>
				<div class="comboxDropdownListContainer">
					<div class="comboxDropdownItem"><s:text name="track"/></div>
					<div class="comboxDropdownItem"><s:text name="artist"/></div>
					<div class="comboxDropdownItem"><s:text name="album"/></div>
				</div>
				<input type="hidden" name="searchType" id="searchType" />
			</div>
			<div class="searchTextContainer">
				<input type="text" name="searchContent" id="searchContent"/>
			</div>
			<div class="searchButtonContainer">
				<input type="submit" id="searchButton" value="" />
			</div>
    	</form>
    </div>
  </body>
</html>
