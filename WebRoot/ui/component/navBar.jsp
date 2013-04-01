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
     <link type="text/css" href="ui/css/navBar.css" rel="stylesheet">
  </head>
  
  <body>
   	<div id="navBarBack" class="pageBack">
   		<div id="navBarContainer" class="pageContainer">
   			
   		</div>
   	</div>
  </body>
</html>
