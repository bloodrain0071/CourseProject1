<%@ page import="az.orient.course.model.Teacher" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 3/26/17
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  List<Teacher> teacherComboList = (List<Teacher>) request.getAttribute("teacherComboList"); %>


<option value="0">Select Teacher</option>


 <% for (Teacher t: teacherComboList) {  %>
<option value="<%=t.getId()%>"><%=t.getName()+" "+t.getSurname()%></option>

<% } %>