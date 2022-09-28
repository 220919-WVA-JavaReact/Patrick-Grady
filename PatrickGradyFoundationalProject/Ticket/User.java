package github.PatrickGradyFoundationalProject.Ticket;

import java.util.Scanner;
public class User {
    private String fName;
    private String lName;
    private String uName;
    private String password;

    public User() {
        this.create();
    }

    public User(Integer choice) {
        if (choice == 1){
            this.create();
        } else if (choice == 2){
            this.login();
        }
    }

    public User(String fName, String lName, String uName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.uName = uName;
        this.password = password;
    }
    
    public User create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        this.fName = sc.nextLine();
        System.out.println("Please enter your last name: ");
        this.lName = sc.nextLine();
        System.out.println("Please enter your user name: ");
        this.uName = sc.nextLine();
        System.out.println("Please enter your password: ");
        this.password = sc.nextLine();

        System.out.println("Creating User in database......");

        return this;
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Name: ");
        String name = sc.nextLine();
        System.out.println("Password ");
        String password = sc.nextLine();

        System.out.println("Retrieving User from database.......");

        return new User("pat", "grady", "pgrady", "pass1234");

    }
}
