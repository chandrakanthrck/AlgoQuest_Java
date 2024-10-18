package walmart;

public class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // 26 letters in the alphabet
        isEndOfWord = false;
    }
}
