<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    </head>
    <body>
        <div class="divTable">
            <table class="bordered">
                <thead>
                    <tr>
                        <th><spring:message code="lang.delivery"/></th>
                    </tr>
                </thead>
                    <tr>
                        <td><a href="/coffee/"><spring:message code="lang.to_delivery_page"/></a></td>
                    </tr>
            </table>
        </div>
    </body>
</html>