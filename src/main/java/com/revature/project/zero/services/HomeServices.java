package com.revature.project.zero.services;

import com.revature.project.zero.Main;
import com.revature.project.zero.data.UserDataManager;
import com.revature.project.zero.elements.User;
import com.revature.project.zero.tools.Menus;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//HomeServices: class to handle the validation and function of the home menu
public class HomeServices {
    private UserDataManager userDataManager;
    private final MessageDigest messageDigest;

    //HomeServices: Constructor that throws a NoSuchAlgorithmException
    //              instantiates encrypter and userDataManager
    public HomeServices() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("SHA-512");
        this.userDataManager = new UserDataManager();
    }

    //createUser: method takes a username and password
    //            validates they are at least 1 character in length
    //            before creating a new user with username and an encrypted password
    public void createUser(String username, String password) {
        if (username.length() > 0 && password.length() > 0) {
            Main.logMessage("debug", "About to create a new user");
            User newUser = new User(username, securePassword(password));
            userDataManager.create(newUser);
        } else {
            Menus.invalidCredentials();
        }

        Main.logDash();
    }

    //signUserIn: takes the user object so far and passes it to the datamanager
    //            when the user object comes back the id is checked
    //            to ensure the user is complete before signing them in
    public User signUserIn(User user) {
        Main.logMessage("debug", "About to log in an existing user" + user.getUsername());

        user.setPassword(securePassword(user.getPassword()));
        user = userDataManager.getByUser(user);

        if (user.getId() == 0) {
            Main.logMessage("info", "The Credentials are invalid");
            user.nullify();
            Menus.invalidCredentials();
        } else {
            Main.logMessage("debug", "User credentials are valid");
        }
        Main.logDash();
        return user;
    }

    //securePassword: takes the password and encrypts it before
    //                either being created with a new user or logging in
    private String securePassword(String pass) {
        return new String(messageDigest.digest(pass.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }


}



















































































































//creation validation for username and password
//    private boolean validateUserNameCreation (String name) {
//        Main.logMessage("debug", "Validating creation data");
//        //pattern reads: First character is a letter, followed by zero or more characters
//        Pattern usernamePattern = Pattern.compile("^[A-Za-z].*");
//        Matcher nameIsValid = usernamePattern.matcher(name);
//
//        Main.logMessage("info", "the username is " + nameIsValid.find());
//        return nameIsValid.find();
//    }



///////Garbage/cut feature
///
//
//
//        Pattern passwordPattern = Pattern.compile("(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])");//
//        Matcher passwordIsValid = passwordPattern.matcher(pass);
//        Main.logMessage("info", "the password is " + nameIsValid.find());
//if (nameIsValid.find() && name.length() > 5) {
//        //if name is valid check validity of password
//        //if (passwordIsValid.find()) {
//        //if password is valid return true
//
//        //}
//        Main.logMessage("info", "Creation data valid");
//        return true;
//        }
//        //by now something is invalid thanks to nested ifs
//        Main.logMessage("debug", "Creation data is invalid");
//        return false;