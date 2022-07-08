<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/4/9
  Time: 23:08
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

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("a.deleteOrder").click(function () {
                return confirm("你确定要删除商品吗？");
            });
        });
    </script>

</head>


<body>


<div id="container" style="width:100%;height:100%;">

    <div id="header" style="background-color:#FFA500;">
        <%@include file="/WebContent/admin/login/top.jsp"%>
    </div>

    <div id="menu" style="background-color:#EEEEEE;float:left;width:15%;height:80%;">
        <%@include file="/WebContent/admin/login/left.jsp"%>
    </div>

    <div id="content" style="height:200px;width:85%;height:70%;float:left;">
        <%--<form id="Form1" name="Form1" method="post" action="findOrdersServlet?action=findAllOrders">--%>
        <form id="Form1" name="Form1" method="post" action="findOrdersServlet?action=findOrdersByCondition">
            <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>查 询 条 件</strong></td>
                </tr>

                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" border="0" width="100%">
                            <tr>
                                <td height="22" align="center" bgColor="#f5fafe">订单编号：</td>
                                <td bgColor="#ffffff">
                                    <input type="text" name="orderId" size="15" value="" id="id" />
                                </td>

                                <td height="22" align="center" bgColor="#f5fafe">收件人：</td>
                                <td>
                                    <input type="text" name="name" size="15" value="" id="addressee" />
                                </td>
                            </tr>

                            <tr>
                                <td width="100" height="22" align="center" bgColor="#f5fafe"></td>
                                <td bgColor="#ffffff"><font face="宋体" color="red"> &nbsp;</font></td>
                                <td align="right" bgColor="#ffffff"><br /> <br /></td>
                                <td align="right" bgColor="#ffffff">
                                    <%--先将这个查询定义为全部查询，后面再修改具体的查询条件--%>
                                    <button type="submit" id="search" name="search" value="查询">
                                        查询
                                    </button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" name="reset" value="重置" />
                                </td>
                            </tr>

                        </table>
                    </td>
                </tr>


                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>订 单 列 表</strong></TD>
                </tr>
                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr></tr>

                <tr>
                    <td align="center" bgColor="#f5fafe">
                        <table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
                               style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                            <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                <td align="center" width="24%">订单编号</td>
                                <td align="center" width="18%">收件人</td>
                                <td align="center" width="9%">地址</td>
                                <td align="center" width="9%">联系电话</td>
                                <td width="8%" align="center">总价</td>
                                <td width="8%" align="center">所属用户</td>
                                <td width="8%" align="center">订单状态</td>

                                <td width="8%" align="center">查看</td>
                                <td width="8%" align="center">删除</td>
                            </tr>

                            <!--  在这里循环输出所有商品 -->
                            <c:forEach items="${requestScope.orderList}" var="order">
<%--                             <c:forEach items="${requestScope.products}" var="product">--%>
                                <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">
                                        <div>${order.id}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
                                        <div>${order.receiverName}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                        <div>${order.receiverAddress}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                        <div>${order.receiverPhone}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <div>${order.money}</div>
                                    </td>

                                    <%--所属用户--%>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <div>${order.user.username}</div>
                                    </td>

                                    <%--订单状态--%>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <%--如果paystate为1，就显示已支付--%>
                                        <c:if test="${order.paystate == 1}">
                                            <div>已支付</div>
                                        </c:if>

                                        <%--如果paystate为0，就显示未支付--%>
                                        <c:if test="${order.paystate == 0}">
                                            <div>未支付</div>
                                        </c:if>
                                    </td>


                                    <!-- 查看 -->
                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                        <%--        根据当前订单编号，去搜索订单详情--%>
                                            <a href="findOrdersServlet?action=findAllOrderItems&id=${order.id}&name=${order.receiverName}&address=${order.receiverAddress}&phone=${order.receiverPhone}&money=${order.money}&user=${order.user.username}
                                                                                                    &time=${order.ordertime}">
                                                <%--<img src="images/icon1.png" border="0" style="CURSOR: hand">--%>
                                                <img src="images/productImg/SearchImg.png" border="0" style="CURSOR: hand">
                                        </a>
                                    </td>

                                    <!-- 删除 -->
                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                            <%--根据id删除商品，往servlet里传入参数--%>
                                        <%--<a class="deleteOrder" href="productServlet?action=deleteProduct&id=${product.id}">--%>
                                        <a class="deleteOrder" href="findOrdersServlet?action=deleteOrder&orderId=${order.id}&userId=${order.userId}">
                                            <img src="images/error.jpg" width="16" height="16" border="0" style="CURSOR: hand" id="delete">
                                        </a>
                                    </td>

                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </div>


    <div id="footer" style="height:15%;  " >
        <%@include file="/WebContent/admin/login/bottom.jsp"%>
    </div>

</div>

</body>
</html>
