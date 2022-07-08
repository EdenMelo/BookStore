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
<%--    <!--写base标签，永远固定相对路径跳转的结果-->--%>
<%--    <jsp:include page="/common/basePath.jsp"></jsp:include>--%>

    <title>Title</title>
    <style>
        #word{
            background-image: url("../../../images/stripe.png");
            /*background-image: url("/images/stripe.png");*/
            height: 150px;
            width: 100%;
            text-align: center;
        }

        #word span{
            position: relative;
            top: 40px;
            color: darkcyan;
        }

        #homepage{
            background-color: darkorange;
            font-weight:bold;
            font-size: 20px;
            margin-top: 1px;
            margin-left:1px;
            text-align: center;
        }
    </style>
</head>
<body>

    <%--系统首页条--%>
    <div id="homepage">
        <span>系统首页条</span>
    </div>

    <div id="word">
        <span>登陆成功</span>
    </div>
</body>
</html>
