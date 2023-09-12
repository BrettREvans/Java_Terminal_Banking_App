package com.revature.project.zero.menus;

import com.revature.project.zero.Main;
import com.revature.project.zero.data.AccountDataManager;
import com.revature.project.zero.data.UserDataManager;
import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.elements.User;
import com.revature.project.zero.services.AccountServices;
import com.revature.project.zero.services.UserServices;
import com.revature.project.zero.tools.Menus;
import com.revature.project.zero.tools.ScannerFactory;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu extends Menus {
    UserDataManager userDatabase = new UserDataManager();
    AccountDataManager accountDatabase = new AccountDataManager();

    HomeMenu homeMenu;

    AccountServices accountServices = new AccountServices();
    UserServices userServices = new UserServices();
    Scanner input = ScannerFactory.getScanner();

    //
    public int openAccount() {
        Menus.printL("Enter the Accounts ID: ");
        return Integer.parseInt(input.nextLine());
    }

    //list all the current users accounts = menu option 2
    public void listAllAccounts(int id) {
        ArrayList<BankAccount> accountArrayList = accountDatabase.getAllAccountsById(id);
        Menus.printL(50);
        for (BankAccount account: accountArrayList) {
            Menus.printL("\t" + account.toString());
        }
        Menus.printL(50);
    }

    //create bank account methods = menu option 3
    public void createBankAccount(int userId) {
        int accountType = accountTypeQuery();
        if (accountType == 1 || accountType == 2) {
            int secondaryID;
            if (jointAccountInquiry()) {
                secondaryID = jointUserInquiry();
                while(secondaryID == 0) {
                    Menus.printL("Login Failed Try Again: ");
                    secondaryID = jointUserInquiry();
                }
            } else {
                secondaryID = 0;
            }
            String name = enterAccountName();
            double deposit = enterInitialDeposit();
            userServices.createBankAccount(name, deposit, userId, secondaryID, accountType);
        }

    }

    private int accountTypeQuery() {
        Menus.printL("What Type of Account Will This Be?", "1) Checking Account\t2) Savings Account\t9) Back");
        return userServices.validateAccountType(Integer.parseInt(input.nextLine()));
    }
    private boolean jointAccountInquiry() {
        Menus.printL("Will This Be a Joint Bank Account?", "(Y)es\t(N)o");
        return userServices.jointAccountSetup(input.nextLine());
    }
    private int jointUserInquiry() {
        User user = new User();
        Menus.printL("Secondary User Please Log In: ");
        try { homeMenu = new HomeMenu(); }
        catch (NoSuchAlgorithmException e) { Main.logMessage("Warn", e.getMessage());}
        homeMenu.signUserIn(user);
        return user.getId();
    }
    private String enterAccountName() {
        Menus.printL("Enter a Name for this account");
        return input.nextLine();
    }
    private Double enterInitialDeposit() {
        Menus.printL("How much will you be depositing today?");
        return accountServices.validateDeposit(input.nextLine());
    }

    //sign out method: option 9
    public User signUserOut(User user) {
        return userServices.signUserOut(user);
    }


    private final String userMenu0 = " __       __   ______   ______  __    __        __       __  ________  __    __  __    __ ";
    private final String userMenu1 = "|  \\     /  \\ /      \\ |      \\|  \\  |  \\      |  \\     /  \\|        \\|  \\  |  \\|  \\  |  \\";
    private final String userMenu2 = "| $$\\   /  $$|  $$$$$$\\ \\$$$$$$| $$\\ | $$      | $$\\   /  $$| $$$$$$$$| $$\\ | $$| $$  | $$";
    private final String userMenu3 = "| $$$\\ /  $$$| $$__| $$  | $$  | $$$\\| $$      | $$$\\ /  $$$| $$__    | $$$\\| $$| $$  | $$";
    private final String userMenu4 = "| $$$$\\  $$$$| $$    $$  | $$  | $$$$\\ $$      | $$$$\\  $$$$| $$  \\   | $$$$\\ $$| $$  | $$";
    private final String userMenu5 = "| $$\\$$ $$ $$| $$$$$$$$  | $$  | $$\\$$ $$      | $$\\$$ $$ $$| $$$$$   | $$\\$$ $$| $$  | $$";
    private final String userMenu6 = "| $$ \\$$$| $$| $$  | $$ _| $$_ | $$ \\$$$$      | $$ \\$$$| $$| $$_____ | $$ \\$$$$| $$__/ $$";
    private final String userMenu7 = "| $$  \\$ | $$| $$  | $$|   $$ \\| $$  \\$$$      | $$  \\$ | $$| $$     \\| $$  \\$$$ \\$$    $$";
    private final String userMenu8 = " \\$$      \\$$ \\$$   \\$$ \\$$$$$$ \\$$   \\$$       \\$$      \\$$ \\$$$$$$$$ \\$$   \\$$  \\$$$$$$ ";
    private final String userMenu9 = "------------------------------------------------------------------------------------------------";
    private final String userMenu10 = "\t\tWhat Would you like to do today\n\t\t 1) Open Account\t2) List all Accounts\t3) Create New Account\t9) Log Out";

    public final String[] menuUI = {userMenu0, userMenu1, userMenu2, userMenu3, userMenu4, userMenu5, userMenu6, userMenu7, userMenu8, userMenu9, userMenu10};

    }