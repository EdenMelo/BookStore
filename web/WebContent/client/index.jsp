<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/4
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL导包--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>


    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <link rel="stylesheet" type="text/css" href="css/autoplay.css">

    <script type="text/javascript" src="js/autoplay.js">
    </script>

    <style>
        /*<div style="background-color: #FCFDEF; border: 1px solid gray; height: 150px; width: 900px; margin: 0px auto"  >*/
        #bulletinDiv{
            background-color: #FCFDEF;
            border: 1px solid gray;
            height: 230px;
            width: 900px;
            margin: 0px auto;
        }

        #bulletinText{
        /*<span style="float: left;  font-size: 15px; text-align: left; width: 500px" id="bulletinText">*/
            float: left;
            font-size: 15px;
            text-align: left;
            width: 500px
        }
    </style>

    <script type="text/javascript">
        window.onload=function () {
            function autoForward() {
                location.href = "noticeServlet?action=queryNewNotice";
            }
            //定义一个定时器，30分钟执行一次该方法
            setInterval(autoForward,1000*60*30);
        };
    </script>

</head>
<body>

<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>

    <div id="box_autoplay">
        <div class="list">
            <ul>
                <li> <img src="images/ad/index_ad1.jpg" width="900" height="335" /> </li>
                <li> <img src="images/ad/index_ad2.jpg" width="900" height="335" /> </li>
                <li> <img src="images/ad/index_ad3.jpg" width="900" height="335" /> </li>
            </ul>
        </div>
    </div>

    <div id="bulletinDiv" >
        <span>
            <img src="images/billboard.gif" width="500" style="float: left"/>
            <img src="images/hottitle.gif" style="float: left; position: relative; left: 40px; top: 5px"/>
        </span>

        <br>
        <br>

<%--        <c:forEach items="${requestScope.noticeList}" var="notice" varStatus="i">--%>
        <c:forEach items="${applicationScope.noticeList}" var="notice" varStatus="i">
            <span id="bulletinText" style="font-size: 20px;">
                <div style="height: 40px">
                    公告${i.index+1}：
                    <a style="text-decoration: none;" href="noticeServlet?action=viewNotice&id=${notice.noticeId}">
                       ${notice.noticeTitle}
                    </a>
                    ---<span style="color: darkorange">${notice.noticeTime}</span> <br>
                </div>
            </span>
        </c:forEach>

        <c:forEach items="${applicationScope.hotProductList}" var="hotProduct" varStatus="i">
            <span style="font-size: 20px;">
                <div style="height: 40px">
                    热卖商品${i.index+1}：${hotProduct.productName}
                    ---<span style="color: darkorange">${hotProduct.productSale}</span>本<br></div>
            </span>
        </c:forEach>

    </div>



    <%--br换行与下方显示隔开距离--%>
    <br>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
