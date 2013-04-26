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
   	<title><s:property value="%{getText('login')}" /></title>
   	
   	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	
   	<link type="text/css" href="ui/css/common.css" rel="stylesheet"/>
   	<link type="text/css" href="ui/css/login.css" rel="stylesheet"/>
   	<link rel="icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
    <link rel="Shortcut Icon" href="ui/img/icon/yueyun_logo.ico" type="image/x-icon"/>
   	
   	<script src="ui/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
   	<script src="ui/js/jquery/jquery.validate.js" type="text/javascript"></script>
   	<script type="text/javascript">
   		function LoginManager(){
   			this.init();
   		}
   		LoginManager.prototype.init = function(){
   			$(document).ready(function(){
	   			$("#loginForm").validate({
	   				onfocusout: false,
	   				onkeyup: false,
	   				rules:{
	   					userEmail:{
	   						required:true,
	   						email:true
	   					},
	   					userPassword:{
	   						required:true
	   					}
	   				},
	   				messages:{
	   					userEmail:{
	   						required:"请输入邮箱地址",
	   						email:"请输入正确格式的邮箱地址"
	   					},
	   					userPassword:{
	   						required:"请输入密码"
	   					}
	   				},
	   				errorPlacement:function(error, element){
	   					if(error.attr("for") == "userEmail"){
	   						error.appendTo("#loginEmailErrorMessage");
	   					}else if(error.attr("for") == "userPassword"){
	   						error.appendTo("#loginPasswordErrorMessage");
	   					}
	   				},
	   				submitHandler:function(form){
	            		var loginInfo = $("#loginForm").serialize();
		   				var actionUrl = "/YueYun/userAjax/userLoginAction";
		   				$.ajax({
		   					url: actionUrl,
		   					type: "POST",
		   					data: loginInfo,
		   					success: function(data){
		   						if(data.result=="LOGIN_SUCCESS"){
		   							location.href = "/YueYun/public/index";
		   						}else{
		   							$("#loginAjaxErrorMessage").html("").append("<label class='error'>邮箱或密码错误</label>");
		   						}
		   					}
		   				});
	        		} 
	   			});
   			});
   		};
   		var loginManager = new LoginManager();
   	</script>
  </head>
  <body>
  	<s:include value="../../component/topUserBar.jsp"></s:include>
  	<s:include value="../../component/topSearchBar.jsp"></s:include>
  	<s:include value="../../component/navBar.jsp"></s:include>
  	<div id="loginPageBack" class="pageBack">
  		<div id="loginPageContainer" class="pageContainer">
  			<div id="loginPageTitle">
  				<s:text name="youHaveNotLogin"/>
  			</div>
  			<div id="loginFormContainer">
  				<div id="loginFormTitle"><s:text name="pleaseLoginOrRegister"/></div>
  				<div id="loginFormContent">
			    <div id="loginFormLeftContent">
			     	<form id="loginForm">
			     		<table>
			     			<tr>
			     				<td><label><s:text name="loginEmailAddress"/></label></td>
			     				<td>
			     					<input type="text" name="userEmail" id="userEmail"/>	
			     					<div id="loginEmailErrorMessage"></div>
			     				</td>
			     			</tr>
			     			<tr>
			     				<td><label><s:text name="loginPassword"/></label></td>
			     				<td>
			     					<input type="password" name="userPassword" id="userPassword"/>
			     					<div id="loginPasswordErrorMessage"></div>
			     				</td>
			     			</tr>
			     			<tr>
			     				<td></td>
			     				<td>
			     					<div id="loginAjaxErrorMessage"></div>
			     					<input type="submit" value="" id="loginSubmitButton"/>
			     				</td>
			     			</tr>
			     		</table>
			     	</form>
			     </div>
			     <div id="loginFormRightContent">
			     	<div class="loginFormOptionLinkContainer">
			     		<a href="user/register"><s:text name="newUserRegister"/></a>
			     	</div>
			     	<div class="loginFormOptionLinkContainer">
			     		<a href=""><s:text name="forgetPassword"/></a>
			     	</div>
			     </div>
  				</div>
			</div>
			<div style="height:50px;"></div>
		</div>
    </div>
  <s:include value="../../component/bottomSearchBar.jsp"></s:include>
  <s:include value="../../component/backTop.jsp"></s:include>
  </body>
</html>
