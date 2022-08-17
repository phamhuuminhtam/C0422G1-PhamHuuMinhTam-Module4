<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: WSWINDOWS
  Date: 08/17/2022
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Form</title>
  <link rel="stylesheet" href="/resources/styles/bootstrap.min.css">
  <style>
    label, p{
      font-weight: bolder;
    }
  </style>

</head>
<body>
<p style="text-align: center">Sửa thông tin tờ khai y tế</p>
<p style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
  THIẾT ĐỀ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</p>
<P style="text-align: center; color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể bị
  xử lý hình sự</P>
<div class="container">
  <form:form modelAttribute="MedicalDeclaration" action="/update?id=${MedicalDeclaration.id}" method="post">
    <div class="row ">
      <label>Họ tên (ghi chữ in hoa)</label>
      <form:input path="name" type="text"/>
    </div>

    <div class="row">
      <div class="col-4">
        <label>Năm sinh</label>
        <form:select path="yearOfBirth" items="${yearList}"></form:select>
      </div>
      <div class="col-4">
        <label>Giới tính</label>
        <form:select path="gender" items="${genderList}"></form:select>
      </div>
      <div class="col-4">
        <label>Quốc tich</label>
        <form:select path="nation" items="${nationList}"></form:select>
      </div>
    </div>

    <div class="row">
      <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
      <form:input path="personalCode" type="text" />
    </div>
    <div class="row">
      <label>Thông tin đi lại</label>
      <form:radiobuttons path="transfer" items="${vehicleList}"></form:radiobuttons>
    </div>
    <div class="row">
      <div class="col-6">
        <label>Số hiệu phương tiện</label>
        <form:input path="vehicleCode" type="text"/>
      </div>
      <div class="col-6">
        <label>Số ghế</label>
        <form:input path="seatCode" type="text"/>
      </div>
    </div>
    <div class="row">
      <div class="col-6">
        <label>Ngày khởi hành</label>
        <form:select path="dayOfDateStart" items="${dayList}"></form:select>
        <form:select path="monthOfDateStart" items="${monthList}"></form:select>
        <form:select path="yearOfDateStart" items="${yearList}"></form:select>
      </div>
      <div class="col-6">
        <label>Ngày kết thúc</label>
        <form:select path="dayOfDateEnd" items="${dayList}"></form:select>
        <form:select path="monthOfDateEnd" items="${monthList}"></form:select>
        <form:select path="yearOfDateEnd" items="${yearList}"></form:select>
      </div>
    </div>
    <div class="row">
      <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? </label>
      <form:textarea path="note" type="text"/>
    </div>
    <button class="btn btn-success" type="submit">Cập nhật</button>
  </form:form>
</div>

<script src="/resources/javascript/bootstrap.min.js"></script>
</body>
</html>
