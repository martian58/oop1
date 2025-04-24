# Geometry & Stack Visualization App

Welcome to the **Geometry & Stack Visualization App**! This application allows users to perform various operations related to geometry and stack data structures, with interactive and visual representations.

## Features
- Add and visualize points and line segments on a coordinate grid.
- Perform stack operations such as push, pop, and peek, with real-time visualization.
- Navigate between different panels for geometry, stack, and settings using the navigation menu.

---

## Requirements

Before using this application, ensure the following are installed on your system:
- **Java Development Kit (JDK)** (version 8 or above)
- **Git Bash** (for Linux/Mac/Windows) or Command Prompt (for Windows)

---

## Project Structure

The core files for this application are:
- `GeometryApp.java` - The main entry point of the application.
- `Segment.java` - Implements the Segment structure.
- `Point.java`, Implements the Point Structure.
- `MyStack.java` - Implements the stack data structure.

The project also includes:
- `build` - Bash script to compile and run the application on Linux/Mac.
- `build.bat` - Batch script to compile and run the application on Windows.
- `README.md` - This documentation file.

---

## How to Compile and Run

### 1. Using the Bash Script (`build`)
This is for **Linux/Mac** users.

1. Open a terminal in the project directory.
2. Ensure the `build` file has execute permissions by running:
    ```bash
    chmod +x build
    ```
3. Compile and run the application using:
    ```bash
    ./build
    ```

The application will launch automatically after compilation.

---

### 2. Using the Batch Script (`build.bat`)
This method is for **Windows** users.

1. Open the project directory in File Explorer.
2. Double-click the `build.bat` file to execute it.
3. The application will compile and run in a Command Prompt window.

---

## Navigation Guide

To explore the application:
- **Home Page**: Provides an overview of the app and its features.
- **Draw Panel**: Access tools to add and manipulate points and line segments on a grid.
- **Stack Operations Panel**: Perform stack operations with real-time visualization.
- **Settings Panel**: Customize your experience (future features planned).

Use the navigation menu at the top of the application to switch between these panels.

---

## Troubleshooting
- **Compilation Errors**: Ensure all `.java` files are in the same directory and that JDK is installed.
- **Execution Errors**: Verify the output directory (`out/`) contains the compiled `.class` files.

If issues persist, feel free to open an issue.

---

## Future Plans
- Add support for advanced geometry features like angles and shapes.
- Enhance the settings panel for user customization.
- Include intersection checks for geometry operations.

Enjoy exploring the **Geometry & Stack Visualization App**!