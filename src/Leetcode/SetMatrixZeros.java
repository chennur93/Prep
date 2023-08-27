package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i=0, j=0;
        boolean isFirstRowZero=false, isFirstColumnZero=false;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                if ((matrix[i][j] == 0) && (i == 0)) {
                    isFirstRowZero = true;
                }
                if ((matrix[i][j] == 0) && (j == 0)) {
                    isFirstColumnZero = true;
                }
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set rows
        for (i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int col = 1; col < columns; col++) {
                    matrix[i][col] = 0;
                }
            }
        }

        // set columns
        for (j = 1; j < columns; j++) {
            if (matrix[0][j] == 0) {
                for (int row = 1; row < rows; row++) {
                    matrix[row][j] = 0;
                }
            }
        }

        if (isFirstColumnZero) {
            for (i=0; i<rows; i++) {
                matrix[i][0] = 0;
            }
        }if(isFirstRowZero) {
            for (j=0; j<columns; j++) {
                matrix[0][j] = 0;
            }
        }
    }


    public static void setZeroes1(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
