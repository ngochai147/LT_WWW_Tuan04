<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet"><h2>View cart</h2></a>

<div style="display: grid;grid-template-columns: 300px 300px 300px 300px;gap:10px">
    <c:forEach items="${products}" var="product">
        <form action="cart" method="post">
            <div style="border: solid 1px;border-radius: 4px;display: flex;flex-direction: column;justify-content: center;align-items: center;padding: 4px">
                <img src="/Bai02_war_exploded/images/${product.urlImage}" style="width: 300px;height: 250px;object-fit: contain">
                <div>
                    <input type="text" name="name" value="${product.name}">
                    <input type="text" name="quantity" value="1">
                    <p>${product.price}</p>
                </div>
                <div>
                    <button style="padding-left: 10px;padding-right: 10px;padding-top: 8px;padding-bottom: 8px;background: green;color: white;font-weight: 700;border-radius: 4px;width: 200px;" name="action" value="add">Them vao gio</button>
                </div>
            </div>
        </form>
    </c:forEach>
</div>

</body>
</html>