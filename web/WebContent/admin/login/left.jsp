<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/17
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <style>
        #list tr td{
            /*设置padding自动在表格中对齐*/
            padding: 25px;
            font-size: 20px;
            text-align: center;
            width: 15%;
        }
    </style>

    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"/>
</head>
<body>

    <table id="list">
        <tr>
            <td>
                <a href="WebContent/admin/products/list.jsp" style="text-decoration: none">商品管理</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="WebContent/admin/products/download.jsp" style="text-decoration: none">销售榜单</a>
            </td>
        </tr>
        <tr>
            <td>
                <%--<a href="WebContent/admin/products/orderList.jsp" style="text-decoration: none">订单管理</a>--%>
                <a href="findOrdersServlet?action=findAllOrders" style="text-decoration: none">订单管理</a>
                <%--订单管理--%>
            </td>
        </tr>
        <tr>
            <td>
                <%--<a href="WebContent/admin/notice/noticeList.jsp" style="text-decoration: none">公告管理</a>--%>
                <a href="noticeServlet?action=showAllNotice" style="text-decoration: none">公告管理</a>
            <%--公告管理--%>
            </td>
        </tr>
    </table>
</body>
</html>
