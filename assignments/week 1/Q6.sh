#!/usr/bin/bash

# Is the number prime?
# A prime number (or a prime) is a natural number greater than 1 that is not a product of two smaller natural numbers.
# 9 is not prime because 3 x 3 = 9, but 11 is prime.

echo "Prime?"
# get user input for prime number check
read -p "Enter number to check for prime: " num 

# find the square root of the inputted number
# we only have to check up until the square root of the number
sq=`echo "sqrt($num)" | bc`

# loop from 2 (not 1 because it is always a factor) until the square root of the inputted value
for (( i=2; i<=$sq; i++ ))
do 
    # if the remainder of the division between the number and the current loop is 0...
    if [ $(($num % i)) -eq 0 ]
    then 
        # it is not prime
        echo "Not Prime"
        exit
    fi 
done
# if after searching all factors and none have remainders, it is prime
echo "Prime"