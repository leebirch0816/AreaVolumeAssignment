# AreaVolume

## Overview
This Java console program lets the user calculate:
1) Rectangle Area  
2) Sphere Volume  
3) Cylinder Volume  
4) Cube Volume  

The program displays a menu, asks the user to choose an option, then prompts for the required dimensions.
When the user selects **Show Summary and Exit**, the program prints a summary of all calculations performed.

## Program Requirements Implemented
- Create a Java project and begin the program with a clear purpose/comment
- Use a menu (loop) to allow the user to choose a calculation repeatedly
- Prompt the user for the required dimensions for each shape
- Validate input so dimensions must be **greater than 0**
- Calculate and display results for:
  - Rectangle area: **area = length × width**
  - Sphere volume: **volume = (4/3) × π × r³**
  - Cylinder volume: **volume = π × r² × h**
  - Cube volume: **volume = side³**
- Store each completed calculation in arrays (type + inputs + result)
- When the user chooses **Show Summary and Exit**, display all stored calculations in order, then exit cleanly

## Input Rules
- Menu choice must be an integer from **1 to 5**
  - If invalid, the program prompts again
- All dimensions must be numeric and **> 0**
  - Rectangle: length > 0, width > 0
  - Sphere: radius > 0
  - Cylinder: radius > 0, height > 0
  - Cube: side length > 0
- Results are displayed with consistent formatting (e.g., 4 decimal places)

## How to Compile & Run

Compile:
- `javac -d bin (Get-ChildItem -Path src -Filter *.java).FullName`

Run:
- `java -cp bin App`

> Note: Run these commands in the folder where `App.java` is located (e.g., in PowerShell/Terminal).