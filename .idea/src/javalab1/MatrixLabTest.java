package javalab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixLabTest {

    @Test
    void testMultiplyMatrixByConstant() {
        // Arrange
        long[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        long constant = 5;
        long[][] expected = {
                {5, 10, 15},
                {20, 25, 30},
                {35, 40, 45}
        };

        // Act
        long[][] result = MatrixLab.multiplyMatrixByConstant(matrix, constant);

        // Assert
        assertArrayEquals(expected, result, "Matrix multiplication by constant failed.");
    }

    @Test
    void testCalculateMaxRowSum() {
        // Arrange
        long[][] matrix = {
                {5, 10, 15},
                {20, 25, 30},
                {35, 40, 45}
        };
        long expectedSum = 90; // 15 + 30 + 45

        // Act
        long result = MatrixLab.calculateMaxRowSum(matrix);

        // Assert
        assertEquals(expectedSum, result, "Sum of max elements in rows calculation failed.");
    }

    @Test
    void testPrintMatrix() {
        // Arrange
        long[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MatrixLab.printMatrix(matrix);
    }

    /**
     * Utility method to capture printed output.
     *
     * @param runnable the code that produces console output
     * @return the captured output as a String
     */
    private String capturePrintOutput(Runnable runnable) {
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        runnable.run();
        System.setOut(System.out); // Restore original System.out
        return outputStream.toString();
    }
}
