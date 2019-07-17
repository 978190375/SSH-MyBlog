/**
 * 
 */
var sort_id=0;
var tag_id=0;
var sort_sort;
var tag_tag;
$(document).ready(function() {
	/*获取分类*/
	$.ajax({
		type:'get',
		url : "GetSortByJson.action",
		dataType : 'json',
		success : function(data) {
			if (data[0].result != "error") {
				var result = "";
				for (var i = 1; i < data.length; i++) {
					result += "<li class=\"right_li right_li_sort\"><input type=\"hidden\" name=\"sort_id\" value=\""+data[i].sort_id+"\"><font>";
					
					result += data[i].sort_sort+"</font>("+data[i].sort_num+")";
					result += "</li>";
				}
				$('#right_wall_post_display_ul').append(result);
			}
		}
	});
	/*获取标签*/
	$.ajax({
		type:'get',
		url : "GetTagByJson.action",
		dataType : 'json',
		success : function(data) {
			if (data[0].result != "error") {
				var result = "";
				for (var i = 1; i < data.length; i++) {
						if(data[i].tag_num>="1")
							result += "<font class=\"tag_font\" style=\"font-size:25px;text-decoration:underline;\"><input type=\"hidden\" value=\""+data[i].tag_id+"\"><font>";				
						else
							result += "<font  class=\"tag_font\"  ><input type=\"hidden\" value=\""+data[i].tag_id+"\"><font>";

					result += data[i].tag_value+"</font>(<span >"+data[i].tag_num+"</span>)";
					result += "</font>";
				}
				$('.right_li_tag').append(result);
			}
		}
		
	});
	/*分类点击*/
	$('body').on('click', '.right_li_sort',function() {
		if($("script[src='js/index.js']").length <= 0)
		{
			$('head').append("<script src=\"js/index.js\"></script>");
			sort_id=$(this).children("input").val();
			sort_sort=$(this).children("font").html();
			page=1;
			$('#main_display').html("").load('sort.html', function() {
				$('#sort_font').html(sort_sort);
			});
		}
		else{
			sort_id=$(this).children("input").val();
			sort_sort=$(this).children("font").html();
			page=1;
			$('#main_display').html("").load('sort.html', function() {
				$('#sort_font').html(sort_sort);
				getData(page,sort_id,tag_id);
			});
		}
	});
	right_li_login
	/*标签点击*/
	$('body').on('click', '.tag_font',function() {
		if($(this).children("span").html()!=0){
			if($("script[src='js/index.js']").length <= 0)
			{
				$('head').append("<script src=\"js/index.js\"></script>");
				tag_id=$(this).children("input").val();
				tag_tag=$(this).children("font").html();
				page=1;
				$('#main_display').html("").load('tag.html', function() {
					$('#tag_font_show').html(tag_tag);
				});
			}
			else{
				tag_id=$(this).children("input").val();
				tag_tag=$(this).children("font").html();
				page=1;
				$('#main_display').html("").load('tag.html', function() {
					$('#tag_font_show').html(tag_tag);
					getData(page,sort_id,tag_id);
				});
			}
		}
		else{
			alert("没有文章！");
		}
	});	
	/*登陆点击*/
	$('body').on('click', '#right_li_login',function() {
		window.location.replace("admin/login.jsp");
	});
});