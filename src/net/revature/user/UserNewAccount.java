package net.revature.user;

import java.util.Locale;
import java.util.Scanner;

import static net.revature.UserMenu.clearScreen;
import static net.revature.UserMenu.menu;

public class UserNewAccount {
    private static Object scanner;
    public static boolean joint = false;
    public static boolean savings = false;
    public static void userNewAccount(){
        clearScreen();
        System.out.println("Thank You for Choosing EZE Bank");
        System.out.println("________________________________");
        System.out.println("What Type of Account Would you Like to open?" );
        System.out.println("(C)hecking");

        System.out.println("(S)avings");
        System.out.println("E(x)it");

        Scanner scanner = new Scanner(System.in);

        char input = scanner.next().charAt(0);

        if (input == 'x' || input == 'X'){
            System.out.println("Would you like to go back to the main menu?    (Y)es/(N)o");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response =='y'){
                clearScreen();
                menu();
            }else{
                scanner.close();
                System.exit(0);
                clearScreen();
                System.out.println("Have a Wonderful Day");
            }

        }else {
            switch(input){
                case 'c':
                case 'C':
                {
                    jointAccountQ();
                    System.out.println("opening a checking account " + joint);
                    if (joint){
                        jointAccount(savings);
                        }else
                    {
                        singleAccount(savings);
                    }
                    break;
                }
                case 's':
                case 'S':
                {
                    jointAccountQ();
                    System.out.println("opening a savings account" + joint);
                    savings = true;
                    if (joint){
                        jointAccount(savings);
                        break;
                    }else
                    {
                        singleAccount(savings);
                        break;
                    }

                }
                default:{
                    clearScreen();
                    System.out.println("Your input was invalid!!!!");
                    userNewAccount();
                }
            }
        }

    }

    private static void jointAccount(boolean savings) {
        clearScreen();
        Scanner jascanner = new Scanner(System.in);
        System.out.println("Please Enter the Primary Account holders First Name");
        String primaryAccFirst = jascanner.nextLine().trim();
        System.out.println("Please Enter the Primary Account holders Last Name");
        String primaryAccLast = jascanner.nextLine().trim();
        System.out.println("Please Enter the Primary Account holders Street Number");
        int primaryAccStreetnum= jascanner.nextInt();
        jascanner.nextLine();

        System.out.println("Please Enter the Primary Account holders Street Name");
        String primaryAccAddStreet = jascanner.nextLine().trim();


        System.out.println("Please Enter the Primary Account holders City");
        String primaryCity = jascanner.nextLine().trim();
        System.out.println("Please Enter the Primary Account holders State 2 letters please");
        String primaryState = jascanner.nextLine().trim().toUpperCase();
        System.out.println("Please Enter the Primary Account zip code");
        int primaryZip = jascanner.nextInt();
        jascanner.nextLine();
        System.out.println("Please Enter the Primary Account holders SSN");
        String primarySSD = jascanner.nextLine().trim();
        System.out.println("Do you and a debit card for the account (Y)es or (N)o");
        char primaryDebit = jascanner.next().charAt(0);
        jascanner.nextLine();

        clearScreen();
        System.out.println("Please Confirm the data we have collected");
        System.out.println(primaryAccFirst + " " + primaryAccLast + "\n" + primaryAccStreetnum + " "+ primaryAccAddStreet
        + "\n" + primaryCity + " " + primaryState+ " " + primaryZip + "\n" + primarySSD + "\n"+
                "Debit Card Requested " +primaryDebit);

        System.out.println("Enter Yes to confirm");
        char accconfirm = jascanner.next().charAt(0);
        jascanner.nextLine();

        if (accconfirm == 'n' || accconfirm == 'N') {
            clearScreen();
            System.out.println(accconfirm);

            jointAccount(savings);
//            System.out.println("Information Was not correct");
        }
//        System.out.println("you made it through the first part LOL"); //This was just to make sure
        System.out.println("Please Enter the Secondary Account holders First Name");
        String secondaryAccFirst = jascanner.nextLine().trim();
        System.out.println("Please Enter the Secondary Account holders Last Name");
        String secondaryAccLast = jascanner.nextLine().trim();
        System.out.println("Is the address the same as the primary account holders? Y or N" );
        char sameadd = jascanner.nextLine().trim().charAt(0);
        jascanner.nextLine();
        int secodaryAccStreetnum;
        String secondaryAccAddStreet;
        String secondaryCity;
        String secondaryState ;
        int secondaryZip;

        if (sameadd == 'n' || sameadd=='N'){
            System.out.println("Please Enter the Secondary Account holders Street Number");
            secodaryAccStreetnum= jascanner.nextInt();
            jascanner.nextLine();
            System.out.println("Please Enter the Secondary Account holders Street Name");
            secondaryAccAddStreet = jascanner.nextLine().trim();
            System.out.println("Please Enter the Secondary Account holders City");
            secondaryCity = jascanner.nextLine().trim();
            System.out.println("Please Enter the Secondary Account holders State 2 letters please");
            secondaryState = jascanner.nextLine().trim().toUpperCase();
            System.out.println("Please Enter the Secondary Account zip code");
            secondaryZip = jascanner.nextInt();
            jascanner.nextLine();
        }else{
           secodaryAccStreetnum = primaryAccStreetnum;
           secondaryAccAddStreet = primaryAccAddStreet;
           secondaryCity = primaryCity;
           secondaryState = primaryState;
           secondaryZip = primaryZip;


        }

        System.out.println("Please Enter the Secondary Account holders SSN");
        String secondarySSD = jascanner.nextLine().trim();
        System.out.println("Do you and a debit card for the account (Y)es or (N)o");
        char secondaryDebit = jascanner.next().charAt(0);
        jascanner.nextLine();



        clearScreen();
        System.out.println("Please Confirm the data we have collected");
        System.out.println(secondaryAccFirst + " " + secondaryAccLast + "\n" + secodaryAccStreetnum + " "+ secondaryAccAddStreet
                + "\n" + secondaryCity + " " + secondaryState+ " " + secondaryZip + "\n" + secondarySSD + "\n"+
                "Debit Card Requested " +secondaryDebit);

        System.out.println("Enter Yes to confirm");
         accconfirm = jascanner.next().charAt(0);

         if (accconfirm == 'y' || accconfirm == 'Y'){
             // write to DB
         }
         else{
             clearScreen();
             jointAccount(savings);
         }


    }

    private static void singleAccount(boolean savings) {
        joint = false;
    }

    public static void jointAccountQ(){
        clearScreen();
        System.out.println("Will This be a Joint account? (Y)es / (N)o");
        Scanner js= new Scanner(System.in);
        char jsin= js.next().charAt(0);
        if(jsin == 'Y' || jsin == 'y'){
            joint = true;
        }
    }

}
