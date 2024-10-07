package kWayMerge;

public class Node {
    public int value;
    int row;
    int col;  // Optional: Can be used for 2D structures like matrix, or can be ignored

    // Constructor for handling 1D structures like linked lists
    public Node(int value) {
        this.value = value;
    }

    // Constructor for handling 2D structures like matrix or arrays of lists
    public Node(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
