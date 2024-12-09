package javalab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixLab {

    public static void main(String[] args) {
        // Define matrix dimensions
        final int rows = 3;
        final int cols = 3;

        // Initialize matrix
        long[][] matrixB = new long[rows][cols];

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the elements of the matrix B (" + rows + "x" + cols + "):");

        // Input elements of matrix B
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("matrixB[" + i + "][" + j + "]: ");
                        matrixB[i][j] = scanner.nextLong();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: you've entered an incorrect value. Please enter a long value.");
                        scanner.next(); // Clear the buffer
                    }
                }
            }
        }

        // Print the initial matrix B
        System.out.println("Initial matrix B:");
        printMatrix(matrixB);

        // Define the constant a
        final long a = 5;

        // Perform the operation: C = aB
        long[][] matrixC = multiplyMatrixByConstant(matrixB, a);
        System.out.println("Matrix C after multiplying B by constant a:");
        printMatrix(matrixC);

        // Calculate the sum of the largest elements in each row of matrix C
        long maxSum = calculateMaxRowSum(matrixC);
        System.out.println("The sum of the largest elements of every row in matrix C: " + maxSum);

        // Close scanner
        scanner.close();
    }

    /**
     * Multiplies the given matrix by a constant.
     *
     * @param matrix  the input matrix
     * @param constant the constant to multiply by
     * @return the resulting matrix
     */
    public static long[][] multiplyMatrixByConstant(long[][] matrix, long constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        long[][] result = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }
        return result;
    }

    /**
     * Calculates the sum of the largest elements in each row of the matrix.
     *
     * @param matrix the matrix to process
     * @return the sum of the largest elements of each row
     */
    public static long calculateMaxRowSum(long[][] matrix) {
        long sum = 0;
        for (long[] row : matrix) {
            long maxInRow = row[0]; // Assume the first element is the largest initially
            for (long num : row) {
                if (num > maxInRow) {
                    maxInRow = num; // Update max if a larger value is found
                }
            }
            sum += maxInRow; // Add the largest value of this row to the sum
        }
        return sum;
    }

    /**
     * Prints the matrix to the console.
     *
     * @param matrix the matrix to print
     */
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
