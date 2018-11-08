<html lang="fr">

<c:if test="${param.lang != null}">
    <fmt:setLocale value="${param.lang}" scope="session"/>
</c:if>