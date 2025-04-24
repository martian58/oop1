@echo off

REM Create output directory if it doesn't exist
if not exist out (
    mkdir out
)

REM Compile Java files
javac -d out ./src/*.java

REM Run the main class
java -cp out GeometryApp
pause
