package com.revature.project.zero.services;

import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.tools.Menus;

public class AccountServices {
    //validateWithdraw: validates that the amount to withdraw does not overdraft the account
    //                  if it does overdraft, return the balance as it was
    //                  otherwise, return withdraw minus the current balance
    public double validateWithdraw(BankAccount bankAccount, String withdrawAmount) {
        try {
            if (bankAccount.getBalance() - Double.parseDouble(withdrawAmount) >= 0) {
                return bankAccount.getBalance() - Double.parseDouble(withdrawAmount);
            } else {
                Menus.invalidOption();
            }
        }catch (Exception e) {
            Menus.invalidOption();
        }

        return bankAccount.getBalance();
    }

    //validateDeposit: validates the deposit before returning the string as a double
    //                 if the deposit is invalid zero will be returned
    public double validateDeposit(String depositAmount) {
        try {


            if (Double.parseDouble(depositAmount) >= 0) {
                return Double.parseDouble(depositAmount);
            } else {
                Menus.invalidOption();
            }
        }catch (Exception e) {
            Menus.invalidOption();
        }
        return 0;
    }
}
