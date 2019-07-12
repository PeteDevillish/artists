<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 2019-07-09
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artists</title>
</head>
<body>
${artists}
<%--//3. Dokument artists.jsp generuje przy pomocy tagów z biblioteki JSTL tablicę artystów (z odpowiednimi nagłówkami i wierszami).--%>
<table>
    <thead>
    <th>ID</th>
    <th>First name</th>
    <th>Last Name</th>
<%--    <th>Edit</th>--%>
    </thead>
<tbody>
<c:forEach items="${artists}" var="artist">
    <tr>
        <td>${artist.id}</td>
        <td>${artist.firstName}</td>
        <td>${artist.lastName}</td>
        <td><a href="/edit-artists?id=${artist.id}">Edit artist</a></td>
    </tr>
</c:forEach>
</tbody>
</table>
<a href="/edit-artists">Create artist</a>
</body>
</html>
