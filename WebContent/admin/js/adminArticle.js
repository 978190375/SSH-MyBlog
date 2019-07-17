

$(document).ready(function() {
		$('body').on('click', '.nav_oprion',function() {
			
			if ($(this).attr("id") == "SaveArticle") {//添加文章
				 clickArticle(this);
			}
			else if ($(this).attr("id") == "index") { //首页
				$(this).parent().siblings().removeClass("active");
				$(this).parent().addClass("active");
				location.href = "index.action";
			}else if ($(this).attr("id") == "AllArticle") { //所有文章页
				clickAllArticle(this);
			}else if ($(this).attr("id") == "AllSort") { //分类页
				clickSort(this);
			}else if ($(this).attr("id") == "AllTag") { //标签页
				clickTag(this);
			}else if ($(this).attr("id") == "Comment") { //评论
				clickComment(this);
			}
		});
		function clickComment(comment_icon){
			$(comment_icon).parent().siblings().removeClass("active");
			$(comment_icon).parent().addClass("active");
			$('#display').hide().load('admin/comment.html', function() {
				$(this).fadeIn(500);/* 文章编辑页--初始化输入框 */
				showComments();
			});
		}
		function clickArticle(article_icon){
			$(article_icon).parent().siblings().removeClass("active");
			$(article_icon).parent().addClass("active");
			$('#display').hide().load('admin/addArticle.html', function() {
				$(this).fadeIn(500);/* 文章编辑页--初始化输入框 */
				getSort();
			});
		}
		function clickSort(sort_icon){

			$(sort_icon).parent().siblings().removeClass("active");
			$(sort_icon).parent().addClass("active");
			$('#display').hide().load('admin/sort.html', function() {
				$(this).fadeIn(200);/* 文章编辑页--初始化输入框 */
				showSort();
			});
		};

		function clickTag(tag_icon){

			$(tag_icon).parent().siblings().removeClass("active");
			$(tag_icon).parent().addClass("active");
			$('#display').hide().load('admin/tag.html', function() {
				$(this).fadeIn(200);/* 文章编辑页--初始化输入框 */
				showTag();
			});
		};

		function clickAllArticle(article_icon){

			$(article_icon).parent().siblings().removeClass("active");
			$(article_icon).parent().addClass("active");
			$('#display').hide().load('admin/allArticle.html', function() {
				$(this).fadeIn(200);/* 文章编辑页--初始化输入框 */
				showArticle();
			});
		};
		//鼠标移动上去后显示编辑/删除操作
		$('body').on('mouseover','.action_tr',function(){
			$(this).find('.action_show').addClass("show");
		});
		//鼠标移除后隐藏编辑/删除操作
		$('body').on('mouseout','.action_tr',function(){
			$(this).find('.action_show').removeClass("show");
		});
/*首页*/
		$('body').on('click','#new_article',function(){
			clickArticle($('#SaveArticle'));
		})
		$('body').on('click','#manage_sort',function(){
			clickSort($('#AllSort'));
		})
		$('body').on('click','#manage_tag',function(){
			clickTag($('#AllTag'));
		})
		$('body').on('click','#manage_comment',function(){
			clickComment($('#Comment'));
		})
/*标签页*/
		$('body').on('click','#addtag_button',function() {
			if ($('#addtag_input').val()==""||$('#addtag_input').val()==null)
				alert("请检查是否输入新标签名!");
			else{
				var key=$('#addtag_input').val();
				$.ajax({type : 'get',
					url : "saveTag.action?input_value="+key,
					dataType : 'json',
					success : function(data) {
						console.log(data)
						if (data[0].result != "error") {
							alert($('#addtag_input').val()+"添加成功!");
							showTag();
						}
						if(data[0].result == "error"){
							alert($('#addtag_input').val()+"已存在！");
						}
						$('#addtag_input').val("");
					}
				})	
			}

		});	
		function showTag(){
				$.ajax({
					type:'get',
					url : "GetTagByJson.action",
					dataType : 'json',
					success : function(data) {
						if (data[0].result != "error") {
							var result = "";
							for (var i = 1; i < data.length; i++) {
								if(i%2==0){
									result += "<tr class=\"tr_ou action_tr\">";
	
								}else{
									result += "<tr  class=\"tr_ji action_tr\">";
	
								}
								result += "<input type=\"hidden\" name=\"tag_id\" value=\""+data[i].tag_id+"\">";
								
								result += "<td><p>"+data[i].tag_value+"</p>";
								result+="<div class=\"action_show\"><span class=\"edit tag_edit\">编辑</span>/<span class=\"delete  tag_delete\">删除</span></div></td>";
								result += "<td>"+data[i].tag_num+"</td>";
								result += "</tr>";
							}
							$('#allTagShow').html("").append(result);
						}
					}
					
				});
		}
		/*标签删除*/
		$('body').on('click','.tag_delete',function(){
			var tag_id=$(this).parent().parent().siblings("input").val();
			console.log(tag_id);
			deleteTag(this,tag_id);
		});
		function deleteTag(de,tag_id){
			layer.confirm('确认删除？', {icon: 3, title:'提示'}, function(index){
				$.ajax({
					type : 'get',
					url : "deleteTag?tag_id="+tag_id,
					dataType : 'json',
					success : function(data) {
					}
				})	

				$(de).parent().parent().parent(".action_tr").remove();
				layer.close(index);
			})
		};
		
		/*分类编辑*/
		$('body').on('click','.tag_edit',function(){
			$('#edit_tag_wall').addClass("show");
			$('#update_tag_hidden').val($(this).parent().parent().siblings("input").val());
			$('#update_tag_input').val($(this).parent().siblings("p").text());
		});
		$('body').on('click','#update_tag_button',function(){
			var tag_id=$('#update_tag_hidden').val();
			var tag_value=$('#update_tag_input').val();
			if(tag_value==null||tag_value=="")
				alert("请检查是否填写！");
			else{
				$.ajax({
					type:'get',
					url : "updateTag?tag_id="+tag_id+"&tag_value="+tag_value,
					dataType : 'json',
					success : function(data) {
						alert("修改成功！");
						clickTag($(".nav_oprion[id='AllTag']"));
					},
					error:function(data){
						alert("修改失败！");
						console.log(data);
					}
				});
			}
		});
/*分类页*/
		$('body').on('click','#addSort_button',function() {
			if ($('#addSort_input').val()==""||$('#addSort_input').val()==null)
				alert("请检查是否输入新分类名!");
			else{
				var key=$('#addSort_input').val();
				$.ajax({type : 'get',
					url : "saveSort.action?sort_value="+key,
					dataType : 'json',
					success : function(data) {
						if (data[0].result != "error") {
							alert($('#addSort_input').val()+"添加成功！");
							showSort();
						}
						else{
							alert($('#addSort_input').val()+"已存在！");
							
						}
						$('#addSort_input').val("");
					}
				})	
			}

		});	
		function showSort(){
			
			$.ajax({
				type:'get',
				url : "GetSortByJson.action",
				dataType : 'json',
				success : function(data) {
					if (data[0].result != "error") {
						var result = "";
						for (var i = 1; i < data.length; i++) {
							if(i%2==0){
								result += "<tr class=\"tr_ou action_tr\">";

							}else{
								result += "<tr  class=\"tr_ji action_tr\">";

							}
							result += "<input type=\"hidden\" name=\"sort_id\" value=\""+data[i].sort_id+"\">";
							
							result += "<td><p>"+data[i].sort_sort+"</p>";
							result+="<div class=\"action_show\"><span class=\"edit sort_edit\">编辑</span>/<span class=\"delete sort_delete\">删除</span></div></td>";
							result += "<td>"+data[i].sort_num+"</td>";
							result += "</tr>";
						}
						$('#allSortShow').html("").append(result);
					}
				}
				
				});
		}
		/*分类删除*/
		$('body').on('click','.sort_delete',function(){
			var sort_id=$(this).parent().parent().siblings("input").val();
			console.log(sort_id);
			deleteSort(this,sort_id);
		});
		function deleteSort(de,sort_id){
			layer.confirm('确认删除？', {icon: 3, title:'提示'}, function(index){
				$.ajax({
					type : 'get',
					url : "deleteSort?sort_id="+sort_id,
					dataType : 'json',
					success : function(data) {
					}
				})

				$(de).parent().parent().parent(".action_tr").remove();
				layer.close(index);
			})
		};

		/*分类编辑*/
		$('body').on('click','.sort_edit',function(){
			$('#edit_sort_wall').addClass("show");
			$('#update_sort_hidden').val($(this).parent().parent().siblings("input").val());
			$('#update_sort_input').val($(this).parent().siblings("p").text());
		});
		$('body').on('click','#updata_sort_button',function(){
			var sort_id=$('#update_sort_hidden').val();
			var sort_value=$('#update_sort_input').val();
			if(sort_value==null||sort_value=="")
				alert("请检查是否填写！");
			else{
				$.ajax({
					type:'get',
					url : "updateSort?sort_id="+sort_id+"&sort_value="+sort_value,
					dataType : 'json',
					success : function(data) {
						alert("修改成功！");
						clickSort($(".nav_oprion[id='AllSort']"));
					},
					error:function(data){
						alert("修改失败！");
						console.log(data);
					}
				});
			}
		});
/*所有文章页*/
		function showArticle(){
			$.ajax({
			type:'get',
			url : "GetAllArticleByJson.action?page=1",
			dataType : 'json',
			success : function(data) {
				if (data[0].result != "error") {
					var result = "";
					for (var i = 1; i < data.length; i++) {
						if(i%2==0){
							result += "<tr class=\"tr_ou action_tr\"><jsp:useBean id=\"dateValue\" class=\"java.util.Date\"/>";
						}else{
							result += "<tr  class=\"tr_ji action_tr\"><jsp:useBean id=\"dateValue\" class=\"java.util.Date\"/>";
						}
						result += "<input type=\"hidden\" name=\"article_id\" value=\""+data[i].article_id+"\">";
						
						result += "<td><a href=\"GetArtilceDetail?article_id="+data[i].article_id+"\"><p>"+data[i].article_title+"</p></a>";
						result += "<div class=\"action_show\"><span class=\"edit article_edit\">编辑</span>/<span class=\"delete article_delete\">删除</span></div></td>";
						result += "<td>"+data[i].article_author+"</td>";
						result += "<td>"+data[i].article_sort+"</td>";
						result += "<td>"+data[i].article_tag+"</td>";
						result += "<td>"+timestampToTime(data[i].article_time)+"</td>";
						result += "</tr>";
					}
					$('#allArticleShow').append(result);
				}
			}
			})
		}
		/*文章删除*/
		$('body').on('click','.article_delete',function(){
			var article_id=$(this).parent().parent().siblings("input").val();
			deleteTips(this,article_id);
		});
		/*文章删除*/
		function deleteTips(de,article_id){
			layer.confirm('确认删除？', {icon: 3, title:'提示'}, function(index){
				$.ajax({
					type : 'get',
					url : "deleteArticle?article_id="+article_id,
					dataType : 'json',
					success : function(data) {
					}
				})
		
				$(de).parent().parent().parent(".action_tr").remove();
				layer.close(index);
			})
		};
		/*文章修改*/
		$('body').on('click','.article_edit',function(){
			articleUpdate(this);
		});

		$('body').on('click','#submit_update_article',function(){
			updateArticleSubmit();
		});
		/*文章更新*/

		/*文章更新*/

		function articleUpdate(article_edit){
			var article_id=$(article_edit).parent().parent().siblings("input").val();

			$('#display').hide().load('admin/updateArticle.html', function() {
				$(this).fadeIn(500);
			});
			$.ajax({
				type : 'get',
				url : "getArticleDetailJSON?article_id="+article_id,
				dataType : 'json',
				success : function(data) {
					console.log(data);
					if (data[0].message != "error") {

						$('#title').before("<input type=\"hidden\" id=\"article_id\" name=\"article_id\" value=\""+data[1].article_id+"\"/>");
						$('#title').val(data[1].article_title);
						$('.simditor-body').eq(0).html(data[1].article_content);
						$('#comment').html(data[1].article_summary);
						if(data[1].article_image!=""&&data[1].article_image!=null)
							$('.simditor-body').eq(1).html("<p><img src=\""+data[1].article_image+"\" width=\"100%\" height=\"auto\"></p>");
						var newarray=new Array();
						var newarray1=new Array();
						newarray=data[2];
						getCheckedSort(newarray);
						newarray1=data[3];
						getCheckedTag(newarray1);
					}
				}
			});
		};
		
		/*文章更新---写入sort*/
		function getCheckedSort(array){
			$.ajax({type : 'get',
				url : "GetAllSort.action",
				dataType : 'json',
				success : function(data) {
					if (data[0].message != "error") {
						var result = "";
						var sure=0;
						for (var i = 1; i < data.length; i++) {
							for(var j=0;j<array.length;j++){
								if(data[i].sort_id==array[j].sortId)
								{
									result += "<input type=\"checkbox\" checked=\"true\" class=\"input_sort\" name=\"sort\" value=\""+data[i].sort_id+"\">"+data[i].sort_sort+"<br />";
									sure=1;
									break;
								}
							}
							if(sure==0)
							{
								result += "<input type=\"checkbox\" class=\"input_sort\" name=\"sort\" value=\""+data[i].sort_id+"\">"+data[i].sort_sort+"<br />";
							}
							else{
								sure=0;
							}
						}
						$('.shownewSort').before(result);
					}
				}
				});
		};
		/*文章更新---写入标签*/
		function getCheckedTag(array){
			var html="";
			var tag_value="";
			for(var i=0;i<array.length;i++)
			{	console.log("array.length"+array.length);
				html = "<span class=\"tag_has\" id=\""
					+ array[i].tagId
					+ "\"><font>"
					+ array[i].tag_tag
					+ "</font><span class=\"glyphicon glyphicon-remove tag_close\" aria-hidden=\"true\"></span></span>";
				tag_value+=array[i].tagId+",";
			}
			$('#tag_input').before(html);
			
			$('#tag').val(tag_value);
		};
		/*文章更新--提交*/
		function updateArticleSubmit(){
			var artilce_id=$('#article_id').val();
			var title=$('#title').val();
			var content=$('.simditor-body').eq(0).html();
			var sort="";
			$('input[name="sort"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数    
	            sort+=$(this).val()+",";//将选中的值添加到数组chk_value中    
	            });
			sort=sort.substring(0,sort.length-1);
			var tag=$('#tag').val();
			var summary=$('#comment').val();
			var image_url=$('.simditor-body').eq(1).find("img").attr("src");
			$.ajax({type : 'post',
				url : "updateArticle",
				data:{
					"article_id":artilce_id,
					"title":title,
					"content":content,
					"sort":sort,
					"tag":tag,
					"image_url":image_url,
					"summary":summary,
				},
				dataType : 'json',
				success : function(data) {
					alert("提交成功");
					clickAllArticle($(".nav_oprion[id='AllArticle']"));
				}
				});
		}
/*文章编辑页*/
	/*文章编辑也--提交*/
		$('body').on('click','#save_article_button',function(){
			saveArticleSubmit();
		});
		function saveArticleSubmit(){
			var title=$('#title').val();
			var content=$('.simditor-body').eq(0).html();
			var sort="";
			$('input[name="sort"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数    
	            sort+=$(this).val()+",";//将选中的值添加到数组chk_value中    
	            });
			sort=sort.substring(0,sort.length-1);
			var tag=$('#tag').val();
			var summary=$('#comment').val();
			var image_url=$('.simditor-body').eq(1).find("img").attr("src");
			$.ajax({type : 'post',
				url : "ArticleSave",
				data:{
					"title":title,
					"content":content,
					"sort":sort,
					"tag":tag,
					"image_url":image_url,
					"summary":summary,
				},
				dataType : 'json',
				success : function(data) {
					alert("提交成功");
					clickAllArticle($(".nav_oprion[id='AllArticle']"));
				}
				});
		}
	/*文章编辑页--获取分类*/
		function getSort(){
			$.ajax({type : 'get',
				url : "GetAllSort.action",
				dataType : 'json',
				success : function(data) {
					if (data[0].message != "error") {
						var result = "";
						for (var i = 1; i < data.length; i++) {
							result += "<input type=\"checkbox\" class=\"input_sort\" name=\"sort\" value=\""+data[i].sort_id+"\">"+data[i].sort_sort+"<br />";
						}
						$('.shownewSort').before(result);
					}
				}
				});
		};
		
		/* 文章编辑页--显示添加新分类目录 */
		$('body').on('click','.shownewSort',function() {
			if ($('#newSort').hasClass("show"))
				$('#newSort').removeClass("show");
			else
				$('#newSort').addClass("show");

		});
		/*文章编辑页--添加新分类目录*/
		$('body').on('click','#newSort_button',function() {
			if ($('#newSort_input').val()==""||$('#newSort_input').val()==null)
				alert("请检查是否输入新分类名!");
			else{
				var key=$('#newSort_input').val();
				$.ajax({type : 'get',
					url : "saveSort.action?sort_value="+key,
					dataType : 'json',
					success : function(data) {
						if (data[0].result != "error") {
							var sort = "<input type=\"checkbox\" class=\"input_sort\" name=\"sort\" value=\""+data[1].sort_id+"\">"+data[1].sort_sort+"<br />";
							//将添加新分类的输入框内的值设置为空
							$('#newSort_input').val("");
							$('.shownewSort').before(sort);
						}
						else{
							alert("添加失败");
						}
					}
				})	
			}

		});

		/* 文章编辑页--输入框得到焦点 */
		$('body').on('focus','#tag_input',function() {
			$('#tag_div').removeClass("tag_div_class");
			$('#tag_div').addClass("tag_div_click");

		});
		/* 文章编辑也--标签输入框按下回车键 */
		$('body').on('keypress','#tag_input',function(event) {
					var keynum = (event.keyCode ? event.keyCode
							: event.which);
					if (keynum == '13') {
						uploadTag();
						$('#tag_div').removeClass("tag_div_class");
						$('#tag_div').addClass("tag_div_click");
						return false;
					}
				});
		/* 文章编辑页--输入框失去焦点 */
		$('body').on('blur','#tag_input',function() {
			if($('#tag_select').css("display")=="none")
				uploadTag();
			$('#tag_div').removeClass("tag_div_click");
			$('#tag_div').addClass("tag_div_class");
		});

		/* 文章编辑页--输入框实时监听输入内容 */
		$('body').on('input','#tag_input',function() {
			$('#tag_div').addClass("tag_div_click");
			var input_value = $('#tag_input').val();
			if (input_value != ""
					&& input_value != null
					&& input_value.length >= 2) {
				$.ajax({
						type : 'get',
						url : "GetTag.action?input_value="
								+ input_value,
						dataType : 'json',
						success : function(data) {
							if (data[0].result != "error") {
								var result = "";
								for (var i = 1; i < data.length; i++) {
									result += "<li id="
											+ data[i].tag_id
											+ " class=\"tag_select_li\">"
											+ data[i].tag_value
											+ "</li>"
								}
								$('#tag_select').addClass("show");
								$('#tag_select_ul').html(result);
								} 
							else {
								$('#tag_select').removeClass("show");
							}
						}
					})
			} else {
				$('#tag_select')
						.removeClass("show");
			}
		});
		/* 文章编辑页--点击动态生成的li并更新标签 */
		$('body').on('click',".tag_select_li",function() {
			$('#tag_input').val("");
			var html = "<span class=\"tag_has\" id=\""
					+ $(this).attr("id")
					+ "\"><font>"
					+ $(this).html()
					+ "</font><span class=\"glyphicon glyphicon-remove tag_close\" aria-hidden=\"true\"></span></span>";

			/* 更新input */
			var tag_value = $('#tag').val()
					+ $(this).attr("id") + ",";
			$('#tag').val(tag_value);
			$('#tag_input').before(html);
			$('#tag_select').removeClass("show");
		})
		/*更新标签*/
		function uploadTag() {
			if ($('#tag_input').val() != "") //如果输入框中内容不为空，就添加至span标签
			{
				var html = "<span class=\"tag_has\"><font>"
						+ $('#tag_input').val()
						+ "</font><span class=\"glyphicon glyphicon-remove tag_close\" aria-hidden=\"true\"></span></span>";

				$('#tag_input').before(html);
				/*更新input*/
				var tag_value = $('#tag').val()
						+ $('#tag_input').val() + ",";
				$('#tag').val(tag_value);
				//将input内的值设置为空
				$('#tag_input').val("");
			}
			$('#tag_select').removeClass("show");
		}

		/* 文章编辑也--删除标签 */
		$('body').on('click','.tag_close',function() {
			if ($(this).parent().attr("id") != null) {
				var id = $(this).parent().attr("id");
				$('#tag').val(
						$('#tag').val().replace(id + ",",
								""));
			} else {
				var tag_value = $(this).siblings().html();
				$('#tag').val(
						$('#tag').val().replace(
								tag_value + ",", ""));
			}
			$(this).parent().remove();
		});
/*评论页*/
		$('body').on('click','.right_span_accept',function(){
			var comment_id=$(this).siblings("input").val();
			$.ajax({
				type:'get',
				url : "acceptComment?comment_id="+comment_id,
				dataType : 'json',
				success : function(data) {
				}
			});

			$(this).parent().parent(".comments_li").remove();
		});
		$('body').on('click','.right_span_refuse',function(){
			var comment_id=$(this).siblings("input").val();
			$.ajax({
				type:'get',
				url : "refuseComment?comment_id="+comment_id,
				dataType : 'json',
				success : function(data) {
					$(this).parent().parent(".comments_li").remove();
				}
			});

			$(this).parent().parent(".comments_li").remove();
		});
		
		function showComments(){
			$.ajax({
				type:'get',
				url : "getAllComment",
				dataType : 'json',
				success : function(data) {
					console.log(data);
					if (data[0].result != "error") {
						var result = "";
						for (var i = 1; i < data.length; i++) {
							result+="<li class=\"comments_li\"><div class=\"col-md-12 article_title_div\"><a href=\"GetArtilceDetail?article_id="+
								+data[i].article_id
								+"\"><span>"
								+data[i].article_title
								+"</span></a></div><div class=\"comments_list_left col-md-2\"><div class=\"tou\"></div><p class=\"nickname\">"
								+data[i].comment_nickname
								+"</p><br></div><div class=\"comments_list_right col-md-9\"><div class=\"comments_list_right_top\"style=\"width:100%\"><p>"
								+data[i].comment_content
								+"<p></div><div class=\"comments_list_right_bottom\"><span>"
								+timestampToTime(data[i].comment_time)
								+"</span></div></div><div class=\"comments_list_right_right col-md-1\"><input type=\"hidden\" value=\""
								+data[i].comment_id
								+"\"><div class=\"right_span right_span_accept\"><span >通过"
								+"</span></div><div class=\"right_span right_span_refuse\">"
								+"<span>删除</span></div></div></li>"	
						}
						$('.comments_ul').html("").append(result);
					}

					$('.nickname').each(function(){
						var nickname=$(this).html();
						var first=nickname.substring(0,1);
						$(this).siblings("div").html(first);
					})
				}
				
			});
		}
});
/*时间戳转换为时间*/
		function timestampToTime(timestamp){
			//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		    var date = new Date(timestamp);
		    Y = date.getFullYear() + '-';
		    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		    D = date.getDate() + ' ';
		    h = date.getHours() + ':';
		    m = date.getMinutes() + ':';
		    s = date.getSeconds();
		    return Y+M+D+h+m+s;
		}