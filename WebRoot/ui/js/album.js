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
		
		$(".albumInfoOptionContainer .store").click(function(){
			var actionUrl = "/YueYun/userAjax/userLoginAction!isUserLogin";
			$.when($.ajax({
				url: actionUrl,
				type: "POST"
			}))
			.done(function(data){
				if(data.result == "IS_LOGIN"){
					var collectContent = $("#collectAlbumForm").serialize();
					actionUrl = "/YueYun/userAjax/userCollectAjaxAction!collectAlbum";
					$.when($.ajax({
						url: actionUrl,
						type: "POST",
						data: collectContent
					}))
					.done(function(data){
						if(data.result == "COLLECT_SUCCESS"){
							$("#collectAlbumDialogContainer").modal({
								appendTo: "body",
								opacity: 50,
				                overlayCss: { backgroundColor: "#000" },
				                closeHTML: "<a title='关闭'></a>"
							});
							function hideCollectAlbumDialogContainer(){
								$.modal.close();
							}
							setTimeout(hideCollectAlbumDialogContainer,1000);
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
		
		$(".albumInfoOptionContainer .share").click(function(){
			var actionUrl = "/YueYun/userAjax/userLoginAction!isUserLogin";
			$.when($.ajax({
				url: actionUrl,
				type: "POST"
			}))
			.done(function(data){
				if(data.result == "IS_LOGIN"){
					$(".shareAlbumStatusContainer textarea").val("#分享专辑#");
					var leftSize = 140;
					leftSize = leftSize - $.trim($(".shareAlbumStatusContainer textarea").val()).length;
					$(".shareAlbumStatusSizeContainer span").html(leftSize + "字");
					
					$("#shareAlbumDialogContainer").modal({
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
		
		$(".shareAlbumOptionContainer .confirm").click(function(){
			if($.trim($(".shareAlbumStatusContainer textarea").val()).length > 0){
				var statusContent = $("#shareAlbumForm").serialize();
				var actionUrl = "/YueYun/userAjax/userStatusAjaxAction!shareAlbumStatus";
				$.when($.ajax({
					url: actionUrl,
					type: "POST",
					data: statusContent
				}))
				.done(function(data){
					if(data.result == "PUBLISH_SUCCESS"){
						$(".shareAlbumStatusContainer textarea").val("");
						var leftSize = 140;
						$(".shareAlbumStatusSizeContainer span").html(leftSize + "字");
						$("#shareAlbumDialogContainer .shareAlbumSuccessContainer").show();
						function hideShareAlbumSuccessContainer(){
							$("#shareAlbumDialogContainer .shareAlbumSuccessContainer").hide();
							$.modal.close();
						}
						setTimeout(hideShareAlbumSuccessContainer,1000);
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
		
		$(".shareAlbumOptionContainer .cancel").click(function(){
			$.modal.close();
		});
		
		$(".shareAlbumStatusContainer textarea").keyup(function(){
			if($.trim($(this).val()).length > 0){
				if($.trim($(this).val()).length <= 140){
					var leftSize = 140;
					leftSize = leftSize - $.trim($(this).val()).length;
					$(".shareAlbumStatusSizeContainer span").html(leftSize + "字");
				}else{
					var leftSize = 0;
					$(".shareAlbumStatusSizeContainer span").html(leftSize + "字");
				}
			}else{
				var leftSize = 140;
				$(".shareAlbumStatusSizeContainer span").html(leftSize + "字");
			}
		});
	};
	var albumManager = new AlbumManager();
});