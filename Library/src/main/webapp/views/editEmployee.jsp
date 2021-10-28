<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 15.08.2021
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $('#employeePositionCmbIdU').val('${employee.position.id}');
</script>
<div class="lblDesign">Name:</div>
<input type="text" id="employeeNameIdU" placeholder="Name" value="${employee.name}"/><br/>
<div class="lblDesign">Surname:</div>
<input type="text" id="employeeSurnameIdU" placeholder="Suname" value="${employee.surname}"/><br/>
<div class="lblDesign">Position:</div>
<select id="employeePositionCmbIdU">
    <option value="0">Select Position</option>
    <c:forEach items='${positionList}' var='pl'>
        <option value="${pl.id}">${pl.name}</option>
    </c:forEach>
</select>

