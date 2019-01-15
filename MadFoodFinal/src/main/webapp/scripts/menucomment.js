
$(document).ready(function(){   
   $('#menu_write_comment').click(function(){
      $.ajax({
    	 type : "POST",
         url:"writeComment.menu",
         async : true,
         dataType : "json", 
         data:{            
         dish_num:$('#dish_num').val(),
         comment_content:$("#comment_content").val()
         },
         success : function(data) {      

            var html = '<table border="1">'; 
               $.each(data.commentList,function(entryIndex, entry){   
                var formatted_date=new Date(entry.comment_date);
                
                 html += '<tr>';
                  html += '<td>' + entry.id + '</td>';
                  html += '<td>' + entry.comment_content + '</td>';
                  html += '<td>' + formatted_date.toLocaleDateString() + '</td>';
//                  html += '<td>' + entry.comment_date + '</td>';
                     html += '</tr>';    
             });             
             html += '</table>';             
            $("#comment_show").html(html);
         },
         error : function(xhr) {
            alert("error html = " + xhr.statusText);
         }         
      });
   }); 
   $('#show_comment').click(function(){
	      $.ajax({
	         type : "POST",
	         url:"getComment.menu",
	         async : true,
	         dataType : "json", 
	         data:{            
	         dish_num:$('#dish_num').val(),
	         },
	         success : function(data) {      

	            var html = '<table border="1">'; 
	               $.each(data.commentList,function(entryIndex, entry){   
	                var formatted_date=new Date(entry.comment_date);
	                
	                 html += '<tr>';
	                  html += '<td>' + entry.id + '</td>';
	                  html += '<td>' + entry.comment_content + '</td>';
	                  html += '<td>' + formatted_date.toLocaleDateString() + '</td>';
//	                  html += '<td>' + entry.comment_date + '</td>';
	                     html += '</tr>';    
	             });             
	             html += '</table>';             
	            $("#comment_show").html(html);
	         },
	         error : function(xhr) {
	            alert("error html = " + xhr.statusText);
	         }         
	      });
	   });   
});   