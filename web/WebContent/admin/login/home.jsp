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

    <div id="header" style="background-color:#FFA500;">
        <%@include file="top.jsp"%>
    </div>

    <div id="menu" style="background-color:#EEEEEE;float:left;width:15%;height:80%;">
        <jsp:include page="left.jsp" />
    </div>


    <div id="content" style="height:200px;width:85%;height:70%;float:left;">
        <jsp:include page="welcome.jsp" />

<%--        JSP页面跳转过来显示的内容--%>
        <div style="font-size: 30px">

            <%--JSTL转发获取做法，直接获取静态包含中的键值对即可--%>
<%--            <c:if com.melo.mybatis.test.MBGTest="${requestScope.forwardMessage!=null}">
                <div style="font-size: 30px">
                    <%= request.getParameter("forwardMessage")%>
                </div>
            </c:if>--%>

            <%
                if(request.getParameter("forwardMessage")!=null){
            %>
                <%= request.getParameter("forwardMessage")%>
            <% } %>
        </div>
    </div>


    <div id="footer" style="height:15%;" >
        <%@include file="bottom.jsp"%>
    </div>

</div>

</body>
</html>
