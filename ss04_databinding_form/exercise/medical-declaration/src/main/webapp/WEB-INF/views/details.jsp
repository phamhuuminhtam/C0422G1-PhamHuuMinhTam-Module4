<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/17/2022
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Họ và Tên</td>
        <td>Năm Sinh</td>
        <td>Giới tính</td>
        <td>Quốc tịch</td>
        <td>CMND</td>
        <td>Thông tin đi lại</td>
        <td>Số hiệu phương tiện</td>
        <td>Số ghế</td>
        <td>Hành động</td>
    </tr>
    <c:forEach items="${medicalDeclarationList}" var="medicalDeclarationList" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${medicalDeclarationList.id}</td>
            <td>${medicalDeclarationList.name}</td>
            <td>${medicalDeclarationList.yearOfBirth}</td>
            <td>${medicalDeclarationList.gender}</td>
            <td>${medicalDeclarationList.nation}</td>
            <td>${medicalDeclarationList.personalCode}</td>
            <td>${medicalDeclarationList.transfer}</td>
            <td>${medicalDeclarationList.vehicleCode}</td>
            <td>${medicalDeclarationList.seatCode}</td>
            <td><button onclick="location.href='/update?id=${medicalDeclarationList.id}'">Sửa</button></td>
        </tr>
    </c:forEach>
    <a href="/">Quay về trang thêm mới</a>
</table>
</body>
</html>
