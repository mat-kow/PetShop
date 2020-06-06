<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 02.06.2020
  Time: 12:40
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
        <h1>Zamówienie nr ${orderDto.id}</h1>
        <h2>Status: ${orderDto.status}</h2>
        <h2>Dostawa: ${orderDto.deliveryDto.label}</h2>
        <h2>Kupujący: </h2>
        ${orderDto.userDto.userDetailsDto.firstName} ${orderDto.userDto.userDetailsDto.lastName}<br>
        ${orderDto.userDto.userDetailsDto.address}<br>
        ${orderDto.userDto.userDetailsDto.postCode} ${orderDto.userDto.userDetailsDto.post}<br><br>
        <h2>Lista towarów:</h2>
        <table>
            <tr>
                <th>[pozycja]</th>
                <th>Nazwa</th>
                <th>EAN</th>
                <th>Ilość</th>
            </tr>
            <c:forEach var="orderProduct" items="${orderDto.productsDto}">
                <tr>
                    <td>[pozycja]</td>
                    <td>${orderProduct.productDto.name}</td>
                    <td>${orderProduct.productDto.ean}</td>
                    <td>${orderProduct.quantity}</td>
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
