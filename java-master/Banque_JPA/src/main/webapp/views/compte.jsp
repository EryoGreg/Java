<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<fmt:setLocale value="${param.lang}" scope="session"/>
<fmt:setBundle basename="Resources.fr.ynov.Banque_JPA.bank"/>

<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="/login" method="post">
					<span class="login100-form-title">
						<fmt:message key="signIn"/>
					</span>

                <div class="wrap-input100 validate-input m-b-16" data-validate="<fmt:message key="login"/>">
                    <input class="input100" type="text" name="login" placeholder="<fmt:message key="username"/>">
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="<fmt:message key="enterPassword"/>">
                    <input class="input100" type="password" name="password" placeholder="<fmt:message key="password"/>">
                    <span class="focus-input100"></span>
                </div>

                <div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							<fmt:message key="forgot"/>
						</span>

                    <a href="#" class="txt2">
                        <fmt:message key="usernamePassword"/>
                    </a>
                </div>

                <c:if test="${errorMsg != null}">
                    <p style="color: red"> <c:out value="${errorMsg}"/> </p>
                </c:if>

                <div class="container-login100-form-btn">
                    <input type="submit" class="login100-form-btn" value='<fmt:message key="submit"/>'>

                </div>

                <div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							<fmt:message key="noAccount"/>
						</span>

                    <a href="/signup" class="txt3">
                        <fmt:message key="createAccount"/>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="loaders/scriptLoader.jsp"></jsp:include>

<ul>
    <li><a href="?lang=fr">Français</a></li>
    <li><a href="?lang=en">Anglais</a></li>
</ul>



</body>
</html>