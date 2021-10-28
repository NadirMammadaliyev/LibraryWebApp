<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 19.08.2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#topicCmbIdUpdate').val('${bookInfo.topic.id}');
        $('#bookInputU').val('${bookInfo.book.id}');
        $('#authorInput').val('${bookInfo.author.id}');
        $('#updateBtn').click(function () {
            updateBookInfo();
        });
    });

    function updateBookInfo() {
        let bookId = (document.getElementById('bookInput').value);
        let authorId = (document.getElementById('authorInput').value);
        let topicId = $('#topicCmbIdUp').val();
        let data = {
            "bookId": bookId,
            "authorId": authorId,
            "topicId": topicId
        }
        $.ajax({
            url: 'cs?action=updateBookInfo',
            type: 'POST',
            dataType: 'text',
            data: data,
            success: function (response) {
                if (response == 'success') {
                    alert('Book information has been successfully updated!');
                    getBookInfoList();
                } else {
                    alert('Problem! Book information has not been successfully updated!');
                }
            }
        });
    }

    function addBookInfo() {

        let bookId = (document.getElementById('bookInp').value);
        let authorId = (document.getElementById('authorInp').value);
        let topicId = $('#topicCmbIdUp').val();
        let data = {
            "bookId": bookId,
            "authorId": authorId,
            "topicId": topicId
        }
        $.ajax({
            url: 'cs?action=addBookInfo',
            type: 'POST',
            dataType: 'text',
            data: data,
            success: function (response) {
                if (response == 'success') {
                    alert('Book information has been successfully added!');
                    getBookInfoList();
                } else {
                    alert('Problem! Book information has not been successfully added!');
                }
            }
        });
    }
</script>
<div class="lblDesign">Book:</div>
<input list="bookCmbIdUpdate" type="text" id="bookInput">
<datalist id="bookCmbIdUpdate" style="width: 202px">
    <c:forEach items="${bookList}" var="bl">
        <option value="${bl.id}">${bl.name} ${bl.language.name}</option>
    </c:forEach>
</datalist>
<br/>
<div class="lblDesign">Author:</div>
<input list="authorCmbIdUpdate" type="text" id="authorInput">
<datalist id="authorCmbIdUpdate" style="width: 202px">
    <c:forEach items="${authorList}" var="al">
        <option value="${al.id}">${al.name} ${al.surname}</option>
    </c:forEach>
</datalist>
<div class="lblDesign">Topic:</div>
<select id="topicCmbIdUpdate" style="width: 202px">
    <option value="0">Select Topic</option>
    <c:forEach items="${topicList}" var="tl">
        <option value="${tl.id}">${tl.name}</option>
    </c:forEach>
</select>
<input type="button" id="updateBtn" value="Update">
