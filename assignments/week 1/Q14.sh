#!/usr/bin/bash

# Palindrome
# A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward.
# madam and racecar are palindromes.

# prompt user for input
read -p "What do you want to check for palindrome: " pal 

# get length of the string
len=${#pal}

# initialize a variable for the reversed string
rev=""

# reverse the string
# loop bacwards through the string
for (( i=$len-1; i>=0; i-- ))
do
    # add the current character where the loop is to the rev string
    rev=$rev${pal:i:1}
done

# check the reveresed string with the original
# if they are the same
if [ $pal == $rev ]
then 
    # add it to the palindrome.txt file
    echo $pal >> palindrome.txt
fi
