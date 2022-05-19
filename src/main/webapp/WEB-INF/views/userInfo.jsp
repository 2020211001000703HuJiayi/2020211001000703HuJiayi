<%@ page import="com.HuJiayi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/5/13
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
  User u = (User)session.getAttribute("user");
%>
<table>
  <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=u.getBirthdate()%></td></tr>
    <tr>
      <a href="updateUser">Update User</a>
    </tr>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
