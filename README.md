<h1>SSH个人博客系统</h1>学习SSH时，做的一个个人博客系统。<br>


* 需求分析：<br>
对于本博客系统，是面向个人使用，主要用于记录日常学习知识与文章分享。<br>
网站博主可以发表文章，每篇文章可以选择多个分类和标签。文章发表后，访问者可以查看每条博文，并对其进行评论和点赞。<br>
对于参观者所留下的评论，博主可以对其进行审核，通过则显示，未通过则删除。<br>
<h2>系统功能</h2>
系统主要为文章管理、分类管理、标签管理以及评论管理。	<br>

<strong>文章管理</strong>：文章有标题、内容、分类、标签、摘要、特色图片、浏览量、点赞量等属性。文章管理主要有文章的编写发布、查看、修改、删除。<br>
<strong>分类管理</strong>：每篇文章都可以由多个分类。分类主要有ID、分类名称属性。分类管理主要实现分类的添加、修改、删除、按照分类查看文章。<br>
<strong>标签管理</strong>：每篇文章可以有多个标签。标签主要有ID、标签名称属性。标签管理主要实现标签的添加、修改、删除、按照标签查看文章。<br>
<strong>评论管理</strong>：每篇文章都可以任意评论，每条评论网站访问者都可以查看并点赞或者点踩。评论管理主要为评论的增加、删除以及查看评论。<br>

<h2>功能模块设计</h2>
<h3>>功能模块描述<</h3>
管理员文章管理、评论管理、分类管理、标签管理四大模块。<br>
访问者文章点赞、增加评论、评论点赞/踩。<br>
<strong>管理员：</strong><br>
文章管理：文章添加、文章删除、文章修改<br>
评论管理：评论审核<br>
分类管理：新增分类、修改分类、删除分类<br>
标签管理：新增标签、修改标签、删除标签<br>
1)	文章添加：文章标题、内容、相关分类、标签、摘要以及特色图片<br>
2)	文章删除：通过Ajax获取文章ID进行删除<br>
3)	文章修改：通过Ajax获取文章详情，并进行修改<br>
4)	评论审核：通过Ajax获取所有未审核评论，并对其进行审核，通过保留、未通过删除<br>
5)	新增分类：通过Ajax保存新分类<br>
6)	修改分类：通过Ajax获取分类详情，进行修改并保存<br>
7)	删除分类：通过Ajax直接异步删除该分类<br>
8)	新增标签：通过Ajax保存新标签<br>
9)	修改标签：通过Ajax获取标签详情，进行修改并保存<br>
10)	删除标签：通过Ajax直接异步删除该标签<br>
11)	文章查询：通过Action跳转获取所有文章信息，进行异步加载剩余文章<br>
12)	文章、评论点赞：通过Ajax直接传入相关文章或评论ID，进行更新<br>
13)	追加评论：对文章进行评论，并通过Ajax进行提交保存。<br>
  
<h3>>功能模块描述<</h3>
  
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/action-index.png)<br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/action-background.png)<br>
<h3>>数据库设计<</h3>

<strong>Article表【文章表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_article.png)<br>
<strong>Sort表【分类表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_sort.png)<br>
<strong>Tag表【标签表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_tag.png)<br>
<strong>Comment表【评论表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_comment.png)<br>
<strong>user表【用户表表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_user.png)<br>
<strong>article_sort表【文章分类表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_article_sort.png)<br>
<strong>article_sort表【文章标签表】</strong><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/mysql_article_tag.png)<br>
<h2>图片预览</h2>

<strong>前台界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/FirstIndex.png)<br>

<strong>文章详情页</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/articleDetail.png)<br>

<strong>文章详情下方文章点赞、添加评论、评论点赞</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/commentStar.png)<br>

<strong>分类页</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/sortArticle.png)<br>

<strong>标签页</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/tagArticle.png)<br>

<strong>后台登陆界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/index.png)<br>

<strong>后台首页界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/backgroundIndex.png)<br>

<strong>后台所有文章界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/allArticle.png)<br>

<strong>后台文章发布界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/addArticle.png)<br>

<strong>后台文章修改界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/editArticle.png)<br>

<strong>后台分类功能界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/Sort.png)<br>

<strong>后台标签功能界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/Tag.png)<br>

<strong>评论审核界面</strong><br><br>
![image](https://github.com/978190375/SSH-MyBlog/blob/master/image/comment.png)<br>
