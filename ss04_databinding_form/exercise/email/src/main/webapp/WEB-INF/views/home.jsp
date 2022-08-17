<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/17/2022
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" modelAttribute="emailForm" method="post">
    <table>
        <tr>
            <td>Languages:</td>
            <td><form:select path="languages" items="${languageList}" multiple="none"></form:select></td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td><span>Show </span> <form:select path="pageSizes" items="${pageSizeList}" multiple="none"></form:select>
                <span> emails per page</span></td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td><form:checkbox path="spamsFilter"></form:checkbox> <span>Enable spams filter</span></td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"></form:textarea> <span>Enable spams filter</span></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Update</button> <button type="button">Cancel</button></td>
        </tr>


    </table>

</form:form>
</body>
</html>
