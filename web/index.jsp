<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/4
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
      window.onload=function () {
        location.href = "noticeServlet?action=queryNewNotice";
      };
    </script>
  </head>

  <body>
<%--  JSP转发到实际的index.jsp中--%>
<%--<jsp:forward page="WebContent/client/index.jsp"></jsp:forward>--%>

  </body>
</html>
