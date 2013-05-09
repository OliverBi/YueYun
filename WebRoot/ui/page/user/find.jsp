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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
	<link type="text/css" href="ui/css/find.css" rel="stylesheet"/>
	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>

	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
  </head>
  
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp">
  		<s:param name="navItem">findPage</s:param>
  	</s:include>
  	
  	<s:include value="../../component/bottomSearchBar.jsp"></s:include>
   	<s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
