<input id="currentWeight" value=""/>
<script>
    //websocket实现
    var websocket;
    var socketUrl = "ws://127.0.0.1:8000/websocket";
    var count = 0;
    if ('WebSocket' in window) {
        // console.log("此浏览器支持websocket");
        websocket = new WebSocket(socketUrl);
    } else if ('MozWebSocket' in window) {
        alert("此浏览器只支持MozWebSocket");
    } else {
        alert("此浏览器只支持SockJS");
    }
    websocket.onopen = function (evnt) {
        // $("#tou").html("链接服务器成功!");
        console.log("链接服务器成功");
    };
    websocket.onmessage = function (evnt) {
        // console.log("event", evnt.data);
        $("#currentWeight").val(evnt.data);
    };
    websocket.onerror = function (evnt) {
        console.log("消息异常：" + evnt.data);
    };
    websocket.onclose = function (evnt) {
        console.log("与服务器断开了链接");
    } 
</script>
