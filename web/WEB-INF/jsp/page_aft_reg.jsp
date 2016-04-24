<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="${sessionScope.language}">
<head>
  <title>User Page</title>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="css/style.css" />
  <c:set var="language" value="${not empty param.language ? param.language :
        not empty language ? language : pageContext.request.locale}" scope="session"/>
  <fmt:setLocale value="${language}" />
  <fmt:setBundle basename="by.epam.task5.localization.local" var="loc" />
  <fmt:message bundle="${loc}" key="local.successfulRegistration" var="sucReg"/>
  <fmt:message bundle="${loc}" key="local.loginButton" var="loginBtn" />
</head>

<body>

<h1> <c:out value="${sucReg}" /> </h1>
<form action="Controller" method="post">
  <input type="hidden" name="command" value="to-index-page" />
  <input type="submit" value="${loginBtn}" />
</form>
</body>
</html>
