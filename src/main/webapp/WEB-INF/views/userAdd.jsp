<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>用户新增</h3>
<%--<form action="/user/add" method="post" >
    <input name="id" type="hidden" value="${user.id}"/>
    用户名：<input name="name" type="text" value="${user.name}"/>
    密码：<input name="password" type="password" value="${user.password}"/>
    <input type="submit" value="提交"/>
</form>--%>
<%--mvcfrom标签--%>
<form:form action="/user/add" enctype="multipart/form-data" method="post" modelAttribute="user"><%--method默认值postenctype 属性规定在发送到服务器之前应该如何对表单数据进行编码。--%>
<form:hidden path="id"/>
   用户名： <form:input path="name"/>
    密码：<form:password path="password" showPassword="true"/><%--showPassword密码做回显--%>
    文件：<input type="file" name="file"/>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>
