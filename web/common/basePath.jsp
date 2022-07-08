<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/5
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);
    //① request.getScheme()可以返回当前页面使用的协议；默认返回http，SSL时返回https；
    //② request.getServerName()可以返回当前页面所在的服务器的名字；localhost/192.xx.xx.x等
    //③request.getServerPort()可以返回当前页面所在的服务器使用的端口,就是项目在服务器上发布的端口，或者在本地tomcat容器运行时发布的端口；
    //④request.getContextPath()可以返回当前页面所在的应用的名字;
%>

<base href="<%=basePath%>">

