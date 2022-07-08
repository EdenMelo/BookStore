<%--
  Created by IntelliJ IDEA.
  User: Melo
  Date: 2022/4/9
  Time: 23:08
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

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script type="text/javascript">
        $(function () {
           //标签要设置为class类型而不能设置成id类型，因为新增的字段不会自动设置id，必须指定为class
           $("a.delete").click(function () {
               return confirm("你确定要删除商品吗？");
            });
        });
    </script>

</head>


<body>


<div id="container" style="width:100%;height:100%;">

    <div id="header" style="background-color:#FFA500;">
        <%@include file="/WebContent/admin/login/top.jsp"%>
    </div>

    <div id="menu" style="background-color:#EEEEEE;float:left;width:15%;height:80%;">
        <%@include file="/WebContent/admin/login/left.jsp"%>
    </div>

    <div id="content" style="height:200px;width:85%;height:70%;float:left;">
        <form id="Form1" name="Form1" method="post" action="productServlet?action=queryProductForCondition">
            <table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>查 询 条 件</strong></td>
                </tr>

                <tr>
                    <td>
                        <table cellpadding="0" cellspacing="0" border="0" width="100%">
                            <tr>
                                <td height="22" align="center" bgColor="#f5fafe">商品编号：</td>
                                <td bgColor="#ffffff">
                                    <input type="text" name="id" size="15" value="" id="id" />
                                </td>
                                <td height="22" align="center" bgColor="#f5fafe">类别：</td>
                                <td  bgColor="#ffffff"><select name="category" id="category">
                                    <option value="" selected="selected" id="selected">--选择商品类别--</option>
                                    <option value="文学">文学</option>
                                    <option value="生活">生活</option>
                                    <option value="计算机">计算机</option>
                                    <option value="外语">外语</option>
                                    <option value="经营">经营</option>
                                    <option value="励志">励志</option>
                                    <option value="社科">社科</option>
                                    <option value="学术">学术</option>
                                    <option value="少儿">少儿</option>
                                    <option value="艺术">艺术</option>
                                    <option value="原版">原版</option>
                                    <option value="科技">科技</option>
                                    <option value="考试">考试</option>
                                    <option value="生活百科">生活百科</option>
                                </select></td>
                            </tr>

                            <tr>
                                <td height="22" align="center" bgColor="#f5fafe" >商品名称：</td>
                                <td bgColor="#ffffff"><input type="text" name="name" size="15" value="" id="name" />
                                </td>
                                <td height="22" align="center" bgColor="#f5fafe" >价格区间(元)：</td>
                                <td bgColor="#ffffff">
                                    <input type="text" name="minprice" size="10"/> - <input type="text" name="maxprice" size="10"/></td>
                            </tr>

                            <tr>
                                <td width="100" height="22" align="center" bgColor="#f5fafe"></td>
                                <td bgColor="#ffffff"><font face="宋体" color="red"> &nbsp;</font></td>
                                <td align="right" bgColor="#ffffff"><br /> <br /></td>
                                <td align="right" bgColor="#ffffff">
                                    <%--先将这个查询定义为全部查询，后面再修改具体的查询条件--%>
                                    <button type="submit" id="search" name="search" value="查询">
                                        查询
                                    </button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="reset" name="reset" value="重置" />
                                </td>
                            </tr>

                        </table>
                    </td>
                </tr>


                <tr>
                    <td align="center" bgColor="#afd1f3"><strong>商 品 列 表</strong></TD>
                </tr>

                <tr>
                    <td align="right">
                        <a href="WebContent/admin/products/add.jsp">
                            <button type="button" id="add" name="add" value="添加" > 添加</button>
                        </a>
                    </td>
                </tr>


                <tr>
                    <td align="center" bgColor="#f5fafe">
                        <table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
                               style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                            <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                                <td align="center" width="24%">商品编号</td>
                                <td align="center" width="18%">商品名称</td>
                                <td align="center" width="9%">商品价格</td>
                                <td align="center" width="9%">商品数量</td>
                                <td width="8%" align="center">商品类别</td>
                                <td width="8%" align="center">编辑</td>
                                <td width="8%" align="center">删除</td>
                            </tr>

                            <!--  在这里循环输出所有商品 -->
                            <c:forEach items="${sessionScope.products}" var="product">
                                <tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">
                                        <div>${product.id}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
                                        <div>${product.name}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                        <div>${product.price}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">
                                        <div>${product.pnum}</div>
                                    </td>

                                    <td style="CURSOR: hand; HEIGHT: 22px" align="center">
                                        <div>${product.category}</div>
                                    </td>


                                    <!-- 编辑 -->
                                    <td align="center" style="HEIGHT: 22px" width="7%">
                                        <%--往地址栏里传入参数--%>
                                        <a href="WebContent/admin/products/update.jsp?id=${product.id}&name=${product.name}&pnum=${product.pnum}&price=${product.price}&category=${product.category}&description=${product.description}">
                                            <img src="images/icon1.png" border="0" style="CURSOR: hand">
                                        </a>
                                    </td>

                                    <!-- 删除 -->
                                    <td  align="center" style="HEIGHT: 22px" width="7%">
                                        <%--根据id删除商品，往servlet里传入参数--%>
                                        <a class="delete" href="productServlet?action=deleteProduct&id=${product.id}">
                                            <img src="images/error.jpg" width="16" height="16" border="0" style="CURSOR: hand" id="delete">
                                        </a>
                                    </td>

                                </tr>
                            </c:forEach>

                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </div>


    <div id="footer" style="height:15%;  " >
        <%@include file="/WebContent/admin/login/bottom.jsp"%>
    </div>

</div>

</body>
</html>
