<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<base href="<%=basePath%>">
    <title><s:property value="%{getText('register')}" /></title>
    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
    
    <link type="text/css" href="ui/css/common.css" rel="stylesheet">
    <link type="text/css" href="ui/css/register.css" rel="stylesheet">
    <link type="text/css" href="ui/css/jquery-ui-1.10.2.custom.css" rel="stylesheet">
    <link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    
    <script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
   	<script src="ui/js/jquery/jquery.validate.js" type="text/javascript"></script>
   	<script src="ui/js/jquery/jquery.ui.core.js" type="text/javascript"></script>
   	<script src="ui/js/jquery/jquery.ui.widget.js" type="text/javascript"></script>
   	<script src="ui/js/jquery/jquery.ui.datepicker.js" type="text/javascript"></script>
   	<script src="ui/js/jquery/jquery.ui.datepicker-zh-TW.js" type="text/javascript"></script>
   	
   	<script type="text/javascript">
   		function RegisterManager(){
   			this.init();
   		}
   		RegisterManager.prototype.init = function(){
   		$(document).ready(function(){
   			$("#registerFormFirstStepContainer .registerFormTitle").html("注册新用户");
			$("#registerFormSecondStepContainer").hide();
			
			//init datepicker
			$("#registerBirthdayContainer input").datepicker({
				dateFormat:"yy-mm-dd",
				changeMonth:true,
				changeYear:true,
				yearRange:"-100:+0"
			});
			$("#ui-datepicker-div").css('font-size','12px');
			$("#ui-datepicker-div").css('font-family','microsoft yahei');
		
			//init verify code
			$("#registerVCodeImage").click(function(){
				$(this).attr("src","/YueYun/tool/verifyCodeAction?timestamp="+new Date().getTime());
			});
			
			//init gender select
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
	            		var actionUrl = "/YueYun/userAjax/userRegisterFirstStepAction";
	            		$.ajax({
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
		   							}else{
		   								$("#registerNameErrorContainer").html("").append("<div class='error' for='registerUser.userName'>您填写的昵称已经存在</div>");
		   								$("#registerEmailErrorContainer").html("").append("<div class='error' for='registerUser.userEmail'>您填写的电子邮箱地址已经存在</div>");
		   							}
		   						}
		   					}
	            		});
	            	}else{
	            		var registerInfoSecondStep = $("#registerForm").serialize();
	            		var actionUrl = "/YueYun/userAjax/userRegisterSecondStepAction";
	            		$.ajax({
	            			url: actionUrl,
	            			type:"POST",
	            			data: registerInfoSecondStep,
	            			success:function(data){
	            				if(data.result=="REGISTER_SECONDSTEP_SUCCESS"){
	            					alert("success");
	            				}else if(data.result == "REGISTER_FAIL_VERIFYCODE_WRONG"){
	            					$("#registerVCodeErrorContainer").html("").append("<div class='error' for='registerVCode'>验证码错误</div>");
	            				}
	            			}
	            		});
	            	}
        		}
   			});
   		});
   		};
   		var registerManager = new RegisterManager();
   	</script>
  </head>
  <body>
    <s:include value="../../component/topUserBar.jsp"></s:include>
    <s:include value="../../component/topSearchBar.jsp"></s:include>
    <s:include value="../../component/navBar.jsp"></s:include>
    <div id="registerPageBack" class="pageBack">
    	<div id="registerPageContainer" class="pageContainer">
    		<div style="height:20px;"></div>
    		<div id="registerFormContainer">
    			<form id="registerForm">
    			<div id="registerFormFirstStepContainer">
    				<div class="registerFormTitle">
    				</div>
    				<div class="registerFormContent">
    					<!--<form id="registerForm">-->
    					<div id="registerFormFirstInputContainer">
    						<div id="registerNameErrorContainer">
    						</div>
    						<div id="registerEmailErrorContainer">
    						</div>
    						<div id="registerPasswordErrorContainer">
    						</div>
    						<div id="registerNameContainer">
    							<span><s:text name="chineseOrEnglishNameBothOk"/></span>
    							<input type="text" id="registerUser.userName" name="registerUser.userName" />
    						</div>
    						<div id="registerEmailContainer">
    							<span><s:text name="useToLoginAndFindPassword"/></span>
    							<input type="text" id="registerUser.userEmail" name="registerUser.userEmail" />
    						</div>
    						<div id="registerPasswordContainer">
    							<span><s:text name="fourToTwentyCharEnglishCharOrNum"/></span>
    							<input type="password" id="registerUser.userPassword" name="registerUser.userPassword" />
    						</div>
    					</div>
    					<div id="registerFormNextStepButtonContainer">
    						<input id="registerFormNextStepButton" type="submit" 
    							value=""/>
    					</div>
    					<!--</form>-->
    				</div>
    			</div>
    			<div id="registerFormSecondStepContainer">
    				<div class="registerFormTitle">
    				</div>
    				<div class="registerFormContent">
    					<div id="registerFormSecondInputContainer">
    						<div style="position:absolute;left:130px;top:5px;">
	    						<div id="registerGenderErrorContainer"></div>
	    						<div id="registerGenderContainer">
	    							<input type="text" id="registerUser.userGender" name="registerUser.userGender" style="display:none;" value="F"/>
	    							<div id="registerMaleContainer">
	    								<div class="registerMaleImg"></div>
	    								<div>
	    									<div class="registerRadioImgSelect"></div>
	    									<div class="registerRadioText"><s:text name="male" /></div>
	    								</div>
	    							</div>
	    							<div id="registerFemaleContainer">
	    								<div class="registerFemaleImg"></div>
	    								<div>
	    									<div class="registerRadioImg"></div>
	    									<div class="registerRadioText"><s:text name="female" /></div>
	    								</div>
	    							</div>
	    						</div>
    						</div>
    						<div style="position:absolute;left:350px;top:30px;">
    							<div id="registerBirthdayErrorContainer"></div>
    							<div id="registerBirthdayContainer">
    								<div><s:text name="selectYourBirthday"/></div>
    								<input type="text" id="registerUser.userBirthday" name="registerUser.userBirthday" readonly="readonly"/>
    							</div>
    						</div>
    						<div style="position:absolute;left:350px;top:210px;">
    							<div id="registerVCodeContainer">
    								<div>
    									<span><s:text name="verifyCode"/></span>
    									<input type="text" id="registerVCode" name="registerVCode" />
    								</div>
    								<div>
    									<img id="registerVCodeImage" src="/YueYun/tool/verifyCodeAction" alt="<s:text name='donotSeeClearlyAndChangeOne'/>"/>
    								</div>
    							</div>
    							<div id="registerVCodeErrorContainer"></div>
    						</div>
    					</div>
    					<div id="registerFormCompleteRegisterButtonContainer">
    						<input id="registerFormCompleteRegisterButton" type="submit" 
    							value=""/>
    					</div>
    				</div>
    			</div>
    			</form>
    		</div>
    		<div style="height:50px;"></div>
    	</div>
    </div>
  <s:include value="../../component/bottomSearchBar.jsp"></s:include>
   <s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
