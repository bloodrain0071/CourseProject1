<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 4/15/17
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">

    $(function() {
        $('#studentTableId').DataTable({
            "order": [ 1, 'asc' ]
        });
    });


</script>


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