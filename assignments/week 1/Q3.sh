#!/usr/bin/bash

# Factorial
# the factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n.
# 5! = 5 x 4 x 3 x 2 x 1 = 120


echo "Factorial!"
# get user input 
read -p "Enter number: " num

# initialize the answer variable to start at 1 for multiplication
ans=1

# loop from the user entered number backwards until we get to 1
for (( i=$num; i>0; i-- ))
do
    # multiply the current answer with the number in the loop
    ans=$(($ans*i))
done

# print the answer
echo $ans