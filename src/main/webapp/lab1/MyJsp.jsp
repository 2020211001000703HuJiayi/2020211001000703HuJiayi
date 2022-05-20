<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/5/20
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My JSP</title>
</head>
<body>
    i am MyJsp.jsp<br/><br/>

    <form method="post" action="MyDearJsp.jsp">
        name<input type="text" name="name"><br/>
        class<input type="text" name="Class"><br/>
        ID<input type="text" name="id"><br/>
        <input type="submit" value="Send data to server">
    </form>
</body>
</html>
