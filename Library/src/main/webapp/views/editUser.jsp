<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 14.08.2021
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#userDobId').datepicker({
            changeMonth: true,
            changeYear: true
        });
    });
</script>
<div class="lblDesign">Name:</div>
<input type="text" id="userNameIdU" placeholder="Name" value="${user.name}"/> <br>
<div class="lblDesign">Surname:</div>
<input type="text" id="userSurnameIdU" placeholder="Surname" value="${user.surname}"/> <br>
<div class="lblDesign">Date of Birth:</div>
<input type="text" id="userDobIdU" placeholder="Date of birth" value="${user.dob}"/> <br>
<div class="lblDesign">Identity number:</div>
<input type="text" id="identityNumberIdU" placeholder="Identity number" value="${user.identityNumber}"/> <br>
<div class="lblDesign">Mail:</div>
<input type="email" id="userMailIdU" placeholder="Mail" value="${user.mail}"/> <br>
<div class="lblDesign">Phone:</div>
<input type="text" id="userPhoneIdU" placeholder="Phone" value="${user.phone}"/> <br>
<div class="lblDesign">User Activity:</div>
<input type="text" id="userActivityIdU" placeholder="User Activitiy" value="${user.userActivity}"/> <br>
