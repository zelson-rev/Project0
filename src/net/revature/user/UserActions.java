package net.revature.user;

import java.util.Scanner;

public class UserActions {
    private  String fName;
    private String lName;
    private String Accounts [][];



    static void userAMenu(String first, String last, String[][] Accounts){


        System.out.println("Hello " + first + " "+ last);
        System.out.println("Which account do you want to access?");
        int count = 0;
        char charind = 'a';

             for (String[] account : Accounts) {
                 System.out.print("(" + charind +")"+ " " + account[0]);
                 System.out.print(account[1]);
                 System.out.println(" Balance: " + account[2]);
                 count++;
                 charind ++;

             }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Or (q) to quit");
        char input = scanner.next().charAt(0);

        {
            charind  = (char) (charind - 1);
            System.out.println(charind);

            if (input == 'q'){

            } else if (!(input <= charind)  ){
            System.out.println("invalid input please try again");
            userAMenu(first, last, Accounts);
        }

            switch (input){
                case 'a':{
                    System.out.println('a');
                    break;
                }
                case 'b':{
                    System.out.println('b');
                    break;
                }
                case 'c':{
                    System.out.println('c');
                    break;
                }
                case 'd':{
                    System.out.println('d');
                    break;
                }
                case 'e':{
                    System.out.println('e');
                    break;
                }
                case 'f':{
                    System.out.println('f');
                    break;
                }
                case 'g':{
                    System.out.println('g');
                    break;
                }
                case 'h':{
                    System.out.println('h');
                    break;
                }
                case 'i':{
                    System.out.println('i');
                    break;
                }
                case 'j':{
                    System.out.println('j');
                    break;
                }
                case 'k':{
                    System.out.println('k');
                    break;
                }
                case 'l':{
                    System.out.println('l');
                    break;
                }
                case 'm':{
                    System.out.println('m');
                    break;
                }
                case 'n':{
                    System.out.println('n');
                    break;
                }
                case 'o':{
                    System.out.println('o');
                    break;
                }
                case 'p':{
                    System.out.println('p');
                    break;
                }
                case 'q':{
                    System.out.println('q');
                    break;
                }



            }
        }


        }



    }

