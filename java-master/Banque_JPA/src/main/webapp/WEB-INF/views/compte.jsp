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
        <td><c:out value="${compte.libelle}"/></td>
        <button><a href="<c:out value="/detailsCompte?idCompte=${compte.id}"/>"><fmt:message key = "see_more_compte"/></a></button> <br>
    </tr>
</c:forEach>


</body>



<%@ include file="footer.jsp"%>
</body>
</html>