<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 01.08.2021
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
    <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
    <script type="text/javascript" src="js/jquery/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
    <script type="text/javascript" src="js/main.js"></script>

    <link rel="stylesheet" type="text/css" href="css/jquery/jquery-ui.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery/jquery.dataTables.min.css"/>

</head>
<body>
<c:import url="static/header.jsp"></c:import>
<c:import url="static/information.jsp"></c:import>
<c:import url="static/menu.jsp"></c:import>
<c:import url="static/footer.jsp"></c:import>

<div class="ui-layout-center">
    <div id="newBookDialogId"></div>
    <div id="newUserDialogId"></div>
    <div id="newAuthorDialogId"></div>
    <div id="newLanguageDialogId"></div>
    <div id="newTopicDialogId"></div>
    <div id="newEmployeeDialogId"></div>
    <div id="problemUserDialogId"></div>
    <div id="returnBookDialogId"></div>
    <div id="editUserDialogId"></div>
    <div id="editAuthorDialogId"></div>
    <div id="editLanguageDialogId"></div>
    <div id="editEmployeeDialogId"></div>
    <div id="editTopicDialogId"></div>
    <div id="editBookDialogId"></div>
    <div id="editProblemUserDialogId"></div>
    <div id="editBookInfoDialogId"></div>
    <div id="newBookInfoDialogId"></div>
    <div id="newGiveBookDialogId"></div>
    <div id="editGiveBookDialogId"></div>
</div>


</body>
</html>
