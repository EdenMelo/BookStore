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
</head>
<body>
    <%
        String deleteBook = "book"+request.getParameter("no");
        session.removeAttribute(deleteBook);

    %>

    <%--重定向回购物车页面--%>
    <jsp:forward page="Cart.jsp"></jsp:forward>
</body>
</html>