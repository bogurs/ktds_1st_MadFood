<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl을 사용해주겠다는 의미(c라는 이름으로 사용하겠다) -->
 
<!DOCTYPE html>
<html>
<head>
    <title>JQuery Stack Slideshow</title>
    <script type="text/javascript" src="scripts/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        var cwidth = parseInt($("#container").css("width").replace("px", ""));
        var img_count = $("#img_container").children().length;
        var img_width = $("#img1").width();
        var divider = cwidth / img_count;
        var small_space = (cwidth - img_width) / (img_count - 1);

        // set position
        var cssleft = Array();
        $("#img_container img").each(function(index) {
            cssleft[index] = new Array();
            // set default position
            cssleft[index][0] = (index * divider) - (index * img_width);
            $(this).css("left", cssleft[index][0] + "px");

            // set left position
            cssleft[index][1] = (index * small_space) - (index * img_width);

            // set right position
            var index2 = index;
            if (index2 == 0) {
                index2++;
            }
            cssleft[index][2] = cssleft[index2 - 1][1];
        });

        // image hover 
        $("#img_container img").mouseenter(function() {
            var img_id = parseInt($(this).attr("id").replace("img", "")) - 1;

            if ($(this).attr("id") != "img1") {
                $(this).animate({ 
                    left: cssleft[img_id][1] 
                }, 300);
            }                
            loopNext(this);
            loopPrev(this);
        });

        // image container hover out back to default position
        $("#img_container").mouseleave(function() {
            $("#img_container img").each(function(index) {
                $(this).animate({
                    left: cssleft[index][0]
                }, 300);
            });
        });

        function loopPrev(el) {
            if ($(el).prev().is("img")) {
                var imgprev_id = parseInt($(el).attr("id").replace("img", ""));

                if ($(el).prev().attr("id") != "img1") {
                    $(el).prev().animate({
                        left: cssleft[imgprev_id - 2][1]
                    }, 300);
                }
                loopPrev($(el).prev());
            }
        }

        function loopNext(el) {
            if ($(el).next().is("img")) {
                var imgnext_id = parseInt($(el).attr("id").replace("img", ""));

                $(el).next().animate({
                    left: cssleft[imgnext_id][2]
                }, 300);
                loopNext($(el).next());
            }
        }
    });
    </script>
    <style type="text/css">
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, "Free Sans";        
    }
    #main {
        background: #0099cc;
        margin-top: 0;
        padding: 2px 0 4px 0;
        text-align: center;
    }
    #main a {
        color: #ffffff;
        text-decoration: none;
        font-size: 12px;
        font-weight: bold;
        font-family: Arial;
    }
    #main a:hover {
        text-decoration: underline;
    }
    #container {
    	position: absolute;
        margin: 0 auto;
        margin-top: 250px;
        left: 500px;
        width: 800px;
        height: 340px;
        overflow: hidden;
        border: 10px solid #000;
        -webkit-border-radius: .5em;
        -moz-border-radius: .5em;
        border-radius: .5em;
    }
    #img_container {
        width: 4000px;
    }
    #img_container img {
        position: relative;
        -moz-box-shadow: -5px 0 10px #000;
        -webkit-box-shadow: -5px 0 10px #000;
        box-shadow: -5px 0 10px #000;
        width: 600px;
    }
    #img1 { z-index: 0; }
    #img2 { z-index: 1; }
    #img3 { z-index: 2; }
    #img4 { z-index: 3; }
    #img5 { z-index: 4; }
    html {
		padding:0px;
		margin:0px;
	}
</style>
</head>

<body>

<div id="container">	
    <div id="img_container">
        <img id="img1" src="resources/01.jpg"/>
        <img id="img2" src="resources/02.jpg"/>
        <img id="img3" src="resources/03.jpg"/>
        <img id="img4" src="resources/04.jpg"/>
        <img id="img5" src="resources/05.jpg"/>
    </div>
</div>
</body>
</html>
 