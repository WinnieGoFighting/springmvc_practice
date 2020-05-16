<%--
  Created by IntelliJ IDEA.
  User: Ni
  Date: 5/14/2020
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统方式文件上传</h3>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data" >
        选择文件： <input type="file" name="upload"/><br>
        <input type="submit" value="文件上传">
    </form>

    <h3>springMVC方式文件上传</h3>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data" >
        选择文件： <input type="file" name="upload"/><br>
        <input type="submit" value="文件上传">
    </form>

    <h3>springMVC方式跨服务器文件上传</h3>
    <form action="user/fileupload3" method="post" enctype="multipart/form-data" >
        选择文件： <input type="file" name="upload"/><br>
        <input type="submit" value="文件上传">
    </form>
</body>
</html>
