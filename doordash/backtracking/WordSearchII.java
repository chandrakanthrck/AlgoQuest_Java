package doordash.backtracking;

import java.util.*;

public class WordSearchII {

    // Define directions for moving in the grid
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // Build a Trie from the list of words
        TrieNode root = buildTrie(words);

        // Backtracking to find words
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root, result);
            }
        }

        return result;
    }

    private void backtrack(char[][] board, int row, int col, TrieNode node, List<String> result) {
        char letter = board[row][col];

        // If the current letter is not in the Trie, return
        if (letter == '#' || node.children[letter - 'a'] == null) {
            return;
        }

        // Move to the next Trie node
        node = node.children[letter - 'a'];

        // If a word is found, add it to the result and mark it as used
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate words in the result
        }

        // Mark the cell as visited
        board[row][col] = '#';

        // Explore neighbors
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                backtrack(board, newRow, newCol, node, result);
            }
        }

        // Restore the cell
        board[row][col] = letter;

        // Optimization: Remove the leaf node
        if (isEmptyNode(node)) {
            node = null;
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char letter : word.toCharArray()) {
                if (node.children[letter - 'a'] == null) {
                    node.children[letter - 'a'] = new TrieNode();
                }
                node = node.children[letter - 'a'];
            }
            node.word = word; // Store the word at the end node
        }

        return root;
    }

    private boolean isEmptyNode(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    // TrieNode class
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
}

