package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // -----------------------------------------
        // ArrayList
        // -----------------------------------------
        System.out.println("ArrayList");
        // 1. Write a Java program to create a new array list, add some colors (string) and print out the collection.
        // 2. Write a Java program to iterate through all elements in an array list
        // 3. Write a Java program to insert an element into the array list at the first position
        ArrayList<String> colors = new ArrayList<>();

        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Indigo");
        colors.add("Violet");
        colors.add(0, "Red");

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


        // -----------------------------------------
        // HashMap
        // -----------------------------------------
        System.out.println("HashMap");
        // 1. Create a HashMap with Integers for the Keys and Strings for the Entries. Insert 5 entries with numbers as
        // the key and colors as the value associated
        HashMap<Integer, String> colorMap = new HashMap<Integer, String>();
        colorMap.put(0, "Red");
        colorMap.put(1, "Orange");
        colorMap.put(2, "Yellow");
        colorMap.put(3, "Green");
        colorMap.put(4, "Blue");
        // 2. Write a Java program to count the number of key-value (size) mappings in a map.
        System.out.println(colorMap.size());

        // 3. Write a Java program to test if a map contains a mapping for the specified key
        if (colorMap.get(6) != null){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // 4. Write a Java program to get the value of a specified key in a map.
        System.out.println(colorMap.get(3));

        // 5. Write a Java program to get a set view of the keys contained in this map.
        Set<Integer> allKeys = colorMap.keySet();
        System.out.println(allKeys);

        // -----------------------------------------
        // HashSet
        // -----------------------------------------
        System.out.println("HashSet");
        // 1. Write a Java program to append the specified element to the end of a hash set
        HashSet<String> colorSet = new HashSet<>();
        colorSet.add("Red");

        String course = "101";
        System.out.println(Integer.parseInt(course));


        // 2. Write a Java program to iterate through all elements in a hash list. ??? Meaning the hash set I assume



        // 3. Write a Java program to get the number of elements in a hash set



        // 4. Write a Java program to test a hash set is empty or not



        // 5. Write a Java program to convert a hash set to an array.

    }
}
