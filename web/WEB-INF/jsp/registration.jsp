<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <head>
        <title>Registration page</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/style.css" />
        <c:set var="language" value="${not empty param.language ? param.language :
              not empty language ? language : pageContext.request.locale}" scope="session"/>
        <fmt:setLocale value="${language}" />
        <fmt:setBundle basename="by.epam.task5.localization.local" var="loc" />
        <fmt:message bundle="${loc}" key="local.registrationPage" var="registrationPage" />
        <fmt:message bundle="${loc}" key="local.messageLogin" var="messageLogin" />
        <fmt:message bundle="${loc}" key="local.messagePassword" var="messagePassword" />
        <fmt:message bundle="${loc}" key="local.registerButton" var="regButton" />
        <fmt:message bundle="${loc}" key="local.confirmPassword" var="confPassword" />
        <fmt:message bundle="${loc}" key="local.regIsUsed" var="regIsUsed" />
        <fmt:message bundle="${loc}" key="local.regInvLogin" var="regInvLogin" />
    </head

    <body>
        <jsp:useBean id="user" class="by.epam.task5.entity.User" scope="request"/>
        <jsp:setProperty name="user" property="login"/>
        <jsp:setProperty name="user" property="password"/>
        <jsp:setProperty name="user" property="confirmPassword"/>

        <h1> ${registrationPage} </h1>

        <c:if test="${user.login!=null || user.password!=null || user.confirmPassword!=null}">
            <c:choose>
                <c:when test="${!user.password.equals(user.confirmPassword)}">
                    <p class="message"> <c:out value="${regInvLogin}" /> </p>
                </c:when>
                <c:when test="${!user.added}">
                    <p class="message"> <c:out value="${regIsUsed}" /> </p>
                </c:when>
            </c:choose>
        </c:if>

        <form action="Controller" method="post">
            <br/> <c:out value="${messageLogin}" /> <br/>
            <input type="text" name="login" value="" />
            <br/> <c:out value="${messagePassword}" /> <br/>
            <input type="password" name="password" value="" />
            <br/> <c:out value="${confPassword}" /><br/>
            <input type="password" name="confirmPassword" value="" />
            <input type="hidden" name="command" value="register" /> <br/><br/>
            <input type="submit" value="${regButton}" /> <br/>
        </form>
    </body>
</html>
