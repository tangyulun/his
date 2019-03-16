<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>系统登录</title>
<style type="text/css">
	*{
		margin: 0px;
		padding: 0px;
	}
	#login-big-div{
		width: 100%;
	}
	#login-top-div{
		width:100%;
		height:90px;
	}
	#login-center-div{
		width:100%;
		height:562px;
		background-image: url(<c:url value='/images/tsp/tttt.jpg'/>);
		background-repeat:no-repeat;
		background-size:100% 100%;
	}
	.header{margin:10px auto; position: relative; width: 800px;}
	.headerNav { right: 0;text-align: right;top: 52px; width: 300px; position:absolute;}
	.headerNav a{ color:#515151; font-size:12px; padding:0 2px;text-decoration: none}
	.headerNav a:hover{ text-decoration:underline; color:#658b98;}

label.form-label {
    display: block;
    float: none;
    height: auto;
    line-height: 12px;
    text-align: left;
    width: auto;
	font-size:14px;
	color:#fff;
	font-weight:bold;
	text-shadow:1px 1px 1px #4e6877;
	-o-text-shadow:1px 1px 1px #4e6877;
	-o-moz-shadow:1px 1px 1px #4e6877;
	-o-mis-shadow:1px 1px 1px #4e6877;
	-o-webkit-shadow:1px 1px 1px #4e6877;
	margin-top:16px;
	margin-bottom:16px;
}
.i-text{ 
  width:240px;
  height:37px;
  line-height:37px;
  border:1px solid #80acd9;
  background:#eef3f8;
  color:#9cb5cd;
  font-size:14px; 
  text-indent:12px; 
  box-shadow:1px 1px 1px #dfe4e8 inset;
  -moz-box-shadow:1px 1px 1px #dfe4e8 inset;
  -webkit-box-shadow:1px 1px 1px #dfe4e8 inset;
  -o-box-shadow:1px 1px 1px #dfe4e8 inset;
  -mis-box-shadow:1px 1px 1px #dfe4e8 inset;
 }

.btn-login{ width:242px; height:38px;background:rgb(137 , 206 , 243)
; border:none; margin-top:5px;font-size: 16px}


#login_form_di{
	width:22%;
  height: 340px;
 float: right;
  margin: 45px 45px 0px 0px;
  border:1px solid #80acd9;
  color:#9cb5cd;
  font-size:14px; 
  text-indent:12px; 
  box-shadow: 1px 1px 4px rgba(11, 122, 179, 0.65) inset, 1px 1px 14px rgba(11, 122, 179, 0.45);
}
#login_form_di .registerform1{
	margin: 0px auto;
	position: absolute;
	padding: 28px;
}


#ul_lunbo{
	width:150px;
	list-style: none;
	position: absolute;
	margin: 535px 0px 0px 45%;
}
#ul_lunbo li{
	border:1px solid #ddd;
	width:10px;
	float: left;
	opacity:0.7;
	height: 10px;
	margin:3px;
	text-align:center;
	line-height:15px;
	border-radius: 10px;
}
</style>

<script type="text/javascript" src="<c:url value="/js/jquery-3.1.0.js"/>"></script>

<script type="text/javascript">
	$(function(){
		/*	点击忘记密码跳转忘记密码页面 */
			$("#wjmm").click(function(){
				$(".registerform1").addClass("out").removeClass("in");
			    setTimeout(function() {
			    	$(".registerform2").show().addClass("in").removeClass("out");
			    	$(".registerform1").hide();
			    },600);
			});
			/* 忘记密码完成点击去登录实现跳转 */
			$("#djdl").click(function(){
				$(".registerform2").addClass("out").removeClass("in");
			    setTimeout(function() {
			    	$(".registerform2").hide().addClass("in").removeClass("out");
			    	$(".registerform1").show();
			    },600);
			});
	});
	
	$(function(){
		$("#send-btn").click(function(){
			regexUser();
		});
	});
	   	function regexUser(){
	   		var userName=$("#username").val();
			var passWord=$("#password").val();
			$.post("yanzheng_user",{userName : userName,passWord :passWord},function(data){
				var json = eval('('+data+')');
				if(json.error){
					window.location.href="to_menu";
				}else{
					$(".error-box").html(json.eMessage);
				}
			});
	   	}
	   	
		document.onkeypress = login;
    	function login() {
	       	 if (event.keyCode == 13) {
	       		regexUser();
	       	 }
  		}
		
    	$(function(){
    		//检测是不是已经由用户登录
    		$.getJSON('select_is_user' , function(json){
    			if(json.error){
    				window.location.href="to_menu";
    			}
    		});
    	});
    	 
    	   var image=["<c:url value='/images/tsp/yy1.jpg'/>" , "<c:url value='/images/tsp/yy2.jpg'/>" ,
    		   "<c:url value='/images/tsp/tttt.jpg'/>","<c:url value='/images/tsp/yy1.jpg'/>" , "<c:url value='/images/tsp/yy2.jpg'/>" ,
    		   "<c:url value='/images/tsp/tttt.jpg'/>"
    		   ];
    	var i = 0;
    /* 	
    	function timer(){
    		if(i == image.length){ 	
    			i = 0 ;
    		}
     	  	$("#login-center-div").css("background" , "url('"+image[i++]+"') center 0 no-repeat").css("background-size" , " 100% 100%");
    	  	$("#ul_lunbo li").eq(i).css('background' ,'blue').siblings('li').css('background','');
    	}
    	var x=setInterval("timer()",3000);//无限触发   
  */
</script>

</head>
<body>
	<div id="login-big-div">
		<div>
			<div id="login-top-div">
				<div class="header">
				   <h1 class="headerLogo"><a title="后台管理系统" target="_blank" href="">
				   <img alt="" style="
				   	position:absolute;
				   " src="<c:url value="/images/ljj/医院.png"/>" width="80px" height="80">
				   <img alt="logo"  style="margin-left: 5px;margin-top: 7px" src="<c:url value="/images/ljj/logo.gif"/>"></a></h1>
					<div class="headerNav">
						<a target="_blank" href="#">关于His</a>
				
						<a target="_blank" href="#">开发团队</a>
				
						<a target="_blank" href="#">意见反馈</a>
				
						<a target="_blank" href="#">帮助</a>	
				
					</div>
				
				</div>
			</div>
			<div id="login-center-div">
				   

   <div id="login_form_di">
   		 <form class="registerform1 in">
   		 	   <div class="fm-item">
			   		 <div class="error-box" style="height:20px; color : red ; font-size:17px;"></div>
			  </div>
			   <div class="fm-item">
				   <label for="logonId" class="form-label" style="">HIS系统登陆：</label>
				   <input type="text" value="admin" maxlength="100" id="username" class="i-text" ajaxurl="demo/valid.jsp"  datatype="s6-18" errormsg="用户名至少6个字符,最多18个字符！"  >    
			       <div class="ui-form-explain"></div>
			  </div>
			  <div class="fm-item">
				   <label for="logonId" class="form-label">登陆密码：</label>
				   <input type="password" value="admin" maxlength="100" id="password" class="i-text" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！">    
			       <div class="ui-form-explain"></div>
			  </div>
			<!-- 登录 -->
			  <div class="fm-item" >
				   <label for="logonId" class="form-label"></label>
				  <input type="button" value="登  录" tabindex="4" id="send-btn" class="btn-login"style="background:#0099cc;color:white">
			       <div class="ui-form-explain"></div>
			  </div>
		  </form>
   </div>
	<!-- 
		<ul id="ul_lunbo">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul> -->
	
	</div>
		</div>
	</div>
</body>
</html>

