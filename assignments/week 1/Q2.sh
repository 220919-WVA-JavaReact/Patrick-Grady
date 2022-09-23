#!/usr/bin/bash

# Print the first 100 digits of the Fibonacci sequence
# The Fibonacci sequence: each number is the sum of the two preceding ones.
# 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...

# How many do we want to print?
number=100

# initialize the first two numbers to one and initialize a temporary variable for storing the sum
first=1
second=1
temp=0

# print out the first three digits before looping
echo "0"
echo $first 
echo $second

# loop from 0 to the number we want to print -3 because we already printed the first 3
for (( i=0; i<=number-3; i++ ))
do
    # sum the current digits and store it in a temporary variable
    temp=$(($first + $second))
    # only want to go if less than 100
    if [ $temp -gt 100 ]
    then 
        exit
    fi 
    # print that out
    echo "$temp"
    # the second number now becomes the first
    first=$second
    # the sum of the two previous now becomes our second number
    second=$temp
done