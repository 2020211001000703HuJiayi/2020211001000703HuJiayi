<%--
  Created by IntelliJ IDEA.
  User: 佳佳
  Date: 2022/5/6
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<%
    // read cookies
    Cookie[] allCookies = request.getCookies();
    String username = "", password = "", rememberMeVal  = "";
    if(allCookies!=null){
        for(Cookie c: allCookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal = c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    username：<input type="text" name="username" value="<%=username%>"/><br/>
    password：<input type="password" name="password" value="<%=password%>" minlength="8"/><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>checked/>Remember Me<br/>
    <input type="submit" value="Login"/>
</form>

</body>
</html>

<%@include file="footer.jsp"%>
