<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/user/login" method="post" >
    用户名：<input name="name" type="text"/>
    密码：<input name="password" type="password" />
    <input type="submit" value="提交"/>
</form>
</body>
</html>
