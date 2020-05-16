<%--
  Created by IntelliJ IDEA.
  User: Ni
  Date: 5/15/2020
  Time: 2:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        $(function() {
            $("#btn").click(function() {
                //发送ajax请求
                $.ajax({
                    //编写jason参数
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"呵呵","password":"123","age":15}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        //data时服务器端响应的json数据
                        alert(data.username);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/tsetString">testString</a><br>
    <a href="user/testVoid">testVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testModelAndView">testForwardOrRedirect</a><br>
    <button id="btn">发送ajax请求</button>

</body>
</html>
