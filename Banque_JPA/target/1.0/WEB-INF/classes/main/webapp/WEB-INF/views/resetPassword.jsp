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
    <title><fmt:message key = "title_resetPassword"/></title>
</head>




<body>


<h2><fmt:message key = "title_resetPassword"/></h2>

<form id="transactionsForm" action="/resetPassword" method="post">
    <div>
        <div>
            <input name="oldpassword" placeholder="Old Password" id="oldpassword" type="password">
            <fmt:message key = "odlPassword"/><label for="oldpassword"></label>
        </div>
        <div>
            <input name="newpassword" placeholder="New Password" id="newpassword" type="password">
            <fmt:message key = "newPassword"/><label for="newpassword"></label>
        </div>
    </div>

    <button type="submit" name="action">Submit</button>


    <c:if test="${errorMsg != null}">
        <p style="color: red"> <c:out value="${errorMsg}"/> </p>
    </c:if>

</form>



</body>


<%@ include file="footer.jsp" %>

</body>
</html>