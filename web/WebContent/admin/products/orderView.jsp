<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/18
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL导包--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="container" style="width:100%;height:100%;">

    <div id="header" style="
    background-color:#FFA500;">
        <%@include file="/WebContent/admin/login/top.jsp"%>
    </div>

    <div id="menu" style="background-color:#EEEEEE;float:left;width:15%;height:80%;">
        <%@include file="/WebContent/admin/login/left.jsp"%>
    </div>

    <div id="content" style="height:200px;width:85%;height:70%;float:left;">

        <div style="font-size: 30px">
            <table cellSpacing="1" cellPadding="5" width="100%" align="center"
                   bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3" colSpan="4" height="26">
                        <strong>
                            订单详细信息
                        </strong>
                    </td>
                </tr>

                <tr>
                    <td width="18%" align="center" bgColor="#f5fafe">订单编号：</td>

                    <td bgColor="#ffffff">
                       ${param.id}
                    </td>

                    <td align="center" bgColor="#f5fafe">所属用户：</td>
                    <td bgColor="#ffffff">
                        ${param.user}
                    </td>
                </tr>

                <tr>
                    <td align="center" bgColor="#f5fafe">收件人：</td>
                    <td bgColor="#ffffff">
                        ${param.name}
                    </td>

                    <td align="center" bgColor="#f5fafe">联系电话：</td>
                    <td bgColor="#ffffff">
                        ${param.phone}
                    </td>
                </tr>

                <tr>
                    <td align="center" bgColor="#f5fafe">送货地址：</td>
                    <td bgColor="#ffffff">
                        ${param.address}
                    </td>

                    <td align="center" bgColor="#f5fafe">总价：</td>
                    <td bgColor="#ffffff">
                        ${param.money}
                    </td>
                </tr>
                <tr>
                    <td align="center" bgColor="#f5fafe">下单时间：</td>
                    <td bgColor="#ffffff" colSpan="3">
                        ${param.time}
                    </td>
                </tr>


                <TR>
                    <TD align="center" bgColor="#f5fafe">商品信息</TD>
                    <TD bgColor="#ffffff" colSpan="3">
                        <table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1"
                               style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                            <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                <td align="center" width="7%">序号</td>
                                <td align="center" width="18%">商品编号</td>
                                <td align="center" width="10%">商品名称</td>
                                <td align="center" width="10%">商品价格</td>
                                <td width="7%" align="center">购买数量</td>
                                <td width="7%" align="center">商品类别</td>
                                <td width="31%" align="center">商品描述</td>
                            </tr>


                            <c:forEach items="${requestScope.itemList}" var="item" varStatus="i">
                                <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #eeeeee">
                                    <td align="center" width="7%">
                                            ${i.index+1}
                                    </td>

                                    <td align="center" width="18%">
                                            ${item.p.id}
                                    </td>

                                    <td align="center" width="10%">
                                            ${item.p.name}
                                    </td>

                                    <td align="center" width="10%">
                                            ${item.p.price}
                                    </td>

                                    <td width="7%" align="center">
                                            ${item.buynum}
                                    </td>

                                    <td width="7%" align="center">
                                            ${item.p.category}
                                    </td>

                                    <td width="31%" align="center">
                                            ${item.p.description}
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </TD>
                </TR>
                <TR>
                    <td align="center" colSpan="4" class="sep1"><img
                            src="${pageContext.request.contextPath}/admin/images/shim.gif">
                    </td>
                </TR>
                <TR>
                    <td style="WIDTH: 100%" align="right" bgColor="#f5fafe" colSpan="4">
                        <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
                        <INPUT type="button" onclick="history.go(-1)" value="返回" />
                        <span></span>
                    </td>
                </TR>
            </table>
        </div>
    </div>


    <div id="footer" style="height:15%;" >
        <%@include file="/WebContent/admin/login/bottom.jsp"%>
    </div>

</div>

</body>
</html>
