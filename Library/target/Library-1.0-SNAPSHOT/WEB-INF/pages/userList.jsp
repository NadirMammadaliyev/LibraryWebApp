<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.08.2021
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#userTableId').DataTable();
    });
</script>
<style>
    .display.DataTable {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 13px;
    }
</style>

<table id="userTableId" class="display" style="width: 100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Date of birth</th>
        <th>IdentityNumber</th>
        <th>Mail</th>
        <th>Phone</th>
        <th>User activity</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="ul">
        <tr>
            <td>${ul.id}</td>
            <td>${ul.name}</td>
            <td>${ul.surname}</td>
            <td>${ul.dob}</td>
            <td>${ul.identityNumber}</td>
            <td>${ul.mail}</td>
            <td>${ul.phone}</td>
            <td>${ul.userActivity}</td>
            <td><a href="javascript: editUser('${ul.id}');"><img width="20px" src="images/edit.png"></a></td>
            <td><a href="javascript: deleteUser('${ul.id}','${ul.name} ${ul.surname}');"><img width="20px"
                                                                                              src="images/delete.png"></a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
