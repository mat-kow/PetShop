<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <form:form method="post" modelAttribute="delivery">
            <c:if test="${successFlag}">
                <span class="success">Zapisano dane</span>
            </c:if>

            <form:errors path="name" class="error"/>
            <br/>Nazwa: <form:input type="text" name="name" path="name" /><br/>

            <form:errors path="description" class="error"/>
            <br/>Producent: <form:input type="text" name="description" path="description" /><br/>

            <form:errors path="cost" class="error"/>
            <br/>Cena: <form:input type="number" step="0.01" min="0" name="cost" path="cost" /><br/>

            <br/><input type="submit" value="Zapisz">

        </form:form>

    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
