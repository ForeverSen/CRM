<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet"
		href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>


		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script
			src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="js/jquery.validate.min.js" type="text/javascript"></script>

		<style>
.login {
	height: 505px;
	background-position: center 0%;
	background-repeat: no-repeat;
}

.loingnr {
	width: 502px;
	height: auto;
	margin-left: auto;
	margin-right: auto;
	padding-top: 130px;
	padding-right: 35px;
}

.loingnr span {
	font-size: 14px;
}

@charset "utf-8";

body {
	background-color: #F4F4F4;
	font-family: "微软雅黑";
}


.top10 {
	margin-top: 10px;
}

.top20 {
	margin-top: 20px;
}



.input-group, .input-group .form-control {
	height: 50px
}

.input-group-lg>.input-group-btn>.btn {
	height: 50px;
	padding: 10px 16px;
	font-size: 18px;
	line-height: 1.3333333;
	width: 100px;
}



.topx {
	border-top: 1px solid #E0E0E0;
	padding-top: 20px;
}
.row{
	background-color:#AFD9EE;
}
.bgcontainer{
	background-image: url(img/regist_bg.jpg);
	
}
label.error{
	background:url(img/unchecked.gif) no-repeat 10px 3px;
	padding-left: 30px;
	font-family:georgia;
	font-size: 15px;
	font-style: normal;
	color: red;
}



</style>
<script type="text/javascript">
	
	



	$(function(){
		$("#mylogin").validate({
			rules:{
				username:{
					required:true,
				},
				password:{
					required:true,
					rangelength:[6,18]
				}
				
				
			},
			messages:{
				username:{
					required:"用户名不能为空!"
				},
			password:{
				required:"密码不能为空!",
				rangelength:"密码长度必须在6到18位!"
			}			
			},
			errorElement: "label", //用来创建错误提示信息标签
			success: function(label) { //验证成功后的执行的回调函数
				//label指向上面那个错误提示信息标签label
				label.text(" ") //清空错误提示消息
					.addClass("success"); //加上自定义的success类
			}
		});
	})
	
	function loginSuccess() {
			$.post("<%=basePath%>user/login.action",$("#mylogin").serialize(),function(data){
				alert("登陆成功！");
				window.location.href="${pageContext.request.contextPath }/index.jsp";
			});
		}
u
	

	
</script>
</head>

<body>
<div class="bgcontainer">
<div class="row">
	<div class="col-md-1"></div>
	<div class="page-header col-md-10">
		<h1>詹叶客户管理系统
			<small>欢迎您</small>
		    <small style="margin-left: 180px;">系统登录</small>
		</h1>
	</div>
	<div class="col-md-1"></div>
</div>
	<div class="login">
		<div class="loingnr">
			<div class="modal-body">
				<form id="mylogin"  class="login-class" action="${pageContext.request.contextPath }/login.action"  method="post" >
				<div class="input-group input-group-lg" style="position: relative;">
					<span class="input-group-addon" id="sizing-addon1"><span
						class="glyphicon glyphicon-envelope" aria-hidden="true">
						</span></span>
						
						<input type="text" name="username" class="form-control " placeholder="请输入用户名"
						aria-describedby="sizing-addon1" type="text"  size="30"
						>
				</div>
	
				<div class="input-group input-group-lg top20">
					<span class="input-group-addon" id="sizing-addon1"><span
						class="glyphicon glyphicon-pencil" aria-hidden="true"></span></span>
						
						<input type="password" class="form-control" id="password" name="password"
						placeholder="请输入登录密码" aria-describedby="sizing-addon1"
						> 
						<span class="input-group-btn tccBut">
							<input type="submit" class="btn btn-info" style="width: 130px" 
							 value="登录">
					</span>	
				</div>

			</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
