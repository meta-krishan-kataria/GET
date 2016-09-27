$(document).ready(function(){

    $("#btn-start").click(function(){
        $("#target").stop();
        $("#target").animate({
            left: '+=50%'
            
        }, 2000);
    });
    $("#btn-stop").click(function(){
        $("#target").stop();
    });
    $("#btn-back").click(function(){
        $("#target").stop();
        $("#target").animate({
            left: '-=25%'
            
        }, 2000);
    });

    $("#btn-up").click(function(){
        $("#target").animate({
            top: '-=50px'
        }, 100);
    });
    $("#btn-down").click(function(){
        $("#target").animate({
            top: '+=50px'
        }, 100);
    });    
   $("#btn-right").click(function(){
        $("#target").animate({
            left: '+=50px'
        }, 100);
    });    
    $("#btn-left").click(function(){
        $("#target").animate({
            left: '-=50px'
        }, 100);
    });    
});