<%@ include file="header.jsp" %>

<!DOCTYPE html>
<%@ include file="language.jsp" %>

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
            <input class="form-control" name="oldpassword" placeholder="Enter old password" id="oldpassword" type="password">
            <label for="oldpassword"></label>
        </div>
        <div>
            <input class="form-control" name="newpassword" placeholder="Enter new password" id="newpassword" type="password">
            <label for="newpassword"></label>
        </div>
    </div>

    <button class="btn btn-success" type="submit" name="action">Submit</button>


    <c:if test="${errorMsg != null}">
        <p style="color: red"> <c:out value="${errorMsg}"/> </p>
    </c:if>

</form>

</body>

<%@ include file="footer.jsp" %>

</body>
</html>