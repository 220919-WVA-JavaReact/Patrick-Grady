package com.revature;

import com.revature.models.User;
import com.revature.util.Helper;

import java.util.Scanner;

public class Menu {

    // method to show main menu
    // one where user is not logged in
    // one where user is logged in
    public static int menu(User user) {
        if (user == null) {
            print(5);
            System.out.println("---------------------------");
            System.out.println("Ticket Reimbursement System");
            System.out.println("What would you like to do? ");
            System.out.println("---------------------------");
            System.out.println("    1) Create New User ");
            System.out.println("    2) Log in to Existing User ");
            System.out.println("    3) Exit ");
            System.out.println("---------------------------");
            return getChoice(1);
        } else { // user is logged in
            print(5);
            System.out.println("---------------------------");
            System.out.println("What would you like to do next " + user.getuName());
            System.out.println("---------------------------");
            System.out.println("    4) Create Expense Report ");
            System.out.println("    5) See All Your Expense Reports ");
            System.out.println("    6) Log Out ");
            System.out.println("    7) Exit ");
            System.out.println("---------------------------");
            return getChoice(2);
        }
    }

    // Uses a scanner to get keyboard input, validates the input
    // and return the result back to the main program.
    private static int getChoice(int stage){
        Scanner sc = new Scanner(System.in);  // used to get user input from the keyboard
        boolean validInput = false;
        String input = "";
        do{
            input = sc.nextLine(); // get user input
            if (stage == 1) { // if user is not logged in
                validInput = Helper.isInteger(input) && Helper.isNumberBetween(Integer.parseInt(input), 1, 3);
            } else if (stage == 2) { // if user is logged in
                validInput = Helper.isInteger(input) && Helper.isNumberBetween(Integer.parseInt(input), 4, 7);
            }
        } while (!validInput); // loop until the user input is valid
        return Integer.parseInt(input); // once input is valid, return the input as an integer
    }

    //method that prints num blank lines
    private static void print(int num){
        for (int i = 0; i < num; i++){
            System.out.println();
        }
    }
}
