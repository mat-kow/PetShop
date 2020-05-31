<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 30.05.2020
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Szczegóły zamówienia</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <h2>Dane so wysyłki:</h2>
        ${userDetails.firstName} ${userDetails.lastName}<br>
        ${userDetails.address}<br>
        ${userDetails.postCode} ${userDetails.post}<br><br>

        <h2>Dostawa:</h2>
        <form method="post" action="summary">
            <c:forEach var="delivery" items="${deliveryOptions}">
                <input type="radio" name="delivery" value="${delivery.name}"> ${delivery.description} (${delivery.cost})<br>
            </c:forEach>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Dalej">
        </form>
    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
