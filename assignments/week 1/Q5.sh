#!/usr/bin/bash

# How many positive and how many negative

# initialize positive and negative variables both to 0
pos=0
neg=0

# loop 10 times
for (( i=1; i<=10; i++ ))
do
    # Get user input for each number
    read -p "Enter Number $i: " num 
    # if that number is greater than or equal to 0...
    if [ $num -ge 0 ]
    then
        # add one to positive
        pos=$(($pos+1))
    else
        # otherwise add one to negative
        neg=$(($neg+1))
    fi
done

# print out how many positive and negative numbers there were inputted
echo "There were $pos positive numbers"
echo "There were $neg negative numbers"