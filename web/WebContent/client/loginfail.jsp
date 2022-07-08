<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/4/2
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">
<head>

    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>

    <meta charset="UTF-8">
    <title>网上书城</title>

    <link rel="stylesheet" type="text/css" href="css/registCSS.css">
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <script type="text/javascript" src="js/form.js"></script>


    <style>
        /*        .registSuccessWord{
                    text-align: left;
                    position: relative;
                    top: 220px;
                }*/

        #registSuccessDiv{
            /*margin-top: 200px;*/
            border: gray 1px solid;
            width: 1500px;
            height: 500px;
            margin: auto;
            position: relative;
            top: 10px;
            background-color: #FCFDEF;
        }

        #registSuccessDiv span{
            text-align: left;
            position: relative;
            top: 220px;
        }


    </style>

    <script type="text/javascript">
        window.onload=function () {
            var second = 2;
            //2.1定义一个方法，获取span标签，修改span标签体内容，时间...
            var time = document.getElementById("time");
            function showTime() {
                second --;
                //判断时间如果<=0，则跳转到指定页面
                if (second <= 0) {
                    //跳转到指定页面，并设置页面回显
                    location.href = "WebContent/client/login.jsp?username=${requestScope.username}";
                }
                //设置标签内的内容为随时边划的second
                time.innerHTML = second + "";
            }

            //2.2 定义一个定时器，1秒执行一次该方法
            setInterval(showTime,1000);
        };
    </script>

</head>


<body>
<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>

<div id="registSuccessDiv">
    <!--    1.显示页面效果-->
    <img src="images/IconTexto_WebDev_009.jpg" style="margin-top: 200px; float: left; margin-left: 50px;">
    <span style="color: red; font-weight: bold;">${requestScope.msg}</span> <br><br>
    <span style="color: cornflowerblue; font-weight: bold;" id="time" >2</span>
    <span style="color: cornflowerblue;">秒后自动为您跳转回登录页面</span>
</div>




<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>