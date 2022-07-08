<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<head>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <jsp:include page="/common/basePath.jsp"></jsp:include>

    <meta http-equiv="Content-Language" content="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //blur事件判断商品名称不为空
            $("#name").blur(function(){
                var name = $("#name").val();
                if("" === name){
                    alert("商品名称不能为空");
                    return false;
                }
            });

            //blur事件判断商品价格不为空
            $("#price").blur(function(){
                var price = $("#price").val();
                price = price.replaceAll(" ","");
                //判断price为数字
                if(isNaN(price)){
                    alert("商品价格必须为数字");
                    return false;
                }
                if("" === price){
                    alert("商品价格不能为空");
                    return false;
                }
            });

            //blur事件判断商品数量不为空
            $("#pnum").blur(function(){
                var pnum = $("#pnum").val();
                pnum = pnum.replaceAll(" ","");
                //判断pnum为数字
                if(isNaN(pnum)){
                    alert("商品数量必须为数字");
                    return false;
                }
                //判断pnum不为空
                if("" === pnum){
                    alert("商品数量不能为空");
                    return false;
                }
            });

            //blur事件判断商品类型不为空
            $("#category").blur(function(){
                var category = $("#category").val();
                if("" === category){
                    alert("商品类型不能为空");
                    return false;
                }
            });

            //blur事件判断商品描述不为空
            $("#description").blur(function(){
                var description = $("#description").val();
                if(description === ""){
                    alert("商品描述不能为空");
                    return false;
                }
            });


            //获取select全部的option
            var options = $("#category option");
            //遍历option
            for(var i = 0; i < options.length; i++){
                //获取option的value值
                var value = options[i].value;

                <%--获取地址栏中传过来的参数，设置参数回显--%>
                if(value === "${param.category}"){
                    //与参数一致的选项就设置为选中状态
                    options[i].selected = true;
                }
            }


            $("#confirm").click(function () {
                var name = $("#name").val();
                var price = $("#price").val();
                var pnum = $("#pnum").val();
                var category = $("#category").val();
                var description = $("#description").val();

                if(name === "" || price === "" || pnum === "" || category === "" || description === ""){
                    alert("请填写完整的商品信息");
                    // return false不进行表单提交
                    return false;
                }else{
                    //进行表单提交
                    alert("商品信息修改成功");
                    return true;
                }
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

        <form id="userAction_save_do" name="Form1" action="productServlet?action=updateProduct" method="post">
            &nbsp;
            <table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3" colSpan="4"
                        height="26"><strong><STRONG>修改商品</STRONG> </strong>
                    </td>
                </tr>

                <tr>
                    <%--设置隐藏域传值--%>
                    <input type="hidden" name="id" value="${param.id}"/>

                    <td align="center" bgColor="#f5fafe">商品名称：</td>
                    <td bgColor="#ffffff">
                        <%--获取地址栏中传过来的参数，设置参数回显--%>
                        <input type="text" name="name" id="name" value="${param.name}"/>
                    </td>
                    <td align="center" bgColor="#f5fafe">商品价格：</td>
                    <td bgColor="#ffffff">
                        <input type="text" name="price" id="price" value="${param.price}"/>
                    </td>
                </tr>

                <tr>
                    <td align="center" bgColor="#f5fafe">商品数量：</td>
                    <td bgColor="#ffffff">
                        <input type="text" name="pnum" id="pnum" value="${param.pnum}"/>
                    </td>
                    <td align="center" bgColor="#f5fafe">商品类别：</td>
                    <td bgColor="#ffffff">
                        <select name="category" id="category" >
                            <option value="" selected="selected">--选择商品类加--</option>
                            <option value="文学" >文学</option>
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
                        </select>
                    </td>
                </tr>

                <tr>
                    <td align="center" bgColor="#f5fafe" >商品图片：</td>
                    <td bgColor="#ffffff" colspan="3">
                        <input type="file" name="imgurl" accept=".jpg (*.jpg),.gif (*.gif)"  size="30" value="" />
                    </td>
                </tr>

                <tr>
                    <td align="center" bgColor="#f5fafe">商品描述：</td>
                    <td bgColor="#ffffff" colSpan="3">
                        <%--隐藏域传值--%>
                        <input type="hidden" name="description" value="${param.description}"/>
                        <textarea name="description" cols="30" rows="3" style="WIDTH: 96%" id="description" >${param.description}</textarea>
                    </td>
                </tr>

                <tr>
                    <td style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
                        <input id="confirm" type="submit" value="确定">
                        <font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
                        <input type="reset" value="重置" >
                        <font face="宋体">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </font>
                        <input type="button" onclick="history.go(-1)" value="返回" />

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
</HTML>