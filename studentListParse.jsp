<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="az.orient.course.model.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 3/14/17
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">

    $(function() {
        $('#studentTableId').DataTable({
            "order": [ 1, 'asc' ]
        });
        $("#accordion").accordion({
            collapsible: true
        });

        $(".dobDesign").datepicker({
            changeMonth: true,
            changeYear: true
        });

        getTeacherComboAdv();
        getLessonComboAdv();


        $('#advLessonComboId').change(function() {

            getTeacherComboByLessonId($('#advLessonComboId').val());

        });

        $('#advSearchBtnId').click(function(){

            advancedSearchStudent();





        });


    });

</script>


<div id="accordion">
    <h3>Ətraflı axtarış</h3>
    <div>
        <select id="advLessonComboId" class="cmbDesign"></select>   &nbsp;
        <select id="advTeacherComboId" class="cmbDesign"></select>
        <input type="text" id="beginDate"  placeholder="Başlanğıc tarix" class="dobDesign" />    &nbsp;
        <input type="text" id="endDate" placeholder="Son tarix" class="dobDesign" />
        <input type="button" value="Axtar" id="advSearchBtnId" />
    </div>

</div>


<div id="studentDataId1">
    <table id="studentTableId" class="display" cellspacing="0" width="100%" style="background-color: #ffffff">
        <thead>
        <tr>
            <th style="display: none">ID</th>
            <th>No</th>
            <th>Ad</th>
            <th>Soyad</th>
            <th>Unvan</th>
            <th>Dogum tarixi</th>
            <th>Muellimin ad soyadi</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach items="${studentList}" var="sl">
            <tr>
                <td style="display: none">${sl.id}</td>
                <td>${sl.r}</td>
                <td>${sl.name}</td>
                <td>${sl.surname}</td>
                <td>${sl.address}</td>
                <td>${sl.dob}</td>
                <td>${sl.teacherName} ${sl.teacherSurname}</td>
                <td><a href="javascript: editStudent('${sl.id}');">Edit</a></td>
                <td><a href="javascript: deleteStudent('${sl.id}','${sl.name} ${sl.surname}');">Delete</a></td>
            </tr>

        </c:forEach>




        </tbody>

    </table>

</div>
