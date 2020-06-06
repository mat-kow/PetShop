<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 21.05.2020
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Panel administratora</title>
</head>
<body>
<div id="container">
    <div id="header">
        <%@ include file="../fragments/header.jsp" %>
    </div>
    <div>
        <c:if test="${empty users}">
            <p>Brak użytkowników</p>
        </c:if>
        <c:if test="${!empty users}">
            <table>
                <tr>
                    <th>Login</th>
                    <th>Aktywny</th>
                    <th>Uprawnienia</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>email</th>
                    <th>...</th>
                    <th>...</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userName}</td>
                        <td>${user.active}</td>
                        <td>${user.roles}</td>
                        <td>${user.userDetailsDto.firstName}</td>
                        <td>${user.userDetailsDto.lastName}</td>
                        <td>${user.email}</td>
                        <td><a href="admin?active=${!user.active}&id=${user.id}">Zablokuj/odblokuj</a></td>
                        <td>
                            <form method="post">
                                <input type="hidden" name="id" value="${user.id}"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <select name="role">
                                    <c:forEach var="role" items="${roles}">
                                        <option value="${role}" ${role == user.roles ? 'selected="selected"' : ''}>${role}</option>
                                    </c:forEach>
                                </select>
                                <input type="submit" value="Zmień uprawnienia"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <div id="footer">
        <%@ include file="../fragments/footer.jsp" %>
    </div>
</div>
</body>
</html>
