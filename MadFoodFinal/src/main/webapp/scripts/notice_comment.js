$(document).ready(function(){
	$('#comm_show').click(function(){
		$.ajax({
			type : "POST",
			url:"/food/commentRead.notice",
			async : true,
			dataType : "json",
			data:{
				article_num:$('#article_num').val()
			},
			success : function(data){
				//json으로 넘어오므로 파싱이 필요없음 data=JSON.parse(data);
				var html = '<table border="1">';
				$.each(data.commentList, function(entryIndex, entry){
					//data.commentList의 키 값을 불러야 그 해당 값을 불러올 수 있다
					var fommated_date= new Date(entry.comment_date);
					//시간을 제대로 출력하기 위한 메서드(직접 바꾸는 방법)
					html += '<tr>';
					html += '<td>' + entry.comment_num + '</td>';
					html += '<td>' + entry.id + '</td>';
					html += '<td>' + entry.comment_content + '</td>';
					html += '<td>' + fommated_date.toLocaleDateString() + '</td>';
					html += '<td> <input type="button" value="댓글삭제"> </td>';
					html += '</tr>';
				});
				html += '</table>';
				$("#show_comment").html(html);
			},
			error : function(xhr){
				alert("error html = " + xhr.statusText);
			}
		});
	});
	
	$('#comm_write').click(function(){
		$.ajax({
			type : "POST",
			url : "/food/commentWrite.notice",
			async : true,
			dataType : "json",
			data:{
				article_num:$('#article_num').val(),
				comment_content:$("#comment_content").val()
			},
			success : function(data){
				//json으로 넘어오므로 파싱이 필요없음 data=JSON.parse(data);
				var html = '<table border="1">';
				$.each(data.commentWrite, function(entryIndex, entry){
					var fommated_date= new Date(entry.comment_date);
					html += '<tr>';
					html += '<td>' + entry.comment_num + '</td>';
					html += '<td>' + entry.id + '</td>';
					html += '<td>' + entry.comment_content + '</td>';
					html += '<td>' + fommated_date.toLocaleDateString() + '</td>';
					html += '<td> <input type="button" value="댓글삭제" id="comm_delete"> </td>';
					html += '</tr>';
				});
				html += '</table>';
				$("#show_comment").html(html);
				$("#comment_content").text("");
			},
			error : function(xhr){
				alert("error html = " + xhr.statusText);
			}
		});
	});
	
});
	
