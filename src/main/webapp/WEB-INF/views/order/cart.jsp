<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Twój Koszyk</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <c:if test="${empty cart}">
            <h2>Koszyk jest pusty!</h2>
        </c:if>
        <c:if test="${!empty cart}">
            <table>
                <tr>
                    <th>Produkt</th>
                    <th>Ilość</th>
                    <th>...</th>
                </tr>

                <c:forEach items="${cart}" var="orderProduct" varStatus="status">
                    <tr>
                        <td>${orderProduct.product.name}</td>
                        <td>${orderProduct.quantity}</td>
                        <td><a href="cart?deleteIndex=${status.index}">Usuń</a></td>
                    </tr>
                </c:forEach>
            </table>
            <button type="button"><a href="chooseDelivery">Dalej</a></button>
        </c:if>
    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
