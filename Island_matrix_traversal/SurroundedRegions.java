package Island_matrix_traversal;

/*
Problem 4: Surrounded Regions (Capture Regions)
This problem introduces the idea of "flipping" certain regions based on traversal rules.

Problem Statement:
Given an m x n board consisting of 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's, but only if it is completely surrounded by 'X' on all sides
 (not connected to the border).
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Start DFS from 'O's on the border and mark them as 'S' (safe)
        for (int i = 0; i < rows; i++) {
            // Check first and last column for 'O'
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            // Check first and last row for 'O'
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Step 2: Go through the board and flip remaining 'O' to 'X', and 'S' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // flip surrounded regions
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O'; // revert safe regions
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }

        // Mark this cell as safe
        board[i][j] = 'S';

        // Continue DFS in all four directions
        dfs(board, i + 1, j); // down
        dfs(board, i - 1, j); // up
        dfs(board, i, j + 1); // right
        dfs(board, i, j - 1); // left
    }
}

