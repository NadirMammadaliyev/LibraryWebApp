<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.08.2021
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui-layout-east">
    <c:choose>
        <c:when test="${loginUser.role.roleName eq 'ROLE_ADMIN' or loginUser.role.roleName eq 'ROLE_DIRECTOR' or loginUser.role.roleName eq 'ROLE_LIBRARIAN'}">
            <input type="button" value="New" id="newBtnId" class="btnDesign1 button1"/>
        </c:when>
    </c:choose>
   <%-- <span style="position: absolute;bottom:6%;left: 3px"><a href="https://www.instagram.com/nadirmammadaliyev/"><img
            src="images/instav1.png"></a>  </span>
    <span style="position: absolute;top:94%;left: 33px"><a href="https://www.facebook.com/nadir.moff/"><img
            src="images/face.png"></a></span>
    <span style="position: absolute;top:94%;left: 63px;font-size: 10px;vertical-align: middle"><img
            src="images/phone_32.png"><span style="vertical-align: middle">(+994)55-306-24-29</span></span>--%>

    <div class="icon">
        <ul>
            <li><a href="https://www.instagram.com/nadirmammadaliyev/"><img src="images/instav1.png"></a> </li>
            <li><a href="https://www.facebook.com/nadir.moff/"><img src="images/face.png"></a></li>
            <li><img src="images/phone_32.png"></li>
        </ul>
    </div>
</div>
