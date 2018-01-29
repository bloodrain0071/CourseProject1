<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 4/1/17
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">


    $(function() {
        $('#dobId1').datepicker({
            changeMonth: 'true',
            changeYear: 'true'
        });

       editTeacherCombo('${student.teacherId}');
    });


</script>


<div class="lblDesign">Name</div>    <input type="text" id="nameId1" value="${student.name}"  /> <br>
<div class="lblDesign">Surname</div>     <input type="text" id="surnameId1" value="${student.surname}"  /> <br>
<div class="lblDesign">Date of Birth</div>     <input type="text" id="dobId1" value="${student.dob}"  /> <br>
<div class="lblDesign">Address</div>     <input type="text" id="addressId1" value="${student.address}"  /> <br>
<div class="lblDesign">Teacher</div>   <select id="teacherComboId1" class="cmbDesign">

</select>


