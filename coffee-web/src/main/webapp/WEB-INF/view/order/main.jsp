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
                        <th><spring:message code="lang.name"/></th>
                        <th><spring:message code="lang.price"/></th>
                        <th><spring:message code="lang.quantity"/></th>
                        <th><spring:message code="lang.total"/></th>
                    </tr>
                </thead>
                <c:forEach var = "coffeeType" items ="${coffeeOrderDTO.coffeeTypeDTOList}" varStatus= "loopIndex">
                    <tr>
                        <td><c:out value="${coffeeType.typeName}"/></td>
                        <td><c:out value="${coffeeType.price} TGR"/></td>
                        <td><c:out value="${coffeeType.quantity}"/></td>
                        <td><c:out value="${coffeeType.cost}"/></td>
                    </tr>
                </c:forEach>
            </table>

            <table class="bordered">

                <sf:form action="addOrder" method="post" modelAttribute="coffeeOrderDTO">
                    <thead>
                    <tr>
                        <th colspan="2"><spring:message code="lang.delivery"/></th>
                    </tr>
                    </thead>
                    <tr>
                        <td width="20%"><spring:message code="lang.full_name"/></td>
                        <td width="80%">
                            <sf:input id="fullName" path="name" size="40"/>
                            <span id="valid1"></span>
                        </td>
                    </tr>
                    <tr>
                        <td><spring:message code="lang.address"/></td>
                        <td>
                            <sf:input id="address" path="address" size="40"/>
                            <span id="valid2"></span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <strong><spring:message code="lang.amount"/>:&nbsp;</strong><c:out value="${coffeeOrderDTO.sum} TGR"/><br>
                            <strong><spring:message code="lang.delivery"/>:&nbsp;</strong><c:out value="${coffeeOrderDTO.delivery} TGR"/><br>
                            <strong><spring:message code="lang.to_pay"/>:&nbsp;</strong><c:out value="${coffeeOrderDTO.total} TGR"/><br>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <sf:button id="button2" disabled="true
">
                                <spring:message code="lang.order"/>
                            </sf:button>
                            <c:out value="${error}"/>
                        </td>
                    </tr>
                </sf:form>
            </table>
        </div>
    </body>
</html>