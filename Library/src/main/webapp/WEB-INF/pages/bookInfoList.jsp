<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07.08.2021
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $('#bookInfoTableId').DataTable();
    });
</script>
<style>
    .display.DataTable {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 13px;
    }
</style>

<table id="bookInfoTableId" class="display" style="width: 100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Book</th>
        <th>Author</th>
        <th>Topic</th>
        <%-- <th>Edit</th>--%>
        <c:if test="${loginUser.role.roleName eq 'ROLE_ADMIN' or  loginUser.role.roleName eq 'ROLE_LIBRARIAN' or loginUser.role.roleName eq 'ROLE_DIRECTOR'}">
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookInfoList}" var="bil">
        <tr>
            <td>${bil.id}</td>
            <td>${bil.book.name}</td>
            <td>${bil.author.name} ${bil.author.surname}</td>
            <td>${bil.topic.name}</td>
            <c:if test="${loginUser.role.roleName eq 'ROLE_ADMIN' or  loginUser.role.roleName eq 'ROLE_LIBRARIAN' or loginUser.role.roleName eq 'ROLE_DIRECTOR'}">
                <%--<td><a href="javascript: editBookInfo('${bil.id}');">Edit</a> </td>--%>
                <td><a style="text-align: center" href="javascript: deleteBookInfo('${bil.id}');"><img width="20px"
                                                                                                       src="images/delete.png"></a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>