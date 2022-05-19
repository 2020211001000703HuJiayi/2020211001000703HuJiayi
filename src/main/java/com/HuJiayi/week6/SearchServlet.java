package com.HuJiayi.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");

        if(txt.isEmpty())
        {
            response.sendRedirect("search.jsp");
        }
        else {
            if(search.equals("baidu"))
            {
                response.sendRedirect("https://www.baidu.com/s?wd=" + txt);
            }
            else if(search.equals("bing"))
            {
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            }
            else if(search.equals("google"))
            {
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
