<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>

<script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

<script>





    var goEasy = new GoEasy({
        appkey: "BC-1ce8777b150545a5b0cdbf26504aca53",
        onConnected: function () {
            alert("成功连接GoEasy。");
        },
        onDisconnected: function () {
            alert("与GoEasy连接断开。"); },
        onConnectFailed: function(error) {
            alert("与GoEasy连接失败，错误编码："+error.code+"错误信息："+error.content);
        }
    });
       //var goEasy = new GoEasy({appkey: "BC-1ce8777b150545a5b0cdbf26504aca53"});


        goEasy.subscribe({
            channel: "yhzchannel",
            onMessage: function (message) {
                alert("Channel:"+ " content:" + message);
                console.log(message);
            }
        })
    </script>

