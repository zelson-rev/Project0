package net.revature;

import java.io.IOException;
import java.util.Scanner;

import static net.revature.user.UserLogin.bankLogin;

public class UserMenu {
    public static void menu(){

        System.out.println("EZE Bank Menu");
        System.out.println("Please Select an option.");
        System.out.println("(L)ogin to my account.");
        System.out.println("(O)pen an account.");
        System.out.println("(E)xit!!!");

        Scanner scanner= new Scanner(System.in);
        char liScanner = scanner.next(".").charAt(0);

        switch(liScanner) {
            case 'L':
            case 'l': {
//                scanner.close();
                bankLogin();
                break;
            }
            case 'O':
            case 'o': {
                System.out.println("You chose case b");
                break;
            }

            case 'E':
            case 'e': {
                System.out.println("Thank you Have a great day");
                System.exit(0);

            } default: {
                System.out.println("Please Provide a valid input");

                clearScreen();
                menu();
            }
        }


    }



    public static void clearScreen() {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;    //works but inefficient
            System.out.flush();

        }


    }
}
