<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.08.2021
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#bookTableId').DataTable();
    })
</script>
<style>
    .display.DataTable {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 13px;
    }
</style>

<table id="bookTableId" class="display" style="width: 100%">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Language</th>
        <th>Page</th>
        <th>Date of Publication</th>
        <th>Shelf</th>
        <th>Price</th>
        <th>Number of book</th>
        <th>Information</th>
        <c:if test="${loginUser.role.roleName eq 'ROLE_ADMIN' or  loginUser.role.roleName eq 'ROLE_LIBRARIAN' or loginUser.role.roleName eq 'ROLE_DIRECTOR'}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="bl">
        <tr>
            <td>${bl.id}</td>
            <td>${bl.name}</td>
            <td>${bl.language.name}</td>
            <td>${bl.page}</td>
            <td>${bl.dateOfPublication}</td>
            <td>${bl.shelf.name}</td>
            <td>${bl.price}</td>
            <td>${bl.numberOfBook}</td>
            <td><a href="javascript: infoBook('${bl.id}');"><img width="20px" src="images/information_32.png"></a></a>
            </td>
            <c:if test="${loginUser.role.roleName eq 'ROLE_ADMIN' or  loginUser.role.roleName eq 'ROLE_LIBRARIAN' or loginUser.role.roleName eq 'ROLE_DIRECTOR'}">
                <td><a href="javascript: editBook('${bl.id}');"><img width="20px" src="images/edit.png"></a></a> </td>
                <td><a href="javascript: deleteBook('${bl.id}','${bl.name}');"><img width="20px"
                                                                                    src="images/delete.png"></a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>

</table>
