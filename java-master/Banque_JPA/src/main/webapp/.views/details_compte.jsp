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
    <title><fmt:message key = "title_details_compte"/></title>
</head>
<body>
<p><fmt:message key = "client_details_compte"/><c:out value=" ${compte.libelle}"/></p>
<p><fmt:message key = "client_details_compte"/><c:out value=" ${compte.solde}"/></p>
</body>



<%@ include file="footer.jsp"%>
</body>
</html>