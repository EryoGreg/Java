<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<fmt:setBundle basename="Resources.fr.ynov.Banque_JPA.bank"/>
<html>
<head>
    <title>Comptes</title>
    <script type = "text/javascript"
            src = "https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
    </script>

    <script>

        (function($){

            $(function(){
                $('select').not('.disabled').formSelect();

            });
        })(jQuery);

    </script>
</head>
<body>


<h1>Bonjour, <c:out value="${client.prenom}"/> <c:out value="${client.nom}"/></h1>


<div class="container">
    <form id="transactionsForm" action="/maketransactions" method="post">
        <div class="row">
            <div class="input-field col s4">
                <select  name="from" form="transactionsForm">
                    <option value="" disabled selected>Choose your option</option>
                    <c:forEach items="${client.comptes}" var="item">
                        <option value="<c:out value="${item.id}"/>"><c:out value="${item.libelle}"/></option>
                    </c:forEach>
                </select>
                <label>Select your  account</label>
            </div>


            <div class="input-field col s4">
                <input name="to" placeholder="Account to be credited" id="account_credited" type="number" step="0.01">
                <label for="account_credited">Enter the number of the account to be credited</label>
            </div>

            <div class="input-field col s6">
                <input name="amount" placeholder="Amount" id="amount_money" type="number" step="0.01">
                <label for="amount_money">Amount</label>
            </div>

            <div class="input-field col s6">
                <input name="libelle" placeholder="Libelle" id="lib" type="text">
                <label for="lib">Libelle</label>
            </div>
        </div>

        <button class="btn waves-effect waves-light" type="submit" name="action">Submit
            <i class="material-icons right">send</i>
        </button>

    </form>
</div>
</body>
</html>
