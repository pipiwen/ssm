<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h3>用户列表</h3>
<a href="/user/addFrom">新增</a>
<table border="1" cellpadding="0" cellspacing="0" width="500">
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
<c:forEach items="${userModel}" var="u">
    <tr>
        <td>${u.id}</td>
        <td>${u.name}</td>
        <td>${u.password}</td>
        <td><a href="/user/addFrom?id=${u.id}&name=${u.name}&password=${u.password}">修改</a>&nbsp;&nbsp;<a href="#">删除</a></td>
    </tr>
</c:forEach>
</table>
<img src="/images/tb1.jpg" alt="...">
</body>
</html>
