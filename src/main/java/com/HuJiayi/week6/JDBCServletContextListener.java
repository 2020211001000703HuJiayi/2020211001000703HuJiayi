package com.HuJiayi.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String Username = context.getInitParameter("username");
        String Password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,Username,Password);
            System.out.println("i am in contextInitialized() -->" + con);
            context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("i am in contextDestroyed()");
        sce.getServletContext().removeAttribute("con");
    }
}
