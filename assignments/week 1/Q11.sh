#!/usr/bin/bash

# Grades

# initialize variable for how many classes
classes=3
# get user input for Math, English and Science
read -p "Enter the grade for Math: " math
read -p "Enter the grade for English: " english
read -p "Enter the grade for Science: " science

# average the grades
avg=$((($math + $english + $science) / $classes))

# use if statement to print out the correct grade
if [ $avg -ge 90 ] && [ $avg -le 100 ]
then 
    echo "Grade A"
elif [ $avg -ge 80 ]
then
    echo "Grade B"
elif [ $avg -ge 70 ]
then
    echo "Grade C"
elif [ $avg -ge 60 ]
then
    echo "Grade D"
else
    echo "Grade F"
fi