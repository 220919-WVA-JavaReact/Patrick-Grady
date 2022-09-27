package github.PatrickGradyFoundationalProject.Ticket;

import java.util.Scanner;

public class Ticket {

    public static void main(String[] args) {
        int choice = menu();
        if (choice == 1) {
            create();
        }
    }

    public static void create() {
        System.out.println("Creating new user...");
    }

    public static void login() {
        System.out.println("Logging in...");
    }

    public static int menu() {
        int input = 0;

        System.out.println("Ticket Reimbursement System");
        System.out.println("What would you like to do? ");
        System.out.println("1) Create New User ");
        System.out.println("2) Log in to Existing User ");

        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        sc.close();

        return input;
    }
}
