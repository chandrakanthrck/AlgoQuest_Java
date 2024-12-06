package doordash.trie;

class Trie {

    // TrieNode definition
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        // Constructor
        TrieNode() {
            children = new TrieNode[26]; // For lowercase English letters
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    // Constructor to initialize the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false; // Character not found
            }
            node = node.children[index];
        }
        return node.isEndOfWord; // Return true only if it's the end of a word
    }

    // Checks if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false; // Prefix not found
            }
            node = node.children[index];
        }
        return true; // All characters in the prefix were found
    }
}
