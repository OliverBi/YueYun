<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.ognl.OgnlValueStack"%>  
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  
 ((OgnlValueStack) request.getAttribute("struts.valueStack")).set(  
   "navItem", request.getParameter("navItem"));  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <link type="text/css" href="ui/css/navBar.css" rel="stylesheet">
     <script src="ui/js/navBar.js" type="text/javascript"></script>
  </head>
  
  <body>
   	<div id="navBarBack" class="pageBack">
   		<div id="navBarContainer" class="pageContainer">
   			<s:if test="navItem == 'homePage'">
   				<div class="navBarItemContainerOn">
   					<a href="public/index"><s:text name="homePage"/></a>
   				</div>
   			</s:if>
   			<s:else>
   				<div class="navBarItemContainer">
   					<a href="public/index"><s:text name="homePage"/></a>
   				</div>
   			</s:else>
   			<s:if test="navItem == 'personalPage'">
   				<div class="navBarItemContainerOn" style="width:120px;">
   					<a href="user/home"><s:text name="personalPage"/></a>
   				</div>
   			</s:if>
   			<s:else>
   				<div class="navBarItemContainer" style="width:120px;">
   					<a href="user/home"><s:text name="personalPage"/></a>
   				</div>
   			</s:else>
   			<div class="navBarItemContainer">
   				<a href="#"><s:text name="find"/></a>
   			</div>
   			<div class="navBarItemContainer" style="float:right;width:130px;">
   				<a id="myMusicBox" href="javascript:;"><s:text name="myMusicBox"/></a>
   			</div>
   		</div>
   	</div>
  </body>
</html>
