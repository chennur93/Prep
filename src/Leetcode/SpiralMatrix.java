package Leetcode;

import java.util.ArrayList;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
 * Memory Usage: 36.9 MB, less than 91.44% of Java online submissions for Spiral Matrix.
 */

public class SpiralMatrix {
    public static ArrayList<Integer> getSpiral(int[][] matrix) {
        int minRow = 0, minCol = 0;
        int maxRow = matrix.length-1;
        int maxCol = matrix[0].length-1;
        int x = 0, y = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int resultCounter = 0;
        int totalCounter = (maxRow+1)*(maxCol+1);

        while (resultCounter < totalCounter) {
            if (x == minRow && y == minCol) {
                for (y = minCol; y <= maxCol; y++) {
                    result.add(matrix[x][y]);
                    resultCounter++;
                }
                minRow++;
                x++;
                y--;
                if (resultCounter == totalCounter)
                    break;
            }
            if (x == minRow && y == maxCol) {
                for (x = minRow; x <= maxRow; x++) {
                    result.add(matrix[x][y]);
                    resultCounter++;
                }
                maxCol--;
                y--;
                x--;
                if (resultCounter == totalCounter)
                    break;
            }
            if (x == maxRow && y == maxCol) {
                for (y = maxCol; y >= minCol; y--) {
                    result.add(matrix[x][y]);
                    resultCounter++;
                }
                maxRow--;
                x--;
                y++;
                if (resultCounter == totalCounter)
                    break;
            }
            if (x == maxRow && y == minCol) {
                for (x = maxRow; x >= minRow; x--){
                    result.add(matrix[x][y]);
                    resultCounter++;
                }
                minCol++;
                y++;
                x++;
                if (resultCounter == totalCounter)
                    break;
            }
        }
        return result;
    }
}
