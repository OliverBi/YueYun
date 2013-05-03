$(document).ready(function(){
	function TrackManager(){
		this.init();
	}
	TrackManager.prototype.init =  function(){
		$(".trackPlayContainer .play").click(function(){
			var trackId = $(".trackPlayContainer #trackId").val();
			playOrAddTrack(trackId, "PLAY");
		});
		$(".trackPlayContainer .add").click(function(){
			var trackId = $(".trackPlayContainer #trackId").val();
			playOrAddTrack(trackId, "ADD");
		});
		
		function playOrAddTrack(trackId, type){
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
						var playUrl = "/YueYun/user/play?trackId=" + trackId + "&type=" + type;
						musicBoxWindow =  window.open(playUrl,MUSICBOX_WINDOW_NAME);
					}else{
						var messageStr = "trackId=" + trackId + "&type=" + type;
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
	var trackManager = new TrackManager();
});