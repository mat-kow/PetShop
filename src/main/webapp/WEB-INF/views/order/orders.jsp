<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 01.06.2020
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <a href="orders?status=CREATED">Złożone</a>
        <a href="orders?status=PAID">Opłacone/Przyjęte do realizacji</a>
        <a href="orders?status=SENT">Wysłane/Gotowe do odbioru</a>
        <a href="orders?status=DELIVERED">Dostarczone/Odebrane</a><br>
        <table>
            <tr>
                <th>ID</th>
                <th>Status</th>
                <th>Wartość</th>
                <th>...</th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><a href="order?id=${order.id}">${order.id}</a></td>
                    <td>${order.status}</td>
                    <td>${order.sum}</td>
                    <td><button type="button"><a href="orders?changeStatusId=${order.id}">Zmieś status</a> </button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
