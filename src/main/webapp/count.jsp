<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/4/28
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>
<body>
<%! int count=0;%>
this Page has access : <%out.println(++count);%>
</body>
</html>
