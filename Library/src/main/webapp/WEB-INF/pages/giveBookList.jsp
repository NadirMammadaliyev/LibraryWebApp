<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07.08.2021
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#giveBookTableId').DataTable();
    });
</script>
<style>
    .display.DataTable {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 13px;
    }
</style>

<table id="giveBookTableId" class="display" style="width: 100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>User</th>
        <th>Book</th>
        <th>Reading room</th>
        <th>Employee fullname</th>
        <th>Give date</th>
        <th>Return date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${giveBookList}" var="gbl">
        <tr>
            <td>${gbl.id}</td>
            <td>${gbl.user.name} ${gbl.user.surname}</td>
            <td>${gbl.book.name}</td>
            <td>${gbl.readingRoom.name}</td>
            <td>${gbl.employee.name} ${gbl.employee.surname} </td>
            <td>${gbl.dataDate}</td>
            <td>${gbl.returnDate}</td>
            <td><a href="javascript: editGiveBook('${gbl.id}');"><img width="20px" src="images/edit.png"></a></td>
            <td><a href="javascript: deleteGiveBook('${gbl.id}');"><img width="20px" src="images/delete.png"></a></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
