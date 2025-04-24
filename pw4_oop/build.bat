@echo off
setlocal enabledelayedexpansion

:: ANSI Colors
for /F "delims=" %%a in ('"echo prompt $E| cmd"') do set "ESC=%%a"
set "GREEN=%ESC%[92m"
set "BLUE=%ESC%[94m"
set "YELLOW=%ESC%[93m"
set "CYAN=%ESC%[96m"
set "RED=%ESC%[91m"
set "RESET=%ESC%[0m"

:: Welcome message
echo "%CYAN%======================================%RESET%"
echo "%CYAN%| PW 4 Java Builder && Runner Script |%RESET%"
echo "%CYAN%======================================%RESET%"
echo.

:: Create output directory
if not exist out (
    mkdir out
)

:: Compile Java files (recursively)
echo %YELLOW%Compiling Java files...%RESET%
for /R src %%f in (*.java) do (
    set "srcfiles=!srcfiles! %%f"
)
javac -d out !srcfiles!
if errorlevel 1 (
    echo %RED%Compilation failed! Please check your code.%RESET%
    pause
    exit /b
)

:: Display Menu
:MENU
echo.
echo %BLUE%Which exercise would you like to run?%RESET%
echo   %GREEN%1%RESET%) Exercise 1 - String Manipulation GUI
echo   %GREEN%2%RESET%) Exercise 2 - Arithmetic Expressions
echo   %GREEN%3%RESET%) Clean up output directory
echo   %GREEN%4%RESET%) Exit
set /p choice=%YELLOW%Enter your choice (1/2/3/4): %RESET%

:: Evaluate choice
if "%choice%"=="1" (
    echo %GREEN%Running Exercise 1 - String Manipulation GUI...%RESET%
    java -cp out StringManipulationGUI
) else if "%choice%"=="2" (
    echo %GREEN%Running Exercise 2 - Arithmetic Expressions...%RESET%
    java -cp out Main
) else if "%choice%"=="3" (
    echo %YELLOW%Cleaning up output directory...%RESET%
    rmdir /s /q out
    echo %GREEN%Output directory cleaned.%RESET%
) else if "%choice%"=="4" (
    echo %GREEN%Exiting...%RESET%
    exit /b
) else (
    echo %RED%Invalid choice. Please enter 1, 2, 3, or 4.%RESET%
)

pause