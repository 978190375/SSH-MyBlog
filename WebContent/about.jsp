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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>BM的个人博客--ABOUT</title>
<base href="<%=basePath%>">
<link href="source/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet" />
<link href="css/blog.css" rel="stylesheet" />
<link href="css/articleDetail.css" rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script src="source/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="js/article.js"></script>
</head>
<body>
	<div style="width:100%;"><jsp:include   page="daohang.jsp" flush="true"/></div>
    <div class="main_show">
		<div class="container">
			<div class="col-md-8" id="main_div" style="margin: 10px 0px 10px 0px">
				<ul id="main_display">
					<li class="col-md-12 article_li ">
						<div class="article_detail about_detail">
							<div><h1>BingMao</h1></div>
							<div class="about_detail_img"><img id="img_wechat" src="image/wechat.png"></div>
							<div class="about_detail_img"><img id="img_github" src="image/GitHub.png"></div>
							<div class="about_detail_img"><img id="img_weibo" src="image/weibo.png"></div>
							<div id="show_detail"></div>
							<div><h2>其它作品</h2></div>
							<div><a href="http://www.404zz.cn/steamapps/">Steam特惠信息网</a></div>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-md-4" style="margin: 10px 0px 10px 0px">
				<div style="width:100%;"><jsp:include   page="right.jsp" flush="true"/></div>
			</div>
		</div>
	</div>
	<div style="width:100%;"><jsp:include   page="floor.html" flush="true"/></div>

</body>

<style type="text/css">
.about_detail{
	text-align:center;
	height:100%;
	padding:50px;
}
.about_detail h1{
	margin:10px;
}
.about_detail_img{
	cursor:pointer;
	display:inline;
	margin:10px;
	padding:0px 10px 0px 10px;
}
.about_detail_img img{
	width:20px;
	height:20px;
}
.article_li{
}
</style>
<script>
	$('document').ready(function(){
		$('#img_wechat').hover(function(){
			$('#show_detail').html("<img style=\"width:200px;\" src=\"image/wechatqrcode.png\">")
		},function(){
			$('#show_detail').html("");
		});
		$('#img_github').hover(function(){
			$('#show_detail').html("<img style=\"width:200px;\" src=\"image/githubqrcode.png\">")
		},function(){
			$('#show_detail').html("");
		});
		$('#img_weibo').hover(function(){
			$('#show_detail').html("<img style=\"width:200px;\" src=\"image/weiboqrcode.png\">")
		},function(){
			$('#show_detail').html("");
		});
	})
</script>
</html>