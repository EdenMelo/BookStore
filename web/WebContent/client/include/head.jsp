<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/11
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .shoppingWord{
        color: blue;
    }
    #loginMessage{
        font-size: 20px;
        margin-left: 1630px;
    }
</style>

<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        //如果当前用户未登录，那么submitOrder无效
        $("#cart").click(function () {
            if(${applicationScope.loginUser == null}){
                alert("请先登录！");
                return false;
            }
        });

        $("#myAccount").click(function () {
            if(${applicationScope.loginUser == null}){
                alert("请先登录！");
                return false;
            }
        });


    });
</script>

<!--永远固定相对路径跳转的结果-->
<jsp:include page="/common/basePath.jsp"></jsp:include>

<table>
    <tr>
        <td>
            <%--                <img src="images/cart.gif"  style="margin-left: 1500px">--%>
            <img src="images/cart.gif"  style="margin-left: 1450px">
        </td>

        <td>
            <a href="cartServlet?action=cartCheckout" style="text-decoration: none;">
            <%--<a id="cart" href="cartServlet?action=cartCheckout&index=1" style="text-decoration: none;">--%>
                <span class="shoppingWord"> 购物车 </span> |
            </a>
        </td>

        <td>
            <a id="help" href="https://cn.bing.com/" style="text-decoration: none;">
                <span class="shoppingWord">帮助中心 </span> |
            </a>
        </td>

        <td>
            <%--<a id="myAccount" href="WebContent/client/myAccount.jsp" style="text-decoration: none;">--%>
            <a id="myAccount" href="userServlet?action=personalInfo" style="text-decoration: none;">
                <span class="shoppingWord">我的账户 </span> |
            </a>
        </td>

        <td>
            <%--设定a标签跳转到注册页面，去掉下划线--%>
<%--            <c:if test="${empty sessionScope.username}">--%>
            <c:if test="${empty applicationScope.username}">
                <%--                <c:if test="${empty pageScope.username}">--%>
                <a href="WebContent/client/register.jsp" class="shoppingWord"
                   style="text-decoration: none">新用户注册</a> |

                <a href="WebContent/client/login.jsp" class="shoppingWord"
                   style="text-decoration: none">用户登录</a>
            </c:if>



<%--            <c:if test="${not empty sessionScope.username}">--%>
                <c:if test="${not empty applicationScope.username}">
<%--                <c:if test="${empty pageScope.username}">--%>
                <a href="collectionServlet?action=queryUserCollection&index=1" class="shoppingWord"
                   style="text-decoration: none">我的收藏</a> |
                <a href="userServlet?action=logout" class="shoppingWord"
                   style="text-decoration: none">用户退出</a> |
                <a href="WebContent/admin/login/home.jsp" class="shoppingWord"
                   style="text-decoration: none">进入后台</a>
                </c:if>


        </td>
    </tr>
</table>


<%--<a href="WebContent/client/index.jsp" >--%>
<a href="noticeServlet?action=queryNewNotice" >
    <img src="images/logo.jpg" style="position: relative; left: 50px;vertical-align: middle;" >
</a>

<%--<c:if test="${not empty sessionScope.username}">--%>
<c:if test="${not empty applicationScope.username}">
    <span id="loginMessage">
        欢迎您：${applicationScope.username}
        <%--<img src="WebContent/admin/login/cheems.jpg" style="width: 50px; height: 50px; position: absolute; border: solid 1px; bottom: 800px;" />--%>
        <%--<img src="WebContent/admin/login/cheems.jpg" style="width: 50px; height: 50px; position: absolute; border: solid 1px; bottom: 79%;" />--%>
        <img src="${applicationScope.userIcon.userIconUrl}" style="width: 50px; height: 50px; position: absolute; border: solid 1px; bottom: 79%;" />
    </span>

    <%--<span id="loginMessage">欢迎您：${sessionScope.username}</span>--%>
</c:if>







