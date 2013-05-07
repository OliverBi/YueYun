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
		
		$(".trackOptionContainer .share").click(function(){
			var actionUrl = "/YueYun/userAjax/userLoginAction!isUserLogin";
			$.when($.ajax({
				url: actionUrl,
				type: "POST"
			}))
			.done(function(data){
				if(data.result == "IS_LOGIN"){
					$(".shareTrackStatusContainer textarea").val("#分享音乐#");
					var leftSize = 140;
					leftSize = leftSize - $.trim($(".shareTrackStatusContainer textarea").val()).length;
					$(".shareTrackStatusSizeContainer span").html(leftSize + "字");
					
					$("#shareTrackDialogContainer").modal({
						appendTo: "body",
						opacity: 50,
		                overlayCss: { backgroundColor: "#000" },
		                closeHTML: "<a title='关闭'></a>"
					});
				}else if(data.result == "NOT_LOGIN"){
					window.location.href = "/YueYun/user/login";
				}
			})
			.fail(function(){
				alert("error");
			});
		});
		$(".trackOptionContainer .store").click(function(){
			var actionUrl = "/YueYun/userAjax/userLoginAction!isUserLogin";
			$.when($.ajax({
				url: actionUrl,
				type: "POST"
			}))
			.done(function(data){
				if(data.result == "IS_LOGIN"){
					var collectContent = $("#collectTrackForm").serialize();
					actionUrl = "/YueYun/userAjax/userCollectAjaxAction!collectTrack";
					$.when($.ajax({
						url: actionUrl,
						type: "POST",
						data: collectContent
					}))
					.done(function(data){
						if(data.result == "COLLECT_SUCCESS"){
							$("#collectTrackDialogContainer").modal({
								appendTo: "body",
								opacity: 50,
				                overlayCss: { backgroundColor: "#000" },
				                closeHTML: "<a title='关闭'></a>"
							});
							function hideCollectTrackDialogContainer(){
								$.modal.close();
							}
							setTimeout(hideCollectTrackDialogContainer,1000);
						}else if(data.result == "COLLECT_FAIL"){
							alert("fail");
						}else{
							alert("error");
						}
					})
					.fail(function(){
						alert("error");
					});
				}else if(data.result == "NOT_LOGIN"){
					window.location.href = "/YueYun/user/login";
				}
			})
			.fail(function(){
				alert("error");
			});
		});
		
		
		$(".shareTrackOptionContainer .confirm").click(function(){
			if($.trim($(".shareTrackStatusContainer textarea").val()).length > 0){
				var statusContent = $("#shareTrackForm").serialize();
				var actionUrl = "/YueYun/userAjax/userStatusAjaxAction!shareTrackStatus";
				$.when($.ajax({
					url: actionUrl,
					type: "POST",
					data: statusContent
				}))
				.done(function(data){
					if(data.result == "PUBLISH_SUCCESS"){
						$(".shareTrackStatusContainer textarea").val("");
						var leftSize = 140;
						$(".shareTrackStatusSizeContainer span").html(leftSize + "字");
						$("#shareTrackDialogContainer .shareTrackSuccessContainer").show();
						function hideShareTrackSuccessContainer(){
							$("#shareTrackDialogContainer .shareTrackSuccessContainer").hide();
							$.modal.close();
						}
						setTimeout(hideShareTrackSuccessContainer,1000);
					}else if(data.result == "PUBLISH_FAIL"){
						alert("fail");
						$.modal.close();
					}else{
						alert("error");
						$.modal.close();
					}
				})
				.fail(function(){
					alert("error");
					$.modal.close();
				});
			}
		});
		
		$(".shareTrackOptionContainer .cancel").click(function(){
			$.modal.close();
		});
		
		$(".shareTrackStatusContainer textarea").keyup(function(){
			if($.trim($(this).val()).length > 0){
				if($.trim($(this).val()).length <= 140){
					var leftSize = 140;
					leftSize = leftSize - $.trim($(this).val()).length;
					$(".shareTrackStatusSizeContainer span").html(leftSize + "字");
				}else{
					var leftSize = 0;
					$(".shareTrackStatusSizeContainer span").html(leftSize + "字");
				}
			}else{
				var leftSize = 140;
				$(".shareTrackStatusSizeContainer span").html(leftSize + "字");
			}
		});
	};
	var trackManager = new TrackManager();
});