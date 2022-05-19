<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/5/19
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateUser</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Update User</h1>
<%
    User u = (User)session.getAttribute("user");
%>
<form method="post" action="updateUser">
    Id: <input type="text" name="id" readonly="true" value=<%=u.getId()%><br/>
    Username: <input type="text" name="username" value=<%=u.getUsername()%> placeholder=<%=u.getUsername()%>><br/>
    Email: <input type="text" name="email" value=<%=u.getEmail()%> placeholder=<%=u.getEmail()%>><br/>
    Gender: <input type="radio" name="gender" value="male" checked=<%=(u.getGender()=="male")?"true":"false"%>>Male
            <input type="radio" name="gender" value="female" checked="<%=(u.getGender()=="female")?"true":"false"%>">Female <br/>
    Date of Birth: <input type="date" name="birthDate" value=<%=u.getBirthdate()%> pattern="yyyy-mm-dd"><br/>
    New Password: <input type="password" name="newPassword"><br/>
    Old Password: <input type="password" name="oldPassword"><br/>
    <input type="submit" value="updateUser">
</form>
<%@include file="footer.jsp"%>
</body>
</html>
