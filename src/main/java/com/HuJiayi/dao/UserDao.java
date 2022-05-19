package com.HuJiayi.dao;

import com.HuJiayi.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {

        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "UPDATE userdb SET username=?, password=?,email=?,gender=?,birthdate=? WHERE id = ?";
        PreparedStatement sm = null;
        sm = con.prepareStatement(sql);
        sm.setString(1, user.getUsername());
        sm.setString(2,user.getPassword());
        sm.setString(3,user.getEmail());
        sm.setString(4, user.getGender());
        sm.setDate(5, (java.sql.Date) user.getBirthdate());
        sm.setInt(6,user.getId());

        int i = sm.executeUpdate();
        return i;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql = "SELECT id,username,password,email,gender,birthdate FROM usertable WHERE username='" + username + "' and password='" + password + "'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user = null;

        if(rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
           }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthdate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
