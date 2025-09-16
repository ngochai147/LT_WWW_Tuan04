<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/09/2025
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tin tức</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            text-align: center;
            margin: 20px 0;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        a {
            color: #007BFF;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>📢 Danh sách tin tức</h2>
<form action="tin-tuc" method="post">
    <div style="display: flex;justify-content: center;gap:10px">
        <label>Nhập mã danh mục</label>
        <input type="text" name="maDM" value="${sessionScope.maDanhMuc}">
        <button type="submit">Tìm</button>
    </div>
</form>

    <table>
        <thead>
        <tr>
            <th>Mã TT</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Liên kết</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dsTinTuc}" var="tinTuc">
            <tr>
                <td style="width: 50px">${tinTuc.maTT}</td>
                <td style="width: 400px">${tinTuc.tieuDe}</td>
                <td style="width: 400px">${tinTuc.noiDungTT}</td>
                <td><a href="${tinTuc.lienKet}" target="_blank">Xem chi tiết</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>

