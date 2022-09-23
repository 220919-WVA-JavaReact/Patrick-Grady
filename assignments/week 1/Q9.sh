#!/usr/bin/bash

# Even or Odd

echo "Even or Odd?"
read -p "Enter number to check: " eo 

# if the entered number has no remainder, check using the modulo operator...
if [ $(($eo%2)) -eq 0 ]
then 
    # it is even
    echo "Even"
else 
    # otherwise it is odd
    echo "Odd"
fi