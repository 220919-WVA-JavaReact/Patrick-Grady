#!/usr/bin/bash

# Find maximum number

# initialize max to a very low number
max=-100000

# loop 3 times
for i in 1 2 3
do 
    read -p "Enter number $i: " inp 
    # if the inputted number is greater than the current max
    if [ $inp -ge $max ]
    then
        max=$inp 
    fi
done

# print the maximum number
echo $max