package com.revature;

import java.util.Scanner;

public class Menu {

    public static int show(User user){
        int input = 0;
        if (user == null) {
            System.out.println( " ____     ___ __ __   ____  ______  __ __  ____     ___ ");
            System.out.println( "|    \\   /  _]  T  | /    T|      T|  T  T|    \\   /  _]");
            System.out.println( "|  D  ) /  [_|  |  |Y  o  ||      ||  |  ||  D  ) /  [_ ");
            System.out.println( "|    / Y    _]  |  ||     |l_j  l_j|  |  ||    / Y    _]");
            System.out.println( "|    \\ |   [_l  :  !|  _  |  |  |  |  :  ||    \\ |   [_ ");
            System.out.println( "|  .  Y|     T\\   / |  |  |  |  |  l     ||  .  Y|     T");
            System.out.println( "l__j\\_jl_____j \\_/  l__j__j  l__j   \\__,_jl__j\\_jl_____j");
            System.out.println( "                                                        ");
            System.out.println("----------------------------");
            System.out.println("|   Ticket Reimbursement   |");
            System.out.println("|          System          |");
            System.out.println("----------------------------");

            System.out.println("What would you like to do? ");
            System.out.println("1) Create New User ");
            System.out.println("2) Log in to Existing User ");
        } else {
            System.out.println("What would you like to do next " + user.getUName());
            System.out.println("3) Create Expense Report ");
            System.out.println("4) See All Your Expense Reports ");
            System.out.println("5) Exit ");

        }

        // get user input from the keyboard
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        return input;
    }
}
