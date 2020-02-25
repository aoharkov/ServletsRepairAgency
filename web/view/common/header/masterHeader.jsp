<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <title><fmt:message key="title" /></title>
</head>
<body>
<table>
    <tr>
        <td>
            <a href="/home?lang=${lang}">
            <img border="0" alt="Logo"
                 src="../../images/logo.png"
                 width="60" height="60">
            </a>
        </td>
        <td>
            <h1><fmt:message key="title" /></h1>
        </td>
        <td>
            <h2><a href="/master/orders?lang=${lang}&rows=4&page=1"><fmt:message key="menu.orders" /></a></h2>
        </td>
        <td>
            <h2><a href="/master/stages?lang=${lang}&rows=4&page=1"><fmt:message key="menu.stages" /></a></h2>
        </td>
    </tr>
</table>

