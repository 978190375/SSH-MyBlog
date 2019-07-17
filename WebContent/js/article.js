/**
 * 
 */
$('document').ready(function(){
	$('.nickname').each(function(){
		var nickname=$(this).html();
		var first=nickname.substring(0,1);
		$(this).siblings("div").html(first);
	})
	$('.comments_list_right_bottom').each(function(){
		var time=timestampToTime(parseInt($(this).children("span").html()));
		//alert(time);
		$(this).html(time);
	})
	
	/*点赞*/
	$('#star').on('click',function(){
		var article_id=$(this).parent().parent().siblings("input").val();
		if($('#star').hasClass('red'))
		{	
			//parseInt(_String str) 将字符串转换为int
			$('#star_data').html(parseInt($('#star_data').text())-1);
			$('#star').removeClass('red');
			$.ajax({
				url : "deStar?article_id="+article_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					
				}
			});
		}
		else{
			$('#star_data').html(parseInt($('#star_data').text())+1);
			$('#star').addClass('red');
			$.ajax({
				url : "addStar?article_id="+article_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					
				}
			});
		}
	});
	
	/*评论提交*/
	$('#comment_button').on('click',function(){
		var article_id=$(this).parent().siblings().children("input").val();
		var nickname=$('#nickname').val();
		var comment_textarea=$('#comment_textarea').val();
		if(nickname==null||comment_textarea==null||nickname==""||comment_textarea=="")
			alert("请检查输入结果");
		else{
			$.ajax({
				url : "addComment?nickname="+nickname+"&comment="+comment_textarea+"&article_id="+article_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					var result = "";
					if (data[0].result != "error") {
						alert("评论成功！待管理员审核通过后显示！");
						$('#nickname').val("");
						$('#comment_textarea').val("");
					}
					else{
						alert("评论失败，请重新提交！");
					}
				}
			});
		}
	});
	/*评论点赞*/
	$('body').on('click','.right_span_star',function(){
		var comment_id=$(this).siblings("input").val();
		if($(this).hasClass('red')) //点过赞 再点取消
		{
			$(this).children(".comment_star_num").html(parseInt($(this).children(".comment_star_num").text())-1);
			$(this).removeClass('red');
			$.ajax({
				url : "commentDeleteStar?comment_id="+comment_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					
				}
			});
			
		}
		else{  //未点赞 
			$(this).children(".comment_star_num").html(parseInt($(this).children(".comment_star_num").text())+1);
			$(this).addClass('red');
			$.ajax({
				url : "commentAddStar?comment_id="+comment_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					
				}
			});
		}
	});
	/*评论点踩*/
	$('body').on('click','.right_span_diss',function(){
		var comment_id=$(this).siblings("input").val();
		if($(this).hasClass('red'))
		{
			$(this).children(".comment_diss_num").html(parseInt($(this).children(".comment_diss_num").text())-1);
			$(this).removeClass('red');
			$.ajax({
				url : "commentDeleteDiss?comment_id="+comment_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					
				}
			});
		}
		else{
			$(this).children(".comment_diss_num").html(parseInt($(this).children(".comment_diss_num").text())+1);
			$(this).addClass('red');
			$.ajax({
				url : "commentAddDiss?comment_id="+comment_id,
				type : 'GET',
				dataType : 'json',
				success : function(data) {
					
				}
			});
		}
	});
});
/*时间戳转换为时间*/
function timestampToTime(timestamp){
	//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    var date = new Date(timestamp);
    Y = date.getFullYear() + '年';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '月';
    D = date.getDate() + '日';
    return Y+M+D;
}