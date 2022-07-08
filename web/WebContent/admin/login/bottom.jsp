<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/17
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #bgc_green{
            background-color: #B4D86E;
            height: 80px;
            /*width: 85%;*/
            width: 100%;
            /*float: left;*/
            /*设定绝对位置为页面顶部*/
            position: absolute;
            bottom: 0;
        }

        #bgc_green span{
            position: relative;
            top: 10px;
        /*让span形成块(独占一行)，就像div一样，再设置内容居中css text-align:center*/
            display:block;
            text-align: center;
        }
    </style>
</head>

<body>
    <div id="bgc_green">
        <span>
            网上书城后台管理系统
        </span>
    </div>
</body>
</html>
