<html lang="fr">

<!-- Vérifie la langue choisie (dans l'URL) et modifie le texte de la page via le fichier Resources-->

<c:if test="${param.lang != null}">
    <fmt:setLocale value="${param.lang}" scope="session"/>
</c:if>