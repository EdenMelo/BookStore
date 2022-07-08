<%@ page import="java.util.LinkedList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/27
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        .separateTable {
            border: gray 1px solid;
            background-color: #E1FFE1;
            margin: auto;
            text-align: center;
        }

        #cart_div{
            margin-top: 50px;
            border: gray 1px solid;
            width: 1500px;
            /*height: 250px;*/
            height: 500px;
            margin: auto;
            background-color: #FCFDEF;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="css/registCSS.css">
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <%--    <script type="text/javascript" src="js/form.js"></script>--%>

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("a.deleteProduct").click(function () {
                return confirm("你确定要删除商品吗？");
            });

            //如果当前用户未登录，那么submitOrder无效
            $("#submitOrder").click(function () {
                if(${applicationScope.loginUser == null}){
                    alert("请先登录！");
                    return false;
                }
                //使用标记判断当前购物车是否为空
                <%--if(${requestScope.flag != null}){--%>
                if(${sessionScope.flag != null}){
                    alert("请添加商品！");
                    return false;
                }
                return confirm("你确定要提交订单吗？");
            });
        });
    </script>

</head>
<body>

<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>

<br>
<div style="float:right;">
    <%--WebContent/client/index.jsp--%>
    <a href="WebContent/client/index.jsp" style="text-decoration: none;">
        首页
    </a> > 购物车
</div>
<br>


<form action="cartServlet?action=submitCartItems" method="post">
<%--<form action="cartServlet?action=simulationPay" method="post">--%>
<%--<form action="WebContent/client/Pay.jsp" method="post">--%>
<div id="cart_div">
    <table width="80%" border="0" cellspacing="0" class="separateTable" style="margin-top: 35px; ">
        <tr>
            <td width="12%">序号</td>
            <td width="12%">商品名称</td>
            <td width="12%">价格</td>
            <td width="12%">库存</td>
            <td width="12%">数量</td>
            <td style="position: relative;left: 55px;">删除</td>
        </tr>
    </table>

    <%--中间隔了两行--%>
    <table width="80%" border="0" cellspacing="0" style="margin: auto; text-align: center;">
        <%--使用varStatus获取当前遍历对象的状态--%>
        <c:forEach items="${requestScope.productMap}" var="map" varStatus="i">
                <tr>
                    <%--在这里要输出序号,使用varStatus获取对象状态，再获取index判断当前对象的下标即可--%>
                    <td width="12%" >
                        <%--index--%>
                        ${(i.index)+1}
                    </td>

                    <td width="12%" >
<%--                        ${product.name}--%>
                        ${map.key.name}
                    </td>

                    <td width="12%" >
<%--                        ${product.price}--%>
                        ${map.key.price}
                    </td>

                    <td width="12%" >
<%--                        ${product.pnum}--%>
                        ${map.key.pnum}
                    </td>

                    <td width="12%" >
                        <%--数量--%>
                        ${map.value}
                    </td>

                    <td style="position: relative;left: 50px;">
                        <%--<a href="WebContent/client/DeleteCart.jsp?no=${(i.index)+1}">--%>
                        <a class="deleteProduct" href="cartServlet?action=deleteCartItem&id=${map.key.id}">
                            <button type="button" style="color: #FF0000; font-weight: bold">
                                删除图书
                            </button>
                        </a>
                    </td>

                </tr>
<%--            </c:if>--%>
        </c:forEach>
    </table>



    <table width="80%" border="0" cellspacing="0" class="separateTable">
        <tr>
            <td colspan="0" style="float: right; margin-right: 50px; color: #FF9900; font-weight: bold;">
                合计：${requestScope.sum}元
            </td>
        </tr>
    </table>

    <br>
    <br>


    <table width="80%" border="0" cellspacing="0" class="separateTable">
        <tr>
            <td colspan="0" style="font-size: 20px; float: left; margin-right: 50px; color: #FF9900; font-weight: bold;">
                <%--收货人：<input type="text" id="receiverName" name="receiverName" value="${applicationScope.loginUser.name}">--%>
                收货人：<input style="font-size: 20px; width: 300px;" type="text" id="receiverName" name="receiverName" value="${applicationScope.username}">
            </td>
        </tr>
        <tr>
            <td colspan="0" style="font-size: 20px; float: left; margin-right: 50px; color: #FF9900; font-weight: bold;">
                <%--收货地址：<input type="text" id="receiverAddress" name="receiverAddress" value="${applicationScope.userAddress}">--%>
                收货地址：<input style="font-size: 20px; width: 300px;" type="text" id="receiverAddress" name="receiverAddress" value="${applicationScope.userAddress}">
            </td>
        </tr>
        <tr>
            <td colspan="0" style="font-size: 20px; float: left; margin-right: 50px; color: #FF9900; font-weight: bold;">
                <%--联系电话：<input type="text" id="receiverPhone" name="receiverPhone" value="${applicationScope.loginUser.phone}">--%>
                联系电话：<input style="font-size: 20px; width: 300px;" type="text" id="receiverPhone" name="receiverPhone" value="${applicationScope.loginUser.telephone}">
            </td>
        </tr>
    </table>

        <br/>
        <br/>

        <div>
            <%--<a href="cartServlet?action=submitCartItems">--%>
                <button id="submitOrder" type="submit" style="float:right;position: relative;right: 150px;">
                    提交订单
                </button>
            <%--</a>--%>
        </div>
</div>
</form>







<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>
</body>
</html>
