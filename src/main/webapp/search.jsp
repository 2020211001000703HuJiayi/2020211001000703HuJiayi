<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/5/13
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>

<%@include file="header.jsp"%>
    <h2>Welcome to My Online Shop Home Page.</h2><br>
    <form method="get" target="_blank" action="search">
        <input type="text" name="txt" size="30">
        <select name="search">
            <option value="baidu">Baidu</option>
            <option value="bing">Bing</option>
            <option value="google">Google</option>
        </select>
        <input type="submit" value="Search">
    </form>
<%@include file="footer.jsp"%>

</body>
</html>
