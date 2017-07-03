$( document ).ready(function() {   
    $("#all-btn").click(function() { 
        $('.list-quotes.coming').show(500);
        $('.list-quotes.past').show(500);
    });
    $("#coming-btn").click(function(){
        $('.list-quotes.coming').show(500);
        $('.list-quotes.past').hide(500);
    });
    $("#past-btn").click(function(){
        $('.list-quotes.coming').hide(500);
        $('.list-quotes.past').show(500);
    });
});