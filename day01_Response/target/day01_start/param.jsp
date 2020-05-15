<%--
  Created by IntelliJ IDEA.
  User: Ni
  Date: 5/14/2020
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <a href="param/testParam?username=hehe&password=12345">请求参数绑定</a>--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名：<input type="text" name="username"><br>--%>
<%--        密码：<input type="text" name="password"><br>--%>
<%--        金额：<input type="text" name="money"><br>--%>
<%--        用户名：<input type="text" name="user.uname"><br>--%>
<%--        年龄：<input type="text" name="user.age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名：<input type="text" name="username"><br>--%>
<%--        密码：<input type="text" name="password"><br>--%>
<%--        金额：<input type="text" name="money"><br>--%>

<%--        用户名：<input type="text" name="users[0].uname"><br>--%>
<%--        年龄：<input type="text" name="users[0].age"><br>--%>

<%--        用户名：<input type="text" name="map['a'].uname"><br>--%>
<%--        年龄：<input type="text" name="map['a'].age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>


    <form action="param/saveUser" method="post">
        用户名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
