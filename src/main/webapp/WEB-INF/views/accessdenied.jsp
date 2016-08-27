<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mesut
  Date: 27.8.2016
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Acces Denied!</title>
</head>
<body>
Access Denied!: ${user}
<br>
<a href="<c:url value="/logout" /> ">Logout</a>
</body>
</html>
