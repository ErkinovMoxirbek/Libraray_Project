package org.example.Repository;

import org.example.DB.Database;
import org.example.DTO.User;
import org.example.Enums.Role;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    public void save(User user) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement prepareStatement = con.prepareStatement("insert into user (id, name, surname,phone,pswd, createdDate, visible,role) values(?,?,?,?,?,now(),?,?);");
            prepareStatement.setInt(1,user.getId());
            prepareStatement.setString(2, user.getName());
            prepareStatement.setString(3, user.getSurname());
            prepareStatement.setString(4, user.getPhone());
            prepareStatement.setString(5,user.getPswd());
            prepareStatement.setTimestamp(5, Timestamp.valueOf(user.getCreatedDate()));
            prepareStatement.setBoolean(6,user.isVisible());
            prepareStatement.setString(7, String.valueOf(user.getRole()));
            int effectedRows = prepareStatement.executeUpdate();
            System.out.println(effectedRows);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByPhone(String phone) {
        try {
            User user = null;
            Connection con = Database.getConnection();
            PreparedStatement prepareStatement = con.prepareStatement("select * from user where phone = ?");
            prepareStatement.setString(1, phone);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getString("phone"));
                user.setPswd(resultSet.getString("pswd"));
                user.setCreatedDate((resultSet.getTimestamp("createdDate").toLocalDateTime()));
                user.setVisible(resultSet.getBoolean("visible"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }
            con.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User getUserById(Integer Id) {
        try {
            User user = null;
            Connection con = Database.getConnection();
            PreparedStatement prepareStatement = con.prepareStatement("select * from user where id = ?");
            prepareStatement.setInt(1, Id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getString("phone"));
                user.setPswd(resultSet.getString("pswd"));
                user.setCreatedDate((resultSet.getTimestamp("createdDate").toLocalDateTime()));
                user.setVisible(resultSet.getBoolean("visible"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }
            con.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUser() {
        List<User> userList = new LinkedList<>();
        try {
            Connection con = Database.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getString("phone"));
                user.setPswd(resultSet.getString("pswd"));
                user.setCreatedDate((resultSet.getTimestamp("createdDate").toLocalDateTime()));
                user.setVisible(resultSet.getBoolean("visible"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                userList.add(user);
            }
            con.close();
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean deleteByPhoneUser(String phone) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement prepareStatement = con.prepareStatement("delete from user where phone = ?");
            prepareStatement.setString(1, phone);
            int n = prepareStatement.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }public boolean deleteByIdUser(String phone) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement prepareStatement = con.prepareStatement("delete from user where id = ?");
            prepareStatement.setString(1, phone);
            int n = prepareStatement.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
