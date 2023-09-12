package com.revature.project.zero.data;

import com.revature.project.zero.Main;
import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.elements.User;
import com.revature.project.zero.tools.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AccountDataManager implements DataManager<BankAccount> {
    @Override
    public void create(BankAccount bankAccount) {
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();

            String statement = "insert into account_list(account_name, account_balance, user_id, secondary_id, type_id) values (?, ?, ?, ?, ?)";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);

            sqlStatement.setString(1, bankAccount.getNickname());
            sqlStatement.setDouble(2, bankAccount.getBalance());
            sqlStatement.setInt(3, bankAccount.getUserId());
            sqlStatement.setInt(4, bankAccount.getSecondaryUserID());
            sqlStatement.setInt(5, bankAccount.getType());


            sqlStatement.executeUpdate();
        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage() + " : " + e.getCause());
        }
    }

    //@Override
    //public BankAccount getById(int id) {
        //return null;
    //}

    public BankAccount getById(int id, BankAccount bankAccount) {
        Connection connection = null;
        Main.logMessage("debug", "gonna connect with account database");

        try {
            connection = ConnectionFactory.getConnection();

            String statement = "select * from account_list where account_id=(?) and (user_id=? or secondary_id=?)";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            sqlStatement.setInt(1, id);
            sqlStatement.setInt(2, bankAccount.getUserId());
            sqlStatement.setInt(3, bankAccount.getSecondaryUserID());
            ResultSet resultSet = sqlStatement.executeQuery();

            if (resultSet.next()) {
                Main.logMessage("info", "results: " + resultSet.getInt("account_id"));
                bankAccount.setAccountID(resultSet.getInt("account_id"));
                bankAccount.setNickname(resultSet.getString("account_name"));
                bankAccount.setBalance(resultSet.getDouble("account_balance"));
                bankAccount.setUserId(resultSet.getInt("user_id"));
                bankAccount.setSecondaryUserID(resultSet.getInt("secondary_id"));
                bankAccount.setType(resultSet.getInt("type_id"));
            }


        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
        Main.logMessage("info", bankAccount.toString());
        return bankAccount;
    }

    @Override
    public ArrayList<BankAccount> getAll() {
        Connection connection = null;
        ArrayList<BankAccount> list = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            String statement = "select * from account_list";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            ResultSet resultSet = sqlStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new BankAccount(resultSet.getInt("account_id"),
                        resultSet.getString("account_name"),
                        resultSet.getDouble("account_balance"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("secondary_id"),
                        resultSet.getInt("type_id")
                ));
            }

        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
        return list;
    }


    public ArrayList<BankAccount> getAllAccountsById(int id) {
        Connection connection = null;
        ArrayList<BankAccount> list = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();

            String statement = "select * from account_list where user_id = ? or secondary_id = ?";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            sqlStatement.setInt(1, id);
            sqlStatement.setInt(2, id);

            ResultSet resultSet = sqlStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new BankAccount(resultSet.getInt("account_id"),
                        resultSet.getString("account_name"),
                        resultSet.getDouble("account_balance"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("secondary_id"),
                        resultSet.getInt("type_id")
                ));
            }

        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
        return list;
    }


    @Override
    public void update(BankAccount bankAccount) {
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();
            String statement = "update account_list set account_balance = ? where account_id = ?";
            PreparedStatement sqlStatement = connection.prepareStatement(statement);
            sqlStatement.setDouble(1, bankAccount.getBalance());
            sqlStatement.setInt(2, bankAccount.getAccountID());
            sqlStatement.executeUpdate();

        } catch (SQLException e) {
            Main.logMessage("warn", e.getMessage());
        }
    }

}
