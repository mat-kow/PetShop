<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 24.05.2020
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Dodaj produkt</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../fragments/header.jsp" %>
    </div>
    <div>
        <h2>Dodaj nowy przedmiot</h2>
        <form:form method="post" modelAttribute="product">
            <c:if test="${successFlag}">
                <span class="success">Zapisano dane</span>
            </c:if>

            <form:errors path="name" class="error"/>
            <br/>Nazwa: <form:input type="text" name="firstName" path="name" /><br/>

            <form:errors path="manufacturer" class="error"/>
            <br/>Producent: <form:input type="text" name="manufacturer" path="manufacturer" /><br/>

            <form:errors path="supplier" class="error"/>
            <br/>Dostawca: <form:input type="text" name="supplier" path="supplier" /><br/>

            <form:errors path="ean" class="error"/>
            <br/>EAN: <form:input type="number" name="ean" path="ean" /><br/>

            <form:errors path="price" class="error"/>
            <br/>Cena: <form:input type="number" name="price" path="price" /><br/>

            <form:errors path="weightGrams" class="error"/>
            <br/>Gramatura: <form:input type="number" name="weightGrams" path="weightGrams" /> g<br/>

            <form:errors path="stock" class="error"/>
            <br/>Zapas: <form:input type="number" name="stock" path="stock" /><br/>

            <form:errors path="categories" class="error"/>
            <br/>Kategorie: <form:input type="text" name="categories" path="categories" /><br/>

            <form:errors path="description" class="error"/>
            <br/>Opis: <form:textarea type="text" name="description" path="description" /><br/>

            <form:errors path="active" class="error"/>
            <br/>Aktywny do sprzedaży: <form:checkbox name="active" path="active" /><br/>

            <br/><input type="submit" value="Zapisz">

        </form:form>
    </div>
    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
