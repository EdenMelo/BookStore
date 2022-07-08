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
            //blur事件判断公告标题不为空
            $("#title").blur(function(){
                var category = $("#title").val();
                if("" === category){
                    alert("公告标题不能为空");
                    return false;
                }
            });

            //blur事件判断公告描述不为空
            $("#description").blur(function(){
                var description = $("#description").val();
                if(description === ""){
                    alert("公告描述不能为空");
                    return false;
                }
            });


            $("#confirm").click(function () {
                var title = $("#title").val();
                var description = $("#description").val();

                if(title === "" || description === ""){
                    alert("请填写完整的公告信息");
                    // return false不进行表单提交
                    return false;
                }else{
                    //进行表单提交
                    alert("公告修改成功");
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

        <form id="userAction_save_do" name="Form1" action="noticeServlet?action=updateNotice" method="post">
            &nbsp
            <table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
                <tr>
                    <td align="center" bgColor="#afd1f3" colSpan="4"
                        height="26"><strong><STRONG>修改公告</STRONG> </strong>
                    </td>
                </tr>

                <tr>
                    <%--设置隐藏域传值--%>
                    <input type="hidden" name="id" value="${param.id}"/>

                    <td align="center" bgColor="#f5fafe">公告标题：</td>

                    <td bgColor="#ffffff">
                        <%--获取地址栏中传过来的参数，设置参数回显--%>
                        <input type="text" name="title" id="title" value="${param.title}"/>
                    </td>
                </tr>

                <tr>
                    <td align="center" bgColor="#f5fafe">公告内容：</td>
                    <td bgColor="#ffffff" colSpan="3">
                        <%--隐藏域传值--%>
                        <input type="hidden" name="description" />
                        <textarea name="description" cols="30" rows="3" style="WIDTH: 96%" id="description" >${param.detail}</textarea>
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