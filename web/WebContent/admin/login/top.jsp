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
        #bgc_orange{
            background-color: darkorange;
            height: 80px;
            width: 100%;
        }

        #bgc_orange span{
            display:block;
            position: relative;
            top: 15px;
            text-align: center;
            font-size: 35px;
        }

        #bgc_black{
            background-color: black;
            height: 7px;
            width: 100%;
        }

        #theTimeInformation{
            background-color: #E2E2E2;
        }

        #theTimeInformation span{
            margin-left: 50px;
        }

        #theTimeInformation button{
            position: relative;
            float: right;
            width: 200px;
            text-align: left;
        }
    </style>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>
</head>


<body>
    <div id="bgc_orange">
        <span>网上书城后台管理系统</span>
    </div>

    <div id="bgc_black"></div>

    <div id="theTimeInformation">
        <span>2022年3月20日 星期日</span>
        <a href="index.jsp">
            <button>退出系统</button>
        </a>
    </div>



</body>
</html>
