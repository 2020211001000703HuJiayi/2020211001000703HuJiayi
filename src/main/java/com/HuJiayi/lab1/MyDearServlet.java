package com.HuJiayi.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyDearServlet", value = "/MyDearServlet")

public class MyDearServlet extends HttpServlet {

    public void init() throws ServletException{
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String Class = request.getParameter("Class");
        String ID = request.getParameter("id");

        request.setAttribute("name",name);
        request.setAttribute("Class",Class);
        request.setAttribute("id",ID);
        request.getRequestDispatcher("WEB-INF/MyDearJsp.jsp").forward(request,response);

    }
}
