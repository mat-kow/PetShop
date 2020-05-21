<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 19.05.2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"--%>
<%--      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">--%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../fragments/header.jsp" %>
    </div>
    <div>
        <h1>Logowanie</h1>
        <c:if test="${param.error}">
            <br/><span style="color:#ff0000">Error</span><br/><br>
        </c:if>
<%--        <div id="login_form">--%>
<%--            <form method="post" action="login">--%>
<%--                <c:if test="${errorFlag == true}">--%>
<%--                    <br/><span style="color:#ff0000">Niepoprawny login lub hasło</span><br/><br>--%>
<%--                </c:if>--%>
<%--                Nazwa użytkownika:<input type="text" name="userName"><br/><br/>--%>
<%--                Hasło: <input type="password" name="password"><br/><br/>--%>
<%--                <input type="submit" value="Zaloguj">--%>
<%--            </form>--%>
<%--        </div>--%>

        <form action="login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
            <div><input type="submit" value="Sign In"/></div>
        </form>


    </div>
    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
