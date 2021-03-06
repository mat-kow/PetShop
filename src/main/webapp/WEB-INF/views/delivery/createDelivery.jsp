<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 31.05.2020
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Nowy sposób dostawy</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <div id="newDeliveryForm">
            <form:form method="post" modelAttribute="deliveryDto">
                <c:if test="${successFlag}">
                    <span class="success">Zapisano dane</span>
                </c:if>

                <form:errors path="name" class="error"/>
                <br/>Nazwa: <form:input type="text" path="name" /><br/>

                <form:errors path="label" class="error"/>
                <br/>Opis: <form:input type="text" path="label" /><br/>

                <form:errors path="cost" class="error"/>
                <br/>Cena: <form:input type="number" step="0.01" min="0" path="cost" /><br/>

                <br/><input type="submit" value="Zapisz">

            </form:form>
        </div>
        <div id="deliveryList">
            <h5>Dostępne opcje dostawy</h5>
            <c:if test="${empty deliveryList}">
                <p>Brak danych!</p>
            </c:if>
            <c:if test="${!empty deliveryList}">
                <table>
                    <tr>
                        <th>Nazwa</th>
                        <th>Opis</th>
                        <th>Koszt</th>
                        <th>...</th>
                        <th>...</th>
                    </tr>
                    <c:forEach items="${deliveryList}" var="deliveryDto">
                        <tr>
                            <td>${deliveryDto.name}</td>
                            <td>${deliveryDto.label}</td>
                            <td>${deliveryDto.cost}</td>
                            <td><a href="editDelivery?id=${deliveryDto.id}">Edytuj</a></td>
                            <td><a href="deleteDelivery?id=${deliveryDto.id}">Usuń</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>

    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
