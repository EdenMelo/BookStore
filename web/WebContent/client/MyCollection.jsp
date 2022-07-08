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
      height: 35px;
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

    #page{
      position: relative;
      left: 100px;
      top: -50px;
      font-size: 30px;
    }
  </style>

  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <script type="text/javascript">
    $(function () {
      $(".cancelColl").click(function () {
        return confirm("你确定要取消收藏吗？");
      });
    });
  </script>




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
      收藏目录
    </td>
  </tr>

  <tr class="tableWord" >
    <td>
      共[ <span style="font-size: 20px;color: red;">${requestScope.collectionPage.pageTotalCount}</span> ]件收藏
    </td>
  </tr>


  <tr>
    <%--                <c:forEach items="${requestScope.products}" var="product" end="3">--%>
    <c:forEach items="${requestScope.collectionPage.items}" var="product" >
      <td class="formItem" align="center" style="position: relative; bottom: 6px">
        <div class="divBookPic" >
          <p>
            <%--<img src="images/productImg/gundam.jpg" width="150" height="180" border="0"  />--%>
              <img src="${product.imgurl}" width="150" height="180" border="0"  />
          </p>
        </div>


        <div class="divListTitle" >
            <%--<form action="WebContent/client/Handle-AddCart.jsp" method="post">--%>
          <form action="cartServlet?action=testFindUser&id=${product.id}&flag=collection" method="post">
            书名：<br><input type="text" style="border: none;" name="PName" value=${product.name} readonly="readonly"/><br/>
            售价：<br><input type="text" style="border: none;" name="Price" value=${product.price}  readonly="readonly"/> <br/>
            库存：<br><input type="text" style="border: none;" name="PNum" value=${product.pnum}  readonly="readonly"/> <br/>
            <a href="productServlet?action=bookDetails&id=${product.id}&flag=collection">查看商品详情</a><br>
            <a class="cancelColl"  href="collectionServlet?action=cancelCollection&id=${product.id}&pageNo=${requestScope.collectionPage.pageNo}">取消收藏</a><br>
            <input class="buyProduct" type="submit" name="book1" value="购买">
          </form>
        </div>
      </td>
    </c:forEach>
  </tr>

  <tr id="page">
    <td></td>
    <c:if test="${requestScope.collectionPage.pageNo > 1}">
      <td style="position: relative; right: 30px;">
        <%--<a href="productServlet?action=page&pageNo=${requestScope.page.pageNo-1}">--%>
        <a href="collectionServlet?action=queryUserCollection&collectionPageNo=${requestScope.collectionPage.pageNo-1}">
          上一页
        </a>
      </td>
    </c:if>
    <c:if test="${requestScope.collectionPage.pageNo <= 1}">
      <td style="position: relative; right: 30px;">

      </td>
    </c:if>


    <c:if test="${not empty requestScope.collectionPage.pageNo}">
      <td style="position: relative; right: 60px;">
        第[ <span style="color: red">${requestScope.collectionPage.pageNo}</span>  ]页
      </td>
    </c:if>

    <c:if test="${requestScope.collectionPage.pageNo < requestScope.collectionPage.pageTotal}">
      <td style="position: relative; right: 100px;">
        <%--<a href="productServlet?action=page&pageNo=${requestScope.collectionPage.pageNo+1}">--%>
        <a href="collectionServlet?action=queryUserCollection&collectionPageNo=${requestScope.collectionPage.pageNo+1}">
          下一页
        </a>
      </td>
    </c:if>

    <c:if test="${requestScope.collectionPage.pageNo == requestScope.collectionPage.pageTotal}">
      <td style="position: relative; right: 100px;">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </td>
    </c:if>


  </tr>

</table>


<%--</form>--%>

<%--书城下方显示--%>
<%@ include file="include/foot.jsp" %>

</body>
</html>
