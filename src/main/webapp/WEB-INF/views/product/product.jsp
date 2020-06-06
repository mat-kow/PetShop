<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 25.05.2020
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Produkt</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../../fragments/header.jsp" %>
    </div>
    <div>
        <h1>${productDto.name}</h1>
        <h3>Cena: ${productDto.price}</h3>
        <p>${productDto.description}</p>
        <img src="file/${productDto.imageMeta.name}" style="width:200px;height:200px;"/>
        <form method="post" action="addToCart">
            Ilość: <input type="number" name="quantity" value="1"/>
            <input type="hidden" name="productId" value="${productDto.id}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Dodaj do koszyka"/>
        </form>
    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
