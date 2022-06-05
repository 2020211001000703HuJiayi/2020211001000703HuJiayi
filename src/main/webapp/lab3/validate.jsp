<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<h2>2020211001000703-HuJiayi</h2>


</body>
</html>
<%
    if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")){
        String url="welcome.jsp?username="+request.getParameter("username");
        response.sendRedirect(url);
    }else{
        request.setAttribute("message","Username Password Error");
        request.getRequestDispatcher("login.jsp").include(request,response);
    }
%>

</body>
</html>