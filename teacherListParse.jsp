<%@ page import="az.orient.course.model.Teacher" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 3/18/17
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  List<Teacher> teacherList = (List<Teacher>)request.getAttribute("teacherList"); %>

<script type="text/javascript">

    $(function() {
        $('#teacherTableId').DataTable();
    } );

</script>

<table id="teacherTableId" class="display" cellspacing="0" width="100%" style="background-color: #ffffff">
    <thead>
    <tr>
        <th>No</th>
        <th>Ad</th>
        <th>Soyad</th>
        <th>Unvan</th>
        <th>Dogum tarixi</th>
    </tr>
    </thead>
    <tbody>
   <% for (Teacher t: teacherList) { %>
    <tr>
        <td><%=t.getId()%></td>
        <td><%=t.getName()%></td>
        <td><%=t.getSurname()%></td>
        <td><%=t.getAddress()%></td>
        <td><%=t.getDob()%></td>
    </tr>
  <% } %>

    </tbody>

</table>