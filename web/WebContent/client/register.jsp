<%--
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
    <link rel="stylesheet" type="text/css" href="css/registCSS.css">
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <script type="text/javascript" src="js/form.js"></script>

</head>
<body>

<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>


<%--设置表单的提交为registServlet工程，提交方式为post,servlet中使用doPost方法接收--%>
<form action="registServlet" method="post">
    <table id="registerTable">
         <tr>
             <th >新用户注册</th>
         </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>邮箱：</label>
                    <input type="email" id="email" name="email" value="${requestScope.email}"/>
                </div>
            </td>
            <td class="word">
                请输入有效的邮箱地址
            </td>
        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>用户名： </label>
                    <input type="text" id="username" name="username" value="${requestScope.username}"/>
                </div>

                <td class="word">
                    字母数字下划线1到10位，不能是数字开头
                </td>
            </td>

        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>密码： </label>
                    <input type="password" id="pw" name="pw"/>
                </div>
            </td>
            <td class="word">
                密码请设置6-16位字符
            </td>
        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>重复密码： </label>
                    <input type="password" id="rw" name="rw"/>
                </div>
            </td>
        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>性别： </label>
                        <input type="radio" name="sex" id="man" checked="checked" value="male"> 男
                        <input type="radio" name="sex" id="women" value="female"> 女
                </div>
            </td>
        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>联系电话： </label>
                    <textarea cols="50" rows="1" name="telephone"> </textarea>
                </div>
            </td>
        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <label>个人介绍： </label>
                    <textarea cols="50" rows="5" name="introduce"> </textarea>
                </div>
            </td>
        </tr>

        <tr>
            <td class="formItem">
                <div>
                    <input type="image" src="images/button.png" name="submit" align="right" id="sub_btn">
                </div>
            </td>
        </tr>

    </table>

</form>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
