<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 2019-07-09
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit artist</title>
</head>
<body>
<form action="" method="post">
    First Name <br>
    <input type="text" name="firstName" placeholder="First name" value="${firstName}"><br>
    Last Name <br>
    <input type="text" name="lastName" placeholder="Last name" value="${lastName}"><br>
    <input type="submit" value="
    <c:out value="${isUpdate ? 'Edit artist': 'Add artist'}"/>
    ">
</form>
</body>
</html>
