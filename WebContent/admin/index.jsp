<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后-->
<title>后台管理</title>
<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css"
	href="source/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="source/simditor/simditor.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.bootcss.com/jquery-confirm/3.3.4/jquery-confirm.min.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/adminArticle.css" />
<script type="text/javascript" src="source/simditor/jquery.min.js"></script>
<script type="text/javascript"
	src="source/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>
<script type="text/javascript" src="source/simditor/module.js"></script>
<script type="text/javascript" src="source/simditor/hotkeys.js"></script>
<script type="text/javascript" src="source/simditor/uploader.js"></script>
<script type="text/javascript" src="source/simditor/simditor.js"></script>
<script type="text/javascript" src="source/layer/layer.js"></script>
<script type="text/javascript" src="admin/js/updateArticle.js"></script>
<script type="text/javascript" src="admin/js/adminArticle.js"></script>
</head>
<body>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.action">BLOG-后台管理</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">网站首页</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 sidebar left_menu">
				<ul class="nav nav-sidebar">
					<li class="active"><a class="nav_oprion" id="index" ><stong>首页</stong></a></li>
					<li><a class="nav_oprion" id="AllArticle" >所有文章</a></li>
					<li><a class="nav_oprion" id="SaveArticle" >写文章</a></li>
					<li><a class="nav_oprion" id="AllSort">分类目录</a></li>
					<li><a class="nav_oprion" id="AllTag">标签</a></li>
					<li><a class="nav_oprion" id="Comment">评论</a></li>
				</ul>
			</div>
			<div class="col-md-10 main" id="display">
				<div class="col-md-12 index_wall index_welcome">
					<h3><strong>欢迎使用BMBlog！</strong></h3>
					<h4>点击下方链接即可开始使用哦！</h4>
					<div class="col-md-6 aurl">
						<ul>
							<li>
								<a id="new_article">
									<span class="glyphicon glyphicon-pencil li_span" aria-hidden="true"></span>
									撰写您的第一篇博文吧！
								</a>
							</li>
						</ul>
					</div>
					<div class="col-md-6 aurl">
						<ul>
							<li>
								<a id="manage_sort">
									<span class="glyphicon glyphicon-th-list li_span" aria-hidden="true"></span>
									管理您的分类吧！
								</a>
							</li>
							<li>
								<a id="manage_tag">
									<span class="glyphicon glyphicon-tags li_span" aria-hidden="true"></span>
									管理您的标签吧！
								</a>
							</li>
							<li>
								<a id="manage_comment">
									<span class="glyphicon glyphicon-comment li_span" aria-hidden="true"></span>
									管理您的评论吧！
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-12 index_wall index_preview">
					<h3><strong>概览</strong></h3>
					<div class="col-md-6 aurl">
						<ul>
							<li>
								<a>
									<span class="glyphicon glyphicon-book li_span" aria-hidden="true"></span>
									<span>${articleCount }</span>
									篇文章
								</a>
							</li>
							
						</ul>
					</div><div class="col-md-6 aurl">
						<ul>
							<li>
								<a>
									<span class="glyphicon glyphicon-th-list li_span" aria-hidden="true"></span>
									${sortCount }个分类
								</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-12  index_wall index_activity">
					<h3><strong>活动</strong></h3>
					<h4>最近发布</h4>
					<table  id="newActicity">
						<thead>
							<tr>
							  <td id="time_td">时间</td>
							  <td>文章</td>
							</tr>
						</thead>
						<tbody>
						
							<jsp:useBean id="dateValue" class="java.util.Date"/>
							<s:iterator value="articles">
								<tr>
									<td><jsp:setProperty name="dateValue" property="time" value="${time}"/>
									<fmt:formatDate value="${dateValue}" pattern="yyyy/MM/dd HH:mm"/>
									
									</td>
									<td><a href="GetArtilceDetail?article_id=${id }">${title }</a></td>
								</tr>
							
							</s:iterator>
							<tr>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

</html>