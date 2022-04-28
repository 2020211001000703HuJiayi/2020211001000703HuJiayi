package com.HuJiayi.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name : Hu Jiayi");
        writer.println("ID : 2020211001000703");
        writer.println("Date and Time " + new Date());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
