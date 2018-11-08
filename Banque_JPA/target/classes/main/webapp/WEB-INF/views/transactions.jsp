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
    <title><fmt:message key="title_details_compte"/></title>
</head>


<body>
<h1>Bonjour,<c:out value="${client.prenom}"/> <c:out value="${client.nom}"/></h1>

<div>
    <h4>Solde Actuel: <c:out value="${comptes.solde}"/> euros</h4>

    <tbody>
    <c:forEach items="${comptes.transactions}" var="item">
        <tr>
            <fmt:message key = "destinataire_Transaction"/>
            <td><c:out value="${item.compte_destination.id}"/></td>

            <fmt:message key = "date_Transaction"/>
            <td><c:out value="${item.date}"/></td>

            <fmt:message key = "libelle_transaction"/>
            <td><c:out value="${item.libelle}"/></td>"

            <fmt:message key = "montant_Transaction"/>
            <td><c:out value="${item.montant}"/> euros</td>
            <br>
        </tr>
    </c:forEach>

    </tbody>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>