<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/16/2022
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/condiment" method="post">

    <h1>SandWich Condiments</h1>
    <div>
        <c:forEach items="${list}" var="list">
            <input type="checkbox" name="condiment" value="${list.name}">${list.name}
        </c:forEach>
        <input type="checkbox" name="condiment" value="" hidden checked>
        <hr>
    </div>
    <button type="submit">Save</button>

</form>
<c:if test="${choose!=null}">
    <h2 style="font-weight: bolder">You choose:</h2>
    <c:forEach items="${choose}" var="choose">
        <c:if test="${choose!=''}">
            <span>${choose}, </span>
        </c:if>
    </c:forEach>
</c:if>
</body>
</html>
