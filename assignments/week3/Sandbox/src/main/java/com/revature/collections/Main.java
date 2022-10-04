package com.revature.collections;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Write a Java program to create a new array list, add some colors (string) and print out the collection.
        // 2. Write a Java program to iterate through all elements in an array list
        // 3. Write a Java program to insert an element into the array list at the first position
        ArrayList<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Indigo");
        colors.add("Violet");

        for (String color : colors){ System.out.println(color); }

        // 4. Write a Java program to retrieve an element (at a specified index) from a given array list
        System.out.println(colors.get(4) + " is the fourth element");


        // 5. Write a Java program to remove the third element from an array list.
        System.out.println("Removing: " + colors.remove(3));


        // 6. Write a Java program to search an element in an array list.
        String search_term = "Orange";
        if (colors.contains(search_term)){ System.out.println("Orange is at index: " + colors.indexOf(search_term)); }


        // 7. Write a Java program to sort a given array list.
//        ArrayList<String> newList = new ArrayList<>();

    }
}
