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
     <link type="text/css" href="ui/css/bottomSearchBar.css" rel="stylesheet">
  </head>
  
  <body>
  	<div id="bottomSearchBarBack" class="pageBack">
  		<div id="bottomSearchBarContainer" class="pageContainer">
  			<div id="bottomSearchBarSearchBarContainer">
  				<s:include value="searchBar.jsp"></s:include>
  			</div>
  			<div id="bottomSearchBarLinkContainer">
  				<span>
  					<a href="#"><s:text name="aboutYueYun"/></a>
  					&nbsp;-&nbsp;
  					<a href="#"><s:text name="contactUS"/></a>
  					&nbsp;-&nbsp;
  					<a href="#"><s:text name="friendLink"/></a>
  					&nbsp;-&nbsp;
  					<a href="#"><s:text name="helpCenter"/></a>
  				</span>
  			</div>
  			<div id="bottomSearchBarTextContainer">
  				<span>
  					Copyright&nbsp;&copy;&nbsp;2013&nbsp;yueyun.com
  				</span>
  			</div>
  		</div>
  	</div>
  </body>
</html>
