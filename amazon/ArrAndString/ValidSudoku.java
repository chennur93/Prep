package amazon.ArrAndString;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet <String> seen = new HashSet<>();

        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!seen.add(ch+"row"+i) || !seen.add(ch+"col"+j) || !seen.add(ch+"grid"+i/3+
                            "-"+j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
