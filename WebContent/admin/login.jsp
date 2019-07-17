<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后-->
<base href="<%=basePath%>">

<title>My JSP 'login' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="source/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>

<body>
	<div class="container" id="main">

		<!--  <div class="col-md-4"></div>-->

		<div class="col-md-4 col-md-offset-4" id="logintag">
		
			<div class="col-xs-4 col-xs-offset-4 col-md-6 col-md-offset-3" id="loginlogo">
				<img alt="MyBlog" src="image/logo.png" style="width: 100%;height:this.width;">
			</div>
			<form class="form-signin" action="login" method="post">
				<label> 用户名 <input type="text" id="username" name="username"
					class="form-control" placeholder="用户名" required="" autofocus="">
				</label> <label> 密码 <input type="password" id="password" name="password"
					class="form-control" placeholder="密码" required="">
				</label> <br />
				<button class="btn btn-lg btn-primary btn-block" id="loginbutton" type="submit">登陆</button>
			</form>
		</div>
		<!--  <div class="col-md-4"></div>-->
		
	</div>
	<!-- /container -->
	<style>
	#loginbutton{
	margin-top:10px;
		}
#loginlogo {
	text-align: center;
	margin-top:30px;
	margin-bottom:50px;
}

body {
	background-color: #f1f1f1;
}

#logintag {
	padding:30px 15px 50px 15px;
	background-color: #FFF;
}

label {
	width: 100%;
}

#loginh2 {
	background-color: #4876FF;
	color: #FFF;
}

input {
	margin-bottom: 10px;
}
</style>
</body>
</html>
