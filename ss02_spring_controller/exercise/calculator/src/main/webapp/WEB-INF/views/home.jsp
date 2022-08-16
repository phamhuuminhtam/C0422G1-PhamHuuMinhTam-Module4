<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/16/2022
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>CALCULATOR</h2>
<form action="/solve" method="post">
  <input type="number" name="numb1" value="0">
  <input type="number" name="numb2" value="0">
<div>
    <button type="submit" value="+" name="action">+</button>
    <button type="submit" value="-" name="action">-</button>
    <button type="submit" value="*" name="action">*</button>
    <button type="submit" value="/" name="action">/</button>
</div>
</form>
<c:if test="${result!=null}">
  <p>${numb1} ${action} ${numb2}</p>
  <p>Result: ${result}</p>
</c:if>
</body>
</html>
