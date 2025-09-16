<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/09/2025
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <style>
      .container{
        display: flex;
        flex-direction: column;
        height: 100%;
        justify-content:space-between;
      }
      img{
        width: 100%;
        object-fit: cover;
      }
      ul{
        display: flex;
        flex-direction: row;
        justify-content: center;
      }
      .header{
        border: solid 1px black;
        padding-top: 5px;
        padding-bottom: 5px;
      }
      .header ul li{
        text-decoration: underline;
        border-right: solid 1px black;
        padding-right: 5px;
        padding-left: 5px;
      }
      a{
        color: black;
        font-size: 20px
      }
      a:hover{
        color: blue;
      }
      ul li{
        padding-right: 5px;
        padding-left: 5px;
        font-size: 20px
      }
    </style>
  </head>
  <body>
  <div class="container">
    <div>
      <img src="../images/home.jpeg" alt="home">
      <div class="header">
        <ul type="none">
          <li><a href="${pageContext.request.contextPath}/tin-tuc">Danh sách tin tức</a></li>
          <li><a href="${pageContext.request.contextPath}/form-tin">Thêm tin tức mới</a></li>
          <li><a href="${pageContext.request.contextPath}/quan-ly">Chức năng quản lý</a></li>
        </ul>
      </div>
    </div>
    <div style="border: 1px solid black">
      <ul type="none">
        <li>Nguyen Huynh Ngoc Hai - </li>
        <li>22687251 -</li>
        <li>DHKTPM18CTT</li>
      </ul>
    </div>
  </div>
  </body>
</html>
