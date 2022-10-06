package com.revature.util;

public class Helper {
    public static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            System.out.println("Input must be a number!");
            return false;
        }
    }

    public static boolean isNumberBetween(Integer num, Integer start, Integer end){
        if (num >= start && num <= end) {
            return true;
        }
        System.out.println("Number must be between " + start + " and " + end);
        return false;
    }
}
