<%@ include file="header.jsp" %>

<!DOCTYPE html>
<%@ include file="language.jsp" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><fmt:message key = "title_compte"/></title>
</head>
<body>

<div align="center">
    <div class="container container-fluid">
        <div class=" raw jumbotron">
<h1><fmt:message key = "welcome_compte"/><c:out value=" ${client.prenom}"/> <c:out value=" ${client.nom}"/></h1>
<h2><fmt:message key = "list_compte"/></h2>


<c:forEach items="${client.comptes}" var="compte">
    <tr>

        <td><c:out value="${compte.id}"/></td>
        <td><c:out value="Livret ${compte.libelle}"/> : </td>

        <b><c:out value="${compte.solde}"/></b>
        <td>
            <a href="<c:url value="/transactions">
                <c:param name="id" value="${compte.id}"/>
                </c:url>">
                <fmt:message key = "more_details"/></a></td>
        </br>
    </tr>
</c:forEach>

</br>

<a href="<c:url value="/resetPassword">
                <c:param name="id" value="${compte.id}"/>
                </c:url>">
    <fmt:message key = "reset_password"/></a></td>

</br>

<a href="
    <c:url value="maketransactions">
    </c:url>">
    <fmt:message key = "make_deal"/>
</a>

<h4><fmt:message key = "create_account"/></h4>
<form method="post" action="${pageContext.request.contextPath}/detailsCompte">
    <label for="accountType"></label><br />
    <select id="accountType" name="compte_libelle">
        <option value="Livret A" selected>Livret A</option>
        <option value="Livret Jeune">Livret Jeune</option>
    </select>
    <input type="submit" class="btn btn-info" />
</form>

    <%@ include file="footer.jsp"%>
        </div>
    </div>
</div>

</body>
</html>