package doordash.backtracking;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // Try placing digits 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            if (backtrack(board)) {
                                return true; // If successful, return
                            }
                            board[row][col] = '.'; // Undo the move
                        }
                    }
                    return false; // If no number fits, backtrack
                }
            }
        }
        return true; // All cells are filled
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-box
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == num) {
                    return false;
                }
            }
        }

        return true; // Valid placement
    }
}

