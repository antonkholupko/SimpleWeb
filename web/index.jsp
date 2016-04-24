<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <head>
        <title>Start Page</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="css/style.css" />
        <c:set var="language" value="${not empty param.language ? param.language :
             not empty language ? language : pageContext.request.locale}" scope="session"/>
        <fmt:setLocale value="${language}" />
        <fmt:setBundle basename="by.epam.task5.localization.local" var="loc" />
        <fmt:message bundle="${loc}" key="local.messageHello" var="messageHello" />
        <fmt:message bundle="${loc}" key="local.messageInfo" var="messageInfo" />
        <fmt:message bundle="${loc}" key="local.messageLogin" var="messageLogin" />
        <fmt:message bundle="${loc}" key="local.loginButton" var="logButton" />
        <fmt:message bundle="${loc}" key="local.messagePassword" var="messagePassword" />
        <fmt:message bundle="${loc}" key="local.messageInvLogin" var="messageInvLogin" />
        <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
        <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
        <fmt:message bundle="${loc}" key="local.goToRegisterPageButton" var="regButton"/>
    </head>

    <body>
        <jsp:useBean id="user" class="by.epam.task5.entity.User" scope="session" />
        <jsp:setProperty name="user" property="rightLogin"/>
        <jsp:setProperty name="user" property="login"/>
        <jsp:setProperty name="user" property="password"/>
        <jsp:setProperty name="user" property="rightPassword"/>
        <div>
            <form class="locale-buttons" action="Controller" method="post">
                <input type="hidden" name="language" value="ru" />
                <input type="submit" value="${ru_button}" />
            </form>
            <form class="locale-buttons" action="Controller" method="post">
                <input type="hidden" name="language" value="en" />
                <input type="submit" value="${en_button}" />
            </form>
            </div>
        <h1> <c:out value="${messageHello}"/> </h1> <br/>
        <p> <c:out value="${messageInfo}"/> </p>

        <form action="Controller" method="post">
            <c:if test="${user.login!=null || user.password!=null}">
                <c:if test="${!user.rightLogin || !user.rightPassword}">
                    <p class="message"> <c:out value="${messageInvLogin}" /> </p>
                </c:if>
            </c:if>
            <br/> <c:out value="${messageLogin}"/> <br/>
            <input type="text" name="login" value=""/>
            <br/> <c:out value="${messagePassword}"/> <br/>
            <input type="password" name="password" value=""/> <br/>  <br/>
            <input type="hidden" name="command" value="login"/>
            <input type="submit" value=${logButton} /> <br/>
        </form>

        <form action="Controller" method="post">
            <input type="hidden" name="command" value="to-registration" />
            <input type="submit" value=${regButton}/>
        </form> <br/>

    </body>

</html>
