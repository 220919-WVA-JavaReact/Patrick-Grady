package com.revature.util;

public class Helper {
    // method to see if a string can be converted to a float
    public static boolean isFloat(String input){
        try{
            Float.parseFloat(input);
        } catch (NumberFormatException e){
            System.out.println("Input must be a number!");
            return false;
        }
        return true;
    }

    public static boolean isNotEmpty(String input){
        return !input.trim().equals("");
    }

    // method to see if a string can be converted to an integer
    public static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.println("Input must be a number!");
            return false;
        }
        return true;
    }

    public static boolean isNumberBetween(Integer num, Integer start, Integer end){
        if (num >= start && num <= end) {
            return true;
        }
        System.out.println("Number must be between " + start + " and " + end);
        return false;
    }
}
