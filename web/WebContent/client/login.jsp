<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/4/3
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="css/registCSS.css">
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">

    <style>
        #loginDiv{
            margin-top: 50px;
            border: gray 1px solid;
            width: 1500px;
            height: 250px;
            margin: auto;
            background-color: #FCFDEF;
        }

        td lable{
            /*文字右对齐*/
            font-size: 20px;
            width: 150px;
            display: inline-block;
            text-align: right;
        }

        #loginTable{
            /*表格居中*/
            margin-left: 34%;
            position: relative;
        }

    </style>
</head>
<body>
<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>


    <div id="loginDiv">

<%--        <form action="loginServlet" method="post">--%>
        <%--设置表单提交到userServlet中的login方法进行处理--%>
        <form action="userServlet?action=login" method="post">
            <div style="font-weight: bold; text-align: center;font-size: 30px;">个人用户登录</div>
            <br><br>
            <table id="loginTable">
                <tr>
                    <td>
                        <lable>用户名：</lable>
                        <%--设置页面回显--%>
                        <%request.setAttribute("username",request.getParameter("username"));%>
                        <%--<input type="text" name="username" value="${requestScope.username}">--%>
                        <input type="text" name="username" value="Test1">
                    </td>
                </tr>
                <tr>
                    <td>
                        <lable>密码：</lable>
                        <%--<input type="password" name="password">--%>
                        <input type="password" name="password" value="123456">
                    </td>
                </tr>
            </table>
            <br>
            <button style="font-size: 20px; display:block; margin:0 auto;">
                登录
            </button>
        </form>
    </div>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
