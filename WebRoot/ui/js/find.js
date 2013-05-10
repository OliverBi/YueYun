$(document).ready(function(){
	function FindManager(){
		this.init();
	}
	FindManager.prototype.init = function(){
		var options = {
			autoResize: true,
			container: $("#tilesContainer"),
			offset: 2,
			itemWidth: 230
		};
		var handler = $("#tiles li");
		handler.wookmark(options);
		
		$(".albumTile").hover(function(){
			$(this).find(".albumSocialInfoContainer").hide();
			$(this).find(".albumTrackListContainer").show();
			handler.wookmark();
		},function(){
			$(this).find(".albumSocialInfoContainer").show();
			$(this).find(".albumTrackListContainer").hide();
			handler.wookmark();
		});
		
		$(".trackTile").hover(function(){
			$(this).find(".trackSocialInfoContainer").hide();
			$(this).find(".trackListenerListContainer").show();
			handler.wookmark();
		},function(){
			$(this).find(".trackSocialInfoContainer").show();
			$(this).find(".trackListenerListContainer").hide();
			handler.wookmark();
		});
	};
	var findManager = new FindManager();
});