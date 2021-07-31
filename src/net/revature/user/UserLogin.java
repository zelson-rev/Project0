package net.revature.user;

import java.io.Console.*;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.*;

import static net.revature.user.UserActions.userAMenu;


public class UserLogin {
    private static String userName;
    private static String psswd;
    private static String fName;
    private static String lName;
    private static String [][] Accounts;







    public static void bankLogin() {

        Scanner inputScanner = new Scanner(System.in);
        String[] creds = {"",""};
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

            System.out.println("Welcome to EZE Bank");
            System.out.println();
            System.out.println("Please insert your username");

            userName = inputScanner.nextLine();
            System.out.println("Please enter a password");
            psswd = inputScanner.nextLine();

            creds[0] = userName;
            creds[1] = psswd;
            if(creds[0] == userName && creds[1] == psswd){
                fName = "Zach";
                lName = "Elson";
                Accounts = new String[][]{{"Checking", " 00001", "1000"}, {"Savings", " 00002","50000"}};
                userAMenu(fName, lName, Accounts);
            }
        System.out.println(date);
        }




}



