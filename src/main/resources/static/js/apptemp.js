var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function sendName() {

    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'eid' : $("#event_id").val(), 'usern' : $("#user_id").val()}));

}

function showGreeting(message) {
    var date = new Date(message.date);

    $("#greetings").append("<div class='row row-eq-height comment'>\
                                <div class='col-xs-2  outsite'>\
                                    <div class='pic col-xs-offset-1'>\
                                        <img src='http://via.placeholder.com/50x50'/>\
                                    </div>\
                                </div>\
                                <div class='col-xs-10 text'>\
                                    <div class='row'>\
                                        <div class='col-xs-6'>\
                                            <div class='name'>" + message.username +"</div>\
                                        </div>\
                                        <div class='col-xs-6'>\
                                            <div class='date'>" + date + "</div>\
                                        </div>\
                                    </div>\
                                    <div class='desc-text'>\
                                    <p>\
                                        " + message.content + "\
                                    </p>\
                                </div>\
                            </div><br/>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendName(); });

    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
});