<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ognl.OgnlValueStack"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  
 ((OgnlValueStack) request.getAttribute("struts.valueStack")).set(  
   "homeNavItem", request.getParameter("homeNavItem"));  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" href="ui/css/homeNavBar.css" rel="stylesheet">
  </head>
  <body>
    <div id="homeNavBarContainer">
		<ul class="homeNavBarItems">
			<li class="homeNavBarItem"><a href="user/home"><s:text name="homePage" /></a></li>
			<s:if test="homeNavItem == 'collectPage'">
				<li class="homeNavBarItemOn"><a href="user/collect"><s:text name="store" /></a></li>
			</s:if>
			<s:else>
				<li class="homeNavBarItem"><a href="user/collect"><s:text name="store" /></a></li>
			</s:else>
			<s:if test="homeNavItem == 'friendPage'">
				<li class="homeNavBarItemOn"><a href="user/friend"><s:text name="yueFriend" /></a></li>
			</s:if>
			<s:else>
				<li class="homeNavBarItem"><a href="user/friend"><s:text name="yueFriend" /></a></li>
			</s:else>
		</ul>
  	</div>
  </body>
</html>
