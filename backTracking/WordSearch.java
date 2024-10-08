package backTracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;  // All characters found
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;  // Out of bounds or character mismatch
        }

        char temp = board[i][j];  // Temporarily mark the cell as visited
        board[i][j] = '*';
        
        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                        backtrack(board, word, i - 1, j, index + 1) ||
                        backtrack(board, word, i, j + 1, index + 1) ||
                        backtrack(board, word, i, j - 1, index + 1);

        board[i][j] = temp;  // Restore the cell

        return found;
    }

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(obj.exist(board, "ABCCED"));  // Output: true
        System.out.println(obj.exist(board, "SEE"));     // Output: true
        System.out.println(obj.exist(board, "ABCB"));    // Output: false
    }
}
