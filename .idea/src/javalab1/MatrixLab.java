package javalab1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A program that performs operations on a matrix, including:
 * 1. Matrix input from the user.
 * 2. Multiplying the matrix by a constant.
 * 3. Calculating the sum of the largest elements in each row.
 */
public class MatrixLab {

    /**
     * The main method that serves as the entry point for the program.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Define matrix dimensions
        final int rows = 3; // Number of rows
        final int cols = 3; // Number of columns

        // Initialize a 3x3 matrix
        long[][] matrixB = new long[rows][cols];

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the elements of the matrix B (" + rows + "x" + cols + "):");

        // Input elements of matrix B with validation
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean validInput = false; // Flag to check for valid input
                while (!validInput) {
                    try {
                        System.out.print("matrixB[" + i + "][" + j + "]: ");
                        matrixB[i][j] = scanner.nextLong(); // Input the matrix element
                        validInput = true; // Exit loop on valid input
                    } catch (InputMismatchException e) {
                        System.out.println("Error: you've entered an incorrect value. Please enter a long value.");
                        scanner.next(); // Clear the invalid input from the buffer
                    }
                }
            }
        }

        // Print the initial matrix B
        System.out.println("Initial matrix B:");
        printMatrix(matrixB);

        // Define a constant value for multiplication
        final long a = 5;

        // Multiply matrix B by constant 'a' to produce matrix C
        long[][] matrixC = multiplyMatrixByConstant(matrixB, a);
        System.out.println("Matrix C after multiplying B by constant a:");
        printMatrix(matrixC);

        // Calculate the sum of the largest elements in each row of matrix C
        long maxSum = calculateMaxRowSum(matrixC);
        System.out.println("The sum of the largest elements of every row in matrix C: " + maxSum);

        // Close the scanner to release resources
        scanner.close();
    }

    /**
     * Multiplies each element of the given matrix by a constant.
     *
     * @param matrix   The input matrix to be multiplied.
     * @param constant The constant value to multiply each element by.
     * @return A new matrix with each element multiplied by the constant.
     */
    public static long[][] multiplyMatrixByConstant(long[][] matrix, long constant) {
        int rows = matrix.length;        // Number of rows in the matrix
        int cols = matrix[0].length;     // Number of columns in the matrix
        long[][] result = new long[rows][cols]; // Resultant matrix

        // Iterate over all elements of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant; // Multiply element by constant
            }
        }
        return result; // Return the resultant matrix
    }

    /**
     * Calculates the sum of the largest elements in each row of a matrix.
     *
     * @param matrix The matrix to process.
     * @return The sum of the largest elements in each row.
     */
    public static long calculateMaxRowSum(long[][] matrix) {
        long sum = 0; // Variable to store the total sum

        // Iterate through each row of the matrix
        for (long[] row : matrix) {
            long maxInRow = row[0]; // Assume the first element in the row is the largest initially

            // Find the largest element in the current row
            for (long num : row) {
                if (num > maxInRow) {
                    maxInRow = num; // Update the largest value if a larger element is found
                }
            }
            sum += maxInRow; // Add the largest value of this row to the total sum
        }
        return sum; // Return the total sum
    }

    /**
     * Prints a matrix to the console in a readable format.
     *
     * @param matrix The matrix to print.
     */
    public static void printMatrix(long[][] matrix) {
        // Iterate over each row of the matrix
        for (long[] row : matrix) {
            // Print each element of the row
            for (long element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }
}
