/**
 * Created by Nikos on 5/6/2017.
 */
$(document).ready(function(){
    $("button#all-btn").click(function(){
        eventClass = $(".list-quotes a").attr("class");
        $("a.list-quotes#all").toggleClass("hidden");
        $("a.list-quotes#past").toggleClass("hidden");
        $("a.list-quotes#upcoming").toggleClass("hidden");
    });
    $("button#past-btn").click(function(){
        eventClass = $(".list-quotes a").attr("class");
        $("a.list-quotes#past").toggleClass("hidden");
        $("a.list-quotes#all").toggleClass("hidden");
        $("a.list-quotes#upcoming").toggleClass("hidden");
    });
});