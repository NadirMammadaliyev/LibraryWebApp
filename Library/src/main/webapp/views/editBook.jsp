<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 15.08.2021
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#bookLanguageCmbIdU').val('${book.language.id}');
        $('#bookShelfCmbIdU').val('${book.shelf.id}');
    });
</script>

<div class="lblDesign">Name:</div>
<input type="text" id="bookNameIdU" placeholder="Name" value="${book.name}"/><br>
<div class="lblDesign">Language:</div>
<select id="bookLanguageCmbIdU" style="width: 202px">
    <option value="0">Select Language</option>
    <c:forEach items="${languageList}" var="ll">
        <option value="${ll.id}">${ll.name}</option>
    </c:forEach>
</select> <br>
<div class="lblDesign">Shelf:</div>
<select id="bookShelfCmbIdU" style="width: 202px">
    <option value="0">Select Shelf</option>
    <c:forEach items="${shelfList}" var="sl">
        <option value="${sl.id}">${sl.name}</option>
    </c:forEach>
</select>
<div class="lblDesign">Page:</div>
<input type="text" id="bookPageIdU" placeholder="Page" value="${book.page}"/><br>
<div class="lblDesign">Price:</div>
<input type="text" id="bookPriceIdU" placeholder="Price" value="${book.price}"/><br>
<div class="lblDesign">Date of publication:</div>
<input type="text" id="bookDateOfPublicationIdU" placeholder="Date of publication"
       value="${book.dateOfPublication}"/><br>
<div class="lblDesign">Number of book:</div>
<input type="text" id="bookNumberOfBookIdU" placeholder="Number of book" value="${book.numberOfBook}"/><br>
