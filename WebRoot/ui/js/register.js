function RegisterManager(){
	this.init();
}

RegisterManager.prototype.init = function(){
$(document).ready(function(){
	initRegisterFormContainer();
	initDatePicker();
	initVerifyCode();
	initGenderSelector();
	initRegisterFormValidator();
});
	
function initRegisterFormContainer(){
	$("#registerFormFirstStepContainer .registerFormTitle").html("注册新用户");
	$("#registerFormSecondStepContainer").hide();
}
function initDatePicker(){
	//init datepicker
	$("#registerBirthdayContainer input").datepicker({
		dateFormat:"yy-mm-dd",
		changeMonth:true,
		changeYear:true,
		yearRange:"-100:+0"
	});
	$("#ui-datepicker-div").css('font-size','12px');
	$("#ui-datepicker-div").css('font-family','microsoft yahei');
}
function initVerifyCode(){
	//init verify code
	$("#registerVCodeImage").click(function(){
		$(this).attr("src","/YueYun/tool/verifyCodeAction?timestamp="+new Date().getTime());
	});
}
function initGenderSelector(){
	//init gender selector
	$("#registerMaleContainer").click(function(){
		$("#registerMaleContainer").children(":last").children(":first").removeClass("registerRadioImg").addClass("registerRadioImgSelect");
		if($("#registerFemaleContainer").children(":last").children(":first").hasClass("registerRadioImgSelect"))
			$("#registerFemaleContainer").children(":last").children(":first").removeClass("registerRadioImgSelect").addClass("registerRadioImg");
		$("#registerGenderContainer input").val("M");
	});
	$("#registerFemaleContainer").click(function(){
		$("#registerFemaleContainer").children(":last").children(":first").removeClass("registerRadioImg").addClass("registerRadioImgSelect");
		if($("#registerMaleContainer").children(":last").children(":first").hasClass("registerRadioImgSelect"))
			$("#registerMaleContainer").children(":last").children(":first").removeClass("registerRadioImgSelect").addClass("registerRadioImg");
		$("#registerGenderContainer input").val("F");
	});
}
function initRegisterFormValidator(){
	//init register form validate
	var isRegisterFirstStep = true;
	$("#registerForm").validate({
		onfocusout: false,
		onkeyup: false,
		rules:{
			"registerUser.userName":{
				required:true
			},
			"registerUser.userEmail":{
				required:true,
				email:true
			},
			"registerUser.userPassword":{
				required:true,
				rangelength:[4,20]
			},
			"registerUser.userGender":{
				required:true
			},
			"registerUser.userBirthday":{
				required:true
			},
			registerVCode:{
				required:true
			}
		},
		messages:{
			"registerUser.userName":{
				required:"请填写您喜欢的昵称"
			},
			"registerUser.userEmail":{
				required:"请填写您的电子邮箱地址",
				email:"请填写正确格式的电子邮箱地址"
			},
			"registerUser.userPassword":{
				required:"请填写您的登录密码",
				rangelength:"密码长度为4-20个字符"
			},
			"registerUser.userGender":{
				required:"请选择您的性别"
			},
			"registerUser.userBirthday":{
				required:"请选择您的出生日期"
			},
			registerVCode:{
				required:"请输入验证码"
			}
		},
		errorPlacement:function(error, element){
			if(error.attr("for") == "registerUser.userEmail"){
				error.appendTo("#registerEmailErrorContainer");
			}else if(error.attr("for") == "registerUser.userPassword"){
				error.appendTo("#registerPasswordErrorContainer");
			}else if(error.attr("for") == "registerUser.userName"){
				error.appendTo("#registerNameErrorContainer");
			}else if(error.attr("for") == "registerUser.userGender"){
				error.appendTo("#registerGenderErrorContainer");
			}else if(error.attr("for") == "registerUser.userBirthday"){
				error.appendTo("#registerBirthdayErrorContainer");
			}else if(error.attr("for") == "registerVCode"){
				error.appendTo("#registerVCodeErrorContainer");
			}
		},
		errorElement:"div",
		submitHandler:function(form){
			if(isRegisterFirstStep){
				$("#registerNameErrorContainer").html("");
				$("#registerEmailErrorContainer").html("");
        		var registerInfoFirstStep = $("#registerForm").serialize();
        		var actionUrl = "/YueYun/userAjax/userRegisterAction!userRegisterCheck";
        		$.when($.ajax({
        			url: actionUrl,
   					type: "POST",
   					data: registerInfoFirstStep
        		}))
        		.done(function(data){
        			if(data.result=="REGISTER_FIRSTSTEP_SUCCESS"){
						$("#registerFormFirstStepContainer").fadeOut("normal",function(){							
							$("#registerFormSecondStepContainer .registerFormTitle").html("选择您的基本信息");
							$("#registerFormSecondStepContainer").fadeIn("normal");
							isRegisterFirstStep = false;
						});
					}else{
						if(data.result == "REGISTER_FAIL_USERNAME_EXIST"){
							$("#registerNameErrorContainer").html("").append("<div class='error' for='registerUser.userName'>您填写的昵称已经存在</div>");
						}else if(data.result == "REGISTER_FAIL_USEREMAIL_EXIST"){
							$("#registerEmailErrorContainer").html("").append("<div class='error' for='registerUser.userEmail'>您填写的电子邮箱地址已经存在</div>");
						}else if(data.result == "REGISTER_FAIL_USERNAME_USEREMAIL_EXIST"){
							$("#registerNameErrorContainer").html("").append("<div class='error' for='registerUser.userName'>您填写的昵称已经存在</div>");
							$("#registerEmailErrorContainer").html("").append("<div class='error' for='registerUser.userEmail'>您填写的电子邮箱地址已经存在</div>");
						}else{
							alert("error");
						}
					}
        		})
        		.fail(function(){
        			alert("error");
        		});
        		/*$.ajax({
        			url: actionUrl,
   					type: "POST",
   					data: registerInfoFirstStep,
   					success:function(data){
   						if(data.result=="REGISTER_FIRSTSTEP_SUCCESS"){
   							$("#registerFormFirstStepContainer").fadeOut("normal",function(){							
   								$("#registerFormSecondStepContainer .registerFormTitle").html("选择您的基本信息");
   								$("#registerFormSecondStepContainer").fadeIn("normal");
   								isRegisterFirstStep = false;
   							});
   						}else{
   							if(data.result == "REGISTER_FAIL_USERNAME_EXIST"){
   								$("#registerNameErrorContainer").html("").append("<div class='error' for='registerUser.userName'>您填写的昵称已经存在</div>");
   							}else if(data.result == "REGISTER_FAIL_USEREMAIL_EXIST"){
   								$("#registerEmailErrorContainer").html("").append("<div class='error' for='registerUser.userEmail'>您填写的电子邮箱地址已经存在</div>");
   							}else if(data.result == "REGISTER_FAIL_USERNAME_USEREMAIL_EXIST"){
   								$("#registerNameErrorContainer").html("").append("<div class='error' for='registerUser.userName'>您填写的昵称已经存在</div>");
   								$("#registerEmailErrorContainer").html("").append("<div class='error' for='registerUser.userEmail'>您填写的电子邮箱地址已经存在</div>");
   							}else{
   								alert("error");
   							}
   						}
   					}
        		});*/
        	}else{
        		var registerInfoSecondStep = $("#registerForm").serialize();
        		var actionUrl = "/YueYun/userAjax/userRegisterAction!userVerifyCheck";
        		$.when($.ajax({
        			url: actionUrl,
        			type:"POST",
        			data: registerInfoSecondStep
        		}))
        		.done(function(data){
        			if(data.result=="REGISTER_SECONDSTEP_SUCCESS"){
    					location.href = "/YueYun/public/index";
    				}else if(data.result == "REGISTER_FAIL_VERIFYCODE_WRONG"){
    					$("#registerVCodeErrorContainer").html("").append("<div class='error' for='registerVCode'>验证码错误</div>");
    				}else{
    					alert("error");
    				}
        		})
        		.fail(function(){
        			alert("error");
        		});
        		/*$.ajax({
        			url: actionUrl,
        			type:"POST",
        			data: registerInfoSecondStep,
        			success:function(data){
        				if(data.result=="REGISTER_SECONDSTEP_SUCCESS"){
        					location.href = "/YueYun/public/index";
        				}else if(data.result == "REGISTER_FAIL_VERIFYCODE_WRONG"){
        					$("#registerVCodeErrorContainer").html("").append("<div class='error' for='registerVCode'>验证码错误</div>");
        				}else{
        					alert("error");
        				}
        			}
        		});*/
        	}
		}
	});
}
};
var registerManager = new RegisterManager();