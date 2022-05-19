package com.HuJiayi.week8;

import com.HuJiayi.dao.UserDao;
import com.HuJiayi.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;

    Statement sm = null;
    ResultSet rs = null;
    String sql = null;

    User user = null;
    public void init() throws ServletException{
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String newpassword = request.getParameter("newPassword");
        String password = request.getParameter("oldPassword");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date ubirthDate;
        try {
            ubirthDate = sdf.parse(birthDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if(newpassword!=null) password = newpassword;
        User user = new User(id, username, password, email, gender, ubirthDate);
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(con,user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp");
    }
}
