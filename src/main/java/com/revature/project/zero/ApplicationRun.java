package com.revature.project.zero;

import com.revature.project.zero.data.AccountDataManager;
import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.menus.AccountMenu;
import com.revature.project.zero.menus.HomeMenu;
import com.revature.project.zero.services.UserServices;
import com.revature.project.zero.tools.ConnectionFactory;
import com.revature.project.zero.tools.Menus;
import com.revature.project.zero.menus.UserMenu;
import com.revature.project.zero.elements.User;
import com.revature.project.zero.tools.ScannerFactory;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

//ApplicationRun: the class that runs the program.
public class ApplicationRun {
    static AccountDataManager accountDataManager = new AccountDataManager();
    static HomeMenu homeMenuUI;
    static UserMenu userMenuUI = new UserMenu();
    static AccountMenu accountMenuUI = new AccountMenu();
    static boolean applicationRunning = true;

    //runApplication: this is the primary program loop.
    //                more simply put it does what it says runs the application
    public static void runApplication() {
        User currentUser = new User();

        try {
            homeMenuUI = new HomeMenu();
        } catch(NoSuchAlgorithmException e) {
            System.out.println("WARN: " + e.getMessage());
        }

        while (applicationRunning) {
            if (currentUser.getCurrentAccount().getType() != 0) {
                currentUser = menuHandler(currentUser, currentUser.getCurrentAccount(),3);
            } else if (currentUser.getId() > 0) {
                currentUser = menuHandler(currentUser, currentUser.getCurrentAccount(), 2);
            } else if (currentUser.getId() == 0) {
                currentUser = menuHandler(currentUser, currentUser.getCurrentAccount(), 1);
            }
        }
        //program ends here


        ScannerFactory.closeScanner();
    }

    //menuHandler: this method decides what menu to try and print out based on where the user is in the runApplication method.
    //             once the user has selected a menu choice. decide the menu to execute that choice with
    //             User and BankAccount is passed in for accessibility purposes
    private static User menuHandler(User currentUser, BankAccount currentAccount, int menuNum) {
        int userChoice = 0;
        String caughtExString = "That input was not an option. Try Again";

        try {
            Main.logDash();
            Main.logMessage("info", currentAccount.toString());
            switch (menuNum) {
                case 1:
                    Menus.printL("\n\n");
                    userChoice = printMenu(homeMenuUI.menuUI);
                    break;
                case 2:
                    Menus.printL("\n\n");
                    userChoice = printMenu(userMenuUI.menuUI);
                    break;
                case 3:
                    if (currentAccount.getType() == 1) {
                        Menus.printL("\n\n");
                        userChoice = printMenu(accountMenuUI.checkingUI);
                        printCurrentAccount(currentUser.getCurrentAccount());

                    } else {
                        Menus.printL("\n\n");
                        userChoice = printMenu(accountMenuUI.savingUI);
                        printCurrentAccount(currentUser.getCurrentAccount());
                    }
                    break;
            }
        } catch(Exception e) {
            Menus.printL(caughtExString + e);
        }

        if (userChoice > 0) {
            switch (menuNum) {
                case 1:
                    currentUser = executeChoice(homeMenuUI, currentUser, currentAccount, userChoice);
                    break;
                case 2:
                    currentUser = executeChoice(userMenuUI, currentUser, currentAccount, userChoice);
                    break;
                case 3:
                    currentUser = executeChoice(accountMenuUI, currentUser, currentAccount, userChoice);
                    break;
            }

        }

        return currentUser;
    }

    //executeChoice: this method decides how to handle the menu choice based on the menu being passed is.
    //               User and BankAccount is passed in for accessibility purposes.
    private static User executeChoice(Menus menu, User currentUser, BankAccount currentAccount, int choice) {
        //home menu cases
        if (menu.equals(homeMenuUI)) {
            switch (choice) {
                case 1: //login
                    currentUser = homeMenuUI.signUserIn(currentUser);
                    break;

                case 2: //signup
                    homeMenuUI.createUser();
                    break;

                case 9: //exit application safely
                    try {
                        ConnectionFactory.closeConnection();
                    } catch (SQLException e) {
                        Main.logMessage("warn", e.getMessage());
                    }
                    applicationRunning = false;
                    break;

                default: //users trolling
                    Menus.invalidOption();
                    break;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //user menu cases

        if (menu.equals(userMenuUI)) {
            switch (choice) {
                case 1://Open Account Menu
                    UserServices userServices = new UserServices();
                    int id = userMenuUI.openAccount();
                    currentAccount = userServices.findUserAccount(accountDataManager.getAllAccountsById(currentUser.getId()), id);
                    Main.logMessage("info", currentAccount.toString());
                    break;

                case 2://list out bank accounts
                    userMenuUI.listAllAccounts(currentUser.getId());
                    break;

                case 3://create bank account
                    userMenuUI.createBankAccount(currentUser.getId());
                    break;

                case 9://log user out
                    currentUser = userMenuUI.signUserOut(currentUser);
                    break;

                default: //users trolling
                    Menus.invalidOption();
                    break;
            }
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //account menu cases

        if (menu.equals(accountMenuUI)) {
            switch (choice) {
                case 1://withdraw funds
                    currentAccount.setBalance(accountMenuUI.withdrawFunds(currentAccount));
                    accountDataManager.update(currentAccount);
                    break;

                case 2://deposit funds
                    currentAccount.setBalance(accountMenuUI.depositFunds(currentAccount));
                    accountDataManager.update(currentAccount);
                    break;

                case 3://transfer funds

                    break;
                case 4:// display transaction log

                    break;

                case 9://back
                    currentAccount.nullify();
                    break;

                default:
                    Menus.invalidOption();
                    break;
            }
        }
        currentUser.setCurrentAccount(currentAccount);
        return currentUser;
    }

    //printMenu: this method takes input from the user to make decisions within menus
    //           after first printing the menu
    private static int printMenu(String[] menu) {
        Scanner in = ScannerFactory.getScanner();
        Menus.printMenuUI(menu);
        return Integer.parseInt(in.nextLine());
    }

    //printCurrentAccount: easy method to print the current account being used
    //                     with a dashed line under
    private static void printCurrentAccount(BankAccount currentAccount) {
        Menus.printL(currentAccount.toString());
        Menus.printL(84);
    }

}