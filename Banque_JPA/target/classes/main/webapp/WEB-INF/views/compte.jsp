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

        <td><c:out value="${compte.id}"/></td>
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



<a href="<c:url value="/resetPassword">
                <c:param name="id" value="${compte.id}"/>
                </c:url>">
    <fmt:message key = "reset_password"/></a></td>



<a href="
    <c:url value="maketransactions">
    </c:url>">
    <fmt:message key = "make_deal"/>
</a>

<h3><fmt:message key = "create_account"/></h3>
<form method="post" action="${pageContext.request.contextPath}/detailsCompte">
    <label for="accountType"></label><br />
    <select id="accountType" name="compte_libelle">
        <option value="Livret A" selected>Livret A</option>
        <option value="Livret Jeune">Livret Jeune</option>
    </select>
    <input type="submit" />
</form>




</body>
<%@ include file="footer.jsp"%>

</body>
</html>