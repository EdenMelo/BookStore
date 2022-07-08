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
    <jsp:include page="/common/basePath.jsp"/>
    <title>Title</title>

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

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
        <form id="Form1" name="Form1" method="post" action="downloadServlet?action=downloadFile">

            <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>查 询 条 件</strong></td>
                </tr>

                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" border="0" width="100%">
                            <tr>
                                <td height="22" align="center" bgColor="#f5fafe">请输入年份：</td>
                                <td bgColor="#ffffff">
                                    <input type="text" name="year" size="15" value="" id="year" />
                                </td>
                                <td height="22" align="center" bgColor="#f5fafe">请选择月份：</td>
                                <td  bgColor="#ffffff">
                                    <select name="month" id="month">
                                        <option value="0" selected="selected" id="selected">--选择月份--</option>
                                        <option value="1">一月</option>
                                        <option value="2">二月</option>
                                        <option value="3">三月</option>
                                        <option value="4">四月</option>
                                        <option value="5">五月</option>
                                        <option value="6">六月</option>
                                        <option value="7">七月</option>
                                        <option value="8">八月</option>
                                        <option value="9">九月</option>
                                        <option value="10">十月</option>
                                        <option value="11">十一月</option>
                                        <option value="12">十二月</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td width="100" height="22" align="center" bgColor="#f5fafe"></td>
                                <td bgColor="#ffffff"><font face="宋体" color="red"> &nbsp;</font></td>
                                <td align="right" bgColor="#ffffff"><br /> <br /></td>
                                <td align="right" bgColor="#ffffff">
                                    <button type="submit" id="download" name="download" value="下载">
                                        下载
                                    </button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" name="reset" value="重置" />
                                </td>
                            </tr>

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
