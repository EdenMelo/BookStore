<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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

        #Details{
            height: 35px;
            /*设置单元格文字靠下*/
            vertical-align:bottom;
            position: relative;
            left: 40px;
            font-size: 20px;
        }

        #page{
            position: relative;
            left: 100px;
            top: -50px;
            font-size: 30px;
        }

        #DetailsImg{
            /*border: 2px solid #ccc;*/
            /*padding设定内边距*/
            padding: 5px;
            display: block;
            /*再设置内边距里面的白色背景填充*/
            /*background-color: white;*/
            position: relative;
            left: 50%;
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
        <td style="font-size: 40px;">
            商品详情
        </td>
    </tr>

    <tr>
        <td>
            <%--判断是从哪个页面进来的，再返回对应的页面--%>
            <c:if test="${requestScope.flag == 'product'}" >
                <a href="productServlet?action=page&pageNo=${applicationScope.pageNo}">
                    <button style="font-size: 25px;position: relative;right: 0.5%;">
                        返回商品目录
                    </button>
                </a>
            </c:if>

            <c:if test="${requestScope.flag == 'collection'}" >
                <a href="collectionServlet?action=queryUserCollection&collectionPageNo=${applicationScope.collectionPageNo}">
                    <button style="font-size: 25px;position: relative;right: 0.5%;">
                        返回我的收藏
                    </button>
                </a>
            </c:if>
        </td>
    </tr>

    <tr>
        <td id="DetailsImg">
            <%--<img src="images/productImg/gundam.jpg" width="300" height="300" border="0"  />--%>
                <img src="${productDetails.imgurl}" width="300" height="300" border="0"  />
        </td>

        <td id="Details">
            <div style="position: relative;left: 100px;">
                图书id：<br><input type="text" style="border: none; font-size: 30px;" name="PNum" readonly="readonly" value=${productDetails.id} /> <br/>
                书名：<br><input type="text" style="border: none; font-size: 30px;" name="PName" readonly="readonly" value=${productDetails.name} /><br/>
                售价：<br><input type="text" style="border: none; font-size: 30px;" name="Price" readonly="readonly" value=${productDetails.price}  /> <br/>
                分类：<br><input type="text" style="border: none; font-size: 30px;" name="PNum" readonly="readonly" value=${productDetails.category} /> <br/>
                库存：<br><input type="text" style="border: none; font-size: 30px;" name="PNum" readonly="readonly" value=${productDetails.pnum}  /> <br/>
                商品描述：<br><input type="text" style="border: none; font-size: 30px;" name="PNum" readonly="readonly" value=${productDetails.description} /> <br/>
            </div>
        </td>
    </tr>

</table>


<%--</form>--%>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
