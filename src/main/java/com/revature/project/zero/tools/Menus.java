package com.revature.project.zero.tools;

import com.revature.project.zero.Main;
import org.apache.log4j.Logger;

public class Menus {

    //the primary way of printing the menu ui
    public static void printMenuUI (String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // print methods: each one has a different print plan i suppose
    //  noparam: prints a empty line
    //  string param: prints the string to the console
    //  int param: prints a line of dashes
    //  strings... param: prints the first line then indents each line after
    //  the invalids are just easy ways to print an invalid string where ever needed
    public static void printL() {
        printL("");
    }
    public static void printL(String s) {
        System.out.println(s);
    }
    public static void printL(int i) {
        StringBuilder sb = new StringBuilder("");
        while(sb.length() < i) {
            sb.append("-");
        }
        printL(sb.substring(0));
    }
    public static void printL(String... strings){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i] + "\n\t");
        }
        printL(sb.substring(0));
    }
    public static void invalidCredentials() {
        String invalidString = "Username or Password is invalid";
        Menus.printL(invalidString.length()); //creates dashes
        Menus.printL(invalidString);
        Menus.printL(invalidString.length()); //creates dashes
        Menus.printL();
    }
    public static void invalidOption() {
        System.out.println("That input was not an option. Try Again");
    }

}