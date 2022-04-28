<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/4/22
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<%@include file="../header.jsp"%>
    This is my register page.<br/><br/>
    <form method="post" action="../register">
        username<input type="text" name="username"/><br/>
        password<input type="password" name="password" minlength="8"/><br/>
        Email<input type="email" name="email"/><br/>
        Gender: <input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
        Date of Birth :<input type="date" name="birthDate" pattern="yyyy-mm-dd"><br/>
        <input type="submit" value="register"/>
    </form>
<%@include file="../footer.jsp"%>

</body>
</html>
