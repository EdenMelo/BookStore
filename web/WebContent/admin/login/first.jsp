<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/18
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        //JSTL做法，直接在request域中保存键值对
        request.setAttribute("forwardMessage","这是使用jsp: forward从first页面跳转过来的~");
    %>
</head>

<body>
<%
    //first.jsp当前域中设置UTF-8字符集防止页面中文乱码
    request.setCharacterEncoding("UTF-8");
%>

    <jsp:forward page="home.jsp">
        <jsp:param name="forwardMessage" value="这是使用jsp: forward从first页面跳转过来的~" />
    </jsp:forward>


</body>
</html>
