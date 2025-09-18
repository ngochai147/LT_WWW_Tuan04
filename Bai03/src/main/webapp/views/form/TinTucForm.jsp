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
    <title>Thêm tin tức</title>
</head>
<body>
<h2 style="text-align: center;">Form nhập tin tức</h2>

<form action="form-tin" method="post" style="width: 400px; margin: auto;">
    <div style="margin-bottom: 10px;">
        <label>Mã tin tức (MATT):</label><br>
        <input type="text" name="maTT" value="${tinTuc.maTT}" style="width: 100%;" >
        <c:forEach var="err" items="${errors}">
            <c:if test="${err.propertyPath eq 'maTT'}">
                <span style="color: red">${err.message}</span>
            </c:if>
        </c:forEach>
    </div>

    <div style="margin-bottom: 10px;">
        <label>Tiêu đề:</label><br>
        <input type="text" name="tieuDe" value="${tinTuc.tieuDe}" style="width: 100%;" >
        <c:forEach var="err" items="${errors}">
            <c:if test="${err.propertyPath == 'tieuDe'}">
                <span style="color: red">${err.message}</span>
            </c:if>
        </c:forEach>
    </div>

    <div style="margin-bottom: 10px;">
        <label>Nội dung:</label><br>
        <textarea name="noiDungTT" rows="4" style="width: 100%;" value="${tinTuc.noiDungTT}"></textarea>
        <input type="text" name="tieuDe" value="${tinTuc.tieuDe}" style="width: 100%;" >
        <c:forEach var="err" items="${errors}">
            <c:if test="${err.propertyPath == 'noiDungTT'}">
                <span style="color: red">${err.message}</span>
            </c:if>
        </c:forEach>
    </div>

    <div style="margin-bottom: 10px;">
        <label>Liên kết:</label><br>
        <input type="text" name="lienKet" value="${tinTuc.lienKet}" style="width: 100%;">
        <c:forEach var="err" items="${errors}">
            <c:if test="${err.propertyPath == 'lienKet'}">
                <span style="color: red">${err.message}</span>
            </c:if>
        </c:forEach>
    </div>

    <div style="margin-bottom: 10px;">
        <label>Mã danh mục (MADM):</label><br>
        <select name="maDM" style="width: 100%;padding-top: 4px;padding-bottom: 4px">
           <c:forEach items="${listDanhMuc}" var="DanhMuc">
               <option value="${DanhMuc.maDM}">${DanhMuc.maDM}</option>
           </c:forEach>
        </select>
    </div>

    <div style="text-align: center;">
        <input type="submit" value="Lưu tin tức"/>
    </div>
</form>

</body>
</html>
