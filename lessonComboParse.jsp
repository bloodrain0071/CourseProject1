<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 4/11/17
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<option value="0">Select Lesson</option>


<c:forEach items="${lessonList}" var="ll">
    <option value="${ll.id}">${ll.lessonName}</option>

</c:forEach>





