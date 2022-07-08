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
            bottom: 100px;
            font-size: 50px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("#isPay").click(function () {
                return confirm("确认已经支付成功了吗？");
            });

            //如果当前用户未登录，那么submitOrder无效
            $("#noPay").click(function () {
                return confirm("确定不进行支付吗？");
            });
        });
    </script>



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
            支付页面
        </td>
    </tr>

    <tr>
        <td style="text-align: center;font-size: 50px;position: relative; bottom: 100px;">
            <img src="WebContent/client/images/mine/p.jpg" style="width: 220px;height: 220px;" />

            <div>
                <a href="cartServlet?action=simulationPay&pay=1&orderId=${param.orderId}" style="text-decoration: none" id="isPay">
                    已支付
                </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <a href="" style="text-decoration: none" id="noPay">
                    未支付
                </a>
            </div>
        </td>
    </tr>


</table>


<%--</form>--%>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
