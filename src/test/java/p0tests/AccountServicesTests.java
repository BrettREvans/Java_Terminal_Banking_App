package p0tests;

import com.revature.project.zero.elements.BankAccount;
import com.revature.project.zero.services.AccountServices;
//import org.checkerframework.checker.units.qual.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountServicesTests {



    @Test
    public void testValidateDepositMethodWithValidNumber() {
        AccountServices accountServices = new AccountServices();
        Assertions.assertEquals(100.54, accountServices.validateDeposit("100.54"));
    }

    @Test
    public void testValidateDepositMethodWithZero() {
        AccountServices accountServices = new AccountServices();
        Assertions.assertEquals(0, accountServices.validateDeposit("00"));
    }

    @Test
    public void testValidateDepositMethodWithInvalidNumber(){
        AccountServices accountServices = new AccountServices();
        Assertions.assertEquals(0, accountServices.validateDeposit("-100.54"));
    }

    @Test void testValidateWithdrawWithValueThatIsAbleToComeOutOfBalance() {
        AccountServices accountServices = new AccountServices();
        BankAccount checkingAccount = new BankAccount(100,"main", 400.54, 3, 4,1);

        Assertions.assertEquals(390.30, accountServices.validateWithdraw(checkingAccount, "10.24"));
    }
    @Test void testValidateWithdrawWithValueThatIsNotAbleToComeOutOfBalance() {
        AccountServices accountServices = new AccountServices();
        BankAccount checkingAccount = new BankAccount(100,"main", 400.54, 3, 4, 1);

        Assertions.assertEquals(400.54, accountServices.validateWithdraw(checkingAccount, "1000.24"));
    }




}
