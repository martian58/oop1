@echo off

REM Create output directory if it doesn't exist
if not exist out (
    mkdir out
)

REM Compile Java files
javac -d out .\src\*.java

REM Check if compilation was successful
if %ERRORLEVEL% equ 0 (
    echo Compilation successful
    REM Run the main class
    java -cp out Main
) else (
    echo Compilation failed
    exit /b 1
)
