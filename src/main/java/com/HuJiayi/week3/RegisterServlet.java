package com.HuJiayi.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url",value = "jdbc:sqlserver://LAPTOP-PFBHAGS5:1433;DatabaseName=userdb;encrypt=false"),
                @WebInitParam(name = "username",value = "sa"),
                @WebInitParam(name = "password",value = "hjy103126")
        }
)
public class RegisterServlet extends HttpServlet {
    //数据库相关参数
    Connection con = null;
    PreparedStatement sm = null;
    String sql;

    public void init() throws ServletException{
        super.init();

        /*ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String Username = context.getInitParameter("username");
        String Password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,Username,Password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        sql = "INSERT INTO usertable(username,password,email,gender,birthdate) VALUES(?,?,?,?,?)";
        try {
            sm = con.prepareStatement(sql);
            sm.setString(1,username);
            sm.setString(2,password);
            sm.setString(3,email);
            sm.setString(4,gender);
            sm.setString(5,birthDate);

            int i = sm.executeUpdate();
            if(i == 1)
            {
                System.out.println("数据添加成功！");
            }

            //week - 9
            response.sendRedirect("login");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       /* PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><meta charset='utf-8'></head>");
        writer.println("<body>");
        writer.println("<table border=" + "1" + ">");
        writer.println("<tr><th>id</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthdate</th></tr>");

        ResultSet rs = null;

        int id;

        sql = "SELECT * FROM usertable";

        try {
            sm = con.prepareStatement(sql);
            rs = sm.executeQuery();

            while(rs.next())
            {
                id = rs.getInt(1);
                username = rs.getString(2);
                password = rs.getString(3);
                email = rs.getString(4);
                gender = rs.getString(5);
                birthDate = rs.getString(6);

                writer.println("<tr><th>" + id + "</th><th>" + username + "</th><th>" + password + "</th><th>" + email + "</th><th>" + gender + "</th><th>" + birthDate + "</th></tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        response.sendRedirect("login.jsp");
    }
}
