<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 09.08.2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="lblDesign">Name:</div>
<input type="text" id="bookNameId" placeholder="Name"/><br>
<div class="lblDesign">Language:</div>
<select id="bookLanguageCmbId" style="width: 202px">
    <option value="0">Select Language</option>
    <c:forEach items="${languageList}" var="ll">
        <option value="${ll.id}">${ll.name}</option>
    </c:forEach>
</select> <br>
<div class="lblDesign">Shelf:</div>
<select id="bookShelfCmbId" style="width: 202px">
    <option value="0">Select Shelf</option>
    <c:forEach items="${shelfList}" var="sl">
        <option value="${sl.id}">${sl.name}</option>
    </c:forEach>
</select>
<div class="lblDesign">Page:</div>
<input type="text" id="bookPageId" placeholder="Page"/><br>
<div class="lblDesign">Price:</div>
<input type="text" id="bookPriceId" placeholder="Price"/><br>
<div class="lblDesign">Date of publication:</div>
<input type="text" id="bookDateOfPublicationId" placeholder="Date of publication"/><br>
<div class="lblDesign">Number of book:</div>
<input type="text" id="bookNumberOfBookId" placeholder="Number of book"/><br>