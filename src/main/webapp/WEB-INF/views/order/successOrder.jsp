<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 31.05.2020
  Time: 11:49
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
        <h2>Zamóienie o numerze ${orderId} zostało przyjęte do realizacji</h2>
    </div>
    <div id="footer">
        <%@ include file="../../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
