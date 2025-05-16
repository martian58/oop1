#!/bin/bash

# Create output directory if it doesn't exist
mkdir -p out

# Compile all Java files in src directory to out directory
javac -d out ./src/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful"
    # Run the main class
    java -cp out Main
else
    echo "Compilation failed"
    exit 1
fi