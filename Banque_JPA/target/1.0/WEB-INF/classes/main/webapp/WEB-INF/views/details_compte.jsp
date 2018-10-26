<%@ include file="header.jsp" %>

<fmt:setBundle basename="Resources.fr.ynov.Banque_JPA.bank"/>

<!DOCTYPE html>
<html lang="${param.lang}">

<c:if test="${param.lang != null}">
    <fmt:setLocale value="${param.lang}" scope="session"/>
</c:if>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><fmt:message key="title_details_compte"/></title>
</head>

<body>

<c:forEach items="${client.comptes}" var="compte">
    <tr>
        <td><c:out value="Livret ${compte.libelle}"/></td>

        <td><c:out value="${compte.solde}"/></td>

        <td>
            <a href="<c:url value="/transactions">
                <c:param name="id" value="${compte.id}"/>
                </c:url>">
                <fmt:message key = "more_details"/></a></td>
        </br>
    </tr>
</c:forEach>
</body>

<%@ include file="footer.jsp" %>

</body>
</html>