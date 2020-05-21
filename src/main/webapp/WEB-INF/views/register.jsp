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
    <link rel="stylesheet" type="text/css" href="register.css">
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
        <form:form method="post" modelAttribute="user">
            <div id="register-box">
                <div class="left">
                    <h1>Zarejestruj się</h1>
                    <form:errors path="userName" style="color:red"/>
                    <c:if test="${userNameFlag == true}">
                        <span class="error">Wprowadzona nazwa użytkownika jest zajęta</span>
                    </c:if>
                    <br/><form:input type="text" name="username" placeholder="Nazwa użytkownika" path="userName" />
                    <form:errors path="email" style="color:red"/>
                    <c:if test="${emailFlag == true}">
                        <span class="error">Wprowadzony adres e-mail jest już używany.</span>
                    </c:if>
                    <br/><form:input type="email" name="email" placeholder="E-mail" path="email"/>
                    <form:errors path="password" style="color:red"/>
                    <br/><form:input type="password" name="password" placeholder="Hasło" path="password"/>
                    <c:if test="${password2Flag == true}">
                        <span class="error">Hasła się nie zgadzają</span>
                    </c:if>
                    <br/><input type="password" name="password2" placeholder="Powtórz hasło" />

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
