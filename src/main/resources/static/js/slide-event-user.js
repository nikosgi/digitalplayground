$( document ).ready(function() {   
    $("#user-event-slide").change(function() { 
        $("#events").fadeToggle();
        $("#users").fadeToggle();
    });
});