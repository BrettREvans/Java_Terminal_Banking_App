package com.revature.project.zero.elements;

import com.revature.project.zero.Main;
import com.revature.project.zero.data.AccountDataManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {
    private BankAccount currentAccount = new BankAccount();

    private int id;
    private String username;
    private String password;

    public User() {}

    // used for create user
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // used to log user in
    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //Getters N Setters
    public BankAccount getCurrentAccount() { return currentAccount; }

    public void setCurrentAccount(BankAccount currentAccount) { this.currentAccount = currentAccount; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String s) { this.username = s; }

    public String getPassword() { return password; }

    public void setPassword(String s) { this.password = s; }

    // nullify: nulls the user's information for logging out
    public void nullify(){
        this.id = 0;
        Main.logMessage("info", "id is now: " + this.id);
        this.username = null;
        Main.logMessage("info", "user is now: " + this.username);
        this.password = null;
        Main.logMessage("info", "password is now: " + this.password);
        this.currentAccount = new BankAccount();
        Main.logDash();
    }

    //Overridden Methods
    @Override
    public String toString() {
        return "username: " + this.username;
    }
}
