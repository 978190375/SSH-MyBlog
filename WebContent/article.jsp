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
<title>BM的个人博客</title>
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
						<div >
							<div class="article_detail">
								<div><img id="article_image" src="${a.image_url}" style="width:100%"></div>
							</div>
							<div class="article_detail">
								<input type="hidden" value="${a.id}">
								<div class="article_detail_top">
									<h2>${a.title}</h2>
									<span>Posted on </span>
									<jsp:useBean id="dateValue" class="java.util.Date"/>
									<jsp:setProperty name="dateValue" property="time" value="${a.time}"/>
									<span id="article_time"><fmt:formatDate value="${dateValue}" pattern="yyyy/MM/dd"/></span> 
									<span>by </span><span id="article_author">${a.author} </span>
									<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>：<span id="article_visited">${a.visit}</span>
								</div>
								<div class="article_detail_center article_detail">${a.content}
								</div>
								<div class="article_detail_star">
									<div class="article_detail_star_div">
											<span id="star" class="glyphicon glyphicon-thumbs-up" aria-hidden="true">
												
											</span><p id="star_data">${a.star}</p>
									</div>
								</div>
								
							</div>
							<!-- 显示评论 -->
							<div class="article_detail_floor">
								<ul>
									<s:iterator id="comment" value="comments">
										<li class="show_comments"> 
											<div class="comments_list_left col-md-2">
												<div class="tou"></div>
												<p class="nickname"><s:property value="#comment.nickname" /></p>
												<br>
											</div>
											<div class="comments_list_right col-md-9">
												<div class="comments_list_right_top"style="width:100%"><p><s:property value="#comment.content" /><p></div>
												<div class="comments_list_right_bottom"><span><s:property value="#comment.time" /></span></div>
												 
											</div>
											<div class="comments_list_right_right col-md-1">
												<input type="hidden" value="${comment.id }">
												<div class="right_span right_span_star">
													<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
													<span class="comment_star_num"><s:property value="#comment.star" /></span>
												</div>
												<div class="right_span right_span_diss">
													<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
												 	<span class="comment_diss_num"><s:property value="#comment.diss" /></span>
												 </div>
											</div>
										</li>
									</s:iterator>
								</ul>
							</div>
							<div class="article_detail_comment" >
									<div style="text-align:center;">
									<h2>评论</h2>
									<span style="color:gray">网络并非无法之地，请注意您的言行！</span></div>
									昵称：<input type="text" maxlength="8"  id="nickname">
									<button id="comment_button" class="btn btn-success">发表评论</button><br>
									评论：<textarea maxlength="200" id="comment_textarea"></textarea>
							</div>
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
<script>
	
</script>
</html>