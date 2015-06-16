<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: m.chmil
  Date: 14.05.2015
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>Guestbook posts</title>
</head>
<body>
<table border="1">
    <c:forEach items="${requestScope.posts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td><c:out value="${post.txt}"/></td>
            <td>
                <a href="delete?id=${post.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    <form action="/add" method="POST">
        <tr>
            <td colspan="2">
                <input name="txt" type="text">
            </td>
            <td>
                <input type="submit">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
