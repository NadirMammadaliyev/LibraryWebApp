<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 20.08.2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.removeAttribute("loginUser");
    session.invalidate();
    response.sendRedirect("login.jsp");

%>
