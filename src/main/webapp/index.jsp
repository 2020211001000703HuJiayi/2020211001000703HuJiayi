<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Welcome to my home page." %></h1>
    <br/>

    <a href="hello-servlet">Hello Servlet - week1</a>
    <br/>

    <a href="hello">Student Info Servlet - week2</a>
    <br/>

    <a href="life">Life Cycle Servlet - week3</a>
    <br/>

    <a href="register.jsp">Register-getParameter - week3</a>
    <br/>

    <a href="config">Config parameter - week4</a>
    <br/>

    <a href="register.jsp">Register JDBC - week4</a>
    <br/>

    <a href="index.jsp">Include - week5</a>
    <br/>

    <a href="login.jsp">Login - week5</a>
    <br/>

    <a href="search.jsp">Search - week6</a>
    <br/>

</body>
</html>
<%@include file="footer.jsp"%>