function menu_add(dish_num){
	alert("asdsafasf");
	$.ajax({
		type : "POST",
		url : "menu_aside.menu",
		dataType : "json",
		data : {
			dish_num : dish_num
		},
		success : function(data) {
			
					var entry=data.article;
					var html = '<table border="1">';
				     html += '<input type="hidden" id="dish_num" value="'+entry.dish_num+'"/>';   
					 html += '<tr>';
					 html += '<td>' + entry.title + '</td>';
					 html += '</tr>';
					 html += '<tr>';
				     html += '<td>' + entry.menu.price +'</td>';
// 					 html +='<td>'+'<img src ="download.menu?fname='+entry.pic_name+' " onclick="popup()" style="cursor:pointer"/>'+ '</td>'; -->
					 html += '</tr>';
				     html += '<tr>';
					 html += '<td>' + entry.menu_content + '</td>';
					 html += '</tr>';
					 html += '</table>';
					 html +=$("#showcomment").html();
					 $("#history").append(html); 
		}, error : function(xhr) {
			alert("error " + xhr.statusText);
		}
});
}


function change(num){
	 var x=$("#count").val();
	 var cnt =Number(x)+num;
	 if(cnt<1) cnt=1;
	 $("#count").val(cnt);
	 }


// function cha
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//function overlay(dish_num) {
//	$.ajax({
//				type : "POST",
//				url : "getInform.menu",
//				dataType : "json",
//				data : {
//					dish_num : dish_num
//				},
//				success : function(data) {
//							popup();
//							 var html = '<table border="0">';
//						     html += '<input type="hidden" id="dish_num" value="'+entry.dish_num+'"/>';   
//							 html += '<tr>';
//							 html += '<td>' + entry.title + '</td>';
//							 html += '</tr>';
//							 html += '<tr>';
//							 html +='<td>'+'<img src ="download.menu?fname='+entry.pic_name+' " onclick="popup()" style="cursor:pointer"/>'+ '</td>';
//							 html += '</tr>';
//						     html += '<tr>';
//							 html += '<td>' + entry.menu_content + '</td>';
//							 html += '</tr>';
//							 html += '</table>';
//							 html +=$("#showcomment").html();
//							 $("#popup").html(html); 
//							$("#popup").load(data);
//				}, error : function(xhr) {
//					alert("error " + xhr.statusText);
//				}
//	});
//}	
 
//function popup() {	
//	var el = document.getElementById("popup");
//	var ol = document.getElementById("overlay");
//	var w = window.getComputedStyle(el, null).getPropertyValue('width').replace("px", "");
//	var h = window.getComputedStyle(el, null).getPropertyValue('height').replace("px", "");
//	el.style.marginTop = (-h / 2) + "px";
//	el.style.marginLeft = (-w / 2) + "px";
//	el.style.visibility = (el.style.visibility === "visible") ? "hidden": "visible";
//	ol.style.visibility = (ol.style.visibility === "visible") ? "hidden": "visible";
//}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//



	
	