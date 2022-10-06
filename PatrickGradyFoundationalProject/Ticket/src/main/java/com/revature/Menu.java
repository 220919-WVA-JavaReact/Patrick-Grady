package com.revature;

import com.revature.models.User;
import com.revature.util.Helper;

import java.util.Scanner;

public class Menu {
    public static int menu(User user) {
        if (user == null) {
            System.out.println("Ticket Reimbursement System");
            System.out.println("What would you like to do? ");
            System.out.println("1) Create New User ");
            System.out.println("2) Log in to Existing User ");
            return getChoice(1);
        } else {
            System.out.println("What would you like to do next " + user.getuName());
            System.out.println("3) Create Expense Report ");
            System.out.println("4) See All Your Expense Reports ");
            System.out.println("5) Log Out ");
            System.out.println("6) Exit ");
            return getChoice(2);
        }
    }

    private static int getChoice(int stage){
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        String input = "";
        while (!validInput){
            input = sc.nextLine();
            if (stage == 1) {
                validInput = Helper.isInteger(input) && Helper.isNumberBetween(Integer.parseInt(input), 1, 2);
            } else if (stage == 2) {
                validInput = Helper.isInteger(input) && Helper.isNumberBetween(Integer.parseInt(input), 3, 6);
            }
        }
        return Integer.parseInt(input);
    }
}
