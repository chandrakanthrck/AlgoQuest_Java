package kWayMerge;

public class Node {
    public int value;         // Value of the element
    public int arrayIndex;    // Index of the array (or row in a matrix)
    public int elementIndex;  // Index within the array (or column in a matrix)

    // Constructor for general use
    public Node(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
