#!/usr/bin/bash

# Print the pattern
# 0
# 0 1
# 0 1 2
# 0 1 2 3
# 0 1 2 3 4
# 0 1 2 3 4 5

# initialize current string to empty
current=""

# loop through numbers 0 through 5
for i in 0 1 2 3 4 5 
do
    # concatenate current string with the value of the loop
    current="${current}$i "
    echo $current
done