<%@ include file="header.jsp"%>

<fmt:setBundle basename="Resources.fr.ynov.Banque_JPA.bank"/>

<!DOCTYPE html>
<html lang="${param.lang}">

<c:if test="${param.lang != null}">
    <fmt:setLocale value = "${param.lang}" scope="session"/>
</c:if>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><fmt:message key = "title_compte"/></title>
</head>
<body>
<p><fmt:message key = "welcome_compte"/><c:out value=" ${client.prenom}"/> <c:out value=" ${client.nom}"/></p>
<h2><fmt:message key = "list_compte"/></h2>


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


<%--<c:import var="compte" url="/solde"/>
<c:out value="${soldejson}"/>--%>

<a class="waves-effect waves-light btn blue darken-3" href="
    <c:url value="maketransactions">
    </c:url>">Virement<i class="material-icons right">send</i>
</a>


</body>

<%@ include file="footer.jsp"%>




<a href="<c:url value="/resetPassword">
                <c:param name="id" value="${compte.id}"/>
                </c:url>">
    <fmt:message key = "reset_password"/></a></td>
</body>
</html>