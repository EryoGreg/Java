<%@ include file="header.jsp"%>
<fmt:setBundle basename="Resources.fr.ynov.Banque_JPA.bank"/>


<!DOCTYPE html>
<html lang="${param.lang}">

<c:if test="${param.lang != null}">
    <fmt:setLocale value = "${param.lang}" scope="session"/>
</c:if>

<h1>Bonjour,<c:out value="${client.prenom}"/> <c:out value="${client.nom}"/></h1>

<div>
    <h4>Solde Actuel: <c:out value="${comptes.solde}"/> euros</h4>
    <thead>
    <tr>
        <th>Libelle</th>
        <th>Montant</th>
        <br>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${comptes.transactions}" var="item">
        <tr>
            <td><c:out value="${item.libelle}"/></td>
            <td><c:out value="${item.montant}"/> euros</td>
            <br>
        </tr>
    </c:forEach>

    </tbody>
</div>
</body>
</html>