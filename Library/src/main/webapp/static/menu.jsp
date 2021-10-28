<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.08.2021
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui-layout-west">
    <c:choose>
        <c:when test="${loginUser.role.roleName eq 'ROLE_USER'}">
            <input type="button" value="Statistics" id="statisticsDataBtnId" class="btnDesign">
            <input type="button" value="Books" id="bookDataBtnId" class="btnDesign">
            <input type="button" value="Book Info" id="bookInfoDataBtnId" class="btnDesign">
            <input type="button" value="Authors" id="authorDataBtnId" class="btnDesign"/>
            <input type="button" value="Language" id="languageDataBtnId" class="btnDesign">
            <input type="button" value="Topic" id="topicDataBtnId" class="btnDesign">
        </c:when>
        <c:when test="${loginUser.role.roleName eq 'ROLE_LIBRARIAN'}">
            <input type="button" value="Users" id="userDataBtnId" class="btnDesign"/>
            <input type="button" value="Give" id="giveBookDataBtnId" class="btnDesign">
            <input type="button" value="Problemic Users" id="problemUserDataBtnId" class="btnDesign">
            <input type="button" value="Return" id="returnBookDataBtnId" class="btnDesign">
            <input type="button" value="Statistics" id="statisticsDataBtnId" class="btnDesign">
            <input type="button" value="Books" id="bookDataBtnId" class="btnDesign">
            <input type="button" value="Book Info" id="bookInfoDataBtnId" class="btnDesign">
            <input type="button" value="Authors" id="authorDataBtnId" class="btnDesign"/>
            <input type="button" value="Language" id="languageDataBtnId" class="btnDesign">
            <input type="button" value="Topic" id="topicDataBtnId" class="btnDesign">
        </c:when>
        <c:otherwise>
            <input type="button" value="Users" id="userDataBtnId" class="btnDesign"/>
            <input type="button" value="Give" id="giveBookDataBtnId" class="btnDesign">
            <input type="button" value="Problemic Users" id="problemUserDataBtnId" class="btnDesign">
            <input type="button" value="Return" id="returnBookDataBtnId" class="btnDesign">
            <input type="button" value="Statistics" id="statisticsDataBtnId" class="btnDesign">
            <input type="button" value="Employee" id="employeeDataBtnId" class="btnDesign">
            <input type="button" value="Books" id="bookDataBtnId" class="btnDesign">
            <input type="button" value="Book Info" id="bookInfoDataBtnId" class="btnDesign">
            <input type="button" value="Authors" id="authorDataBtnId" class="btnDesign"/>
            <input type="button" value="Language" id="languageDataBtnId" class="btnDesign">
            <input type="button" value="Topic" id="topicDataBtnId" class="btnDesign">
        </c:otherwise>
    </c:choose>

</div>
