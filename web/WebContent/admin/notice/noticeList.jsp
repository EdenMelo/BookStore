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
            $("a.deleteNotice").click(function () {
                return confirm("你确定要删除公告吗？");
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
        <%--<form id="Form1" name="Form1" method="GET" action="noticeServlet?action=showAllNotice">--%>
            <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>公 告 列 表</strong></td>
                </tr>

                <tr>
                    <td align="right" bgColor="#ffffff">
                        <%--<input type="submit" name="query" value="查询" style="font-size: 17px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                        <a href="noticeServlet?action=showAllNotice">
                            <button id="query" name="query" value="查询" style="font-size: 17px;">
                                查询
                            </button>
                        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        <a href="WebContent/admin/notice/addNotice.jsp">
                            <button id="add" name="add" value="添加" style="font-size: 17px;" >
                                添加
                            </button>
                        </a>
                    </td>
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
                                <td align="center" width="10%">公告编号</td>
                                <td align="center" width="14%">公告标题</td>
                                <td align="center" width="15%">公告内容</td>
                                <td align="center" width="9%">时间</td>

                                <%--<td width="8%" align="center">总价</td>--%>
                                <%--<td width="8%" align="center">所属用户</td>--%>
                                <%--<td width="8%" align="center">订单状态</td>--%>

                                <td width="8%" align="center">编辑</td>
                                <td width="8%" align="center">删除</td>
                            </tr>

                            <!--  在这里循环输出所有公告 -->
                            <c:forEach items="${requestScope.noticeList}" var="notice">
                                <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="100">
                                        <%--<div>公告编号</div>--%>
                                        <div>${notice.noticeId}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="14%">
                                        <%--<div>公告标题</div>--%>
                                        <div>${notice.noticeTitle}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="15%">
                                        <%--<div>公告内容</div>--%>
                                        <div>${notice.noticeDetails}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                        <%--<div>时间</div>--%>
                                        <div>${notice.noticeTime}</div>
                                    </td>

                                    <!-- 编辑 -->
                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                        <a href="WebContent/admin/notice/editNotice.jsp?id=${notice.noticeId}
                                        &title=${notice.noticeTitle}&detail=${notice.noticeDetails}">
                                            <img src="images/icon1.png" width="16" height="16" border="0" style="CURSOR: hand" id="update">
                                        </a>
                                    </td>

                                    <!-- 删除 -->
                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                        <a class="deleteNotice" href="noticeServlet?action=deleteNotice&id=${notice.noticeId}">
                                            <img src="images/error.jpg" width="16" height="16" border="0" style="CURSOR: hand" id="delete">
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>
            </table>
        <%--</form>--%>
    </div>


    <div id="footer" style="height:15%;  " >
        <%@include file="/WebContent/admin/login/bottom.jsp"%>
    </div>

</div>

</body>
</html>
