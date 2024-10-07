package two_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class TwoHeapsMedian {

    private PriorityQueue<Integer> maxHeap;  // Stores the smaller half of the numbers
    private PriorityQueue<Integer> minHeap;  // Stores the larger half of the numbers

    public TwoHeapsMedian() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // Max-heap
        minHeap = new PriorityQueue<>();  // Min-heap
    }

    // Adds a number into the data structure
    public void addNum(int num) {
        maxHeap.add(num);

        // Balance the heaps: Ensure all elements in maxHeap are <= elements in minHeap
        minHeap.add(maxHeap.poll());

        // Ensure maxHeap has one more element than minHeap if the total number of elements is odd
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Returns the median of all elements
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        TwoHeapsMedian medianFinder = new TwoHeapsMedian();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian());  // Output: 1.5
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian());  // Output: 2
    }
}
