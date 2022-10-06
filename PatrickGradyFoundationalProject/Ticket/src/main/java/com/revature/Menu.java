package com.revature;

import com.revature.models.User;
import com.revature.util.Helper;

import java.util.Scanner;

public class Menu {
    public static int menu(User user) {
        if (user == null) {
            System.out.println("---------------------------");
            System.out.println("Ticket Reimbursement System");
            System.out.println("What would you like to do? ");
            System.out.println("---------------------------");
            System.out.println("    1) Create New User ");
            System.out.println("    2) Log in to Existing User ");
            System.out.println("    3) Exit ");
            System.out.println("---------------------------");
            return getChoice(1);
        } else {
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

    private static int getChoice(int stage){
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        String input = "";
        do{
            input = sc.nextLine();
            if (stage == 1) {
                validInput = Helper.isInteger(input) && Helper.isNumberBetween(Integer.parseInt(input), 1, 3);
            } else if (stage == 2) {
                validInput = Helper.isInteger(input) && Helper.isNumberBetween(Integer.parseInt(input), 4, 7);
            }
        } while (!validInput);
        return Integer.parseInt(input);
    }
}
