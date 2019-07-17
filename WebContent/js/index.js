/**

	var data_result= true;
 * 
 */

var result = "";
var page=1;
var data_result= true;
$(document).ready(function() {
	var open = true; //触发条件
	getData(page,sort_id,tag_id);
	$(window).scroll(function() {
				if ($(document).height() - $(this).scrollTop()
						- $(this).height() < 20) {
					if (open&&data_result) {
						open = false;
						page++;
						getData(page,sort_id,tag_id);
						setTimeout(function() {
							open = true;
						}, 1000);
					}
				}

	});
	
	/*点击文章图片  采用JSON方式 废弃--》采用struts跳转方式article.jsp
	$('body').on('click', '.article_img',function() {

		$('#main_display').load("articleDetail.html");
		$.ajax({
			url : "GetArtilceDetail?article_id="+$(this).parent().parent().siblings("input").val(),
			type : 'GET',
			dataType : 'json',
			success : function(data) {
				if (data[0].result != "error") {
					$('#article_image').attr("src",data[1].article_image);
					$('#article_visited').html(data[1].article_visit);
					$('#article_author').html(data[1].article_author);
					$('#article_time').append(timestampToTime(data[1].article_time));
					$('.article_detail_top h2').append(data[1].article_title);
					$('.article_detail_center').append(data[1].article_content);
				}
			}
		});
	});*/
});
	/**/

	/*首页获取文章*/
	function getData(page,sort_id,tag_id) {
		var url = "GetArtilceIndex?page=" + page+"&sort_id="+sort_id+"&tag_id="+tag_id;
		$.ajax({
			url : url,
			type : 'GET',
			dataType : 'json',
			success : function(data) {
				var result = "";
				if (data[0].result != "error") {
					for (var i = 1; i < data.length; i++) {
						if(data[i].article_image==null||data[i].article_image=="")
							
							result+="<li class=\"col-md-12 article_li\"><input type=\"hidden\" value=\""+data[i].article_id+"\"><div class=\"article_wall\"><div class=\"col-md-12\"><div class=\"article_wall_header\"><a href=\"GetArtilceDetail?article_id="+data[i].article_id+"\"><h3><font>"
								+data[i].article_title
								+"</font></h3></a><p>Posted on "
								+timestampToTime(data[i].article_time)
								+" by Admin</p></div><div class=\"article_wall_detail\"><p class=\"detail-table-detail\">"
								+data[i].article_summary
								+"</p></div></div></div></li>";
						else{
							result+="<li class=\"col-md-12 article_li\"><input type=\"hidden\" value=\""+data[i].article_id+"\"><div class=\"article_wall\"><div class=\"col-md-5 article_wall_image\"><a href=\"GetArtilceDetail?article_id="+data[i].article_id+"\"><img class=\"article_img\" style=\"width: 100%\" alt=\""
								+data[i].article_title
								+"\" src=\""
								+data[i].article_image
								+"\"></a></div><div class=\"col-md-7\"><div class=\"article_wall_header\"><a href=\"GetArtilceDetail?article_id="+data[i].article_id+"\"><h3><font>"
								+data[i].article_title
								+"</font></h3></a><p>Posted on "
								+timestampToTime(data[i].article_time)
								+" by Admin</p></div><div class=\"article_wall_detail\"><p class=\"detail-table-detail\">"
								+data[i].article_summary
								+"</p></div></div></div>"
								+"<div><h1 class=\"blogpost-button-h1\"><a href=\"GetArtilceDetail?article_id="+data[i].article_id+"\"><span class=\"blogpost-button\">+</span></a></h1></div></li>";
						}
					}
					$('#main_display').append(result);
				}
				else{
					result+="<li class=\"col-md-12 article_li\" style=\"text-align:center;color:#FFF;\"><div class=\"article_wall\" style=\"background-color:#000;\"><div class=\"col-md-12\"><div class=\"article_wall_header\"><h3><a><font style=\"color:#FFF;\">"
						+"您已达到网络的尽头！"
						+"</font></a></h3></div></div></div></li>";
					$('#main_display').append(result);
					data_result=false;
				}

			}
		});
	}
		




/*时间戳转换为时间*/
function timestampToTime(timestamp){
	//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var date = new Date(timestamp);
    Y = date.getFullYear() + '年';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '月';
    D = date.getDate() + '日';
    return Y+M+D;
}