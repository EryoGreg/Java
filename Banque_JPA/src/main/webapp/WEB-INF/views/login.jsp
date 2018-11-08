<%@ include file="header.jsp" %>

<!DOCTYPE html>
<%@ include file="language.jsp" %>

<head>
    <title>Login JPA BANK</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div align="center">
    <div class="container container-fluid">
        <div class=" raw jumbotron">
            <form action="/login" method="post">
					<span>
						<h1><fmt:message key="signIn"/></h1>
					</span>
                <div class= "validate-input" data-validate="<fmt:message key="login"/>">
                    <input class="input100" type="text" name="login" placeholder="<fmt:message key="username"/>">
                    <span class="focus-input100"></span>
                </div>

                <div class=" form-control validate-input" data-validate="<fmt:message key="enterPassword"/>">
                    <input class="input100" type="password" name="password" placeholder="<fmt:message key="password"/>">
                    <span class="focus-input100"></span>
                </div>

                <div>
						<span>
							<fmt:message key="forgot"/>
						</span>
                </div>

                <c:if test="${errorMsg != null}">
                    <p style="color: red"> <c:out value="${errorMsg}"/> </p>
                </c:if>

                <div class=>
                    <input type="submit" class="btn btn-success" value='<fmt:message key="submit"/>'>
                </div>

            </form>
            <%@ include file="footer.jsp"%>
        </div>
    </div>

</div>
</body>
</html>