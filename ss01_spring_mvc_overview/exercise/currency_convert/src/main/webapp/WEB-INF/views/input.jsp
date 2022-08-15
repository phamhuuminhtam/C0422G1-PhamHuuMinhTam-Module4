<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/15/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">

</head>
<body>

<form action="/goConvert" method="post" >
    <div class="col-2 ms-2" >
        <label  class="form-label ">USD</label>
         <input type="number" name="usd" value="${usd}" class="form-control" >
    </div>
   <div class="mt-2 col-2 ms-2">
       <label  class="form-label">Rate</label>
        <input type="number" name="rate" value="${rate}" class="form-control">
   </div>
   <div class="d-flex justify-content-center col-2 mt-4">
       <button class="btn btn-success">Convert</button>
   </div>

    <c:if test="${result!=null}">
        <p> VND:  <fmt:formatNumber type = "number"
                             maxFractionDigits = "3" value = "${result}" /></p>
    </c:if>
</form>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
