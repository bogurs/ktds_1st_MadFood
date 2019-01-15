 
function change(){  
   $.ajax({
         url:'branchintroduce.etc', 
         data:{            
            selectedOptionNum : document.getElementById('branch').selectedIndex
         },
         success: function (data) {  
           $("#c").html(data);
   
    },  
    error: function (xhr, errorThrown) {  
        alert("error " + errorThrown + xhr.statusText);  
    }  
});       
}