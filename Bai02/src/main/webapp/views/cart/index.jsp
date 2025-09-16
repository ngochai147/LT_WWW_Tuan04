<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 16/09/2025
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table style="border: solid 1px black;width: 100%">
        <thead>
        <tr>
            <td style="border: solid 1px black">STT</td>
            <td style="border: solid 1px black">Tên sản phẩm</td>
            <td style="border: solid 1px black">Số lượng</td>
            <td style="border: solid 1px black">Giá</td>
            <td style="border: solid 1px black">Tổng tiền</td>
            <td style="border: solid 1px black">Action</td>
        </tr>
        </thead>
        <tbody>
<%--        <c:if test="${getLineCount()==0}">--%>
<%--            <td>Cart is empty</td>--%>
<%--        </c:if>--%>
    <a href="list-product"><h2>View product</h2></a>
        <c:forEach items="${sessionScope.cart.getCartItem()}" var="cartItem">
            <form action="cart" method="post">
                <tr>
                    <td style="border: solid 1px black" >
                        <input name="index" value="${cartItem.id}"/>
                    </td>
                    <td style="border: solid 1px black">${cartItem.product.name}</td>
                    <td style="border: solid 1px black">
                        <input name="quantity" value="${cartItem.quantity}"/>
                    </td>
                    <td style="border: solid 1px black">${cartItem.product.price}</td>
                    <td style="border: solid 1px black">${cartItem.getTotalPrice()}</td>
                    <td style="display: flex;justify-content: center;gap: 5px;border: solid 1px black">
                        <button type="submit" style="width: 40%;background: red;color: white;padding-top: 5px;padding-bottom: 5px" name="action" value="update"> Update</button>
                        <button type="submit" style="width: 40%;background: blue;color: white;padding-top: 5px;padding-bottom: 5px" name="action" value="Delete"> Delete</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        <tr>
            <td colspan="5" style="text-align: right;border: solid 1px black">Tong tien</td>
            <td style="text-align: center;border: solid 1px black">${sessionScope.cart.totalOrder()}</td>
        </tr>
        </tbody>
    </table>
</body>
</html>
