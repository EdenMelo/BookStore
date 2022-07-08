<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/23
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String []s = new String[4];
        s[0] = request.getParameter("PName");
        s[1] = request.getParameter("Price");
        s[2] = request.getParameter("PNum");
        s[3] = "1";

        for(String str:s){
            System.out.println(str);
        }


        if("网管员必备宝典".equals(s[0])){
            session.setAttribute("book1",s);
        }else if("学会宽容".equals(s[0])){
            session.setAttribute("book2",s);
        }else if("杜拉拉升职记".equals(s[0])){
            session.setAttribute("book3",s);
        }else if("Java基础入门".equals(s[0])){
            session.setAttribute("book4",s);
        }

    %>

<%--    请求转发到购物车转发页面--%>
<%--    <jsp:forward page="Cart.jsp"></jsp:forward>--%>

    <jsp:forward page="ProductList.jsp"></jsp:forward>

</body>
</html>




























































































