package com.HuJiayi.week5;

import com.HuJiayi.dao.UserDao;
import com.HuJiayi.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    String username = null;
    String password = null;

    Statement sm = null;
    ResultSet rs = null;
    String sql = null;

    User user = null;

    public void init() throws ServletException {
        super.init();

        /*ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String Username = context.getInitParameter("username");
        String Password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,Username,Password);
            System.out.println("Connection --> in LoginServlet" +con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PrintWriter out = response.getWriter();*/

        username = request.getParameter("username");
        password = request.getParameter("password");
        //System.out.println("get username: " + username + "   get password: " + password);
        UserDao userDao = new UserDao();
        try {
            user = userDao.findByUsernamePassword(con, username, password);

            if (user != null) {
                //week 8 code
                //create a session

                //add code for remember me
                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session = request.getSession();
                System.out.println("session id-->" + session.getId());
                session.setMaxInactiveInterval(10);

                // week 8  change request to session
                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                System.out.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /*sql = "SELECT id,username,password,email,gender,birthdate FROM usertable WHERE username='"+username+"'and password='" + password + "'";

        try {
            sm = con.createStatement();
            rs = sm.executeQuery(sql);

            if(rs.next())
            {
                *//*out.print("Login Successful!!!");
                out.print("Welcome," + username);*//*

                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
               *//* out.print("Username or Password Error!!!");*//*
                request.setAttribute("massage","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            System.out.println("查询失败! -- in LoginServlet.java");
            throw new RuntimeException(e);
        }*/

    }
}
