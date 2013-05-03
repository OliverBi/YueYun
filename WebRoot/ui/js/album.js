$(document).ready(function(){
	function AlbumManager(){
		this.init();
	}
	AlbumManager.prototype.init = function(){
		$(".albumInfoContainer .albumInfoPlayContainer").click(function(){
			var albumId = $(".albumInfoContainer #albumId").val();
			playAlbum(albumId);
		});
		function playAlbum(albumId){
			var actionUrl = "/YueYun/userAjax/userLoginAction!isUserLogin";
			$.when($.ajax({
				url: actionUrl,
				type: "POST"
			}))
			.done(function(data){
				if(data.result == "IS_LOGIN"){
					var MUSICBOX_WINDOW_NAME = "musicbox_window";
					var musicBoxWindow = window.open("",MUSICBOX_WINDOW_NAME);
					if(musicBoxWindow.location.href === "about:blank"){
						var playUrl = "/YueYun/user/play?albumId=" + albumId;
						musicBoxWindow =  window.open(playUrl,MUSICBOX_WINDOW_NAME);
					}else{
						var messageStr = "albumId=" + albumId;
						musicBoxWindow.postMessage(messageStr,"*");
					}
				}else if(data.result == "NOT_LOGIN"){
					window.location.href = "/YueYun/user/login";
				}
			})
			.fail(function(){
				alert("error");
			});
		}
	};
	var albumManager = new AlbumManager();
});