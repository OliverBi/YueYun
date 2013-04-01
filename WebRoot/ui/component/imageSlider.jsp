<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" href="ui/css/imageSlider.css" rel="stylesheet">
    <script type="text/javascript">
    	$(document).ready(function(){
    		var currentPosition = 0;
    		var slideWidth = 800;
    		var slides = $(".slide");
    		var numberOfSlides = slides.length;
    		$("#slidesContainer").css("overflow","hidden");
    		slides
			    .wrapAll("<div id='slideInner'></div>")
				.css({
			      "float" : "left",
			      "width" : slideWidth
			    });
			$("#slideInner").css("width",slideWidth*numberOfSlides);
			
			 $("#slideShow")
    			.prepend("<span class='control' id='leftControl'></span>")
    			.append("<span class='control' id='rightControl'></span>");
    		manageControls(currentPosition);
    		
    		$(".control")
			    .bind("click", function(){
				currentPosition = ($(this).attr("id")=="rightControl") ? currentPosition+1 : currentPosition-1;
			    manageControls(currentPosition);
			    $("#slideInner").animate({
			      "marginLeft" : slideWidth*(-currentPosition)
			    });
			  });
		
			function manageControls(position){
				if(position==0){ 
					$("#leftControl").hide(); 
				} else{ 
					$("#leftControl").show();
				}
		    	if(position==numberOfSlides-1){ 
		    		$("#rightControl").hide(); 
		    	} else{ 
		    		$("#rightControl").show(); 
		    	}
		  	}	
    	});
    </script>
  </head>
  
  <body>
    <div id="slideShow">
    	<div id="slidesContainer">
    		<div class="slide">
    			<img src="ui/img/test/img1.jpg" />
    		</div>
    		<div class="slide">
    			<img src="ui/img/test/img2.jpg" />
    		</div>
    		<div class="slide">
    			<img src="ui/img/test/img3.jpg" />
    		</div>
    	</div>
    </div>
    <div id="slideBottom">
    </div>
  </body>
</html>
