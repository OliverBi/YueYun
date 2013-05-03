$(document).ready(function(){
	function HomeManager(){
		this.init();
	}
	HomeManager.prototype.init = function(){
		$("#homePageUserStatusContainer textarea").keyup(function(){
			if($.trim($(this).val()).length > 0){
				if($.trim($(this).val()).length <= 140){
					$("#homePageUserStatusOptContainer input[type='button']").removeAttr("disabled");
					$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButtonDisabled").addClass("homePageUserStatusPulishButton");
					var leftSize = 140;
					leftSize = leftSize - $.trim($(this).val()).length;
					$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
				}else{
					$("#homePageUserStatusOptContainer input[type='button']").attr("disabled","disabled");
					$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButton").addClass("homePageUserStatusPulishButtonDisabled");
					var leftSize = 0;
					$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
				}
			}else{
				$("#homePageUserStatusOptContainer input[type='button']").attr("disabled","disabled");
				$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButton").addClass("homePageUserStatusPulishButtonDisabled");
				var leftSize = 140;
				$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
			}
		});
		$("#homePageUserStatusOptContainer input[type='button']").click(function(){
			var statusContent = $("#statusForm").serialize();
			var actionUrl = "/YueYun/userAjax/userStatusAjaxAction!publishCommonStatus";
			$.when($.ajax({
				url: actionUrl,
				type: "POST",
				data: statusContent
			}))
			.done(function(data){
				if(data.result == "PUBLISH_SUCCESS"){
					$("#homePageUserStatusContainer textarea").val("");
					$("#homePageUserStatusOptContainer input[type='button']").attr("disabled","disabled");
					$("#homePageUserStatusOptContainer input[type='button']").removeClass("homePageUserStatusPulishButton").addClass("homePageUserStatusPulishButtonDisabled");
					var leftSize = 140;
					$("#homePageUserStatusSizeContainer span").html("还可以输入" + leftSize + "字");
					$("#homePageUserStatusSuccessContainer").show();
					
					function HideStatusSuccessContainer(){
						$("#homePageUserStatusSuccessContainer").hide();
					}
					setTimeout(HideStatusSuccessContainer, 2000);
				}else if(data.result == "PUBLISH_FAIL"){
					alert("fail");
				}else{
					alert("error");
				}
			})
			.fail(function(){
				alert("error");
			});
		});
	};
	var homeManager = new HomeManager();
});