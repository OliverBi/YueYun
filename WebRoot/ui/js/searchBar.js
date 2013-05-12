$(document).ready(function(){
	(function(){	
		$(".comboxDropdownListContainer").hide();
		$(".searchComboxContainer input[type='hidden']").val("track");
		$(".searchComboxContainer").hover(function(){
			$(".comboxDropdownListContainer",this).show();
		},function(){
			$(".comboxDropdownListContainer",this).hide();
		});
		
		$(".comboxDropdownListContainer .comboxDropdownItem").click(function(){
			var parentSearchComboxContainer = $(this).parent().parent();
			$(".comboxDisplayValueContainer", parentSearchComboxContainer).html($(this).html());
			$(".comboxDropdownListContainer", parentSearchComboxContainer).hide();
			if($(this).html() == "歌手")
				$(this).parent().next().val("artist");
			else if($(this).html() == "歌曲")
				$(this).parent().next().val("track");
			else if($(this).html() == "专辑")
				$(this).parent().next().val("album");
		});
		
	})();
});