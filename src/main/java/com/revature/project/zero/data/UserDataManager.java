package com.revature.project.zero.data;
import com.revature.project.zero.Main;
import com.revature.project.zero.elements.User;
import com.revature.project.zero.tools.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class UserDataManager implements DataManager<User> {

    @Override
    public void create(User user) {
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();
            String statement = "insert into user_list(username, password) values (?, ?)";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            sqlStatement.setString(1, user.getUsername());
            sqlStatement.setString(2, user.getPassword());
            sqlStatement.executeUpdate();

        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
    }

   // @Override
    public User getById(int id) {
        Connection connection;
        User user = new User();

        try {
            connection = ConnectionFactory.getConnection();
            String statement = "select * from user_list where user_id = ?";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            sqlStatement.setInt(1, id);
            ResultSet resultSet =  sqlStatement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
        return user;
    }


    public User getByUser(User user) {
        Main.logMessage("debug", "about to contact DB and validate user info ");
        Connection connection;

        try {
            connection = ConnectionFactory.getConnection();
            String statement = "select * from user_list where username = ? and password = ?";

            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            sqlStatement.setString(1, user.getUsername());
            sqlStatement.setString(2, user.getPassword());

            Main.logMessage("info", "select * from userlist where username = " + user.getUsername());
            ResultSet resultSet = sqlStatement.executeQuery();

            if (resultSet.next()){
                if (user.getUsername().equals(resultSet.getString("username")) && user.getPassword().equals(resultSet.getString("password"))) {
                    user.setId(resultSet.getInt("user_id"));
                }
            }
        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        } catch (Exception e) {
            Main.logMessage("warn", e.getMessage());
        }
        return user;
    }

    @Override
    public ArrayList<User> getAll() {
        Connection connection;
        ArrayList<User> userList = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            String statement = "select * from user_list";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            ResultSet resultSet =  sqlStatement.executeQuery();

            while (resultSet.next()) {
                userList.add(new User(resultSet.getInt("user_id"), resultSet.getString("username"), resultSet.getString("password")));
            }
        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
        return userList;
    }

    @Override
    public void update(User user) {

    }
}
