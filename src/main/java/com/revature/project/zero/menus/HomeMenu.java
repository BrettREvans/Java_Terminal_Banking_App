package com.revature.project.zero.menus;
import com.revature.project.zero.elements.User;
import com.revature.project.zero.services.HomeServices;
import com.revature.project.zero.tools.Menus;
import com.revature.project.zero.tools.ScannerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HomeMenu extends Menus {
    private final Scanner input;

    private final HomeServices homeServices = new HomeServices();

    public HomeMenu() throws NoSuchAlgorithmException {

        this.input = ScannerFactory.getScanner();
    }

    // home menu display used by HomeServices
    public void createUser() {
        printL(50);
        printL("**Username Must Include:", "a letter as its first character");
        printL("Enter Desired Username: ");
        String name = input.nextLine();

        printL(50);
        printL("**Password Must Include:", "nothing for now but maybe one day this bank will care about your password security");
        printL("Enter Desired Password: ");
        String pass = input.nextLine();

        String[] strings = {name, pass};
        homeServices.createUser(strings[0], strings[1]);
    }

    public User signUserIn(User user) {
        printL("Enter Your Username: ");
        user.setUsername(input.nextLine());
        printL("Enter Your Password: ");
        user.setPassword(input.nextLine());

        return homeServices.signUserIn(user);
    }




    private String homeMenu0 =         "   ________                                     ______   __    __      __                                      _______                       __";
    private String homeMenu1 =         "  |        \\                                   /      \\ |  \\  |  \\    |  \\                                    |       \\                     |  \\";
    private String homeMenu2 =         "  | $$$$$$$$______    ______    ______        |  $$$$$$\\ \\$$ _| $$_    \\$$ ________   ______   _______        | $$$$$$$\\  ______   _______  | $$   __";
    private String homeMenu3 =         "  | $$__   /      \\  /      \\  /      \\       | $$   \\$$|  \\|   $$ \\  |  \\|        \\ /      \\ |       \\       | $$__/ $$ |      \\ |       \\ | $$  /  \\";
    private String homeMenu4 =         "  | $$  \\ |  $$$$$$\\|  $$$$$$\\|  $$$$$$\\      | $$      | $$ \\$$$$$$  | $$ \\$$$$$$$$|  $$$$$$\\| $$$$$$$\\      | $$    $$  \\$$$$$$\\| $$$$$$$\\| $$_/  $$";
    private String homeMenu5 =         "  | $$$$$ | $$   \\$$| $$    $$| $$    $$      | $$   __ | $$  | $$ __ | $$  /    $$ | $$    $$| $$  | $$      | $$$$$$$\\ /      $$| $$  | $$| $$   $$";
    private String homeMenu6 =         "  | $$    | $$      | $$$$$$$$| $$$$$$$$      | $$__/  \\| $$  | $$|  \\| $$ /  $$$$_ | $$$$$$$$| $$  | $$      | $$__/ $$|  $$$$$$$| $$  | $$| $$$$$$\\";
    private String homeMenu7 =         "  | $$    | $$       \\$$     \\ \\$$     \\       \\$$    $$| $$   \\$$  $$| $$|  $$    \\ \\$$     \\| $$  | $$      | $$    $$ \\$$    $$| $$  | $$| $$  \\$$\\";
    private String homeMenu8 =         "   \\$$     \\$$        \\$$$$$$$  \\$$$$$$$        \\$$$$$$  \\$$    \\$$$$  \\$$ \\$$$$$$$$  \\$$$$$$$ \\$$   \\$$       \\$$$$$$$   \\$$$$$$$ \\$$   \\$$ \\$$   \\$$";
    private String homeMenu9 =         "   __       __            __                                                              __      __";
    private String homeMenu10 =         "  |  \\  _  |  \\          |  \\                                                            |  \\    /  \\";
    private String homeMenu11 =         "  | $$ / \\ | $$  ______  | $$  _______   ______   ______ ____    ______    _______        \\$$\\  /  $$______   __    __";
    private String homeMenu12 =         "  | $$/  $\\| $$ /      \\ | $$ /       \\ /      \\ |      \\    \\  /      \\  /       \\        \\$$\\/  $$/      \\ |  \\  |  \\";
    private String homeMenu13 =         "  | $$  $$$\\ $$|  $$$$$$\\| $$|  $$$$$$$|  $$$$$$\\| $$$$$$\\$$$$\\|  $$$$$$\\|  $$$$$$$         \\$$  $$|  $$$$$$\\| $$  | $$";
    private String homeMenu14 =         "  | $$ $$\\$$\\$$| $$    $$| $$| $$      | $$  | $$| $$ | $$ | $$| $$    $$ \\$$    \\           \\$$$$ | $$  | $$| $$  | $$";
    private String homeMenu15 =         "  | $$$$  \\$$$$| $$$$$$$$| $$| $$_____ | $$__/ $$| $$ | $$ | $$| $$$$$$$$ _\\$$$$$$\\          | $$  | $$__/ $$| $$__/ $$";
    private String homeMenu16 =         "  | $$$    \\$$$ \\$$     \\| $$ \\$$     \\ \\$$    $$| $$ | $$ | $$ \\$$     \\|       $$          | $$   \\$$    $$ \\$$    $$";
    private String homeMenu17 =         "   \\$$      \\$$  \\$$$$$$$ \\$$  \\$$$$$$$  \\$$$$$$  \\$$  \\$$  \\$$  \\$$$$$$$ \\$$$$$$$            \\$$    \\$$$$$$   \\$$$$$$";
    private String homeMenu18 =      " ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" ;
    private String homeMenu19 =      " How Can We Help Today? \n \t1).Log in \t2).Sign Up \t9).Exit" ;

    public final String[] menuUI = {homeMenu0,homeMenu1,homeMenu2,homeMenu3,homeMenu4,homeMenu5,homeMenu6,homeMenu7,homeMenu8,homeMenu9,
            homeMenu10,homeMenu11,homeMenu12,homeMenu13,homeMenu14,homeMenu15,homeMenu16,homeMenu17,homeMenu18,homeMenu19};

}