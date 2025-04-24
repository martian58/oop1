import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    
    // Exercise 1 – Working with integers
    /**
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int mult(int a, int b) {
        return a * b;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
        //bcs why not :)
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Exercise 2 – Working with integer arrays

    /**
     * @param array
     * @return min value in the array
     */
    public static int min(int[] array){
        int minValue = array[0];
        for(int value : array){
            if(value < minValue){
                minValue = value;
            }
        }
        return minValue;
    }

    /**
     * @param array
     * @param value
     * @return index of the value in the array or -1 if not found
     */
    public static int find(int[] array, int value){
        for(int i = 0; i < array.length; i++){
            if (array[i] == value){
                return i;
            } 
        }
        return -1;
    }

    /**
     * @param array int[]
     * @return sum of the array
     */
    public static int sumArray(int[] array){
        int sum = 0;
        for(int value : array){
            sum+=value;
        }
        return sum;
    }

    /**
     * @param array
     */
    public static void printArray(int[] array){
        for(int value : array){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * @param array
     * @return The reversed array
     */
    public static int[] reverseArray(int[] array){
        int[] reversedArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    // Exercise 3 – Conditional statements
    public static void conditionalMethod() {
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();

        if (a % 2 == 0 && b % 2 == 0) {
            System.out.println("Sum: " + (a + b));
        } else if (a % 2 != 0 && b % 2 != 0) {
            System.out.println("Multiplication: " + (a * b));
        } else {
            System.out.println("Square of " + a + ": " + (a * a));
            System.out.println("Square of " + b + ": " + (b * b));
        }
    }



    // Exercise 4 – A basic calculator

    public static void basicCalculator() {
    
        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();
    
            System.out.println("Choose an operation:");
            System.out.println("1. +");
            System.out.println("2. -");
            System.out.println("3. *");
            System.out.println("4. /");
            System.out.println("5. %");
            System.out.print("Operation: ");
            int operation = scanner.nextInt();
    
            switch (operation) {
                case 1:
                    System.out.println("Output: " + a + " + " + b + " = " + (a + b));
                    break;
                case 2:
                    System.out.println("Output: " + a + " - " + b + " = " + (a - b));
                    break;
                case 3:
                    System.out.println("Output: " + a + " * " + b + " = " + (a * b));
                    break;
                case 4:
                    if (b != 0) {
                        System.out.println("Output: " + a + " / " + b + " = " + (a / b));
                    } else {
                        System.out.println("Cannot divide by zero");
                    }
                    break;
                case 5:
                    if (b != 0) {
                        System.out.println("Output: " + a + " % " + b + " = " + (a % b));
                    } else {
                        System.out.println("Cannot divide by zero");
                    }
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid integers: " + e);
        } 
    }

    // Exercise 5 – Two-dimensional arrays

    public static float[][] product(float[][] matA, float[][] matB) {
        int rowsA = matA.length;
        int colsA = matA[0].length;
        int rowsB = matB.length;
        int colsB = matB[0].length;
    
        if (colsA != rowsB) {
            return null; // Dimensions don't match for matrix multiplication
        }
    
        float[][] result = new float[rowsA][colsB];
    
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }
    
        return result;
    }

    // Exercise 6 – Searching arrays

    /**
     * Searches for a given integer value in a one-dimensional integer array.
     * @param array the array to search in
     * @param value the value to search for
     * @return the index of the value if found, else -1
     */
    public static int search(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for a given integer value in a two-dimensional integer array.
     * @param array the array to search in
     * @param value the value to search for
     * @return an array containing the row and column index of the value if found, else {-1, -1}
     */
    public static int[] search(int[][] array, int value) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == value) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Extras

    public static void intro() {
        System.out.println(
            "        \n" +
            "██████╗ ██╗    ██╗     ██╗\n" +
            "██╔══██╗██║    ██║    ███║\n" +
            "██████╔╝██║ █╗ ██║    ╚██║\n" +
            "██╔═══╝ ██║███╗██║     ██║\n" +
            "██║     ╚███╔███╔╝     ██║\n" +
            "╚═╝      ╚══╝╚══╝      ╚═╝\n" +
            "                                  \n"
        );
    }

    public static void main(String[] args) {

        intro();
    
        // Test the methods
        int[] array = {5, 3, 8, 1, 2};
    
        System.out.println("Exercise 2");
        System.out.println("Min: " + min(array));
        System.out.println("Find 8: " + find(array, 8));
        System.out.println("Sum: " + sumArray(array));
        System.out.print("Array: ");
        printArray(array);
        System.out.print("Reversed Array: ");
        printArray(reverseArray(array));
        System.out.println();
    
        // Test the conditional method
        System.out.println("Exercise 3");
        conditionalMethod();
        System.out.println();
    
        // Test the basic calculator method
        System.out.println("Exercise 4");
        basicCalculator();
        System.out.println();
    
        // Test the two-dimensional array method
        System.out.println("Exercise 5");
        float[][] matA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        float[][] matB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        float[][] result = product(matA, matB);
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Dimensions don't match for matrix multiplication");
        }
        System.out.println();
    
        // Test the search methods
        System.out.println("Exercise 6");
        int searchValue = 8;
        int index = search(array, searchValue);
        System.out.println("Search for " + searchValue + " in one-dimensional array: " + (index != -1 ? "Found at index " + index : "Not found"));
    
        int[][] twoDArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] indices = search(twoDArray, searchValue);
        System.out.println("Search for " + searchValue + " in two-dimensional array: " + (indices[0] != -1 ? "Found at row " + indices[0] + ", column " + indices[1] : "Not found"));
        System.out.println();
    }
}