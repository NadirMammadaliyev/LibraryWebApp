<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.08.2021
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $('#employeeListTableId').DataTable();
</script>
<style>
    .display.DataTable {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 13px;
    }
</style>

<table id="employeeListTableId" class="display" style="width: 100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Position</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="el">
        <tr>
            <td>${el.id}</td>
            <td>${el.name}</td>
            <td>${el.surname}</td>
            <td>${el.position.name}</td>
            <c:if test="${loginUser.role.roleName eq 'ROLE_ADMIN' or  loginUser.role.roleName eq 'ROLE_LIBRARIAN' or loginUser.role.roleName eq 'ROLE_DIRECTOR'}">
                <td><a href="javascript: editEmployee('${el.id}');"><img width="20px" src="images/edit.png"></a></a>
                </td>
                <td><a href="javascript: deleteEmployee('${el.id}','${el.name} ${el.surname}');"><img width="20px"
                                                                                                      src="images/delete.png"></a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>


