<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>Right</title>
<link href="css/right.css" rel="stylesheet" />

<script src="js/right.js"></script>
</head>
<body>
<!--  停止搜索 
<div class="right_wall right_wall_search">
	<h4>搜索</h4>
	<input type="text" id="article_key" name="article_key">
</div> -->
<div class="right_wall right_wall_post">
	<h4>分类目录</h4>
	<div class="right_wall_post_display">
		<ul id="right_wall_post_display_ul">
		</ul>
	</div>
</div>
<div class="right_wall right_wall_tag">
	<h4>标签</h4>
	<div class="right_wall_tag_display">
		<ul>
			<li class="right_li right_li_tag"></li>
		</ul>
	</div>
</div>
<div class="right_wall right_wall_function">
	<h4>功能</h4>
	<div class="right_wall_function_display">
		<ul>
			<li class="right-li" id="right_li_login">登陆</li>
		</ul>
	</div>
</div>
</body>
</html>