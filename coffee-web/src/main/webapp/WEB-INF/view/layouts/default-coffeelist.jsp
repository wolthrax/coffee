<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coffee list</title>
        <script type="text/javascript" src="<c:url value="/assets/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/script.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assets/js/validation.js"/>"></script>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <link rel="stylesheet" href="<c:url value="/assets/css/table.css" />">
    </head>
    <body>
            <tiles:insertAttribute name="header"/>
        <div id="main">
            <tiles:insertAttribute name="main"/>
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>