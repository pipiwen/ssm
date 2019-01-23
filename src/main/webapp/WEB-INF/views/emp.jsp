<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${empList}" var="e">
    <ul>
        <li>${e.name}</li>
    </ul>
</c:forEach>
</body>
</html>
