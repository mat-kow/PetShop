<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 19.05.2020
  Time: 18:55
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
        <h3>Zalogowano jako <security:authentication property="principal.username" /></h3>
        <div id="form">
            <form:form method="post" modelAttribute="userDetails">
                <div id="details-box">
                    <div class="left">
                        <h1>Uzupełnij dane</h1>
                        <c:if test="${successFlag}">
                            <span class="success">Zapisano dane</span>
                        </c:if>

                        <form:errors path="firstName" class="error"/>
                        <br/><form:input type="text" name="firstName" placeholder="Imię" path="firstName" />

                        <form:errors path="lastName" class="error"/>
                        <br/><form:input type="text" name="lastName" placeholder="Nazwisko" path="lastName"/>

                        <form:errors path="address" style="color:red"/>
                        <br/><form:input type="text" name="address" placeholder="Adres" path="address"/>

                        <form:errors path="postCode" style="color:red"/>
                        <br/><form:input type="text" name="postCode" placeholder="Kod pocztowy" path="postCode"/>

                        <form:errors path="post" style="color:red"/>
                        <br/><form:input type="text" name="post" placeholder="Poczta" path="post"/>


                        <input type="submit" value="Zapisz" />
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
