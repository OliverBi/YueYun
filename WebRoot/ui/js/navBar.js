$(document).ready(function(){
	$("#myMusicBox").click(function(){
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
					window.open("/YueYun/user/musicbox",MUSICBOX_WINDOW_NAME);
				}
			}else if(data.result == "NOT_LOGIN"){
				window.location.href = "/YueYun/user/login";
			}
		})
		.fail(function(){
			alert("error");
		});
	});
});