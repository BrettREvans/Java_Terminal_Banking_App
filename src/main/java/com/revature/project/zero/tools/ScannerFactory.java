package com.revature.project.zero.tools;
import java.util.Scanner;

//ScannerFactory: Home of the singleton scanner
public class ScannerFactory {
    
    private ScannerFactory() {}

    private static Scanner scanner;

    //getScanner: gives the scanner where needed
    //            creates a scanner first time called
    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    //closeScanner: closes the scanner. used once program ends for clean end
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
