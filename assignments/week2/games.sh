enter () {
    read -p "Name of game: " game 
    read -p "Maker: " maker 
    read -p "Year: " year

    echo "$game,$maker,$year" >> games.csv

    echo "$game has been added to the file games.csv successfully"
}

print () {
    cat ./games.csv
}

search () {
    read -p "What would you like to search for? " search
    echo "Searching....."
    sleep 1
    grep $search ./games.csv
}

delete () {
    read -p "What game would you like to delete? " delete 
    sed -i "/$delete/d" ./games.csv
}

# change () {
#     read -p "What game would you like to change? " game 
#     sed -i "/$delete/d" ./games.csv
#     enter
    
# }

echo "------------------"
echo "  Favorite Games"
echo "------------------"
echo "1) Enter New Game"
echo "2) See All Data"
echo "3) Search"
echo "4) Delete Game"
# echo "5) Change data"

read -p "Enter your choice: " choice

case $choice in 
    1) enter 0
    exit;;
    2) print
    exit;;
    3) search 
    exit;;
    4) delete 
    exit;;
    # 5) change 
    # exit;;
    *) echo "Invalid option"
    exit;;
esac