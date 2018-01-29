<%--
  Created by IntelliJ IDEA.
  User: fuadp
  Date: 4/22/17
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    session.removeAttribute("login");
    session.invalidate();
    response.sendRedirect("login.jsp");



%>
