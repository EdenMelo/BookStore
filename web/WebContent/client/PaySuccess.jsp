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
    <script type="text/javascript" src="js/form.js"></script>

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
            bottom: 100px;
            font-size: 90px;
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
            订单支付成功！
        </td>
    </tr>

    <tr>
        <td></td>
    </tr>



    <tr>
        <td style="text-align: center;font-size: 50px;position: relative; bottom: 100px;">
            感谢您的购买，请点击下方按钮返回首页。
        </td>
    </tr>

    <tr>
        <td style="text-align: center;font-size: 30px;position: relative; bottom: 100px;">
            <a href="">
                返回首页
            </a>
        </td>
    </tr>

</table>


<%--</form>--%>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
