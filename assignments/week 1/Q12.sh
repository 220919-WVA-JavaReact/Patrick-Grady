#!/usr/bin/bash

# Store even / odd numbers to appropriate txt files

# use for loop to get 10 numbers
for i in 1 2 3 4 5 6 7 8 9 10
do
    read -p "Enter number $i: " eo 

    # if the entered number has no remainder, check using the modulo operator...
    if [ $(($eo%2)) -eq 0 ]
    then 
        # it is even so put it it te even txt file
        echo $i >> even.txt
    else 
        # otherwise it is odd and put it in the odd.txt file
        echo $i >> odd.txt
    fi
done