package com.revature.project.zero.menus;

import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.services.AccountServices;
import com.revature.project.zero.tools.Menus;
import com.revature.project.zero.tools.ScannerFactory;
import java.util.Scanner;

public class AccountMenu extends Menus {
    AccountServices accountServices = new AccountServices();
    Scanner input = ScannerFactory.getScanner();

    public double withdrawFunds (BankAccount account) {
        Menus.printL("How much do you wish to withdraw?");
        return accountServices.validateWithdraw(account, input.next());
    }

    public double depositFunds (BankAccount account) {
        Menus.printL("How much will you be depositing today?");
        return account.getBalance() + accountServices.validateDeposit(input.next());
    }




    private String options = "\t 1) Withdraw\t 2) Deposit\t 3) Transfer Funds\t 4) Display Transaction Log\t 9) Back" ;

    private String checkingString0 = "    ______   __                            __        __";
    private String checkingString1 = "   /      \\ |  \\                          |  \\      |  \\";
    private String checkingString2 = "  |  $$$$$$\\| $$____    ______    _______ | $$   __  \\$$ _______    ______";
    private String checkingString3 = "  | $$   \\$$| $$    \\  /      \\  /       \\| $$  /  \\|  \\|       \\  /      \\";
    private String checkingString4 = "  | $$      | $$$$$$$\\|  $$$$$$\\|  $$$$$$$| $$_/  $$| $$| $$$$$$$\\|  $$$$$$\\";
    private String checkingString5 = "  | $$   __ | $$  | $$| $$    $$| $$      | $$   $$ | $$| $$  | $$| $$  | $$";
    private String checkingString6 = "  | $$__/  \\| $$  | $$| $$$$$$$$| $$_____ | $$$$$$\\ | $$| $$  | $$| $$__| $$";
    private String checkingString7 = "   \\$$    $$| $$  | $$ \\$$     \\ \\$$     \\| $$  \\$$\\| $$| $$  | $$ \\$$    $$";
    private String checkingString8 = "    \\$$$$$$  \\$$   \\$$  \\$$$$$$$  \\$$$$$$$ \\$$   \\$$ \\$$ \\$$   \\$$ _\\$$$$$$$";
    private String checkingString9 = "                                                                  |  \\__| $$";
    private String checkingString10= "                                                                   \\$$    $$";
    private String checkingString11= "                                                                    \\$$$$$$";


    private String savingString0 = "    ______                       __";
    private String savingString1 = "   /      \\                     |  \\";
    private String savingString2 = "  |  $$$$$$\\  ______  __     __  \\$$ _______    ______    _______";
    private String savingString3 = "  | $$___\\$$ |      \\|  \\   /  \\|  \\|       \\  /      \\  /       \\";
    private String savingString4 = "   \\$$    \\   \\$$$$$$\\\\$$\\ /  $$| $$| $$$$$$$\\|  $$$$$$\\|  $$$$$$$";
    private String savingString5 = "   _\\$$$$$$\\ /      $$ \\$$\\  $$ | $$| $$  | $$| $$  | $$ \\$$    \\";
    private String savingString6 = "  |  \\__| $$|  $$$$$$$  \\$$ $$  | $$| $$  | $$| $$__| $$ _\\$$$$$$\\";
    private String savingString7 = "   \\$$    $$ \\$$    $$   \\$$$   | $$| $$  | $$ \\$$    $$|       $$";
    private String savingString8 = "    \\$$$$$$   \\$$$$$$$    \\$     \\$$ \\$$   \\$$ _\\$$$$$$$ \\$$$$$$$";
    private String savingString9 = "                                              |  \\__| $$";
    private String savingString10= "                                               \\$$    $$";
    private String savingString11= "                                                \\$$$$$$";
    private String savingString12= "------------------------------------------------------------------------------------";

    public final String[] checkingUI = {checkingString0,checkingString1,checkingString2,checkingString3,checkingString4,checkingString5,checkingString6,checkingString7,checkingString8,checkingString9,checkingString10,checkingString11, savingString12, options};
    public final String[] savingUI = {savingString0,savingString1,savingString2,savingString3,savingString4,savingString5,savingString6,savingString7,savingString8,savingString9,savingString10,savingString11, savingString12, savingString12, options};
}

