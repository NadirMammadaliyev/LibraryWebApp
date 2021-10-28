<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 08.08.2021
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#statisticsTableId').DataTable();
    });
</script>
<style>
    .display.DataTable {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 13px;
    }
</style>

<table id="statisticsTableId" class="display" style="width: 100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>User activity</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userStatistList}" var="ul">
        <tr>
            <td>${ul.id}</td>
            <td>${ul.name}</td>
            <td>${ul.surname}</td>
            <td>${ul.userActivity}</td>

        </tr>
    </c:forEach>

    </tbody>
</table>
