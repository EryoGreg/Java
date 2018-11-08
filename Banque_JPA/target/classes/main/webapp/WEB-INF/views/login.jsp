<%@ include file="header.jsp"%>



<!DOCTYPE html>
<html lang="${param.lang}">
<head>
    <fmt:setLocale value="${param.lang}" scope="session"/>
    <fmt:setBundle basename="Resources.fr.ynov.Banque_JPA.bank"/>
    <title>Login JPA BANK</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div>
    <div>
        <div>
            <form action="/login" method="post">
					<span>
						<fmt:message key="signIn"/>
					</span>
                <div class="wrap-input100 validate-input m-b-16" data-validate="<fmt:message key="login"/>">
                    <input class="input100" type="text" name="login" placeholder="<fmt:message key="username"/>">
                    <span class="focus-input100"></span>
                </div>

                <div data-validate="<fmt:message key="enterPassword"/>">
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
                    <input type="submit" value='<fmt:message key="submit"/>'>
                </div>

                <div>
						<span><fmt:message key="noAccount"/></span>
                    <a href="/signup">
                        <fmt:message key="createAccount"/>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>