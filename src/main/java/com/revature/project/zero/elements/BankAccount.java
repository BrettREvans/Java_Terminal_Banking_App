package com.revature.project.zero.elements;

import com.revature.project.zero.data.UserDataManager;

import java.util.ArrayList;

public class BankAccount {

    UserDataManager userDataManager = new UserDataManager();

    private int accountID;
    private String nickname;
    private double balance;
    private String balanceString;
    private int userId;
    private int secondaryUserID;
    private int type;

    public BankAccount(){}
    // account creation constructor
    public BankAccount(String nickname, double initalBalance, int userId, int secondaryUserID, int type){
        this.nickname = nickname;
        this.balance = initalBalance;
        this.userId = userId;
        this.secondaryUserID = secondaryUserID;
        this.type = type;
    }

    // login constructor
    public BankAccount(int accountID, String nickname, double balance, int userId, int secondaryUserID, int type) {
        this.accountID = accountID;
        this.nickname = nickname;
        this.balance = balance;
        this.userId = userId;
        this.secondaryUserID = secondaryUserID;
        this.type = type;
    }

    public int getAccountID() { return accountID; }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) { this.nickname = nickname; }


    public String getBalanceString() {
        return String.format("%.2f", balance);
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getSecondaryUserID() {
        return secondaryUserID;
    }
    public void setSecondaryUserID(int secondaryUserID) { this.secondaryUserID = secondaryUserID; }

    public int getType() {
        return type;
    }
    public void setType(int type) { this.type = type; }

    @Override
    public String toString() {
        return "Account ID: " + this.accountID + "\t Account Name: " + this.nickname + "\n\t\t\t\t Balance: " + getBalanceString() + "\t\t Secondary User: " + userDataManager.getById(secondaryUserID).getUsername() + "\n";
    }

    public void nullify() {
        accountID = 0;
        nickname = "";
        balance = 0;
        userId = 0;
        secondaryUserID = 0;
        type = 0;

    }
}
