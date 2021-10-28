<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 20.08.2021
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#giveReturnDateUpdate').datepicker({
            changeMonth: true,
            changeYear: true
        });
        $('#giveBookInputUpdate').val('${giveBook.book.id}');
        $('#giveUserInputUpdate').val('${giveBook.user.id}');
        $('#giveEmployeeCmbIdUpdate').val('${giveBook.employee.id}');
        $('#giveReadingRoomCmbIdUpdate').val('${giveBook.readingRoom.id}');
        $('#giveReturnDateUpdate').val('${giveBook.returnDate}');
    })
</script>
<div class="lblDesign">Book Id:</div>
<input list="giveBookCmbIdUpdate" type="text" id="giveBookInputUpdate">
<datalist id="giveBookCmbIdUpdate" style="width: 202px">
    <c:forEach items="${bookList}" var="bl">
        <option value="${bl.id}">${bl.name} ${bl.language.name}</option>
    </c:forEach>
</datalist>
<br/>
<div class="lblDesign">User Id:</div>
<input list="giveUserCmbIdUpdate" type="text" id="giveUserInputUpdate">
<datalist id="giveUserCmbIdUpdate" style="width: 202px">
    <c:forEach items="${userList}" var="ul">
        <option value="${ul.id}">${ul.name} ${ul.surname}</option>
    </c:forEach>
</datalist>
<div class="lblDesign">Employee:</div>
<select id="giveEmployeeCmbIdUpdate" style="width: 202px">
    <option value="0">Select Employee</option>
    <c:forEach items="${employeeList}" var="el">
        <option value="${el.id}">${el.name}</option>
    </c:forEach>
</select>
<div class="lblDesign">Reading room:</div>
<select id="giveReadingRoomCmbIdUpdate" style="width: 202px">
    <option value="0">Select Employee</option>
    <c:forEach items="${readingRoomList}" var="rl">
        <option value="${rl.id}">${rl.name}</option>
    </c:forEach>
</select>
<div class="lblDesign">Return date:</div>
<input type="text" id="giveReturnDateUpdate" placeholder="Return date">

