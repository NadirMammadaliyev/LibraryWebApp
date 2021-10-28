<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10.08.2021
  Time: 15:52
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
<input type="text" id="userNameId" placeholder="Name"/> <br>
<div class="lblDesign">Surname:</div>
<input type="text" id="userSurnameId" placeholder="Surname"/> <br>
<div class="lblDesign">Date of Birth:</div>
<input type="text" id="userDobId" placeholder="Date of birth"/> <br>
<div class="lblDesign">Identity number:</div>
<input type="text" id="identityNumberId" placeholder="Identity number"/> <br>
<div class="lblDesign">Mail:</div>
<input type="email" id="userMailId" placeholder="Mail"/> <br>
<div class="lblDesign">Phone:</div>
<input type="text" id="userPhoneId" placeholder="Phone"/> <br>

