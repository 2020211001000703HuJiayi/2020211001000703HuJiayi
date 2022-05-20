<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/5/20
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsingServlets</title>
</head>
<body>
<%
    String name = (String) request.getParameter("name");
    String Class = (String) request.getParameter("Class");
    String ID = (String) request.getParameter("id");
%>
    <table>
        <tr><td>name: </td><td><%=name%></td></tr>
        <tr><td>submit: </td><td>Send data to server</td></tr>
        <tr><td>class: </td><td><%=Class%></td></tr>
        <tr><td>id: </td><td><%=ID%></td></tr>
    </table>
</body>
</html>
