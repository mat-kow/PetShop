<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%--Created by IntelliJ IDEA.
  User: teo
  Date: 19.05.2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="form-style.css">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../fragments/header.jsp" %>
    </div>
    <div>
     <form method="post" modelAttribute="user">
            <div id="login-box">
                <div class="left">
                    <h1>Zaloguj się</h1>
                    <c:if test="${param.error==true}">
                        <span class="error">Błędny login albo hasło lub konto jest nie aktywne</span>
                    </c:if>
                    <br/><input type="text" name="username" placeholder="Nazwa użytkownika" autofocus/>
                    <br/><input type="password" name="password" placeholder="Hasło"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                    <input type="submit" value="Zaloguj" />
                </div>
            </div>
        </form>
    </div>

    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
