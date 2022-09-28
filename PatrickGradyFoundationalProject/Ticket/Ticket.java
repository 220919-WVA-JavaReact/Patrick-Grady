package Ticket;

import java.util.Scanner;

public class Ticket {

    public static void main(String[] args) {
        User user = null;
        int choice = menu(user);
        if (choice == 1) {
            user = new User(1);
        } else if ( choice == 2){
            user = new User(2);
        }
        
    }

    public static void login() {
        System.out.println("Logging in...");
    }

    public static int menu(User user) {
        int input = 0;
        if (user == null) {
            System.out.println("Ticket Reimbursement System");
            System.out.println("What would you like to do? ");
            System.out.println("1) Create New User ");
            System.out.println("2) Log in to Existing User ");
        } else {
            System.out.println("3) Create Expense Report ");
            System.out.println("4) Log out ");
            System.out.println("5) Exit ");

        }

        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        return input;
    }
}