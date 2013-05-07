$(document).ready(function(){
	$("#friendPageTabContainer").easytabs();
	
	$(".friendOptionContainer .follow").click(function(){
		var that = this;
		var friendId = $(this).prev().val();
		var actionUrl = "/YueYun/userAjax/userFriendAjaxAction!followFriend?friendId=" + friendId;
		$.when($.ajax({
			url: actionUrl,
			type: "POST"
		}))
		.done(function(data){
			if(data.result == "FOLLOW_FRIEND_SUCCESS"){
				$(that).removeClass("follow").addClass("followBoth").text("互相关注");
			}else if(data.result == "FOLLOW_FRIEND_FAIL"){
				alert("fail");
			}else{
				alert("error");
			}
		})
		.fail(function(){
			alert("error");
		});
	});
});