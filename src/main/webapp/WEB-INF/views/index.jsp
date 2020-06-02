<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 18.05.2020
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Strona główna</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../fragments/header.jsp" %>
    </div>
    <div>
        <div>
            <h1>Witaj w moim sklepie</h1>
            <p>Zapraszam do wypróbowania sklepu, który własnoręcznie napisałem. Jest do bardzo wczesna wersja, wiele rzeczy jeszcze nie działa wcale,
            albo nie tak jak powinno. Frontend (to co wyświetla przeglądarka) praktycznie nie istnieje, w wielu miejscach wyświetlają się placeholdery,
            zdjęcia nie skalują się odpowiednio - w najbliższym czasie będę to usprawniał.<br/>
            Strona nie jest i najprawdopodobniej nie będzie przystosowana do wyświetlania na małych ekranach(smartfony)</p>
            <p>Wersja z dnia 02 czerwca 2020</p><br>
        </div>
        <div>
            <h2>Przykładowe produkty:</h2>
            <c:forEach items="${products}" var="product">
                <h5><a href="product?id=${product.id}">${product.name}</a> </h5>
            </c:forEach>
        </div>
    </div>
    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
