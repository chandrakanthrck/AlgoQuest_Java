package kWayMerge;

// Node class to represent the element, its originating array, and the index in that array
public class Node {
    public int value;  // Value of the element
    public int arrayIndex;  // The array from which the element came
    public int elementIndex;  // The index of the element within its array

    // Constructor
    public Node(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
