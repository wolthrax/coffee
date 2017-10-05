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
            <sf:form action="" method="post" modelAttribute="selectedItemsDTO">
                <table class="bordered">
                    <thead>
                        <tr>
                            <th width="70%"><spring:message code="lang.name"/></th>
                            <th width="10%"><spring:message code="lang.price"/></th>
                            <th width="20%"><spring:message code="lang.quantity"/></th>
                        </tr>
                    </thead>
                    <c:forEach var = "coffeeTypeDTO" items ="${coffeeTypeDTOList}" varStatus= "loopIndex">
                        <tr>
                            <td>
                                <sf:checkbox path="selectedTypes" label="${coffeeTypeDTO.typeName}"
                                    value="${coffeeTypeDTO.id}" id="${'checkbox'}${loopIndex.index}"
                                    onclick="enabledInput(${loopIndex.index})"/>
                            </td>
                            <td><c:out value="${coffeeTypeDTO.price} TGR"/></td>
                            <td>
                                <sf:input type="number" path="quantitySelectedItems" disabled="true"
                                          min="1" max="99"
                                          id="${'text'}${loopIndex.index}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="3">
                            <sf:button id="button" disabled="true">
                                <spring:message code="lang.order"/>
                            </sf:button>
                            <c:out value="${error}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3"></td>
                    </tr>
                </table>
            </sf:form>
        </div>
    </body>
</html>
