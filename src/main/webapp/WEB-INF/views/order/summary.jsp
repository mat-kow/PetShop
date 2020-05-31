<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 30.05.2020
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Potwierdź zamówienie</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <table>
            <tr>
                <th>Nazwa</th>
                <th>Ilość</th>
                <th>Suma</th>
            </tr>
        <c:forEach var="orderProduct" items="${order.products}">
            <tr>
                <td>${orderProduct.product.name}</td>
                <td>${orderProduct.quantity}</td>
                <td>${orderProduct.sum}</td>
            </tr>
        </c:forEach>
            <tr>
                <td>Sposób dostawy</td>
                <td>${order.delivery.description}</td>
                <td>${order.delivery.cost}</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>${order.sum}</td>
            </tr>
        </table>
        <button type="button"><a href="confirmOrder">Zamawiam!</a> </button>
    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
