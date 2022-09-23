#!/usr/bin/bash


# NOT WORKING!!


# Print the pattern:
#          *
#         * *
#        * * *
#       * * * *
#      * * * * *

num=5

for (( i=0; i<$num; i++ ))
do
    for ((j=0; j<i; j++))
    do
        echo " "
    done

    for (( k=j; k<=$num; k++ ))
    do 
        echo "* "
    done
done