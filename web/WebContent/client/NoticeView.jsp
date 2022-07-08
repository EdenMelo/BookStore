<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/4
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>

    <title>Title</title>

    <%--    <link rel="stylesheet" type="text/css" href="css/registCSS.css">--%>
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <style>
        #productTable{
            border: 1px solid gray;
            background-color: #FCFDEF;
            width: 1500px;
            height: 570px;
            margin-left: 200px;
            background-clip: padding-box;
        }

        .tableWord td {
            text-align: center;
            /*position: relative;*/
            /*bottom: 100px;*/
            font-size: 50px;
        }
    </style>


</head>
<body>

<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>


<%--<form>--%>
<table id="productTable">
    <tr class="tableWord">
        <td>
            ${requestScope.notice.noticeTitle}
            <input style="font-size: 35px; position: relative;text-align: right;left: 30%;" type="button" onclick="history.go(-1)" value="返回首页" />
        </td>
    </tr>
    <tr>
        <td style="font-size: 30px;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            ${requestScope.notice.noticeDetails}
        </td>
    </tr>
    <tr>
        <td style="text-align: right;font-size: 30px;">
            ${requestScope.notice.noticeTime}
        </td>
    </tr>
    <tr></tr>
    <tr></tr>
</table>


<%--</form>--%>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
