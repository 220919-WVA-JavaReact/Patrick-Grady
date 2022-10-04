package com.revature;

import com.revature.modles.User;

import java.util.Scanner;

public class Menu {

    public static int show(User user){
        int input = 0;
        if (user == null) {
            Menu.splash();
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

    private static void splash(){
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( " ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____  ");
        System.out.println( "|____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( " ___                                             ______    _______  __   __  _______  _______  __   __  ______    _______                                  ___   ");
        System.out.println( "|   |                                           |    _ |  |       ||  | |  ||   _   ||       ||  | |  ||    _ |  |       |                                |   |  ");
        System.out.println( "|   |                                           |   | ||  |    ___||  |_|  ||  |_|  ||_     _||  | |  ||   | ||  |    ___|                                |   |  ");
        System.out.println( "|   |                                           |   |_||_ |   |___ |       ||       |  |   |  |  |_|  ||   |_||_ |   |___                                 |   |  ");
        System.out.println( "|   |                                           |    __  ||    ___||       ||       |  |   |  |       ||    __  ||    ___|                                |   |  ");
        System.out.println( "|   |                                           |   |  | ||   |___  |     | |   _   |  |   |  |       ||   |  | ||   |___                                 |   |  ");
        System.out.println( "|___|                                           |___|  |_||_______|  |___|  |__| |__|  |___|  |_______||___|  |_||_______|                                |___|  ");
        System.out.println( " ___                   _______  __   __  _______  _______  __    _  _______  _______        ______    _______  _______  _______  ______    _______          ___  ");
        System.out.println( "|   |                 |       ||  |_|  ||       ||       ||  |  | ||       ||       |      |    _ |  |       ||       ||       ||    _ |  |       |        |   | ");
        System.out.println( "|   |                 |    ___||       ||    _  ||    ___||   |_| ||  _____||    ___|      |   | ||  |    ___||    _  ||   _   ||   | ||  |_     _|        |   | ");
        System.out.println( "|   |                 |   |___ |       ||   |_| ||   |___ |       || |_____ |   |___       |   |_||_ |   |___ |   |_| ||  | |  ||   |_||_   |   |          |   | ");
        System.out.println( "|   |                 |    ___| |     | |    ___||    ___||  _    ||_____  ||    ___|      |    __  ||    ___||    ___||  |_|  ||    __  |  |   |          |   | ");
        System.out.println( "|   |                 |   |___ |   _   ||   |    |   |___ | | |   | _____| ||   |___       |   |  | ||   |___ |   |    |       ||   |  | |  |   |          |   | ");
        System.out.println( "|___|                 |_______||__| |__||___|    |_______||_|  |__||_______||_______|      |___|  |_||_______||___|    |_______||___|  |_|  |___|          |___| ");
        System.out.println( " ___                                                   _______  ______    _______  _______  ______    _______  __   __                                      ___  ");
        System.out.println( "|   |                                                 |       ||    _ |  |       ||       ||    _ |  |   _   ||  |_|  |                                    |   | ");
        System.out.println( "|   |                                                 |    _  ||   | ||  |   _   ||    ___||   | ||  |  |_|  ||       |                                    |   | ");
        System.out.println( "|   |                                                 |   |_| ||   |_||_ |  | |  ||   | __ |   |_||_ |       ||       |                                    |   | ");
        System.out.println( "|   |                                                 |    ___||    __  ||  |_|  ||   ||  ||    __  ||       ||       |                                    |   | ");
        System.out.println( "|   |                                                 |   |    |   |  | ||       ||   |_| ||   |  | ||   _   || ||_|| |                                    |   | ");
        System.out.println( "|___|                                                 |___|    |___|  |_||_______||_______||___|  |_||__| |__||_|   |_|                                    |___| ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( " ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____   ____  ");
        System.out.println( "|____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| |____| ");
        System.out.println( "                                                                                                                                                                 ");
        System.out.println( "                                                                                                                                                                 ");
    }

    private static void oldSplash(){
        //            System.out.println( " ____     ___ __ __   ____  ______  __ __  ____     ___ ");
        //            System.out.println( "|    \\   /  _]  T  | /    T|      T|  T  T|    \\   /  _]");
        //            System.out.println( "|  D  ) /  [_|  |  |Y  o  ||      ||  |  ||  D  ) /  [_ ");
        //            System.out.println( "|    / Y    _]  |  ||     |l_j  l_j|  |  ||    / Y    _]");
        //            System.out.println( "|    \\ |   [_l  :  !|  _  |  |  |  |  :  ||    \\ |   [_ ");
        //            System.out.println( "|  .  Y|     T\\   / |  |  |  |  |  l     ||  .  Y|     T");
        //            System.out.println( "l__j\\_jl_____j \\_/  l__j__j  l__j   \\__,_jl__j\\_jl_____j");
        //            System.out.println( "                                                        ");
        //            System.out.println("----------------------------");
        //            System.out.println("|   Ticket Reimbursement   |");
        //            System.out.println("|          System          |");
        //            System.out.println("----------------------------");
    }
}
