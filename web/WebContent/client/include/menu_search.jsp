<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/3/11
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/menu_search.css">

<div  id="div1">

    <a href="productServlet?action=queryProductByMenu&name=文学" style="text-decoration: none;">
        <span style="color: white; font-size: 20px; margin-left: 400px; margin-top: 2000px">文学</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=生活" style="text-decoration: none;color: white;">
        <span>生活</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=计算机" style="text-decoration: none;color: white;">
        <span>计算机</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=外语" style="text-decoration: none;color: white;">
        <span>外语</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=经营" style="text-decoration: none;color: white;">
        <span>经管</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=励志" style="text-decoration: none;color: white;">
        <span>励志</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=社科" style="text-decoration: none;color: white;">
        <span>社科</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=学术" style="text-decoration: none;color: white;">
        <span>学术</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=少儿" style="text-decoration: none;color: white;">
        <span>少儿</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=艺术" style="text-decoration: none;color: white;">
        <span>艺术</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=原版" style="text-decoration: none;color: white;">
        <span>原版</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=科技" style="text-decoration: none;color: white;">
        <span>科技</span>
    </a>

    <a href="productServlet?action=queryProductByMenu&name=考试" style="text-decoration: none;color: white;">
        <span>考试</span>
    </a>
    <a href="productServlet?action=queryProductByMenu&name=生活百科" style="text-decoration: none;color: white;">
        <span>生活百科</span>
    </a>

    <a href="productServlet?action=queryProductByIndex" style="text-decoration: none;">
    <%--<a href="productServlet?action=page" style="text-decoration: none;">--%>
        <span style="margin-left: 25px; font-size: 20px; color: yellowgreen">全部商品目录</span>
    </a>
</div>

<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#submitClick").click(function () {
            //menuSearchForm表单提交
            $("#menuSearchForm").submit();
            return false;
        });
    });
</script>


<div id="div2">

    <form id="menuSearchForm" action="menuSearchServlet?action=showProduct" method="post">
       <span style="margin-left: 1200px; color: black;font-size: 20px" >Search</span>
<%--    placeholder相较于value设置默认值不会设置具体的字段，只会在底层显示--%>
        <input type="text" placeholder="请输入书名" name="bookName">

<%--    relative设定相对位置，静态包含调用的时候不会影响位置--%>
        <a id="submitClick">
            <img src="http://localhost:8080/BookStore/images/serchbutton.gif"
                 style="position:relative; top: 5px; margin-left: 10px" >
        </a>

    </form>

</div>
