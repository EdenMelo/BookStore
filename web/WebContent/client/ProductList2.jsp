<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/4
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL导包--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>

    <title>Title</title>

<%--    <link rel="stylesheet" type="text/css" href="css/registCSS.css">--%>
    <link rel="stylesheet" type="text/css" href="css/menu_search.css">
    <script type="text/javascript" src="js/form.js"></script>

    <style>
        #productTable{
            border: 1px solid gray;
            background-color: #FCFDEF;
            width: 1500px;
            height: 570px;
            margin-left: 200px;
            background-clip: padding-box;
        }

        .tableWord td {
            height: 50px;
            /*设置单元格文字靠下*/
            vertical-align:bottom;
            position: relative;
            left: 40px;
            font-size: 20px;
        }

        .divBookPic p img {
            border: 2px solid #ccc;
            /*padding设定内边距*/
            padding: 5px;
            display: block;
            /*再设置内边距里面的白色背景填充*/
            background-color: white;
        }
    </style>


</head>
<body>

<%--书城顶部--%>
<%@ include file="include/head.jsp" %>

<%--书城菜单列表--%>
<%@ include file="include/menu_search.jsp" %>


<%--<form>--%>
    <table id="productTable">
        <tr class="tableWord">
            <td>
                商品目录
            </td>
        </tr>

        <tr class="tableWord" >
            <td>共 [<font style="color: red">${requestScope.products.size()}</font>] 种商品</td>

        </tr>

        <tr>
            <%--循环整个td--%>
            <c:forEach items="${requestScope.products}" var="product" end="3">
                <td class="formItem" align="center" style="position: relative; bottom: 6px">
                    <div class="divBookPic" >
                        <p>
                            <%--<img src="images/productImg/webMaster.jpg" width="150" height="180" border="0"  />--%>
                                <img src="${product.imgurl}" width="150" height="180" border="0"  />
                        </p>
                    </div>
                    <div class="divListTitle" >
                        <form action="WebContent/client/Handle-AddCart.jsp" method="post">
                            <%--<form action="cartServlet?action=testFindUser&id=${product.id}&search=1&bookName=${product.name}" method="post">--%>
                            书名：<br><input type="text" style="border: none;" name="PName" value="${product.name}" readonly="readonly"/><br/>
                            售价：<br><input type="text" style="border: none;" name="Price" value="${product.price}" readonly="readonly"/> <br/>
                            库存：<br><input type="text" style="border: none;" name="PNum" value="${product.pnum}" readonly="readonly"/> <br/>
                            查看详情：<br><input type="text" style="border: none;" name="PNum" value="${product.pnum}" readonly="readonly"/> <br/>
                            <input type="hidden" name="book1" value="购买">
                        </form>
                    </div>
                </td>
            </c:forEach>

        </tr>


    </table>

<%--</form>--%>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
