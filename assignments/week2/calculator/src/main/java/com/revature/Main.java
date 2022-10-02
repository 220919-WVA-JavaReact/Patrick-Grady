package com.revature;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Scanner op = new Scanner(System.in);
        Scanner i = new Scanner(System.in);

        System.out.println("Calculator");
        System.out.println("Enter operator: +, -, *, /");
        String operator = op.nextLine();
        System.out.println("Please enter the first number ");
        int op1 = i.nextInt();
        System.out.println("Please enter the second number ");
        int op2 = i.nextInt();

        switch (operator) {
            case "+":
                System.out.println(op1 + op2);
                break;
            case "-":
                System.out.println(op1 - op2);
                break;
            case "*":
                System.out.println(op1 * op2);
                break;
            case "/":
                System.out.println(op1 / op2);
                break;
            default:
                System.out.println("Invalid Entry");

        }
     }

;    }