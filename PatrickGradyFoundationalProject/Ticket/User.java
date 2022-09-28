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
        sc.close();

        return this;
    }
}
