<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 2019-07-11
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Album</title>
</head>
<body>
${artists}
<form action="">
    Name <br>
    <input type="text" name="name"> <br>
    Artist <br>
    <select name="aid">
        <c:forEach var="artist" items="${artists}">
            <option value="${artist.id}">${artist.firstName}</option>
        </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>
