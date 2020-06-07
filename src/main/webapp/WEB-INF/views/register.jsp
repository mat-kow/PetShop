<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 20.05.2020
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="form-style.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Zarejestruj się</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../fragments/header.jsp" %>
    </div>
    <div>
        <form:form method="post" modelAttribute="userDto">
            <div id="register-box">
                <div class="left">
                    <h1>Zarejestruj się</h1>
                    <form:errors path="userName" style="color:red"/>
                    <br/><form:input type="text" name="username" placeholder="Nazwa użytkownika" path="userName" />

                    <form:errors path="email" style="color:red"/>
                    <br/><form:input type="email" name="email" placeholder="E-mail" path="email"/>

                    <form:errors path="password" style="color:red"/>
                    <br/><form:input type="password" name="password" placeholder="Hasło" path="password"/>

                    <form:errors path="doubledPassword" style="color:red"/>
                    <br/><form:input type="password" placeholder="Powtórz hasło" path="doubledPassword"/>

                    <input type="submit" value="Zarejestuj" />
                </div>
            </div>
        </form:form>

    </div>
    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
