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

    <%--    <link rel="stylesheet" type="text/css" href="css/registCSS.css">--%>
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <script type="text/javascript" src="js/form.js"></script>

    <style>
        #productTable{
            border: 1px solid gray;
            background-color: #FCFDEF;
            width: 1500px;
            /*height: 570px;*/
            height: 400px;
            margin-left: 200px;
            background-clip: padding-box;
        }

        .tableWord td {
            /*height: 30px;*/
            /*设置单元格文字靠下*/
            vertical-align:bottom;
            position: relative;
            left: 40px;
            font-size: 20px;
        }

        div label{
            font-size: 25px;
        }

        div input{
            font-size: 25px;
        }
    </style>

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#update").click(function () {
                return confirm("你确定要修改个人信息吗？");
            });

            $(".cancelOrder").click(function () {
                return confirm("你确定要取消订单吗？");
            });

            $("#iconSubmit").click(function () {
                return confirm("你确定要上传头像吗？");
            });
        });
    </script>


</head>
<body>

<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>


<div style="background-color: #FCFDEF; width: 1500px; height: 400px;margin-left: 200px;border: 1px solid gray;">
    <div class="card-block">
        <h4 class="card-title" id="username22" style="font-weight: bold;color: blue;font-size: 30px; "></h4>
        <div class="table-responsive">

            <%--上传头像--%>
            <form action="userServlet?action=uploadUserIcon" method="post" enctype="multipart/form-data">
                <input type="file" name="icon" style="position: absolute; left: 233px; bottom: 440px; font-size: 17px;" />
                <button id="iconSubmit" type="submit" style="position: absolute; left: 233px; bottom: 400px; font-size: 17px;">上传头像</button>
            </form>

            <form action="userServlet?action=modifyPersonalInfo" method="post">
                <%--<img src="WebContent/admin/login/cheems.jpg" style="width: 120px;height: 120px; position: absolute; border: solid; left: 266px; bottom: 500px;" />--%>
                <img src="${applicationScope.userIcon.userIconUrl}" style="width: 120px;height: 120px; position: absolute; border: solid; left: 266px; bottom: 500px;" />

                <input type="hidden" name="userId" id="userId" value="${applicationScope.loginUser.id}"/>
                <%--readonly是只读不可修改--%>
                <%--<label style="margin-left: 180px;" >用户名：</label> <input  type="text" name="username" id="username" readonly value="${applicationScope.username}"/>--%>
                <label style="margin-left: 250px;" >用户名：</label> <input  type="text" name="username" id="username"  value="${applicationScope.username}"/>
                <label style="margin-left: 250px;"> 密码：</label> <input type="password" name="password" id="password"   value="${applicationScope.loginUser.password}"/><br><br>
                <label style="margin-left: 250px;"> 性别：</label> <input type="text" name="gender" id="gender"   value="${applicationScope.loginUser.gender}"/>
                <label style="margin-left: 250px;">邮箱：</label>  <input type="text" name="email" id="email"  value="${applicationScope.loginUser.email}"/><br /><br>
                <label style="margin-left: 250px;">电话：</label>  <input type="text" name="phone" id="phone" reado value="${applicationScope.loginUser.telephone}"/><br /><br>
                <label style="margin-left: 250px;">收货地址：</label> <input size="50" name="address" type="text" id="address" value="${applicationScope.userAddress}"/><br /><br>
                <%--<label style="margin-left: 180px;">收货地址：</label> <input size="50" name="address" type="text" id="address" value="${applicationScope.userAddress}"/><br /><br>--%>
                <button id="update" style="margin-left: 700px;font-size: 25px;" >修改</button>
            </form>
            <hr />

            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>订 单 列 表</strong></TD>
                </tr>
                <tr>
                    <td align="center" bgColor="#f5fafe">
                        <table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
                               style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                            <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                <td align="center" width="24%">订单编号</td>
                                <td align="center" width="5%">订单金额</td>
                                <td align="center" width="9%">收货地址</td>
                                <td align="center" width="9%">收货人</td>
                                <td width="8%" align="center">收获联系方式</td>
                                <td width="8%" align="center">支付状态</td>
                                <td width="8%" align="center">订单创建时间</td>
                                <td width="8%" align="center">订单状态</td>
                                <td width="8%" align="center">查看订单详情</td>
                            </tr>

                            <!--  在这里循环输出所有订单信息 -->
<%--                            <c:forEach items="${sessionScope.products}" var="product">--%>
                            <c:forEach items="${applicationScope.orderListByUserId}" var="order">
                                <%--                            <c:forEach items="${requestScope.products}" var="product">--%>
                                <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">
                                        <div>${order.id}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="1%">
                                        <div>${order.money}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">
                                        <div>${order.receiverAddress}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                        <div>${order.receiverName}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <div>${order.receiverPhone}</div>
                                    </td>

                                    <%--订单状态--%>
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                            <%--如果paystate为1，就显示已支付--%>
                                        <c:if test="${order.paystate == 1}">
                                            <div>已支付</div>
                                        </c:if>

                                            <%--如果paystate为0，就显示未支付--%>
                                        <c:if test="${order.paystate == 0}">
                                            <div>
                                                <%--跳转去支付页面--%>
                                                <a href="WebContent/client/Pay.jsp?orderId=${order.id}">
                                                    <span style="font-size: 20px;font-weight: bold;">未支付</span>
                                                </a>
                                            </div>
                                        </c:if>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <div>${order.ordertime}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <c:if test="${order.paystate == 0}">
                                            <div>
                                                <a class="cancelOrder" href="userServlet?action=cancelOrder&orderId=${order.id}">
                                                    <span style="font-size: 20px;font-weight: bold;">取消订单</span>
                                                </a>
                                            </div>
                                        </c:if>

                                        <c:if test="${order.paystate == 1}">
                                            <div>
                                                订单完成
                                            </div>
                                        </c:if>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <div>
                                            <a href="findOrdersServlet?action=findAllOrderItemsByAccount&id=${order.id}&name=${order.receiverName}&address=${order.receiverAddress}&phone=${order.receiverPhone}&money=${order.money}
                                                    &user=${applicationScope.username}&time=${order.ordertime}">
                                                <img src="images/productImg/SearchImg.png" border="0" style="CURSOR: hand">
                                            </a>
                                        </div>
                                    </td>

                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>



<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
