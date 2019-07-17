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
<script src="js/index.js"></script>
<script src="source/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="width:100%;"><jsp:include   page="daohang.jsp" flush="true"/></div>
    <div class="main_show">
		<div class="container">
			<div class="col-md-8" id="main_div" style="margin: 10px 0px 10px 0px">
				<ul id="main_display">
				
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