<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <link type="text/css" href="ui/css/backTop.css" rel="stylesheet">
    <script type="text/javascript">
    	function BackToTop(){
    		this.init();
    	}
    	BackToTop.prototype.init = function(){
    		$(document).ready(function(){
	    		$("#backToTopContainer").fadeOut();
	    		$("#backToTopContainer a").click(function(){
	    			$('body,html').animate({
						scrollTop: 0
					}, 800);
					return false;
	    		});
	    		$(window).scroll(function () {
					if ($(this).scrollTop() > 100) {
						$("#backToTopContainer").fadeIn();
					} else {
						$("#backToTopContainer").fadeOut();
					}
				});
	    	});
    	};
    	var backToTop = new BackToTop();
    </script>
  </head>
  
  <body>
   	<div id="backToTopContainer">
   		<a href="javascript:void(0);"></a>
   	</div>
  </body>
</html>
