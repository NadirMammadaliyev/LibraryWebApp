<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.08.2021
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="lblDesign">Name:</div>
<input type="text" id="employeeNameId" placeholder="Name"/><br/>
<div class="lblDesign">Surname:</div>
<input type="text" id="employeeSurnameId" placeholder="Suname"/><br/>
<div class="lblDesign">Position:</div>
<select style="width: 202px" id="employeePositionCmbId">
    <option value="0">Select Position</option>
    <c:forEach items='${positionList}' var='pl'>
        <option value="${pl.id}">${pl.name}</option>
    </c:forEach>
</select>
