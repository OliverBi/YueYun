$(document).ready(function(){
	function MusicBox(){
		this.init();
	}
	MusicBox.prototype.init = function(){
		var that = this;
		initJPlayer();
		initMessageReceiver();
		function initJPlayer(){
			var userDefaultPlayListJsonStr = $("#userDefaultPlayList")[0].innerHTML;
			var userDefaultPlayListArray = null;
			if(userDefaultPlayListJsonStr != ""){
				var userDefaultPlayListJson = eval("(" + userDefaultPlayListJsonStr + ")");
				userDefaultPlayListArray = userDefaultPlayListJson.playlist;
			}
			
			that.myPlayer = new jPlayerPlaylist({
		        jPlayer: "#jquery_jplayer_N",
		        cssSelectorAncestor: "#jp_container_N"
		        }, userDefaultPlayListArray
		        	/*{
		            	title:"红尘客栈",
		            	artist:"周杰伦",
		            	mp3:"music/1.mp3",
		            	album: "12新作"
		        	},
		        	{
		            	title:"飞行部落",
		            	artist:"F.I.R",
		            	mp3:"music/2.mp3",
		            	album: "飞行部落"
		        	},
		        	{
		            	title:"Fiction",
		            	artist:"Beast",
		            	mp3:"music/3.mp3",
		            	album: "fiction and fact"
		        	}*/
		        ,{
		        	playlistOptions: {
		        		autoPlay: true
		        		//enableRemoveControls: true
		        	},
		        	swfPath: "ui/js/jquery",
		        	supplied: "mp3",
		        	smoothPlayBar: true,
		        	solution: "flash, html",
		        	wmode:"window",
		        	keyEnabled: true,
		        	volumechange: function(event) {
		        		if(event.jPlayer.options.muted) {
		        			that.myControl.volume.slider("value", 0);
		        		} else {
		        			that.myControl.volume.slider("value", event.jPlayer.options.volume);
		        		}
		        	},
		        	timeupdate: function(event) {
		        		that.myControl.progress.slider("value", event.jPlayer.status.currentPercentAbsolute);
		        	}
		        });
			$(that.myPlayer).bind("updateTrackInfo", function(event, artist, poster){
				$("#albumImgContainer img").attr("src", poster);
				$("#albumTitleContainer").text(artist);
			});
		
			that.myControl = {
				progress: $("#jp_container_N .jp-seek-bar"),
				volume: $("#jp_container_N .jp-volume-bar") 	
			};
			
			that.myControl.progress.slider({
				animate: "fast",
				max: 100,
				range: "min",
				step: 0.1,
				value: 0,
				slide: function(event, ui){
					
				}
			});
			that.myControl.volume.slider({
				animate: "fast",
				max: 1,
				range: "min",
				step: 0.01,
				value: $.jPlayer.prototype.options.volume,
				slide: function(event, ui){
					$(that.myPlayer.jPlayer).jPlayer("option", "muted", false);
					$(that.myPlayer.jPlayer).jPlayer("option", "volume", ui.value);
				}
			});
		}
		function initMessageReceiver(){
			var messageReceiver = function(ev){
				var messageStr = ev.data;
				var messageStrArray = messageStr.split("&");
				if(messageStrArray.length == 2){
					var trackIdStr = messageStrArray[0].split("=");
					var typeStr = messageStrArray[1].split("=");
					if(trackIdStr.length == 2 && typeStr.length == 2){
						var trackId = parseInt(trackIdStr[1]);
						var type = typeStr[1];
						var actionUrl = "/YueYun/userAjax/userPlayAjaxAction?trackId=" + trackId + "&type=" + type;
						$.when($.ajax({
							url: actionUrl,
							type: "POST"
						}))
						.done(function(data){
							if(data.result == "SUCCESS_ADD_PLAYLIST"){
								if(type == "PLAY"){
									that.myPlayer.add(data.trackJson,true);
								}else if(type == "ADD"){
									that.myPlayer.add(data.trackJson);
								}
							}else if(data.result == "FAIL_ADD_PLAYLIST"){
								alert("fail");
							}else{
								alert("error");
							}
						})
						.fail(function(){
							alert("error");
						});
					}
				}else if(messageStrArray.length == 1){
					var albumIdStr = messageStrArray[0].split("=");
					if(albumIdStr.length == 2){
						var albumId = parseInt(albumIdStr[1]);
						var actionUrl = "/YueYun/userAjax/userPlayAjaxAction?albumId=" + albumId;
						$.when($.ajax({
							url: actionUrl,
							type: "POST"
						}))
						.done(function(data){
							if(data.result == "SUCCESS_ADD_PLAYLIST"){
								for(var i = data.albumJson.trackList.length - 1; i >= 0; i--){
									if(i == 0){
										that.myPlayer.add(data.albumJson.trackList[i],true);
									}else{
										that.myPlayer.add(data.albumJson.trackList[i]);
									}
								}
							}else if(data.result == "FAIL_ADD_PLAYLIST"){
								alert("fail");
							}else{
								alert("error");
							}
						})
						.fail(function(){
							alert("error");
						});
					}
				}
				
			};
			if(window.addEventListener){
				window.addEventListener("message",messageReceiver,false);
			}else{
				window.attachEvent("message",messageReceiver);
			}
		}
	};
	var musicBox = new MusicBox();
	/*test();
	function test(){
		var actionUrl = "/YueYun/userAjax/userPlayAjaxAction?albumId=8";
		$.when($.ajax({
			url: actionUrl,
			type: "POST"
		}))
		.done(function(data){
			if(data.result == "SUCCESS_ADD_PLAYLIST"){
				for(var i = data.albumJson.trackList.length - 1; i >= 0; i--){
					if(i == 0){
						that.myPlayer.add(data.albumJson.trackList[i],true);
					}else{
						that.myPlayer.add(data.albumJson.trackList[i]);
					}
				}
			}else if(data.result == "FAIL_ADD_PLAYLIST"){
				alert("fail");
			}else{
				alert("error");
			}
		})
		.fail(function(){
			alert("error");
		});
	}*/
});