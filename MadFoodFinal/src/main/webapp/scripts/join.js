var passcheck=false;
var idcheck=false;
function NumObj(obj){
	if(event.keyCode<48 || event.keyCode>57) event.returnValue=false;
}


$(document).ready(function(){	
	$('*').keyup(function(){
	$.ajax({
		url:'',
		success : function(data){
	
		var a=($('#id').val() == "" || $('#pass').val() =="" || $('#phonenumber').val()==""
				|| $('#address').val()=="" || $('#name').val() =="" || !passcheck);

		if(a)
			{
			$('#song').attr('disabled',true);
			}
		else {
			$('#song').attr('disabled',false);
		}
		}
	});
});
});
$(document).ready(function(){
	$('#pass,#pass1').keyup(function(){
		$.ajax({
			url:'',
			success : function(data){
			  if($('#pass').val()==$('#pass1').val()){$("#show_pass1").html("Ok!"); passcheck=true;}
			  else {$("#show_pass1").html("비번 다르다 다시해라!"); passcheck=false;}
			}
		});
	});	
});


$(document).ready(function(){	
	$('#searchmember').click(function(){
		$.ajax({
				type:'POST',
				url:'searchId.etc',
				data: {
					   id:$('#id').val()		
				},
					success : function(data){
					
						if(data.status==1){	
						alert("존재하는 아이디 입니다!");
						$('#id').val("");
						}
						else if(data.status==0){ alert("사용가능 아이디 입니다!");
						idcheck=true;}
						else{
							alert("코드에러여");
							}
					},
					error : function(xhr) {
						alert("error html = " + xhr.statusText);
					}			
		});
	});
});


$(document).ready(function(){	
	$('#name,#address,#pass,#pass1,#phonenumber,#song').keydown(function(){
	if(idcheck==false) alert("아이디체크 해주세요!!");
	});
});