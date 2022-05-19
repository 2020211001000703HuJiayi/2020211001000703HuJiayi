package com.HuJiayi.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");

        PrintWriter writer = response.getWriter();
        writer.println("name: " + name);
        writer.println("studentId: " + studentId);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
