#!/bin/bash
# Create output directory if it doesn't exist
mkdir -p out
# Create release directory if it doesn't exist
mkdir -p release
# Compile all Java files to the out directory
javac -d out ./src/*.java
echo "Main-Class: GeometryApp" > manifest.txt
jar cfm ./release/GeometryAndStackApp.jar manifest.txt -C out .
echo "JAR created: ./release/GeometryAndStackApp.jar"
sleep 1
java -jar ./release/GeometryAndStackApp.jar
