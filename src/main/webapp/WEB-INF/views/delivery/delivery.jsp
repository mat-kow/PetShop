<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 31.05.2020
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Edycja sposobu dostawy</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <form:form method="post" modelAttribute="deliveryDto">
            <c:if test="${successFlag}">
                <span class="success">Zapisano dane</span>
            </c:if>
            <form:errors path="name" class="error"/>
            <br/>Nazwa: <form:input type="text" path="name" /><br/>

            <form:errors path="label" class="error"/>
            <br/>Opis: <form:input type="text" path="label" /><br/>

            <form:errors path="cost" class="error"/>
            <br/>Koszt: <form:input type="number" step="0.01" min="0" path="cost" /><br/>

            <br/><input type="submit" value="Zapisz">

        </form:form>

    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
