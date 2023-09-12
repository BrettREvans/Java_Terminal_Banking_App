package com.revature.project.zero.services;

import com.revature.project.zero.Main;
import com.revature.project.zero.data.AccountDataManager;
import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.elements.User;

import java.util.ArrayList;

//UserServices: class to handle the validation and function of the User Menu
public class UserServices {
    AccountDataManager accountDataManager = new AccountDataManager();

    //findUserAccount: method used to loop through the user account list
    //                 to find correct account based on the id given
    public BankAccount findUserAccount(ArrayList<BankAccount> accounts, int id) {
        Main.logMessage("debug", "looking for account with id: " + id);
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountID() == id) {
                Main.logMessage("info", "this account has id of " + accounts.get(i).getAccountID());
                return accounts.get(i);
            }
        }
        Main.logMessage("Info", "no account id in user list");
        return new BankAccount();
    }

    //createBankAccount: method used to validate that the account is ready to be created
    //                   before creating it
    public void createBankAccount( String name, double deposit, int userId, int secondaryId, int type) {
        if (type > 0) {
            BankAccount newAccount = new BankAccount(name, deposit, userId, secondaryId, type);
            accountDataManager.create(newAccount);
            Main.logMessage("info", newAccount.toString());
        }
    }

    //validateAccountType: this method validates the type of account you want
    //                    returns as an invalid option of zero if users choice doesnt align
    public int validateAccountType(int choice) {
        if (choice == 1 || choice == 2) {
            return choice;
        }else {
            return 0;
        }
    }

    //jointAccountSetup: method takes a string in to check if user is going to make joint account
    //                   if that string starts with a y return true
    //                   else return false
    public boolean jointAccountSetup(String choice) {
        if (choice.toLowerCase().charAt(0) == 'y') {
            return true;
        }
        return false;
    }

    //signUserOut: this method takes the user in
    //             then calls the users nullify method
    public User signUserOut(User user) {
        Main.logMessage("debug", "About to nullify user data");
        user.nullify();
        return user;
    }

}
