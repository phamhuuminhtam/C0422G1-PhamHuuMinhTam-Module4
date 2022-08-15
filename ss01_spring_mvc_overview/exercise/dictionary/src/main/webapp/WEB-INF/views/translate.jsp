<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/15/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Translate</h2>
<form action="/translate" method="post">
   Input word <input type="text" name="word" value="${word}">
    <button>Translate</button>
</form>
<c:if test="${word!=null}">
    <p><span style="color: red">${word}</span> : ${result}</p>
</c:if>

</body>
</html>
