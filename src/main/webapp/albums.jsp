<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 2019-07-11
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Albums</title>
</head>
<body>
${albums}
${artists}
<table>
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Artist</th>
    </thead>
    <c:forEach items="${albums}" var="album">
        <td>${album.id}</td>
        <td>${album.name}</td>
        <td>${album.artist}</td>
    </c:forEach>
    <a href="/edit-album">Add album</a>
</table>
</body>
</html>
